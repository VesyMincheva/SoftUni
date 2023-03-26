function makeDictionary(input){
    let words = {};
    for (const line of input) {
        let wordObj = JSON.parse(line);
        let key = Object.keys(wordObj)[0];
        let value = Object.values(wordObj)[0];
        words[key] = value;
    }
    let sortedWords = Object.entries(words).sort((a, b) => {
        let [keyA, _vA] = a;
        let [keyB, _vB] = b;
       
        return keyA.localeCompare(keyB);
    });

    for (const [term, definition] of sortedWords) {
        console.log(`Term: ${term} => Definition: ${definition}`)
    }
}

makeDictionary([
    '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]);