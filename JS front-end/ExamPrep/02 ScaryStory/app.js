window.addEventListener("load", solve);

function solve() {
  let storyState = {
    firstName: null,
    lastName: null,
    age: null,
    title: null,
    genre: null,
    story: null
  }

  const inputDOMSelectors = {
    firstName: document.getElementById('first-name'),
    lastName: document.getElementById('last-name'),
    age: document.getElementById('age'),
    title: document.getElementById('story-title'),
    genre: document.getElementById('genre'),
    story: document.getElementById('story')
  }

  const otherDOMSelectors = {
    publishBtn: document.getElementById('form-btn'),
    previewList: document.getElementById('preview-list'),
    mainContainer: document.getElementById('main')
  }

  otherDOMSelectors.publishBtn.addEventListener('click', publishHandler);

  function publishHandler(){
    let allFieldsHaveValue = Object.values(inputDOMSelectors)
      .every((input) => input.value !== '');

    if(!allFieldsHaveValue){
      return;
    }

    let { firstName, lastName, age, title, genre, story} = inputDOMSelectors;
    let li = createElement('li', otherDOMSelectors.previewList, null, ['story-info']);
    let article = createElement('article', li);
    createElement('h4', article, `Name: ${firstName.value} ${lastName.value}`);
    createElement('p', article, `Age: ${age.value}`);
    createElement('p', article, `Title: ${title.value}`);
    createElement('p', article, `Genre: ${genre.value}`);
    createElement('p', article, story.value);
    let saveBtn = createElement('button', li, 'Save story', ['save-btn']);
    let editBtn = createElement('button', li, 'Edit story', ['edit-btn']);
    let deleteBtn = createElement('button', li, 'Delete story', ['delete-btn']);

    editBtn.addEventListener('click', editStoryHandler);
    deleteBtn.addEventListener('click', deleteStoryHandler);
    saveBtn.addEventListener('click', saveStoryHandler);


    for (const key in inputDOMSelectors) {
      storyState[key] = inputDOMSelectors[key].value;
    }

    Object.values(inputDOMSelectors)
      .forEach((input) => input.value = '');

    otherDOMSelectors.publishBtn.setAttribute('disabled', true);

  }

  function editStoryHandler (){
    for (const key in inputDOMSelectors) {
       inputDOMSelectors[key].value = storyState[key];
    }

    otherDOMSelectors.publishBtn.removeAttribute('disabled' );
    otherDOMSelectors.previewList.innerHTML = '';
    createElement('h3', otherDOMSelectors.previewList, 'Preview');
  }

  function deleteStoryHandler (event){
    let liItem = event.currentTarget.parentNode;
    liItem.remove();
    otherDOMSelectors.publishBtn.removeAttribute('disabled');
  }

  function saveStoryHandler (){
    otherDOMSelectors.mainContainer.innerHTML = '';
    createElement('h1', otherDOMSelectors.mainContainer, 'Your scary story is saved!')
  }

  function createElement (type, parent, content, classes, id, attributes, useInnerHTML){
    const htmlElement = document.createElement(type);

    if(useInnerHTML){
      htmlElement.innerHTML = content;
    }else{
      if(content && type !== 'input'){
        htmlElement.textContent = content;
      }

      if(content && type === 'input'){
        htmlElement.value = content;
      }
    }

    if(classes && classes.length > 0){
      htmlElement.classList.add(...classes);
    }

    if(id){
      htmlElement.id = id;
    }

    if(attributes){
      for (const key in attributes) {
        htmlElement[key] = attributes[key];
      }
    }

    if(parent){
      parent.appendChild(htmlElement);
    }

    return htmlElement;
  }
}
