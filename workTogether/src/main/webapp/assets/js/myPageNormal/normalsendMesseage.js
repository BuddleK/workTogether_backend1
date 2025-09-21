document.addEventListener('DOMContentLoaded', function() {
	/* 받은 메시지 */
	const master = document.querySelector('.mark_nav input[type="checkbox"]');
	const getRowCheckboxes = () =>
		Array.from(document.querySelectorAll('.mark_list input[type="checkbox"]'));

	function refreshMaster() {
		const rows = getRowCheckboxes();
		const total = rows.length;
		const checked = rows.filter(cb => cb.checked).length;
		master.checked = total > 0 && checked === total;
	}

	refreshMaster();

	master.addEventListener('change', () => {
		getRowCheckboxes().forEach(cb => (cb.checked = master.checked));
	});

	getRowCheckboxes().forEach(cb => cb.addEventListener('change', refreshMaster));

	const deleteBtn = document.getElementById('delete');
	const deleteModal = document.getElementById('deleteModal');
	const doneModal = document.getElementById('chek_deleteModal');
	const confirmDeleteBtn = document.getElementById('confirmDelete');
	const cancelDeleteBtn = document.getElementById('cancelDelete');
	const doneOkBtn = document.getElementById('check_confirmDelete');

	function openModal(m) { m.classList.add('open'); }
	function closeModal(m) { m.classList.remove('open'); }

	/* 쪽지 읽기 */
	const showMsg = document.getElementById('msgModal');
	const msgContents = document.querySelectorAll('.location')
	msgContents.forEach((msgContent) => {
		msgContent.addEventListener('click', function() {
			openModal(showMsg);

			const messageId = this.dataset.id;

			console.log(messageId + ' 메시지 넘버');
			loadMsgNumber(messageId);
			const btnReply = document.querySelector('.btn_reply');
			btnReply.addEventListener('click', async () => {
					const showMsg = document.getElementById('msgModal');
					showMsg.classList.remove('open');
					const sendMsg = document.getElementById('sendMsgModal');
					sendMsg.classList.add('open');
					loadMsgNumber(messageId);
					try {
							const res = await fetch(`/myPageNormal/normalMsgNumber.mn?msgNumber=${messageId}`, {
								headers: {
									Accept: "application/json",
									"X-Requested-With": "XMLHttpRequest",
								},
							});
							if (!res.ok) throw new Error("쪽지를 불러오는데 실패했습니다.");

							const msgL = await safeJson(res);
							const msg = msgL[0];
							if (!msg) {
								alert("쪽지 데이터를 불러올 수 없습니다.");
								return;
							}

							document.getElementById("receive_name").innerText = msg.usersName;
							document.getElementById("receive_id").innerText = msg.usersId;
							document.getElementById("careNumber").value = msg.careNumber;
						} catch (error) {
							console.error("답장용 쪽지 불러오기 실패:", error);
							alert("쪽지 데이터를 불러오는데 실패했습니다.");
						}
				})
				
				const btnSend = document.getElementById('btn_send');
				btnSend.addEventListener('click', () => {
					const sendMsg = document.getElementById('sendMsgModal');
					sendMsg.classList.remove('open');
					const sModal=document.getElementById('sendSuccessModal');
					sModal.classList.add('open')
				} )
			
		});
	});

	
	const closeResend = document.getElementById('close_resend');
		closeResend.addEventListener('click', function() {
			const modalBg = document.getElementById('sendMsgModal');
			console.log('답장에서 닫기 누름');
			modalBg.classList.remove('open');
		});
	

	/* 모달 닫기 */
	const close = document.querySelector(".modal_close")
	close.addEventListener('click', () => {
		const showMsg = document.getElementById('msgModal');
		showMsg.classList.remove('open');
	})


	deleteBtn.addEventListener('click', function(e) {
		e.preventDefault();
		const anyChecked = document.querySelector('.mark_list input[type="checkbox"]:checked');
		if (!anyChecked) {
			alert('삭제할 항목을 선택하세요.');
			return;
		}
		openModal(deleteModal);
	});

	//쪽지 삭제
	confirmDeleteBtn.addEventListener('click', async function() {
		closeModal(deleteModal);

		const checkedValues = Array.from(
			document.querySelectorAll('.mark_list input[type="checkbox"]:checked')
		).map(cb => cb.value);

		if (checkedValues.length === 0) {
			alert("삭제할 항목이 없습니다.");
			return;
		}
		try {
			const response = await fetch(
				`/myPageNormal/normalMsgDeleteList.mn?mark_check=${encodeURIComponent(checkedValues.join(","))}`,
				{
					method: "POST",
					headers: { "X-Requested-With": "XMLHttpRequest" }
				}
			);
			const result = await safeJson(response);
			if (result?.status === "success") {
				openModal(doneModal);
				await loadMatch();
			} else {
				alert("쪽지 삭제 실패");
			}
		} catch (error) {
			console.error("쪽지 삭제 실패 catch", error);
			alert("쪽지 삭제 중 오류 발생");
		}
		master.checked = false;
		refreshMaster();
	});

	cancelDeleteBtn.addEventListener('click', function() {
		closeModal(deleteModal);
		loadMatch();
	});

	doneOkBtn.addEventListener('click', function() {
		closeModal(doneModal);
	});

	const msgListEl = document.getElementById("mark_list");

	// 전체 쪽지 불러오기
	async function loadMatch() {
		try {
			const res = await fetch(`/myPageNormal/normalMsgGetJsList.mn`, {
				headers: {
					Accept: "application/json",
					"X-Requested-With": "XMLHttpRequest",
				},
			});
			if (!res.ok) throw new Error("쪽지 목록을 불러오는데 실패했습니다.");
			const msgs = await safeJson(res);
			console.log(msgs);
			renderMatching(Array.isArray(msgs) ? msgs : []);
		} catch (error) {
			console.error("쪽지 목록 불러오기 실패:", error);
			alert("쪽지 목록을 불러오는데 실패했습니다.");
		}
	}

	// 쪽지 렌더링
	function renderMatching(msgs) {
		/*if (!msgListEl) return;*/
		msgListEl.innerHTML = "";
		if (!msgs.length) {
			msgListEl.innerHTML = "<li>쪽지가 없습니다.</li>";
			return;
		}
		const frag = document.createDocumentFragment();
		msgs.forEach((msg) => {
			const li = document.createElement("li");
			li.classList.add("li");
			li.innerHTML = `
			<input class="checkbox_li" name="mark_check"
										type="checkbox" value="${msg.messageNumber}">
										<div class="name">
											<div>${msg.usersName}</div>
										</div>
										<div class="location" >
											<div>${msg.messageContents}</div>
										</div>
										<div class="phone">
											<div>${msg.messageDate}</div>
										</div>
										<div class="read">
											<div>${msg.isRead}</div>
										</div>
			`;
			frag.appendChild(li);
		});
		msgListEl.appendChild(frag);
	}

	async function safeJson(res) {
		const text = await res.text();
		try {
			return text ? JSON.parse(text) : null;
		} catch {
			return null;
		}
	}

	/*쪽지 읽기 랜더링*/
	async function loadMsgNumber(number) {
		try {
			const res = await fetch(`/myPageNormal/normalMsgNumber.mn?msgNumber=${number}`, {
				headers: {
					Accept: "application/json",
					"X-Requested-With": "XMLHttpRequest",
				},
			});
			if (!res.ok) throw new Error("쪽지를 불러오는데 실패했습니다.");

			const msgL = await safeJson(res);
			const msg = msgL[0];
			if (!msg) {
				alert("쪽지 데이터를 불러올 수 없습니다.");
				return;
			}

			document.getElementById("sender_name").innerText = msg.usersName;
			document.getElementById("sender_id").innerText = msg.usersId;
			document.getElementById("messageContent").innerText = msg.messageContents;

		} catch (error) {
			console.error("쪽지 불러오기 실패:", error);
			alert("쪽지를 불러오는데 실패했습니다.");
		}
	}
	/*loadMatch();*/
});					
