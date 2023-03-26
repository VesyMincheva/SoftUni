function piccolo (input){
    let cars = {};
    for (const line of input) {
        let [command, number] = line.split(', ');
        if(command === 'IN'){
            cars[number] = number;
        }else{
            delete cars[number];
        }
    }

    if(Object.keys(cars).length !== 0){
        let sortedCars = Object.keys(cars).sort((carA, carB) => {
            return carA.localeCompare(carB);
        })
        sortedCars.forEach((c) => console.log(c))
    }else{
        console.log('Parking Lot is Empty');
    }

}
