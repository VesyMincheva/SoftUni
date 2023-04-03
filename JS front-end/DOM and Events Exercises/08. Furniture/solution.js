function solve() {
  let [ inputTextArea, buyTextArea ] = Array.from(document.getElementsByTagName('textarea'));
  let [ generateBtn, buyBtn ] = Array.from(document.getElementsByTagName('button'));
  let tableBody = document.getElementsByTagName('tbody')[0];

  generateBtn.addEventListener('click', generateHandler);

  function generateHandler (){
    let products = JSON.parse(inputTextArea.value);
    for (const {decFactor, img, name, price} of products) {
      let tr = createElement('tr', tableBody);
      let firstTd = createElement('td', tr);
      htmlImg = createElement('img', firstTd, '', '', '', {src: img});
      let secondTd = createElement('td', tr);
      htmlName = createElement('p', secondTd, name);
      let thirdTd = createElement('td', tr);
      htmlPrice = createElement('p', thirdTd, price);
      let forthTd = createElement('td', tr);
      htmlDec = createElement('p', forthTd, decFactor);
      let fifthTd = createElement('td', tr);
      htmlInput = createElement('input', fifthTd, '', '', '', {type: 'checkbox'})
    }
  }
  
  buyBtn.addEventListener('click', buyHandler);

  function buyHandler() {
    let checkedItems = Array.from(document.querySelectorAll('tbody tr td input:checked'));
    let allItems = [];
    let totalPrice = 0;
    let decFactorSum = 0; 
    for (const item of checkedItems) {
      let tableRow = item.parentElement.parentElement;
      let tdArr = Array.from(tableRow.children);
      let itemName = tdArr[1].children[0].textContent;
      allItems.push(itemName);
      let currentPrice = Number(tdArr[2].children[0].textContent);
      totalPrice += currentPrice;
      let currentDecFactor = Number(tdArr[3].children[0].textContent);
      decFactorSum += currentDecFactor;
    }
    buyTextArea.textContent = `Bought furniture: ${allItems.join(', ')}\n` +
    `Total price: ${totalPrice.toFixed(2)}\n` + `Average decoration factor: ${decFactorSum/allItems.length}`
  }

  function createElement (type, parent, content, id, classes, attributes, useInnerHTML){
    let newElement = document.createElement(type);

    if(useInnerHTML && content){
      newElement.innerHTML = content;
    }else{
      if(content && type !== 'input' && type !== 'textarea'){
        newElement.textContent = content;
      }
  
      if(content && type === 'input' || type === 'textarea'){
        newElement.value = content;
      }
    }
 
    if(id){
      newElement.id = id;
    }

    if(classes && classes.length > 0){
      newElement.classList.add(...classes);
    }

    if(attributes){
      for (const key in attributes) {
        newElement.setAttribute(key, attributes[key]);
      }
    }

    if(parent){
      parent.appendChild(newElement);
    }

    return newElement;
  }
}