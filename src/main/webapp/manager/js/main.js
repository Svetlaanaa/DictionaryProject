//import api from "./api.js";

document.addEventListener("DOMContentLoaded", () => {
  const dictionaryContainer = document.getElementById("dictionary-container");
  const pagination = document.getElementById("dictionary-pagination");
  const search = document.getElementById("input-search");
  const sortOptions = document.querySelectorAll("[sortBy]");
  const loadingSpinner = document.getElementById("loading");
  const alert = document.getElementById("alert");

  let filterBy;
  let sorting = {};
  let currentPage = 0;
  let pageSize = 10;
  let pagesCountSet = false; // Переменная для отслеживания вызова функции setPagesCount

  search.addEventListener("change", (evt) => {
    setFilter(evt.target.value);
  });

  setSorting("word");
  loadDictionary();

  function loadDictionary() {
    setLoading(loadingSpinner, true);
    setAlert(alert);
    dictionaryContainer.replaceChildren();
    pagination.replaceChildren();

    Promise.all([
      api.getDictionary(currentPage, pageSize, sorting, filterBy),
      api.getPagesCount(pageSize),
    ])
      .then(([catalog, pagesCount]) => {
        setCatalog(dictionaryContainer, catalog);
        //if (!pagesCountSet) {
            setPagesCount(pagesCount); 
            //pagesCountSet = true;
          //}
      })
      .catch((err) => {
        console.error("getDictionary failed", err);
        setAlert(alert, "Произошла ошибка при загрузке словаря");
      })
      .finally(() => setLoading(loadingSpinner, false));
  }

  function setFilter(filter) {
    filterBy = filter;
    loadDictionary();
  }

  function setSorting(field) {
    changeSorting(sorting, field);
    showSortBy(sortOptions, sorting);
    loadDictionary();
  }

  function setCatalog(catalogContainer, items) {
    for (i of items) {
      catalogContainer.append(createCard(i));
    }

    function createCard(item) {
        const card = document.createElement('div');
        card.classList.add('card');
        card.style.width = '70rem';

        const cardBody = document.createElement('div');
        cardBody.classList.add('card-body');

        const title = document.createElement('h3');
        title.classList.add('card-title');
        title.textContent = item.word;
        title.style.color = 'brown';

        const description = document.createElement('p');
        description.classList.add('card-text');
        description.textContent = item.definition;

        const link = document.createElement('a');
        link.href = '#';
        link.classList.add('btn', 'btn-primary');
        link.textContent = 'Читать больше';

        cardBody.appendChild(title);
        cardBody.appendChild(description);
        cardBody.appendChild(link);

        card.appendChild(cardBody);

      return card;
    }
  }

  function setPagesCount(count) {
    pagination.replaceChildren();
    pagination.append(createPaginationLi(0, "&laquo;"));
    generateRange(count).forEach((p) => {
      pagination.append(createPaginationLi(p, p + 1, p == currentPage));
    });
    pagination.append(createPaginationLi(count - 1, "&raquo;"));

    function createPaginationLi(page, text, active) {
      const li = document.createElement("li");
      const a = document.createElement("a");
      li.append(a);
      li.classList.add("page-item");
      a.classList.add("page-link");
      a.style.color = "brown"
      if (active) {
        li.classList.add("active");
        a.style.backgroundColor = "brown";
        a.style.color = "white";
      } else {
        a.href = "#";
        a.addEventListener("click", () => {
          currentPage = page;
          loadDictionary();
        });
      }
      a.innerHTML = text;
      return li;
    }
  }
});
