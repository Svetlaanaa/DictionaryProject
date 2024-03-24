//import * as mock from "./mock.js";

//export
const api = {
  async getDictionary(page, pageSize, sorting, filterBy) {
    let items = mockCatalog.items;
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
