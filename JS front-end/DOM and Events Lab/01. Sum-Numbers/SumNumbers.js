function calc() {
    const firstInput = document.getElementById('num1');
    const secondInput = document.getElementById('num2');
    const result = document.getElementById('sum');
    result.value = Number(firstInput.value) + Number(secondInput.value);
}
