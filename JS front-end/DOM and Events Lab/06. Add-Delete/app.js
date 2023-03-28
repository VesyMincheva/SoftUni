function addItem() {
    let liContainer = document.getElementById('items');
    let input = document.getElementById('newItemText');
    let inputText = input.value;
    let li = document.createElement('li');
    let anchor = document.createElement('a');
    anchor.textContent = '[Delete]';
    anchor.href = '#';
    li.textContent = inputText;
    li.appendChild(anchor);
    liContainer.appendChild(li);
    input.value = '';

    anchor.addEventListener('click', clickHandler );

    function clickHandler (){
        anchor.parentElement.remove();
    }
}