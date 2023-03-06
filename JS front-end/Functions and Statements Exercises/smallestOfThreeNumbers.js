function smallestNum (...numbers){
    return numbers.sort((a, b) => a - b).shift();
}