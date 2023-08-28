document.addEventListener("DOMContentLoaded", () => {
    const input = document.getElementById("exampleDataList");
    const searchResults = document.getElementById("searchResults");

    input.addEventListener("input", () => {
        const searchText = input.value.trim();
        const selectedCategory = document.getElementById("search").value;

        // Send search request to the server
        fetch(`/search?category=${selectedCategory}&query=${searchText}`)
            .then(response => response.json())
            .then(data => {
                // Call the function that processes the search results
                renderSearchResults(data);
            });
    });

    // Fetch all posts when the page is loaded
    fetch(`/search?category=&query=`)
        .then(response => response.json())
        .then(data => {
            renderSearchResults(data);
        });
});

function renderSearchResults(data) {
    const searchResults = document.getElementById("searchResults");
    searchResults.innerHTML = ""; // Reset existing search results

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
                <p class="card-text">${writing.category}</p>
                <p class="card-text">${writing.tag}</p>
                <span>👍 ${writing.liked} </span>
                <a href="/post/${writing.id}" class="btn btn-primary" style="background-color:#6927ff"
                >보러가기</a>
            </div>
        `;

        searchResults.appendChild(card);
    });
}

function selectOption(inputId, buttonText, element) {
    var selectedValue = element.textContent;
    document.getElementById(inputId).value = selectedValue;
    document.getElementById('boardButton').textContent = buttonText + ': ' + selectedValue;
}
