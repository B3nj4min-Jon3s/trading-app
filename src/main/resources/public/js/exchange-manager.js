$(function () {
    displayExchanges();

    $("#add-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        addExchange(data);
    });

    $("#update-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        updateExchange(data);
    });

});

function displayExchanges() {
    $.get("http://localhost:8282/trader/exchanges", function (exchanges) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(exchanges, function (i, exchange) {
            html += "<div class='data-card'>"
            html += "<div class='hover-edit'>";
            html += "<button class='delete edit-icon' onclick=deleteById(" + exchange.id + ")><i class='fa-solid fa-trash'></i></button>";
            html += "<button class='update edit-icon' data-bs-target='#updateModal' data-bs-toggle='modal' onclick='openUpdateModal(" + exchange.id + ",\"" + exchange.name + "\",\"" + exchange.symbol + "\")'><i class='fa-solid fa-pen-to-square'></i></button>";
            html += "</div>";
            html += "<h3>" + exchange.name + " | " + exchange.symbol + "</h3>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}

function deleteById(id) {
    console.log("Delete: " + id);

    let promise = new Promise(function (resolve, reject) {
        let urlStr = "http://localhost:8282/admin/exchange/" + id;
        $.ajax({
            type: "DELETE",
            url: urlStr
        });
        resolve(); // when successful
    });
    promise.then(
        function (value) {
            displayExchanges();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        window.location.reload();
    });
}

function setUpdateModalFields(id, name, symbol) {
    $("#id-update").val(id);
    $("#name-update").val(name);
    $("#nymbol-update").val(symbol);
}

function openUpdateModal(id, name, symbol) {
    setUpdateModalFields(id, name, symbol);
}

function updateExchange(exchange) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "PUT",
            url: "http://localhost:8282/admin/exchange",
            data: exchange,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    promise.then(
        function (value) {
            displayExchanges();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        window.location.reload();
    });
}

function addExchange(exchange) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8282/admin/exchange",
            data: exchange,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    let displayPromise = promise.then(
        function (value) {
            displayExchanges();
            // document.location.href = "./exchange-manage.html";
        },
        function (error) { /* code if some error */ }
    )

    displayPromise.then(
        function (value) {
            window.location.reload();
        },
        function (error) { /* code if some error */ }
    )
}

