function solve() {
let textArea = document.getElementById('input');
let result= document.getElementById('output');
let text = textArea.value;
let sentences = text.split('.');
sentences.pop();

while(sentences.length > 0){
  let firstThree = sentences.splice(0, 3).map((s) => s.trimStart());
  let paragraph = document.createElement('p');
 
  paragraph.textContent = firstThree.join('. ') + '.';
 
  
  result.appendChild(paragraph);
}
textArea.value = '';
}