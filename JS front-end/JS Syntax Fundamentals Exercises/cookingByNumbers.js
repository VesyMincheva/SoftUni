function solve (number, ...operations){
    let result = Number (number);

    for (let i = 0; i < operations.length; i++) {
        const element = operations[i];
        switch(element){
            case 'chop':
                result = result / 2;
                break;
            case 'dice':
                result = Math.sqrt(result);
                break;
            case 'spice':
                result = result + 1;
                break;
            case 'bake':
                result = result * 3;
                break;
            case 'fillet':
                result = result - result * 0.2;
                break;
        }
        console.log(result);
    }
}
