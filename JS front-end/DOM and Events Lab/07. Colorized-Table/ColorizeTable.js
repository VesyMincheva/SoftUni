function colorize() {
    let trArr = Array.from(document.querySelectorAll('table > tbody > tr:nth-child(even)'));
  
    trArr.forEach((tr) => tr.style.backgroundColor = 'Teal');
}