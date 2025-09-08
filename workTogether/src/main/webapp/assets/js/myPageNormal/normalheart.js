document.addEventListener("DOMContentLoaded", () => {
    const normalNumber = window.usersNumber;

    

    const heartBoxes = document.querySelectorAll(".heart_img_box");

    heartBoxes.forEach(function(box) {
        box.addEventListener("click", async function() {
			console.log("클릭 ㄳㄳ");
            const careNumber = box.closest("li").dataset.carenumber;
			console.log(careNumber);
            if (!normalNumber) {
                return alert("비로그인 상태이거나 돌봄회원이 삭제되어 페이지를 볼 수 없습니다.");
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
                } else {
					
					console.log(result);
                    alert("하트 취소 실패했습니다.");
                }
            } catch (error) {
                console.error("하트 오류", error);
                alert("하트 취소 중 오류가 발생했습니다.");
            }
        });
    });
	
	async function safeJson(res) {
	        const text = await res.text();
	        try {
	            return text ? JSON.parse(text) : null;
	        } catch {
	            return null;
	        }
	    }
});
