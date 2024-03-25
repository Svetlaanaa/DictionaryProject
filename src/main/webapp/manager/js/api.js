//import * as mock from "./mock.js";

//export
const api = {
  async getDictionary(page, pageSize, sorting, filterBy) {
    let items = mockCatalog.items;
    if (filterBy) {
      items = items.filter(
        (i) =>{
          const hasMatchingSynonym = Array.isArray(i.synonyms) && i.synonyms.some(synonym =>
            synonym.match(new RegExp(filterBy, "gi"))
          );  
          return i.word.match(new RegExp(filterBy, "gi")) 
          || i.definition.match(new RegExp(filterBy, "gi"))
          || hasMatchingSynonym;
        }
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
