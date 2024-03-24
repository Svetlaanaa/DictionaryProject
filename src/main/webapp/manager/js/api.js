//import * as mock from "./mock.js";

//export
const api = {
  async getDictionary(page, pageSize, sorting, filterBy) {
    let items = mockCatalog.items;
    if (filterBy) {
      items = items.filter(
        (i) =>
          i.word == filterBy || i.word.match(new RegExp(filterBy, "gi")) || i.definition.match(new RegExp(filterBy, "gi"))
      );
    }
    if (sorting) {
      items = sorted(items, sorting);
    }
    return items.slice(page * pageSize, (page + 1) * pageSize);
  },

  getPagesCount(pageSize) {
    return new Promise((resolve) =>
      setTimeout(
        () => resolve(Math.ceil(mockCatalog.items.length / pageSize)),
        1200
      )
    );
  },
};