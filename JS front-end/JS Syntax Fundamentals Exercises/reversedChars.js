function solve (a, b, c) {
    let textArr = [];
    textArr.push(a);
    textArr.push(b);
    textArr.push(c);
    let result = "";
    for (let i = textArr.length - 1; i >= 0; i--) {
        let element = textArr[i];
        result += element + " ";
    }

    console.log(result);

}

solve('A','B','C');
solve('1',
'L',
'&'
);
