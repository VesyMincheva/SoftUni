function townsParser (input){
    
    for (const line of input) {
        let [town, latitude, longitude] = line.split(" | ");
        let townObj = {town, latitude: Number(latitude).toFixed(2), longitude: Number(longitude).toFixed(2)};
        console.log(townObj);
    }
}
