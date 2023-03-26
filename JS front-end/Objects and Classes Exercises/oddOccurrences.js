function oddOccurrences (input){
    let wordsObj = {};
    let words = input.split(' ');
    for (const word of words) {
        if(wordsObj.hasOwnProperty(word.toLowerCase())){
            wordsObj[word.toLowerCase()] += 1;
        }else{
            wordsObj[word.toLowerCase()] = 1;
        };
    }
    let wordsEntries = Object.entries(wordsObj);
    let filteredWords = [];
    for (const [w, count] of wordsEntries) {
        if(count % 2 !== 0){
            filteredWords.push(w);
        }
    }
    console.log(filteredWords.join(' '));
}

oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');