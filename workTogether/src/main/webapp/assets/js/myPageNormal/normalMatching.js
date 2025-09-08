/*const complete = document.getElementById("complete");
const cancel = document.getElementById("cancel");
const completecheck = document.getElementById("completeBtn");
const cancelcheck = document.getElementById("cancelBtn");

const completemodal = document.querySelector(".completemodal");
const cancelmodal = document.querySelector(".cancelmodal");

complete.addEventListener('click', function(e) {
	e.preventDefault();
	completemodal.style.display = 'block';
});
cancel.addEventListener('click', function(e) {
	e.preventDefault();
	cancelmodal.style.display = 'block';
});
completecheck.addEventListener('click', function(e) {
	e.preventDefault();
	completemodal.style.display = 'none';
});
cancelcheck.addEventListener('click', function(e) {
	e.preventDefault();
	cancelmodal.style.display = 'none';
});*/

document.addEventListener("DOMContentLoaded", () => {
	const normalNumber = window.usersNumber;
	const matchListEl = document.getElementById("matching_table");

	// 월별 매칭 목록 불러오기
	async function loadChooseMatch(month) {
		console.log(month + "월 선택됨");
		try {
			const res = await fetch(`/myPageNormal/normalMatchingListOk.mn?month=${month}`, {
				headers: {
					Accept: "application/json",
					"X-Requested-With": "XMLHttpRequest",
				},
			});
			if (!res.ok) throw new Error("매칭 목록을 불러오는데 실패했습니다. res.ok 오류");
			const matches = await safeJson(res);
			renderMatching(Array.isArray(matches) ? matches : []);
			console.log("매칭", matches);
		} catch (error) {
			console.error("매칭 목록 불러오기 실패:", error);
			alert("매칭 목록을 불러오는데 실패했습니다.");
		}
	}

	// 전체 매칭 불러오기
	async function loadMatch() {
		try {
			const res = await fetch(`/myPageNormal/normalMatchingListOk.mn`, {
				headers: {
					Accept: "application/json",
					"X-Requested-With": "XMLHttpRequest",
				},
			});
			if (!res.ok) throw new Error("매칭 목록을 불러오는데 실패했습니다. res.ok 오류");
			const matches = await safeJson(res);
			renderMatching(Array.isArray(matches) ? matches : []);
			console.log("매칭", matches);
		} catch (error) {
			console.error("매칭 목록 불러오기 실패:", error);
			alert("매칭 목록을 불러오는데 실패했습니다.");
		}
	}

	// 매칭 렌더링
	function renderMatching(matches) {
		if (!matchListEl) return;
		matchListEl.innerHTML = "";
		if (!matches.length) {
			matchListEl.innerHTML = "<li>매칭 없습니다.</li>";
			return;
		}
		const frag = document.createDocumentFragment();
		matches.forEach((matching) => {
			const li = document.createElement("li");
			li.classList.add("match_card");
			li.innerHTML = `
				<div>${matching.month}월 ${matching.matchDate}일 "${matching.careName}" 돌봄회원 |
					이용 시간 : ${matching.matchMatchTime} 포인트 사용 :
					${matching.matchPoints}</div>
				<div class="matchingbutton">
					<button type="button" id="complete">이용완료</button>
					<button type="button" id="cancel">취소</button>
				</div>
			`;
			frag.appendChild(li);
		});
		matchListEl.appendChild(frag);
	}

	async function safeJson(res) {
		const text = await res.text();
		try {
			return text ? JSON.parse(text) : null;
		} catch {
			return null;
		}
	}

	loadMatch();

	// 월 클릭 이벤트 등록
	document.querySelectorAll(".month li").forEach(li => {
		li.addEventListener("click", () => {
			const month = li.dataset.month;
/*			li.style.color = "red";*/
			loadChooseMatch(month);
		});
		li.style.color = "black";
	});
});




