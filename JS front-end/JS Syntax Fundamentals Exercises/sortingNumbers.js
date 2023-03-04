function solve (numbers){
    let sortedNumbers = numbers.sort((a, b) => a - b);
    let resultArr = [];
    let step = 0;
    
    while (sortedNumbers.length > 0){
        if(step % 2 === 0){
            resultArr.push(sortedNumbers.shift());
        }else{
            resultArr.push(sortedNumbers.pop());
        }
        step++;
    }

    console.log(resultArr);

}
solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);
