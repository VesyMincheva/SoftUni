function solve (text){
    let words = text.split(" ");

    let result = [];
    for (const word of words) {
        if(word.startsWith('#') && word.length > 1 && ifValidWord(word)){
            result.push(word.slice(1));
        }
    }

    console.log(result.join('\n'));

    function ifValidWord (checkWord){
        let wordToLowerCase = checkWord.toLowerCase().slice(1);
        let isValid = true;

        for (const symbol of wordToLowerCase) {
            let code = symbol.charCodeAt(0);
            if(!(code >= 97 && code <= 122)){
                isValid = false;
            }
        }

        return isValid;
    }
}