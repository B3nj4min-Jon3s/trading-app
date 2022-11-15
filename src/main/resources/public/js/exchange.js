$(function() {
    displayExchanges();
});

function displayExchanges() {
    $.get("http://localhost:8282/trader/exchanges", function (exchanges) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(exchanges, function (i, exchange) {
            html += "<div class='data-card'>";
            html += "<h3>" + exchange.name + " | " + exchange.symbol + "</h3>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}