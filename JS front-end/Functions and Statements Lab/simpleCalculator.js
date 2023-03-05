function simpleCalculator (firstNum, secondNum, operation){

    let multiply = (a, b) => a * b;
    let divide = (a, b) => a / b;
    let add = (a, b) => a + b;
    let subtract = (a, b) => a - b;

    let operationsMap = {
        multiply,
        divide,
        add,
        subtract
    }

    console.log(operationsMap[operation](firstNum, secondNum));
}