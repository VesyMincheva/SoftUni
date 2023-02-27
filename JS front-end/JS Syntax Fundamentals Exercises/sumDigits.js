function solve (num){
    num = "" + num;
    let sum = 0;
    for (const digit of num) {
        let symbol = Number (digit);
        sum += symbol;
    }
    console.log(sum);
}
