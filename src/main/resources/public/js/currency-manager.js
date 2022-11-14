$(function() {
    displayCurrencies();
    setUpDelete();
});

function displayCurrencies() {
    $.get("http://localhost:8282/trader/currencies", function (addresses) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
            html += "<div class='hover-edit'>";
                html += "<a class='delete'><i class='fa-solid fa-trash'></i></a>";
                html += "<a class='update'><i class='fa-solid fa-pen-to-square'></i></a>";
            html += "</div>";
        $.each(addresses, function (i, currency) {
            html += "<h3>" + currency.name + " | " + currency.symbol + "</h3>";
            html += "<p class='hidden'>" + currency.id + "</p>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}

function setUpDelete() {
    $(".delete").array.forEach(element => {
        console.log(element);
    });
}