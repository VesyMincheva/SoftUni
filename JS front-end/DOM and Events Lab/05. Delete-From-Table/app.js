function deleteByEmail() {
    let tdArr = Array.from(document.querySelectorAll('td:nth-child(even)'));
    let inputArea = document.querySelector('label > input');
    let inputText = inputArea.value;
    let resultContainer = document.getElementById('result');
    for (const td of tdArr) {
        if(td.textContent === inputText){
            resultContainer.textContent = 'Deleted.'
            td.parentElement.remove();
            break;
        }else {
            resultContainer.textContent = 'Not found.'
        }
    }
}