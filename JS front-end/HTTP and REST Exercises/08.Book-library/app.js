function attachEvents() {
  const BASE_URL = 'http://localhost:3030/jsonstore/collections/books/';
  const loadBooks = document.getElementById('loadBooks');
  const booksContainer = document.querySelector('table > tbody');
  const [titleInput, authorInput] = Array.from(document.querySelectorAll('#form > input'));
  const submitBtn = document.querySelector('#form > button');
  const formHeader = document.querySelector('#form > h3');
  let editBookId = null;

  loadBooks.addEventListener('click', allBooksLoader);
  submitBtn.addEventListener('click', createBookHandler)

  async function allBooksLoader () {
    booksContainer.innerHTML = '';
    let bookResponse = await fetch (BASE_URL);
    let booksObject = await bookResponse.json();
    allBooks = booksObject;

    for (const bookId in booksObject) {
        const {author, title} = booksObject[bookId];

        let tr = document.createElement('tr');
        let titleCol = document.createElement('td');
        let authorCol = document.createElement('td');
        let thirdCol = document.createElement('td');
        let editBtn = document.createElement('button');
        let delBtn = document.createElement('button');

        titleCol.textContent = title;
        authorCol.textContent = author;
        editBtn.textContent = 'Edit';
        delBtn.textContent = 'Delete';
        delBtn.id = bookId;

        editBtn.addEventListener('click', () => {
          editBookId = bookId;
          formHeader.textContent = 'Edit FORM';
          submitBtn.textContent = 'Save';
          titleInput.value = title;
          authorInput.value = author;
        });

        delBtn.addEventListener('click', deleteHandler);

        tr.appendChild(titleCol);
        tr.appendChild(authorCol);
        thirdCol.appendChild(editBtn);
        thirdCol.appendChild(delBtn);
        tr.appendChild(thirdCol);
        booksContainer.appendChild(tr);


       
  }

}

async function createBookHandler (){
  let title = titleInput.value;
  let author = authorInput.value;
  const httpHeaders = {
    method: 'POST',
    body: JSON.stringify({title, author})
  }
  let url = BASE_URL;

  if(formHeader.textContent === 'Edit FORM'){
    httpHeaders.method = 'PUT';
    url += editBookId;
  }

  const responseData = await fetch (url, httpHeaders);
  loadBooks();

  if(formHeader.textContent === 'Edit FORM'){
    formHeader.textContent = 'FORM';
    submitBtn.textContent = 'Submit';

  }
  titleInput.value = '';
  authorInput.value = '';
}

async function deleteHandler (){
  const id = this.id;
  const httpHeaders = {
    method: 'DELETE'
  }

  await fetch (BASE_URL + id, httpHeaders);
  loadBooks();
}
}

attachEvents();