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
// 음식점 찜하기(별) 이미지들 가져오기
const reStars = document.getElementsByClassName("star_img");

// 동 목록 (법정동 기준 배열)
var arr = [
  ['방배 1동','방배 2동','방배 3동','방배 4동','방배 본동'],
  ['서초 1동','서초 2동','서초 3동','서초 4동'],
  ['잠원동'],
  ['양재 1동','양재 2동'],
  ['내곡동', '반포 1동', '반포 2동', '반표 3동', '반포 4동'],
];

// 음식점 카드 표출 함수
function showCards(num, value){
  const villages = document.getElementsByClassName('village');
  for(let v of villages){
    v.style.backgroundColor = 'white';
    v.style.color = 'black';
  }
  villages[value].style.backgroundColor = '#1D3266';
  villages[value].style.color = 'white';
}

// 지역 버튼 클릭
function reClicked(num){
  console.log("지역 인덱스 : " + num);
  for(let button of reButtons){
    button.style.backgroundColor = 'white';
    button.style.color = 'black';
  }
  reButtons[num].style.backgroundColor = '#1D3266';
  reButtons[num].style.color = 'white';

  reSmall[0].style.display = "block";
  reSmallList.innerHTML = "";

  // 행정동 버튼 생성
  arr[num].forEach((dongName, index) => {
    const li = document.createElement("li");
    li.innerText = dongName;
    li.dataset.dong = dongName;
    li.value = index;
    li.className += 'village';
    li.onclick = function(){
      showCards(num, li.value);
      const selectedDong = this.dataset.dong;
      window.location.href = `/shops/shopsListSearchOk.sh?legalDong=${encodeURIComponent(selectedDong)}&leNum=${num}`;
    };
    reSmallList.appendChild(li);
  });

  // 화살표 표시
  for(let j = 0; j < reMarks.length; j++){
    reMarks[j].style.display = (j === num) ? "block" : "none";
  }
}

// 찜하기 토글
function togleStar(num){
  console.log("별! " + num);
  if(isLogin){
    reStars[num].style.left = (reStars[num].style.left === "-100%") ? "0" : "-100%";
  } else {
    restaurantModalLoginShow();
  }
}

// --- 초기 선택 적용 로직 ---

// URL 파라미터 가져오기
const params = new URLSearchParams(window.location.search);
let leNum = params.get('leNum');       // 법정동 인덱스
let legalDong = params.get('legalDong'); // 선택된 행정동

if (!leNum) leNum = 0;
else leNum = parseInt(leNum);

let selectedIndex = 0;

// legalDong이 있으면 인덱스 찾기
if (legalDong) {
  const villagesArr = arr[leNum];
  const findIndex = villagesArr.findIndex(d => d === legalDong);
  if(findIndex !== -1) selectedIndex = findIndex;
}

// 지역과 동 클릭
reClicked(leNum);
showCards(leNum, selectedIndex);
