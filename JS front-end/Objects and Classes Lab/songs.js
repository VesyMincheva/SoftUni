function songsParser (input){
    class Song {
        constructor (typeList, name, time){
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    let n = Number (input.shift());
    let searchedType = input.pop();
    let songs = [];

    for (let i = 0; i < n; i++) {
        let [typeList, name, time] = input[i].split('_');
        songs.push(new Song(typeList, name, time));
        
    }

    if(searchedType === 'all'){
        songs.forEach(s => console.log(s.name));
    }else{
        for (let index = 0; index < songs.length; index++) {
            if(songs[index].typeList === searchedType){
                console.log(songs[index].name);
            }
        }
    }

}

songsParser([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']);