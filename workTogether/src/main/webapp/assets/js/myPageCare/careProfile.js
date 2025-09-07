// 페이지 열리면 실행
document.addEventListener('DOMContentLoaded', () => {
  // 파일 업로드 모달
  const uploadModal = document.getElementById('uploadSuccessModal');
  const uploadConfirmBtn = uploadModal.querySelector('button');
  // 업로드 모달 열기
  const openUploadModal = () => uploadModal.classList.add('open');
  // 업로드 모달 닫기
  const closeUploadModal = () => uploadModal.classList.remove('open');
  // 업로드 모달 확인 버튼 클릭하면 닫기
  uploadConfirmBtn.addEventListener('click', closeUploadModal);
  // 파일 선택
  const fileInputs = document.querySelectorAll('input[type="file"]');
  // 업로드 모달 열기
  fileInputs.forEach(input => {
    input.addEventListener('change', () => {
      if (input.files && input.files.length > 0) openUploadModal();
		console.log("언제 실행되나?");
    });
  });
  
  //업로드한 프로필 사진 미리보기 구현
  const profileInput = document.getElementById('profileUpload');
  const profilePreview = document.getElementById('profilePreview');

  profileInput.addEventListener('change', e => {
    const file = e.target.files[0];
    if (!file) return; // 선택 취소했으면 무시

    if (!file.type.startsWith('image/')) {
      alert('이미지 파일만 업로드 가능합니다.');
      profileInput.value = ''; // 리셋
      return;
    }

    const reader = new FileReader();
    reader.onload = ev => {
      profilePreview.src = ev.target.result; // 프로필 이미지만 교체
    };
    reader.readAsDataURL(file);
  });
  
  
  const updateRequestButton = document.getElementById('request');
  const inputLicense = document.getElementById('license');
  const inputAccount = document.getElementById('account');
  
/*  updateRequestButton.addEventListener('click', e =>{
	e.preventDefault();
	console.log("수정요청 누름");
	if(inputLicense.files && inputLicense.files.length > 0){
		const lFileObj = inputLicense.files[0];
		alert("파일 명 : ", lFileObj.name);
		alert("파일 형식 : ", lFileObj.type);
		alert("파일 크기 : ", lFileObj.size);
	}else{
		alert("파일이 선택되지 않았습니다.");
	}
		
  }); */ 

  function sendUpdateRequest(){
	console.log("수정요청 누름");
	if(inputLicense.files && inputLicense.files.length > 0){
		console.log("gdgd", inputLicense.files[0]);
		const lFileObj = inputLicense.files[0];
		alert(`자격증 파일 명: ${lFileObj.name}\n형식: ${lFileObj.type}\n크기: ${lFileObj.size}`);
	}else{
		alert("파일이 선택되지 않았습니다.");
	}
	if(inputAccount.files && inputAccount.files.length > 0){
		console.log("gdgd", inputAccount.files[0]);
		const aFileObj = inputAccount.files[0];
		alert(`계좌 파일 명: ${aFileObj.name}\n형식: ${aFileObj.type}\n크기: ${aFileObj.size}`);
	}else{
		alert("파일이 선택되지 않았습니다.");
	}
  }
  updateRequestButton.addEventListener('click', sendUpdateRequest);

  
  
  // 저장 완료 모달
  const saveModal = document.getElementById('saveSuccessModal');
  const saveModalOk = saveModal.querySelector('button');
  // 저장 모달 열기
  const openSaveModal = () => saveModal.classList.add('open');
  // 저장 모달 닫기
  const closeSaveModal = () => saveModal.classList.remove('open');
  // 확인 버튼 클릭하면 닫기
  saveModalOk.addEventListener('click', closeSaveModal);
  // 요일 선택 버튼
  const dayButtons = document.querySelectorAll('.possible_date button:not(#check)');
  // 요일 확인 버튼
  const dayConfirm = document.getElementById('check');
  const DAYS_STORAGE_KEY = 'careProfile.selectedDays';
  // 저장돼 있던 요일 불러와서 표시
/*  const savedDays = JSON.parse(localStorage.getItem(DAYS_STORAGE_KEY) || '[]');
  if (savedDays.length) {
    dayButtons.forEach(btn => {
      if (savedDays.includes(btn.textContent)) btn.classList.add('active');
    });
  }*/

  // 요일 버튼 누르면 선택
  dayButtons.forEach(btn => {
    btn.addEventListener('click', e => {
      e.preventDefault();
      btn.classList.toggle('active');
    });
  });

  //서브밋 해야 해서 잠시 숨김
/*  const dayResult = {};
  dayConfirm.addEventListener('click', e=> {
	e.preventDefault();
	dayButtons.forEach(btn => {
	  const day = btn.dataset.day; // monday, tuesday...
	  const value = btn.classList.contains('active') ? 'Y' : 'N';
	  dayResult[day] = value;
	  });
	  console.log(dayResult);
  });*/
  
  
  // 선택된 요일 저장하고 저장 모달
/*  dayConfirm.addEventListener('click', e => {
    e.preventDefault();
    const selectedDays = Array.from(dayButtons)
      .filter(b => b.classList.contains('active'))
      .map(b => b.textContent);
    localStorage.setItem(DAYS_STORAGE_KEY, JSON.stringify(selectedDays));
    openSaveModal();
  });*/

  // 확인 버튼
  // const placeConfirm = document.querySelector('.palce_detail ul li:last-child button');
  // // 저장 모달 열기
  // placeConfirm?.addEventListener('click', e => {
  //   e.preventDefault();
  //   openSaveModal();
  // });

  // 우편번호 찾기 버튼
  const placeFindBtn = document.getElementById('find_post');
  // 우편번호 찾기 모달
  const findModal = document.getElementById('findModal');
  const findOkBtn = findModal.querySelector('button');
  // 우편번호 모달 열기
  const openFindModal = () => findModal.classList.add('open');
  // 우편번호 모달 닫기
  const closeFindModal = () => findModal.classList.remove('open');
  // 우편번호 찾기 누르면 모달 열기
/*  placeFindBtn?.addEventListener('click', (e) => {
    e.preventDefault();
    openFindModal();
  });*/
  // 우편번호 모달 확인 누르면 닫기
  findOkBtn.addEventListener('click', closeFindModal);

  // 소개글 확인 버튼
  const introduceConfirm = document.querySelector('.introduce_detail button');
  // 저장 모달 열기
  //   introduceConfirm?.addEventListener('click', e => {
  //     e.preventDefault();
  //     openSaveModal();
  // });

  // 이력 확인 버튼
  const historyConfirmBtn = document.querySelector('.recode .confrim'); // HTML 철자 그대로 사용
  // 이력 수정 신청 완료 모달
  const proposeModal = document.getElementById('proposeSuccessModal');
  const proposeOkBtn = proposeModal.querySelector('button');
  // 이력 모달 열기
  const openProposeModal = () => proposeModal.classList.add('open');
  // 이력 모달 닫기
  const closeProposeModal = () => proposeModal.classList.remove('open');

  // 확인 버튼 클릭 모달 열기
  // historyConfirmBtn?.addEventListener('click', e => {
  //   e.preventDefault();
  //   openProposeModal();
  // });
  // 확인 버튼 클릭시 닫기
  proposeOkBtn.addEventListener('click', closeProposeModal);


  //빈칸 검증 칸 - 지역쪽
  const placeConfirm = document.querySelector('.palce_detail ul li:last-child button');
  placeConfirm.addEventListener('click', e => {
    e.preventDefault();
    const detailInput = document.getElementById('detail');

    // 기본 테두리 복원
    if (detailInput) detailInput.style.borderColor = '#000';

    if (!detailInput.value.trim()) {
      alert("빈 칸을 입력해 주세요.");
      if (detailInput) detailInput.style.borderColor = 'red';
      detailInput.focus();
      return; 
    }

    openSaveModal();  
  });

  //빈칸 검증칸 = 소개글 쪽
  introduceConfirm.addEventListener('click', e => {
    e.preventDefault();
    const introduceInput = document.querySelector('#detail');
    if (!introduceInput.value.trim()) {
      alert("빈 칸을 입력해 주세요.");
      return;
    }
    openSaveModal();
  });

  //빈칸검증칸 --이력
  historyConfirmBtn.addEventListener('click', e => {
    e.preventDefault();
    const experienceInput = document.getElementById('experience');
    if (!experienceInput.value.trim()) {
      alert("빈 칸을 입력해 주세요.");
      return;
    }
    openProposeModal();
  });
});

