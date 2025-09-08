document.addEventListener('DOMContentLoaded', function () {
  // 전체 선택 체크박스
  const headCb = document.querySelector('.mark_nav input[type="checkbox"]');
  function getRowCbs() {
    return Array.from(document.querySelectorAll('.mark_list input[type="checkbox"]'));
  }
  function syncHeaderFromRows() {
    const cbs = getRowCbs();
    const total = cbs.length;
    const checked = cbs.filter(cb => cb.checked).length;
    if (!headCb) return;
    headCb.checked = (total > 0 && checked === total);
  }
  if (headCb) {
    headCb.addEventListener('change', () => {
      getRowCbs().forEach(cb => cb.checked = headCb.checked);
    });
  }

  // 읽기 모달
  const readModal = document.getElementById('msgModal');
  function openReadModal() { readModal?.classList.add('open'); }
  function closeReadModal() { readModal?.classList.remove('open'); }
  window.closeMsgModal = closeReadModal;
  let currentRow = null;

  document.querySelectorAll('.mark_list li').forEach(row => {
    row.addEventListener('click', e => {
      if (e.target.closest('input[type="checkbox"]')) return;
      e.preventDefault();
      currentRow = row;
      openReadModal();
    });
  });

  readModal?.querySelector('.modal_close')?.addEventListener('click', closeReadModal);
  readModal?.addEventListener('click', e => {
    if (e.target === readModal) closeReadModal();
  });

  // 쪽지 보내기 모달
  const sendModal = document.getElementById('sendMsgModal');
  function openSendModal() { sendModal?.classList.add('open'); }
  function closeSendModal() { sendModal?.classList.remove('open'); }
  window.closeSendMsgModal = closeSendModal;

  document.querySelector('#msgModal .btn_reply')?.addEventListener('click', () => {
    closeReadModal();
    openSendModal();
  });
  sendModal?.querySelector('.modal_close')?.addEventListener('click', closeSendModal);
  sendModal?.querySelector('.btn_cancel')?.addEventListener('click', closeSendModal);

  // 상태 모달
  const statusModal = document.getElementById('sendSuccessModal');
  const statusMsgEl = statusModal?.querySelector('.send_message');
  function openStatusModal(message) {
    if (statusMsgEl) statusMsgEl.textContent = message;
    statusModal?.classList.add('open');
  }
  function closeStatusModal() { statusModal?.classList.remove('open'); }
  window.closeSendModal = () => { closeSendModal(); closeStatusModal(); };

  // 보내기 버튼
  sendModal?.querySelector('.btn_send')?.addEventListener('click', () => {
    closeSendModal();
    openStatusModal('쪽지를 보냈습니다.');
    document.getElementById('message_textarea').value = '';
  });

  // 삭제 확인 모달
  const deleteConfirmModal = document.getElementById('deleteMsgModal');
  function openDeleteConfirm() { deleteConfirmModal?.classList.add('open'); }
  function closeDeleteConfirm() { deleteConfirmModal?.classList.remove('open'); }
  window.closeDeleteModal = closeDeleteConfirm;

  let deleteTargets = [];
  document.querySelector('#msgModal .btn_delete')?.addEventListener('click', () => {
    if (!currentRow) return;
    closeReadModal();
    deleteTargets = [currentRow];
    openDeleteConfirm();
  });

  document.getElementById('delete')?.addEventListener('click', e => {
    e.preventDefault();
    const checkedCbs = getRowCbs().filter(cb => cb.checked);
    if (checkedCbs.length === 0) {
      openStatusModal('삭제할 쪽지를 선택하세요.');
      return;
    }
    deleteTargets = checkedCbs.map(cb => cb.closest('li')).filter(Boolean);
    openDeleteConfirm();
  });

  window.confirmDelete = function () {
    deleteTargets.forEach(el => el && el.remove());
    deleteTargets = [];
    currentRow = null;
    closeDeleteConfirm();
    syncHeaderFromRows();
    if (headCb) headCb.checked = false;
    openStatusModal('쪽지가 삭제되었습니다.');
  };

  // 체크박스 동기화
  getRowCbs().forEach(cb => cb.addEventListener('change', syncHeaderFromRows));
  syncHeaderFromRows();
});
