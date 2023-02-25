function solve (n, inputArr){
    let numbers = [];
    for (let i = 0; i < n; i++) {
        numbers.push(inputArr[i]);
        
    }

    let output = "";
    for (let i = numbers.length-1; i >= 0; i--) {
        
        output+= numbers[i] + ' ';
    }
    console.log(output);
}