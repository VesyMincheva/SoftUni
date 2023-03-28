function extractText() {
    let liContainer = document.getElementById('items');
    let resultArea = document.getElementById('result');
    let liArr = Array.from(liContainer.children);
    for (const li of liArr) {
        let textFromLi = li.textContent + '\n';
        resultArea.textContent += textFromLi;
    }
}