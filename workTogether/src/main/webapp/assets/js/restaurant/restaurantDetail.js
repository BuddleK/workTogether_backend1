document.addEventListener("DOMContentLoaded", () => {
    const starImg = document.getElementById("star_img");
	const yesStarImg = document.querySelector(".st");
    const usersNumber = window.usersNumber;
    const shopsNumber = window.shopsNumber;
	

    starImg?.addEventListener('click', async () => {
        if (!usersNumber) return alert("비로그인 상태입니다.");

        try {
			const response = await fetch("/favorite/favoriteAddOk.fa", {
			    method: "POST",
			    headers: {   
			        "Content-Type": "application/json; charset=utf-8",
			        "X-Requested-With": "XMLHttpRequest",
			    },
			    body: JSON.stringify({ shopsNumber, usersNumber })
			})
            const result = await response.json();
            if(result?.status === "success") {
                alert("찜 완료!");
               
            }

        } catch (err) {
            console.error('실패', err);
        }
    });
});
