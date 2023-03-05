function signCheck (numOne, numTwo, numThree){
    let numbers = [numOne, numTwo, numThree];
    let count = numbers.filter(num => num < 0).length;

    if(count % 2 === 0){
        console.log('Positive');
    }else{
        console.log('Negative');
    }
}