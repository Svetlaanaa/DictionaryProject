//import * as mock from "./mock.js";

//export
const api = {
  async getDictionary(page, pageSize, sorting, filterBy, checkRandom) {
    let items = mockCatalog.items;
    if (filterBy) {
      items = items.filter(
        (i) =>{
          const hasMatchingSynonym = Array.isArray(i.synonyms) && i.synonyms.some(synonym =>
            synonym.match(new RegExp(filterBy, "gi"))
          );  
          return i.word.match(new RegExp(filterBy, "gi")) 
          || i.definition == filterBy
          || hasMatchingSynonym;
        }
      );
    }
    if (sorting) {
      items = sorted(items, sorting);
    }
    if (checkRandom) {
      const randomIndex = Math.floor(Math.random() * items.length);
      return [items[randomIndex]];
    } else {
      return items.slice(page * pageSize, (page + 1) * pageSize);
    }
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
