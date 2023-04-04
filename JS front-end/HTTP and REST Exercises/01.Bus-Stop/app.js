function getInfo() {
    let input = document.getElementById('stopId');
    let stopId = input.value;
    let BASE_URL = 'http://localhost:3030/jsonstore/bus/businfo/';
    let stopName = document.getElementById('stopName');
    let busesContainer = document.getElementById('buses');

    busesContainer.innerHTML = '';
    fetch (`${BASE_URL}${stopId}`)
        .then((res) => res.json())
        .then((data) => {
            let {buses, name} = data;
            stopName.textContent = name;
                
            for (let busId in buses) {
                let li = document.createElement('li');
                li.textContent = `Bus ${busId} arrives in ${buses[busId]} minutes`;
                busesContainer.appendChild(li);
            }
        })
        .catch((err) => {
            stopName.textContent = 'Error';
        })
        
}