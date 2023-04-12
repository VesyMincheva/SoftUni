    function sprintReview (input){
        let n = input.shift();
        
        let people = {};
        
        for (let i = 0; i < n; i++) {
            let [assignee, taskId, title, status, estimatedPoints] = input[i].split(':');
            if(!people.hasOwnProperty(assignee)){
                people[assignee] = [];
            people[assignee].push({taskId, title, status, estimatedPoints})
            }else{
                people[assignee].push({taskId, title, status, estimatedPoints});
            }
        }
    
        for (let index = n; index < input.length; index++) {
            let commandParts = input[index].split(':');
            let command = commandParts.shift();

            if(command === 'Add New'){
                addNew(...commandParts);
            }else if (command === 'Change Status'){
                changeStatus(...commandParts);
            }else if (command === 'Remove Task'){
                removeTask(...commandParts);
            }
        }
        
        let toDoPoints = 0;
        let inProgressPoints = 0;
        let codeReviewPoints = 0;
        let donePoints = 0;

        let allPeople = Object.values(people);
        for (const person of allPeople) {
            
            for (const line of person) {
                
                if(line.status === 'ToDo' && line.estimatedPoints){
                    toDoPoints += Number(line.estimatedPoints);
                }
                if(line.status === 'In Progress' && line.estimatedPoints){
                    inProgressPoints += Number(line.estimatedPoints);
                }
                if(line.status === 'Code Review' && line.estimatedPoints){
                    codeReviewPoints += Number(line.estimatedPoints);
                }
                if(line.status === 'Done' && line.estimatedPoints){
                    donePoints += Number(line.estimatedPoints);
                }
            }
        }

        console.log(`ToDo: ${toDoPoints}pts`);
        console.log(`In Progress: ${inProgressPoints}pts`);
        console.log(`Code Review: ${codeReviewPoints}pts`);
        console.log(`Done Points: ${donePoints}pts`);

        if(donePoints >= toDoPoints + inProgressPoints + codeReviewPoints ){
            console.log('Sprint was successful!');
        }else{
            console.log('Sprint was unsuccessful...')
        }

        function addNew (assignee, taskId, title, status, estimatedPoints){
            if(people.hasOwnProperty(assignee)){
                people[assignee].push({taskId, title, status, estimatedPoints});
            }else{
                console.log(`Assignee ${assignee} does not exist on the board!`)
            }
        }

        function changeStatus(assignee, taskId, newStatus){
            if(!people.hasOwnProperty(assignee)){
                console.log(`Assignee ${assignee} does not exist on the board!`)
            }else{
                let hasTask = false;
                for (const task of people[assignee]) {
                    if(task.taskId === taskId){
                        task.status = newStatus;
                        hasTask = true;
                    }
                }

                if(!hasTask){
                    console.log(`Task with ID ${taskId} does not exist for ${assignee}!`)
                }   
            }
        }

        function removeTask (assignee, indexToRemove){
            
            let index = Number (indexToRemove);
            if(!people.hasOwnProperty(assignee)){
                console.log(`Assignee ${assignee} does not exist on the board!`)
    
            }else{
                if(people[assignee].length <= index || index < 0){
                    console.log('Index is out of range!')
                }else{
                    people[assignee].splice(index, 1);
                }
            }

        }
    
    }

sprintReview([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]);