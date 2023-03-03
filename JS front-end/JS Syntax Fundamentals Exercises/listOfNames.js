function solve (names){
    let sortedNames = names.sort((a, b) => a.localeCompare(b));
    let counter = 1;
    for (let i = 0; i < sortedNames.length; i++) {
        const element = sortedNames[i];
        console.log(`${counter}.${element}`);
        counter++;
    }
}
