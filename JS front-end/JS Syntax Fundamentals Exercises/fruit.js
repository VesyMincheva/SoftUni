function solve (fruit, weight, price){
    let weightInKg = weight / 1000;
    let totalSum = weightInKg * price;

    console.log(`I need $${totalSum.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`)
}
