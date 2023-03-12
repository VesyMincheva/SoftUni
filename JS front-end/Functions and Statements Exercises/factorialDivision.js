function factorialDivision(firstNum, secondNum){
    let firstFactorial = 1;
    let secondFactorial = 1;

    for (let i = 1; i <= firstNum; i++) {
        firstFactorial = firstFactorial * i;
    }

    for (let j = 1; j <= secondNum; j++) {
        secondFactorial = secondFactorial * j;
    }

    console.log((firstFactorial / secondFactorial).toFixed(2));

}
