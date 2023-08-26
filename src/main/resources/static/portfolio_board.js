// portfolio_board.js
document.addEventListener("DOMContentLoaded", () => {
    const input = document.getElementById("exampleDataList");
    const searchResults = document.getElementById("searchResults");

    input.addEventListener("input", () => {
        const searchText = input.value.trim();
        const selectedCategory = document.getElementById("search").value;

        // 서버로 검색 요청 보내기
        fetch(`/search?category=${selectedCategory}&query=${searchText}`)
            .then(response => response.json())
            .then(data => {
                // 검색 결과를 처리하는 함수 호출
                renderSearchResults(data);
            });
    });
});

document.addEventListener("DOMContentLoaded", () => {
    const searchResults = document.getElementById("searchResults");

    fetch(`/search?category=&query=`) // category와 query를 빈 값으로 보내면 모든 게시물을 가져옴
        .then(response => response.json())
        .then(data => {
            renderSearchResults(data);
        });
});


function renderSearchResults(data) {
    const searchResults = document.getElementById("searchResults");
    searchResults.innerHTML = ""; // 기존 검색 결과 초기화

    if (data.length === 0) {
        searchResults.innerHTML = "<p>검색 결과가 없습니다.</p>";
        return;
    }

    data.forEach(writing => {
        const card = document.createElement("div");
        card.classList.add("card", "col-3");
        card.id = "card-" + writing.id;

        card.innerHTML = `
            <img src="/images/no_image.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${writing.title}</h5>
                <p class="card-text">${writing.content}</p>
                <p class="card-text">${writing.tag}</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        `;

        searchResults.appendChild(card);
    });
}
const input = document.getElementById("exampleDataList");
const searchResults = document.getElementById("searchResults");

input.addEventListener("input", () => {
    const searchText = input.value.trim();
    const selectedCategory = document.getElementById("search").value;

    // 서버로 검색 요청 보내기
    fetch(`/search?category=${selectedCategory}&query=${searchText}`)
        .then(response => response.json())
        .then(data => {
            // 검색 결과를 처리하는 함수 호출
            renderSearchResults(data);
        });
});
function selectOption(inputId, buttonText, element) {
    var selectedValue = element.textContent;
    document.getElementById(inputId).value = selectedValue;
    document.getElementById('boardButton').textContent = buttonText + ': ' + selectedValue;
}