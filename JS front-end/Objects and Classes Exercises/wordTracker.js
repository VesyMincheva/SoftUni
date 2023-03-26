function wordsTracker (input){
    let words = input.shift().split(' ');
    let wordsObj = {};

    for (const word of words) {
        wordsObj[word] = 0;
    }

    for (const item of input) {
        if(wordsObj.hasOwnProperty(item)){
            wordsObj[item] += 1;
        }
    }

    let sortedWords = Object.entries(wordsObj).sort((word1, word2) => {
        return word2[1] - word1[1];
    })

    for (const [w, count] of sortedWords) {
       console.log(`${w} - ${count}`);
    }
}
