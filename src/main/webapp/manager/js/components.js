
//export
function setAlert(alert, message) {
  if (!message) {
    alert.hidden = true;
    return;
  }
  alert.innerText = message;
  alert.hiddent = false;
}

//export
function showSortBy(sortOptions, sorting) {
  sortOptions.forEach((s) => {
    const si = s.querySelector(".bi");
    si.classList.remove("bi-sort-down-alt");
    si.classList.remove("bi-sort-up-alt");
    if (s.getAttribute("sortBy") == sorting.field) {
      si.classList.add(sorting.asc ? "bi-sort-down-alt" : "bi-sort-up-alt");
    }
  });
}
