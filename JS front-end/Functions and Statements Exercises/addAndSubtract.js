function calculateSumAndSubtract (firstNum, secondNum, thirdNum){


    function sum (a, b){
        return a + b;
    }

    function subtract (a, b){
        return a - b;
    }

    console.log(subtract(sum(firstNum, secondNum), thirdNum));
}
