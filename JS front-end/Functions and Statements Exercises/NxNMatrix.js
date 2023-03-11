function nXnMatrix(number){
    let output = '';
    for (let i = 1; i <= number; i++) {
        for (let j = 1; j <= number; j++) {
           output += number + ' ';
        }
        output += '\n';
    }
    console.log(output);
}
