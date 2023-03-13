function employeesParser (input){
    let employees = input.reduce((data, employee) => {
        data[employee] = employee.length;
        return data;
    }, {})

    for (const key in employees) {
        let value = employees[key];
        console.log(`Name: ${key} -- Personal Number: ${value}`)
    }
    
}
