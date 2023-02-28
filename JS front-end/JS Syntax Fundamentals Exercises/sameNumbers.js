function solve (input){
    let onlySameDigits = true;
    let inputAsText = "" + input;
    let firstDigit = inputAsText.charAt(0);
    let sum = 0;
    for (const symbol of inputAsText) {
        
        let digit = Number (symbol);
        sum += digit;
        if(digit != firstDigit){
            onlySameDigits = false;
        }
    }
    if(onlySameDigits){
        console.log('true');
    }else{
        console.log('false');
    }

    console.log(sum);
}

solve(2222222);
solve(1234);