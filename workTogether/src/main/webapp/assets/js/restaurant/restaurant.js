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
  ['내곡동', '반포 1동', '반포 2동', '반표 3동', '반포 4동'],
];

// 음식점 더미데이터


// 음식점 카드 표출 함수(매개변수 : 지역, 동 인덱스)
function showCards(num, value){
  const villages = document.getElementsByClassName('village');
  let selectedIndex = 0;
    for(let v of villages){
      // 모든 버튼 초기화
      v.style.backgroundColor = 'white';
      v.style.color = 'black';
    }

    // 선택된 동 버튼 스타일 지정
    villages[value].style.backgroundColor = '#1D3266';
    villages[value].style.color = 'white';
  

}

//지역 버튼 클릭 시 실행
function reClicked(num){
  // (확인용)입력한 숫자
  console.log("숫자는 : " + num);

  //버튼 색 초기화
  for(button of reButtons){
    button.style.backgroundColor = 'white';
    button.style.color = 'black';
  }

  //누른 버튼 스타일 수정
  reButtons[num].style.backgroundColor = '#1D3266';
  reButtons[num].style.color = 'white';

  // 판 보이기
  reSmall[0].style.display = "block";

  // 해당 행의 문자열 배열 출력
  console.log(arr[num], typeof arr[num]);

  // 리스트 초기화
  reSmallList.innerHTML = "";

  // 행정동별 버튼 생성
  let d = 0;
  for(ar of arr[num]){
    console.log(ar, typeof ar);


    const li = document.createElement("li");
    li.innerText = ar;
	li.dataset.dong = ar
    li.value = d;
    li.className += 'village';
    li.onclick = function(){
      showCards(num, li.value);
	  const selectedDong = this.dataset.dong;
	  window.location.href=`/shops/shopsListSearchOk.sh?legalDong=${encodeURIComponent(selectedDong)}`
    };

    reSmallList.appendChild(li);
    d++;
  }
  // 화살표 표시
  var j = 0;
  for(i of reMarks){
    if(j==num){
      i.style.display="block";
    }else{
      i.style.display="none";
    }
    j++;
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

// 처음 페이지에 들어오면 0번째 법정동 버튼을 클릭함
reClicked(0);
// 0번째 법정동의 0번째 행정동 버튼을 클릭함
showCards(0, 0);

// url 파라미터를 가져옴
// 디테일 페이지에서 뒤로가기 버튼을 누른 경우 법정동과 행정동
const params = new URLSearchParams(window.location.search);
let leNum = params.get('leNum'); // 지역
let legalDong = params.get('legalDong'); // 선택된 동

// 초기화할 지역 번호
if (!leNum) leNum = 0; // 없으면 0
else leNum = parseInt(leNum);

// 지역 버튼 클릭
reClicked(leNum);

// 동 버튼 선택
if (legalDong) {
  const villages = document.getElementsByClassName('village');
  for (let i = 0; i < villages.length; i++) {
    if (villages[i].innerText === legalDong) {
      showCards(leNum, i); // 선택된 동 적용
      break;
    }
  }
} else {
  showCards(leNum, selectedIndex); // legalDong 없으면 첫 번째 동 선택
}

let adNum;

if (params.has('leNum')) {
  leNum = params.get("leNum");
  adNum = params.get("adNum");

  console.log("leNum = "+ leNum);
  console.log("adNum = "+ adNum);

  console.log("아까 그 카드 다시 보여주기");

  //카드 초기화
  for(let i = 0 ;i < 4;i++){
    reCards[i].innerHTML = "";
  }
  reClicked(leNum);
  showCards(leNum, adNum);

} else {
  // 'paramName' 파라미터가 존재하지 않습니다.
  console.log('파라미터가 없습니다.');
}
