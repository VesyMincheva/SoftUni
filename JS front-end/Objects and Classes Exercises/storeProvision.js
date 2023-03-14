function storeProvision (stock, orders){
    let store = {};

    for (let line = 0; line < stock.length; line++) {
        if(line % 2 === 0){
            store[stock[line]] = Number(stock[line + 1]);
        }
    }

    for (let line = 0; line < orders.length; line++) {
        if(line % 2 === 0){
            if(store.hasOwnProperty(orders[line])){
                store[orders[line]] += Number(orders[line + 1])
            }else{
                store[orders[line]] = Number(orders[line + 1]);
            }
        }
    }

    for (const key in store) {
        console.log(`${key} -> ${store[key]}`)
    }
}
