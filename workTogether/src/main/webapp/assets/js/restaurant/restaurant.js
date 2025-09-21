// 지역 버튼 가져오기
const reButtons = document.getElementsByClassName("region_button");
// 지역 선택 화살표 가져오기
const reMarks = document.getElementsByClassName("region_mark");
// 동 버튼 박스 가져오기
const reSmall = document.getElementsByClassName("region_small");
// 동 버튼 목록 가져오기
const reSmallList = document.getElementById("region_small_list");
// 음식점 카드들 가져오기
const reCards = document.getElementsByClassName("restaurant_card");
// 음식점 찜하기(별)이미지들 가져오기
const reStars = document.getElementsByClassName("star_img");

// 동 목록
var arr = [
  ['방배 1동','방배 2동','방배 3동','방배 4동','방배 본동'],
  ['서초 1동','서초 2동','서초 3동','서초 4동'],
  ['잠원동'],
  ['양재 1동','양재 2동'],
  ['내곡동', '반포 1동', '반포 2동', '반포 3동', '반포 4동'],
];

// 음식점 카드 표출 함수
function showCards(num, value){
  const villages = document.getElementsByClassName('village');
  for(let v of villages){
    v.style.backgroundColor = 'white';
    v.style.color = 'black';
  }
  // 선택된 동 버튼 스타일 지정
  if(villages[value]){
    villages[value].style.backgroundColor = '#1D3266';
    villages[value].style.color = 'white';
  }
}

// 지역 버튼 클릭 시 실행
function reClicked(num, selectedDong){
  // 지역 버튼 초기화
  for(let button of reButtons){
    button.style.backgroundColor = 'white';
    button.style.color = 'black';
  }
  reButtons[num].style.backgroundColor = '#1D3266';
  reButtons[num].style.color = 'white';

  // 동 리스트 초기화
  reSmallList.innerHTML = "";
  reSmall[0].style.display = "block";

  // 동 버튼 생성
  let d = 0;
  for(let ar of arr[num]){
    const li = document.createElement("li");
    li.innerText = ar;
    li.dataset.dong = ar;
    li.value = d;
    li.className = 'village';
    li.onclick = function(){
      const selectedDong = this.dataset.dong;
      showCards(num, d);
      window.location.href = `/shops/shopsListSearchOk.sh?leNum=${num}&legalDong=${encodeURIComponent(selectedDong)}`;
    };

    // URL 파라미터에 있는 동이면 선택
    if(selectedDong && ar.trim() === selectedDong.trim()){
      li.style.backgroundColor = '#1D3266';
      li.style.color = 'white';
    }

    reSmallList.appendChild(li);
    d++;
  }

  // 화살표 표시
  for(let j=0; j<reMarks.length; j++){
    reMarks[j].style.display = (j===num) ? "block" : "none";
  }
}

function togleStar(num){
  console.log("별! " + num);
  if(isLogin){
    if(reStars[num].style.left == "-100%"){
      reStars[num].style.left = "0";
    }else{
      reStars[num].style.left = "-100%";
    }
  }else{
    restaurantModalLoginShow();
  }
}

// URL 파라미터 확인
const params = new URLSearchParams(window.location.search);
let leNum = params.get('leNum'); // 지역
let legalDong = params.get('legalDong'); // 동

if(!leNum) leNum = 0;
else leNum = parseInt(leNum);

// 페이지 초기화
reClicked(leNum, legalDong);

// 선택된 동이 없으면 첫 번째 동 선택
if(!legalDong){
  showCards(leNum, 0);
} else {
  // 선택된 동 index 찾기
  const villages = document.getElementsByClassName('village');
  for(let i=0; i<villages.length; i++){
    if(villages[i].innerText.trim() === legalDong.trim()){
      showCards(leNum, i);
      break;
    }
  }
}

// 카드 초기화
for(let i = 0 ;i < 4;i++){
  reCards[i].innerHTML = "";
}
