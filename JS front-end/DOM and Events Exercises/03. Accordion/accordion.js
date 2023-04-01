function toggle() {
    let btn = document.getElementsByClassName('button')[0];
    let div = document.getElementById('extra');

    if(btn.textContent == 'More'){
        btn.textContent = 'Less';
        div.style.display = 'block'
    }else{
        btn.textContent = 'More';
        div.style.display = 'none';
    }

}