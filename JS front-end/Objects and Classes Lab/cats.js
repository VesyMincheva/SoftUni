function solve (input){
    class Cat {
        constructor(name, age){
            this.name = name;
            this.age = age;
        }
        
        meow() {
        console.log(`${this.name}, age ${this.age} says Meow `)
        }
    }

    let cats = [];
    

    for (const line of input) {
        let [catName, catAge] = line.split(' ');
        cats.push(new Cat (catName, catAge));
    }
    
    for (const cat of cats) {
        cat.meow();
    }

}

solve(['Mellow 2', 'Tom 5']);