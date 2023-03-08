function evenAndOddSum (input){
    let number = Number (input);
    let oddSum = 0;
    let evenSum = 0;

    while (number > 0){
        let currentNum = Math.floor(number % 10);

        if(currentNum % 2 == 0){
            evenSum += currentNum;
        }else{
            oddSum += currentNum;
        }

        number = Math.floor(number / 10);
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`)

}
