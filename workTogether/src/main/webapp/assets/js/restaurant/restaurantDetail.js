document.addEventListener("DOMContentLoaded", () => {
	const starImg = document.getElementById("star_img");
	const yesStarImg = document.querySelector(".st");
	const usersNumber = window.usersNumber;
	const shopsNumber = window.shopsNumber;
	const starImgBox = document.getElementById("star_img_box");
	let isStar= false;

	async function loadStar() {
		try {
			const res = await fetch(`/favorite/favoriteOk.fa?shopsNumber=${shopsNumber}`, {
				headers: {
					Accept: "application/json",
					"X-Requested-With": "XMLHttpRequest",
				},
			});
			if (!res.ok) throw new Error("하트 목록을 불러오는데 실패했습니다. res.ok 오류");
			const star = await safeJson(res);
			renderStar(star);
			
		} catch (error) {
			console.error("찜 상태 불러오기 실패:", error);
		}
	}

	function renderStar(star) {
		if (star.isFavorite === false) {
			starImg.src = "/assets/img/restaurant/star.png"
			starImg.style.right= "0%";
			isStar = false;
		} else {
			starImg.src = "/assets/img/restaurant/star.png"
			starImg.style.right = "100%";
			isStar=true;
		}
	}

	starImg?.addEventListener('click', async () => {
		
		if (!usersNumber) return alert("비로그인 상태입니다.");
		try {
			
			let url = isStar ? `/favorite/favoriteDeleteOk.fa?shopsNumber=${shopsNumber}` : `/favorite/favoriteAddOk.fa?shopsNumber=${shopsNumber}`;
			const response = await fetch(url, {
				method: "POST",
				headers: {
					"Content-Type": "application/json; charset=utf-8",
					"X-Requested-With": "XMLHttpRequest",
				},
				body: JSON.stringify({ shopsNumber, usersNumber })
			})
			const result = await response.json();
			if (result?.status === "success") {
				alert("찜 추가/취소 완료!");
				isStar=!isStar;
				await loadStar();
			}

		} catch (err) {
			console.error('실패', err);
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


	loadStar();
});
