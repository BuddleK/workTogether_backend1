// ==========================
// hidden input 값 헬퍼
// ==========================
function getVal(id) {
  const el = document.getElementById(id);
  return el ? el.value : "";
}

function requireUsersNumber() {
  const n = getVal("usersNumber");
  if (!n) {
    alert("잘못된 접근입니다. (usersNumber 없음)");
    return null;
  }
  return n;
}

// ==========================
// 승인: 모달 없이 바로 POST
// ==========================
function approveUser() {
  const usersNumber = requireUsersNumber();
  if (!usersNumber) return;

  const approveUrl = getVal("approveAction");
  if (!approveUrl) {
    alert("승인 URL이 없습니다.");
    return;
  }

  const form = document.createElement("form");
  form.method = "post";
  form.action = approveUrl;

  // URL에 쿼리로 있어도 중복 무해. body에도 넣어 안전하게 전송
  const f = document.createElement("input");
  f.type = "hidden";
  f.name = "usersNumber";
  f.value = usersNumber;
  form.appendChild(f);

  document.body.appendChild(form);
  form.submit();
}

// ==========================
// 반려: 모달 생성/열기
// ==========================
function getRejectModalEl() {
  const host = document.getElementById("modalCareAllowReject");
  if (!host) return null;

  let modal = host.querySelector(".modal");
  if (!modal) {
    host.innerHTML = `
      <div class="modal" style="display:none;position:fixed;inset:0;z-index:9999;align-items:center;justify-content:center;background:rgba(0,0,0,.4);">
        <div class="card" style="background:#fff;border-radius:10px;min-width:320px;max-width:92vw;padding:20px;box-shadow:0 10px 30px rgba(0,0,0,.18);">
          <h3 style="margin:0 0 10px;">반려 처리</h3>
          <p style="margin:0 0 8px;color:#555;">반려 사유를 입력하세요.</p>
          <textarea id="reason_reject" rows="3" style="width:100%;padding:10px;border:1px solid #ddd;border-radius:8px;"></textarea>
          <div style="margin-top:14px;display:flex;gap:8px;justify-content:flex-end;">
            <button type="button" class="btn-cancel" style="padding:9px 14px;border:1px solid #ddd;border-radius:8px;background:#fff;">취소</button>
            <button type="button" class="btn-reject" style="padding:9px 14px;border:0;border-radius:8px;background:#c62828;color:#fff;">반려</button>
          </div>
        </div>
      </div>
    `;
    modal = host.querySelector(".modal");

    // 닫기 바인딩
    modal.addEventListener("click", (e) => {
      if (e.target === modal) modal.style.display = "none";
    });
    modal.querySelector(".btn-cancel").addEventListener("click", () => {
      modal.style.display = "none";
    });
    modal.querySelector(".btn-reject").addEventListener("click", modalCareAllowRejectCheck);
  }
  return modal;
}

function modalCareAllowRejectShow() {
  const modal = getRejectModalEl();
  if (modal) modal.style.display = "flex";
}

function modalCareAllowRejectCancel() {
  const modal = document.querySelector("#modalCareAllowReject .modal");
  if (modal) modal.style.display = "none";
}

// ==========================
// 반려 확인: POST 전송
// ==========================
function modalCareAllowRejectCheck() {
  const usersNumber = requireUsersNumber();
  if (!usersNumber) return;

  const rejectUrl = getVal("rejectAction");
  if (!rejectUrl) {
    alert("반려 URL이 없습니다.");
    return;
  }

  const input = document.getElementById("reason_reject");
  const reason = (input?.value || "").trim();
  if (!reason) {
    alert("반려 사유를 입력하세요.");
    input?.focus();
    return;
  }

  const form = document.createElement("form");
  form.method = "post";
  form.action = rejectUrl;

  const f1 = document.createElement("input");
  f1.type = "hidden";
  f1.name = "usersNumber";
  f1.value = usersNumber;
  form.appendChild(f1);

  const f2 = document.createElement("input");
  f2.type = "hidden";
  f2.name = "rejectComment"; // 컨트롤러 파라미터명과 일치
  f2.value = reason;
  form.appendChild(f2);

  document.body.appendChild(form);
  form.submit();
}
