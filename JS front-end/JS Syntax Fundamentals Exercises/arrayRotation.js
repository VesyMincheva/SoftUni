function solve (arr, num){

    for (let i = 0; i < num; i++) {
        let firstEl = arr[0];
        arr.splice(0, 1);
        arr.push(firstEl);
    }

    console.log(arr.join(" "));
    
}

solve([51, 47, 32, 61, 21], 2);
solve([32, 21, 61, 1], 4);