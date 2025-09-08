document.addEventListener("DOMContentLoaded", () => {
	const normalNumber = window.usersNumber;
	const heartListEl = document.getElementById("card_list_1");

	async function loadHearts() {
		try {
			const res = await fetch(`/myPageNormal/normalHeartList.mn`, {
				headers: {
					Accept: "application/json",
					"X-Requested-With": "XMLHttpRequest",
				},
			});
			if (!res.ok) throw new Error("하트 목록을 불러오는데 실패했습니다. res.ok 오류");
			const hearts = await safeJson(res);
			renderHearts(Array.isArray(hearts) ? hearts : []);
			console.log("res"+res);
			console.log("하트"+hearts);
		} catch (error) {
			console.error("하트 목록 불러오기 실패:", error);
			alert("하트 목록을 불러오는데 실패했습니다.22");
		}
	}

	// 하트 렌더링
	function renderHearts(hearts) {
		if (!heartListEl) return;
		heartListEl.innerHTML = "";
		if (!hearts.length) {
			console.log(hearts)
			heartListEl.innerHTML = "<li>하트 없습니다.</li>";
			return;
		}
		const frag = document.createDocumentFragment();
		hearts.forEach((care) => {
			const li = document.createElement("li");
			li.classList.add("care_card");
			li.dataset.carenumber = care.careNumber;

			const days = [];
			if (care.dayMonday === "Y") days.push("월");
			if (care.dayTuesday === "Y") days.push("화");
			if (care.dayWednesday === "Y") days.push("수");
			if (care.dayThursday === "Y") days.push("목");
			if (care.dayFriday === "Y") days.push("금");
			if (care.daySaturday === "Y") days.push("토");
			if (care.daySunday === "Y") days.push("일");
			li.innerHTML = `
			<div class="heart_img_box">
							<img class="heart_img" src="/assets/img/careMember/heart_icon.png">
						</div>
						<a href="/careList/careListDetailOk.cl?usersNumber=${care.careNumber}" class="profile">
							<div class="profile_pic_box">
								<img class="profile_pic" src="${care.profilesFilesPath}${care.profilesFilesName}${care.profilesFilesType}">
							</div>
							<div class="profile_name">${care.usersName}</div>
							<div class="day_row">
								${days.map(day => `<div class="day">${day}</div>`).join("")}
							</div>
							<div class="profile_intro">
								<div class="short_intro">${care.careIntroText || ""}</div>
								<div class="long_intro">
									<p>${care.profilesFilesName || ""}</p>
									<p>${care.usersAddressLine1 || ""} 거주</p>
								</div>
							</div>
						</a>
					`;
			frag.appendChild(li);
		});
		heartListEl.appendChild(frag);
	}

	const heartBoxes = document.querySelectorAll(".heart_img_box");

	heartListEl.addEventListener("click", async (e) => {
		const box = e.target.closest(".heart_img_box");
		if (!box) return; 
		const careNumber = box.closest("li").dataset.carenumber;
		console.log("클릭한 careNumber:", careNumber);

		if (!normalNumber) {
			return alert("돌봄회원이 삭제되어 페이지를 볼 수 없습니다.");
		}

		try {
			const response = await fetch("/myPageNormal/normalHeartListDeleteOk.mn", {
				method: "POST",
				headers: {
					"Content-Type": "application/json; charset=utf-8",
					"X-Requested-With": "XMLHttpRequest",
				},
				body: JSON.stringify({ careNumber, normalNumber }),
			});
			const result = await safeJson(response);
			if (result?.status === "success") {
				alert("하트 취소가 완료되었습니다");
				console.log(result);
				await loadHearts();
			} else {
				console.log(result);
				alert("하트 취소 실패했습니다.");
			}
		} catch (error) {
			console.error("하트 오류", error);
			alert("하트 취소 중 오류가 발생했습니다.");
		}
	});

	async function safeJson(res) {
		const text = await res.text();
		try {
			return text ? JSON.parse(text) : null;
		} catch {
			return null;
		}
	}
	
	loadHearts();
});
