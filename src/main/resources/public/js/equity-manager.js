$(function () {
    displayEquities();

    $("#add-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        addEquity(data);
    });

    $("#currency-form-update").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        updateEquities(data);
    });
});

function displayEquities() {
    $.get("http://localhost:8282/trader/equities", function (equities) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(equities, function (i, equity) {
            html += "<div class='data-card'>"
            html += "<div class='hover-edit'>";
            html += "<button class='delete edit-icon' onclick=deleteById(" + equity.id + ")><i class='fa-solid fa-trash'></i></button>";
            html += "<button class='update edit-icon' onclick=openUpdateModal(" + equity.id + ", " + equity.name + ", " + equity.symbol + ")><i class='fa-solid fa-pen-to-square'></i></button>";
            html += "</div>";
            html += "<h3>" + equity.name + " | " + equity.symbol + "</h3>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}

function deleteById(id) {
    console.log("Delete: " + id);

    let promise = new Promise(function (resolve, reject) {
        let urlStr = "http://localhost:8282/admin/equity/" + id;
        $.ajax({
            type: "DELETE",
            url: urlStr
        });
        resolve(); // when successful
    });

    promise.then(
        function (value) {
            displayEquities();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
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

function updateEquity(equity) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "PUT",
            url: "http://localhost:8282/admin/equity",
            data: equity,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    promise.then(
        function (value) {
            displayEquities();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        location.reload();
    });
}

function addEquity(equity) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8282/admin/equity",
            data: equity,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    promise.then(
        function (value) {
            displayEquities();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        location.reload();
    });
}

