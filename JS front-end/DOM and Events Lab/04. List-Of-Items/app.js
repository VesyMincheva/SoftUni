function addItem() {
    let input = document.getElementById('newItemText');
    let liContainer = document.getElementById('items');
    let inputText = input.value;
    let li = document.createElement('li');
    li.textContent = inputText;
    liContainer.appendChild(li);
    input.value = '';
}