function charsInRange (charOne, charTwo){
    
    let start = Math.min(charOne.charCodeAt(0), charTwo.charCodeAt(0));
    let end = Math.max(charOne.charCodeAt(0), charTwo.charCodeAt(0));
    let output = '';

    for (let i = start + 1; i < end; i++) {
        
        output += String. fromCharCode(i) + ' ';
    }

    console.log(output);
}
