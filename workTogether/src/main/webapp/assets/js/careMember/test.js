document.addEventListener("DOMContentLoaded", () => {
	const detailDongs = document.querySelectorAll(".village");
	const restaurantCard = document.querySelector(".restaurant_card")
	detailDongs.forEach(e => {
		e.addEventListener('click', async() => {
			const detailDong = e.textContent;
			
			try{
				const res = await fetch("", {
					method:"GET",
					headers: {
						Accept : "application/json",
						"X-Requested-With": "XMLHttpRequest",
					},
				});
				if(!res.ok) throw new Error("동 목록 불러오는데 실패해씀니다.")
				const lists = await safeJson(res);
				renderDong(Array.isArray(lists) ? lists : []);
			}catch(error){
				console.error("동 목록 불러오기 실패: ", error)
				alert("동 목록을 불러오는데 실패했습니다. catch로 들어옴")
			}
			
		})
	})
	
	// 동 목록 랜더링
	function renderDong(dongs) {
		if(!restaurantCard) return;
		restaurantCard.innerHTML = "";
		if(!restaurantCard) {
			restaurantCard.innerHTML = "<div> 동 목록이 없습니다.</div>"
			return;
		}
		const frag = document.createDocumentFragment();
		dongs.forEach((dong) => {
			const div = document.createElement("div");
			div.innerHTML=`
			<div class="restaurant_card">
				<a class="go_detail"
					href="${pageContext.request.contextPath}/shops/shopsDetailOk.sh?shopsNumber=${shop.shopsNumber}">
					<!-- href="./../restaurant/restaurantDetail.jsp?restaurant=0&leNum=1&adNum=2"> -->
					<div class="restaurant_name">
						${shop.getShopsName()}
						${shop.getShopsBranchName()}
					</div>
				</a>
				<div class="restaurant_introduce">
					<div class="restaurant_info">
						<div>
							${shop.getShopsAdminDong()}
						</div>
						<div>
							${shop.getShopsIntroText()}
						</div>
						<div>
							영업 시간 :
							${shop.getShopsWorkingHours()}
						</div>
					</div>
					<div class="restaurant_mark">
						<div onclick="togleStar(0)" class="star_img_box">
							<img class="star_img"
								src="./../../assets/img/restaurant/star.png"
								data-favorite="${shop.getIsFavorite()}">
						</div>
						<div>찜하기</div>
					</div>
				</div>
			</div>
			`
		})
		
	}
	
	async function safeJson(res) {
			const text = await res.text();
			try {
				return text ? JSON.parse(text) : null;
			} catch {
				return null;
			}
		}
	
})