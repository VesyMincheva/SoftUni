function solve (word, text){
    let wordLowerCase = word.toLowerCase();
    let textArr = text.split(' ');

    for (const searchWord of textArr) {
        if(searchWord.toLowerCase() === word){
            return word;
        }
    }
    return `${word} not found!`;

}

