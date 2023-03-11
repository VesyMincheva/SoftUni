function palindromeIntegers (numbersArr){

    numbersArr.forEach((num) => {
        console.log(isPalindrome(num))
    });

    function isPalindrome (number){
        let reversed = Number([...number.toString()].reverse().join(''));
        return number === reversed;

    }


}

palindromeIntegers([32,2,232,1010]);

