function addressBook (input){
    let addresses = {};
    for (const line of input) {
        let [name, address] = line.split(':');
        addresses[name] = address;
    }

    let sortedAddresses = Object.entries(addresses)
        .sort((key, value) => {
            let a = key[0];
            let b = value[0];
            return a.localeCompare(b)
        }).map((pair) => console.log(`${pair[0]} -> ${pair[1]}`));

}

addressBook([
'Tim:Doe Crossing',
'Bill:Nelson Place',
'Peter:Carlyle Ave',
'Bill:Ornery Rd']);
