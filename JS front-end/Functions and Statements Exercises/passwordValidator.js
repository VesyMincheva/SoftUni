function passValidator (password){
    const checkLength = (pass) => pass.length >= 6 && pass.length <= 10;
    const isOnlyLettersOrDigits =  (pass) => /^[A-Za-z0-9]+$/g.test(pass);
    const hasTwoDigits = (pass) => [...pass.matchAll(/\d/g)].length;

    if(!checkLength(password)){
        console.log('Password must be between 6 and 10 characters');
    }

    if(!isOnlyLettersOrDigits(password)){
        console.log('Password must consist only of letters and digits')
    }

    if (hasTwoDigits(password) < 2){
        console.log('Password must have at least 2 digits')
    }

    if(checkLength(password) && isOnlyLettersOrDigits(password) && hasTwoDigits(password) >= 2){
        console.log('Password is valid');
    }

}

passValidator('logIn');
passValidator('Pa$s$s');