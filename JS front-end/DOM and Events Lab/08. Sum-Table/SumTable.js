function sumTable() {
    let table = document.querySelector('table');
    let tdArr = Array.from(document.querySelectorAll('tbody > tr > td:nth-child(even)'));
    let sum = 0;
    for (const td of tdArr) {
        let sumOfTd = Number(td.textContent);
        sum += sumOfTd;
    }

    let lastTd = document.getElementById('sum');
    lastTd.textContent = sum;
    
}