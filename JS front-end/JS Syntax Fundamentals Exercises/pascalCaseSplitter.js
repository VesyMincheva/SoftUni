function solve (text){
    let output = '';
    for (const symbol of text) {
        let askii = symbol.charCodeAt(0);

        if(askii >= 65 && askii <= 90){
            if(output.length > 0){
                output += ', ';
            }
            output += symbol;
        }else{
            output += symbol;
        }
    }
    console.log(output);
}
