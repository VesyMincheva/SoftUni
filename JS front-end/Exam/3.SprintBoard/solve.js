// TODO:
function attachEvents() {
    let BASE_URL = 'http://localhost:3030/jsonstore/tasks/'
    let loadBtn = document.getElementById('load-board-btn');
    let addTaskBtn = document.getElementById('create-task-btn');
    let titleInput = document.getElementById('title');
    let descriptionTitle = document.getElementById('description');
    let toDoSection = document.getElementById('todo-section');
    let inProgressSection = document.getElementById('in-progress-section');
    let codeReviewSection = document.getElementById('code-review-section');
    let doneSection = document.getElementById('done-section');
    

    let allTasks = {};

    loadBtn.addEventListener('click', loadAllTasksHandler);
    addTaskBtn.addEventListener('click', addTaskHandler);

    function loadAllTasksHandler (){
        toDoSection.children[1].innerHTML = '';
        inProgressSection.children[1].innerHTML = '';
        codeReviewSection.children[1].innerHTML = '';
        doneSection.children[1].innerHTML = '';

        fetch(BASE_URL)
        .then((prom) => prom.json())
        .then((prom) => {
            let data = Array.from(Object.values(prom));
            for (const line of data) {
                let {title, description, status, _id} = line;
                allTasks[_id] = {title, description, status, _id};
                let li = document.createElement('li');
                li.classList.add('task');
                let header = document.createElement('h3');
                header.textContent = title;
                let paragraph = document.createElement('p');
                paragraph.textContent = description;
                let btn = document.createElement('button');
                if(status === 'ToDo'){
                    btn.textContent = 'Move to In Progress';
                }else if(status === 'In Progress'){
                    btn.textContent = 'Move to Code Review';
                }else if(status === 'Code Review'){
                    btn.textContent = 'Move to Done';
                }else if(status === 'Done'){
                    btn.textContent = 'Close';
                }

                btn.status = status;
                btn.taskId = _id;

                if (status === 'Done'){ 
                    btn.addEventListener('click', deleteHandler); 
                }else { 
                    btn.addEventListener('click', moveHandler); 
                } 

                li.appendChild(header);
                li.appendChild(paragraph);
                li.appendChild(btn);

                if(status === 'ToDo'){
                    toDoSection.children[1].appendChild(li);
                }else if(status === 'In Progress'){
                    inProgressSection.children[1].appendChild(li);
                }else if(status === 'Code Review'){
                    codeReviewSection.children[1].appendChild(li);
                }else if(status === 'Done'){
                    doneSection.children[1].appendChild(li);
                }
               
            }
        })
    }

    function addTaskHandler(){
        let taskTitle = titleInput.value;
        let taskDescription = descriptionTitle.value;
        let status = 'ToDo';

        let httpHeaders = {
            method: 'POST',
            body: JSON.stringify({
                "title": taskTitle,
                "description": taskDescription,
                "status": status
            })
        }

        if(taskTitle !== '' && taskDescription !== '' && status !== ''){
            fetch (BASE_URL, httpHeaders)
            .then(() => {
                loadAllTasksHandler();
                titleInput.value = '';
                descriptionTitle.value = '';
            })
            .catch((err) => {
                console.error(err);
            })
        }
    }

    function deleteHandler (){
        const taskId = this.taskId; 
         const httpHeaders = { 
             method: 'DELETE' 
         }; 
         fetch(`${BASE_URL}${taskId}`, httpHeaders)
         .then(() => {
            loadAllTasksHandler();
         } )
    }

    function moveHandler (){
        const liStatus = this.status; 
        
         const taskId = this.taskId; 
         let newStatus = '' 
         if (liStatus === 'ToDo'){ 
             newStatus = 'In Progress' 
         } else if (liStatus === 'In Progress'){ 
             newStatus = 'Code Review' 
         } else if (liStatus === 'Code Review'){ 
             newStatus = 'Done' 
         } 
         const httpHeaders = { 
             method: 'PATCH', 
             body: JSON.stringify({status: newStatus}) 
         } 
         fetch(`${BASE_URL}${taskId}`, httpHeaders)
         .then(() => {
            loadAllTasksHandler();
         })
       
    }

}

attachEvents();