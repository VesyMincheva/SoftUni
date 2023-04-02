function lockedProfile() {
    let profiles = Array.from(document.getElementsByClassName('profile'));
    let btns = Array.from(document.getElementsByTagName('button'));
    for (const btn of btns) {
        btn.addEventListener('click', clickHandler);

        function clickHandler (e){
            let div =  e.target.parentElement.children[9];
            let locked = e.target.parentElement.children[2];
            
            if (btn.textContent == 'Show more' && !locked.checked){
                btn.textContent = 'Hide it';
               
               div.style.display = 'block';
               console.log(div);
            }else if(btn.textContent == 'Hide it' && !locked.checked){
                btn.textContent = 'Show more';
                div.style.display = 'none';
            }
        }
    }
    
}