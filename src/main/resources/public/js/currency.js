$(function() {
    displayCurrencies();
});

function displayCurrencies() {
    $.get("http://localhost:8282/trader/currencies", function (currencies) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(currencies, function (i, currency) {
            html += "<div class='data-card'>";
            html += "<h3>" + currency.name + " | " + currency.symbol + "</h3>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}