function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let input = document.getElementById('searchField');
      let inputText = input.value;

      let searchArea = Array.from(document.getElementsByTagName('tr'));
      for (const tr of searchArea) {
         if(tr.classList.contains('select')){
            tr.classList.remove('select');
         }

         if(tr.textContent.trim().includes(inputText)){
            tr.classList.add('select');
         }
         console.log(tr.textContent);
      }
      input.value = '';
      
   }
}