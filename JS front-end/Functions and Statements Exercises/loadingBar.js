function loadingBar (input){
    let symbolCount = input / 10;
    let firstSymbol = '%';
    let secondSymbol = '.';

    if(symbolCount < 10){
        console.log(`${input}% [${firstSymbol.repeat(symbolCount)}${secondSymbol.repeat(10-symbolCount)}]`);
        console.log('Still loading...');
    }else{
        console.log('100% Complete!')
        
    }

}

loadingBar(30);
loadingBar(50);
loadingBar(100);