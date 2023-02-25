function solve (text, searchWord){
    let words = text.split(' ');
    let count = 0;

    for (const word of words) {
        if(word === searchWord){
            count++;
        }
    }
    console.log(count);
}
