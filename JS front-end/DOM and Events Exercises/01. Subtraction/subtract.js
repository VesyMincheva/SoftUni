function subtract() {
    let firstNumInput = document.getElementById('firstNumber');
    let secondNumInput = document.getElementById('secondNumber');
    let resultInput = document.getElementById('result');

    let firstNum = Number (firstNumInput.value);
    let secondNum = Number (secondNumInput.value);

    let result = firstNum - secondNum;

    resultInput.textContent = result;
}