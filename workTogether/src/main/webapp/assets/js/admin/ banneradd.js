// assets/js/admin/bannerPreview.js
(function () {
  document.addEventListener("DOMContentLoaded", () => {
    const form  = document.getElementById("write-form");
    if (!form) return;

    const input = document.getElementById("imageFile");
    const img   = document.getElementById("imagePreview");
    const meta  = document.getElementById("imageMeta");
    const clear = document.getElementById("clearImage");
    const existing = document.getElementById("existingImagePath");

    let objectUrl = null;
    const MAX_BYTES = 5 * 1024 * 1024;

    // 항상 1장만
    if (input) {
      input.multiple = false;
      input.setAttribute("accept", "image/*");
    }

    // (디버그) 이미지 로딩 문제 추적
    if (img) {
      img.onerror = () => console.error("[preview] 이미지 로드 실패:", img.src);
    }

    function resetPreview() {
      if (objectUrl) { URL.revokeObjectURL(objectUrl); objectUrl = null; }
      if (img) {
        img.style.display = "none";
        img.removeAttribute("src");
      }
      if (meta) meta.textContent = "";
      if (clear) clear.style.display = "none";
    }

    function showPreviewFromFile(file) {
      if (!file || !img) return;
      objectUrl = URL.createObjectURL(file);
      img.onload = () => { URL.revokeObjectURL(objectUrl); objectUrl = null; };
      img.src = objectUrl;
      img.style.display = "block";
      if (meta) meta.textContent = `${file.name} • ${Math.round(file.size / 1024).toLocaleString()} KB`;
      if (clear) clear.style.display = "inline-block";
    }

    function withContext(path) {
      if (!path) return path;
      if (path.startsWith("/") || path.startsWith("http") || path.startsWith("blob:") || path.startsWith("data:")) return path;
      // 상대경로라면 컨텍스트+슬래시 붙이기 (컨텍스트 경로가 필요 없으면 이 함수 전체를 생략해도 됩니다)
      const base = location.origin + (document.documentElement.getAttribute("data-context-path") || "");
      return base.replace(/\/$/, "") + "/" + path.replace(/^\//, "");
    }

    function showPreviewFromExisting(path) {
      if (!path || !img) return;
      const src = withContext(path);
      img.src = src;
      img.style.display = "block";
      if (meta) meta.textContent = "";
      if (clear) clear.style.display = "none";
    }

    // 초기 기존 이미지 표시
    const given = (existing && existing.value) || (img && img.dataset && img.dataset.initial) || "";
    if (given) showPreviewFromExisting(given);

    // 파일 선택 시
    input?.addEventListener("change", () => {
      resetPreview();
      const file = input.files?.[0];
      if (!file) return;

      if (!file.type || !file.type.startsWith("image/")) {
        alert("이미지 파일만 업로드할 수 있어요.");
        input.value = "";
        return;
      }
      if (file.size > MAX_BYTES) {
        alert("이미지 용량이 너무 큽니다. (최대 5MB)");
        input.value = "";
        return;
      }

      showPreviewFromFile(file);
    });

    // 이미지 지우기
    clear?.addEventListener("click", () => {
      const prev = (existing && existing.value) || (img && img.dataset && img.dataset.initial) || "";
      resetPreview();
      if (input) input.value = "";
      if (prev) showPreviewFromExisting(prev);
    });

    // 제출 검증
    form.addEventListener("submit", (e) => {
      const title = form.querySelector('input[name="newsTitle"]');
      const link  = form.querySelector('input[name="newsLinkUrl"]');

      if (!title?.value.trim()) { e.preventDefault(); alert("제목을 입력해 주세요."); title?.focus(); return; }
      if (!link?.value.trim())  { e.preventDefault(); alert("링크(URL)를 입력해 주세요."); link?.focus();  return; }

      const hasExisting = !!((existing && existing.value) || (img && img.dataset && img.dataset.initial));
      const hasNewFile  = !!(input && input.files && input.files[0]);
      const isCreate    = form.dataset.mode === "create";

      if (isCreate && !hasNewFile) {
        e.preventDefault(); alert("배너 이미지를 첨부해 주세요."); input?.focus(); return;
      }
    });

    window.addEventListener("beforeunload", () => { if (objectUrl) URL.revokeObjectURL(objectUrl); });
  });
})();
