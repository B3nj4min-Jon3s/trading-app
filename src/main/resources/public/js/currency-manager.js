$(function () {
    displayCurrencies();

    $("#currency-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);

        $.ajax({
            type: "POST",
            url: "http://localhost:8282/admin/currency",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        displayCurrencies();
    });

    $("#currency-form-update").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        updateCurrency(data);
    });

});

function displayCurrencies() {
    $.get("http://localhost:8282/trader/currencies", function (addresses) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(addresses, function (i, currency) {
            html += "<div class='data-wrapper'>"
            html += "<div class='hover-edit'>";
            html += "<button class='delete edit-icon' onclick=deleteById(" + currency.id + ")><i class='fa-solid fa-trash'></i></button>";
            html += "<button class='update edit-icon' onclick=openUpdateModal(" + currency.id + ", " + currency.name + ", " + currency.symbol+ ")><i class='fa-solid fa-pen-to-square'></i></button>";
            html += "</div>";
            html += "<h3>" + currency.name + " | " + currency.symbol + "</h3>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}

function deleteById(id) {
    console.log("Delete: " + id);

    let promise = new Promise(function (resolve, reject) {
        let urlStr = "http://localhost:8282/admin/currency/" + id;
        $.ajax({
            type: "DELETE",
            url: urlStr
        });
        resolve(); // when successful
    });

    // "Consuming Code" (Must wait for a fulfilled Promise)
    promise.then(
        function (value) {
            console.log("getting updated currencies");
            displayCurrencies();
        },
        function (error) { /* code if some error */ }
    ).then(function(value) {
        console.log("reload window");
        location.reload();
    });
}

function setUpdateModalFields(id, name, symbol) {
    $("#id-update").val(id);
    $("#currencyName-update").val(name);
    $("#currencySymbol-update").val(symbol);
    console.log("id: " + id);
    console.log("name: " + name);
    console.log("symbol: " + symbol);
}

function openUpdateModal(id, name, symbol) {
    setUpdateModalFields(id, name, symbol);
}

function updateCurrency(currency) {
    console.log("Update: " + currency);

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "PUT",
            url: "http://localhost:8282/admin/currency",
            data: currency,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    // "Consuming Code" (Must wait for a fulfilled Promise)
    promise.then(
        function (value) {
            console.log("getting updated currencies");
            displayCurrencies();
        },
        function (error) { /* code if some error */ }
    ).then(function(value) {
        console.log("reload window");
        location.reload();
    });
}



