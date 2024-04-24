//import api from "./api.js";

document.addEventListener("DOMContentLoaded", () => {
  // Получаем значение параметра 'index' из URL
  const urlParams = new URLSearchParams(window.location.search);
  const index = urlParams.get('index');

  // ЗАПОЛНЕНИЕ ИНФОРМАЦИЕЙ 
  function createWordBlock(wordItem) {
    const wordBlock = document.createElement('div');
    wordBlock.classList.add('word-block');
  
    const wordTitle = document.createElement('h2');
    wordTitle.textContent = wordItem.word;
    wordBlock.appendChild(wordTitle);
  
    const definitionPara = document.createElement('p');
    definitionPara.textContent = `Определение: ${wordItem.definition}`;
    wordBlock.appendChild(definitionPara);
  
    if (wordItem.otherForms.length > 0) {
      const otherFormsList = document.createElement('ul');
      otherFormsList.innerHTML = `<b>Другие формы:</b> ${wordItem.otherForms.map(form => `<li>${form}</li>`).join('')}`;
      wordBlock.appendChild(otherFormsList);
    }
  
    if (wordItem.synonyms.length > 0) {
      const synonymsList = document.createElement('ul');
      synonymsList.innerHTML = `<b>Синонимы:</b> ${wordItem.synonyms.map(synonym => `<li>${synonym}</li>`).join('')}`;
      wordBlock.appendChild(synonymsList);
    }
  
    if (wordItem.source.length > 0) {
      const sourcePara = document.createElement('p');
      sourcePara.textContent = `Источник: ${wordItem.source}`;
      wordBlock.appendChild(sourcePara);
    }
  
    return wordBlock;
  }
  
  const dictionaryContainer = document.getElementById('dictionary-container');

  const wordBlock = createWordBlock(mockCatalog.items[index]);
  dictionaryContainer.appendChild(wordBlock);
});
