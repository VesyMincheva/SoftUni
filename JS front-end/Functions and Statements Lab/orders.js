function calculatePrice (product, quantity){
    
    const coffee = quantity => quantity * 1.50;
    const water = quantity => quantity * 1.00;
    const coke = quantity => quantity * 1.40;
    const snacks = quantity => quantity * 2.00;

    let operationMap = {
        coffee,
        water,
        coke,
        snacks
    }

    console.log(operationMap[product](quantity).toFixed(2))
}
