function solve (speed, area){

    let limit;

    switch(area){
        case 'motorway':
            limit = 130;
            break;
        case 'interstate':
            limit = 90;
            break;
        case 'city':
            limit = 50;
            break;
        case 'residential':
            limit = 20;
            break;
    }

    let difference = speed - limit;
    let status;
    if(difference <= 0){
        console.log(`Driving ${speed} km/h in a ${limit} zone`)
    }else if (difference <= 20) {
        status = 'speeding';
    }else if(difference <= 40){
        status = 'excessive speeding';
    }else{
        status = 'reckless driving';
    }

    if(status){
        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${limit} - ${status}`)
    }
}
