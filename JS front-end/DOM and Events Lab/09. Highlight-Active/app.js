function focused() {
    let inputsArr = Array.from(document.querySelectorAll('input'));
    
    for (const input of inputsArr) {
        input.addEventListener('focus', focusHandler);
        input.addEventListener('blur', blurHandler);

        function focusHandler(event){
            
            let div = event.target.parentElement;
            div.classList.add('focused');
        }

        function blurHandler (event){
            let div = event.target.parentElement;
            if(div.classList.contains('focused')){
                div.classList.remove('focused');
            }
            

        }
    }
}