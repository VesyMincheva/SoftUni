function addItem() {
    let textInput = document.getElementById('newItemText');
    let valueInput = document.getElementById('newItemValue');
    let select = document.getElementById('menu');
    let option = document.createElement('option');
    option.textContent = textInput.value;
    option.value = valueInput.value;
    
    select.appendChild(option);
    
    textInput.value = '';
    valueInput.value = '';
}