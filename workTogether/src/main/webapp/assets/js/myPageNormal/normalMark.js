const checkboxAll = document.getElementById("checkbox_col");
	const checkboxes = document.querySelectorAll(".checkbox_li");
	NodeList.prototype.map = Array.prototype.map;

	function checkedAll() {
		checkboxes.forEach(e => {
			e.checked = checkboxAll.checked;
		})
	}

	checkboxes.forEach((checkbox) => {
		checkbox.addEventListener("click", () => {
			checkboxAll.checked = checkboxes.map((checkbox) => checkbox.checked).filter((checked) => checked).length === checkboxes.length;
		})
		
	})
	

document.addEventListener("DOMContentLoaded", () => {
	const btnDelete = document.getElementById("btnDelete");
	const delModal = document.getElementById("deleteModal");
	const okDelete = document.getElementById("confirmDelete");
	const cancleDelete = document.getElementById("cancelDelete");
	const form = document.querySelector("form");

	btnDelete.addEventListener("click", () => {
		const checkedBox = document.querySelectorAll("input[name='mark_check']:checked");
		if (checkedBox.length === 0) {
			alert("삭제할 항목을 선택해주세요.");
			return;
		}

		delModal.style.display = "flex";
	});

	confirmDelete.addEventListener("click", () => {
		delModal.style.display = "none";
		form.submit();
	});

	cancleDelete.addEventListener("click", () => {
		delModal.style.display = "none";
	});
	
	
	
	
})

