$(function() {
    displayEquities();
});

function displayEquities() {
    $.get("http://localhost:8282/trader/equities", function (equities) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(equities, function (i, equity) {
            html += "<div class='data-card'>";
            html += "<h3>" + equity.name + " | " + equity.symbol + "</h3>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}