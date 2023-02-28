function solve (arr, num){
    let resultArr = [];

    for (let i = 0; i < arr.length; i = i + num) {
        const element = arr[i];
        resultArr.push(element);
        
    }
    return resultArr;
}
console.log(solve(['5', '20', '31', '4', '20'], 2));
console.log(solve(['dsa','asd', 'test', 'tset'], 2));
;