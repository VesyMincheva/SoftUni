function solve (input){
    let type = typeof(input);
    let result;

    if(type === "number"){
        result = (input ** 2) * Math.PI;
        console.log(result.toFixed(2)); 
    }else{
        console.log(`We can not calculate the circle area, because we receive a ${type}.`)
    }
}
