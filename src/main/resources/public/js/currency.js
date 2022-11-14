$(function() {
    displayCurrencies();
});

function displayCurrencies() {
    $.get("http://localhost:8282/trader/currencies", function (addresses) {
        $("#data-container").empty();
        let html = "<div class='currency'>";
        $.each(addresses, function (i, currency) {
            html += "<h3>" + currency.name + " | " + currency.symbol + "</h3>";
            html += "<p class='hidden'>" + currency.id + "</p>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}