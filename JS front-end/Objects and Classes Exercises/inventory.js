function inventory (input){
    let heroes = [];

    for (const line of input) {
        let [heroName, heroLevel, heroItems] = line.split(' / ');
        let hero = {name: heroName, level: Number(heroLevel), items: heroItems }
        heroes.push(hero);
    }


    let sortedHeroes = heroes.sort((hero1, hero2) => {
        return hero1.level - hero2.level
    });

    sortedHeroes
    .forEach((hero) => console.log(`Hero: ${hero.name}\nlevel => ${hero.level}\nitems => ${hero.items}`));
    
}

inventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]);