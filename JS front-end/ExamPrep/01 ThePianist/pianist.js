function pianist (input){
  let n = input.shift();
  let pieces = {};

  for (let i = 0; i < n; i++) {
    let [piece, composer, key] = input[i].split('|');
    pieces[piece] = {composer, key};    
  }

  for (let i = n; i < input.length; i++) {
    let commandLine = input[i].split('|');
    let command = commandLine[0];

    if(command === 'Add'){
      addPiece(...commandLine.splice(1));
    }else if (command === 'Remove'){
      removePiece(...commandLine.splice(1));
    }else if (command === 'ChangeKey'){
      changeKey(...commandLine.splice(1));
    }else if (command === 'Stop'){
      for (const piece in pieces) {
        console.log(`${piece} -> Composer: ${pieces[piece].composer}, Key: ${pieces[piece].key}`)
      }
    }

    function addPiece (piece, composer, key){
      if(pieces.hasOwnProperty(piece)){
        console.log(`${piece} is already in the collection!`);
      }else{
        pieces[piece] = {composer, key};
        console.log(`${piece} by ${composer} in ${key} added to the collection!`)
      }
    }

    function removePiece (piece){
      if(pieces.hasOwnProperty(piece)){
        delete pieces[piece];
        console.log(`Successfully removed ${piece}!`)
      }else{
        console.log(`Invalid operation! ${piece} does not exist in the collection.`)
      }
    }

    function changeKey (piece, newKey){
      if(pieces.hasOwnProperty(piece)){
        pieces[piece].key = newKey;
        console.log(`Changed the key of ${piece} to ${newKey}!`)
      }else{
        console.log(`Invalid operation! ${piece} does not exist in the collection.`)
      }
    }
    
  }
}

pianist([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'  
  ]);