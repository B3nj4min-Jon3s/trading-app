$(function () {
    displayEquities();

    $("#add-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        addEquity(data);
    });

    $("#update-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        updateEquity(data);
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
            html += "<button class='update edit-icon' data-bs-target='#updateModal' data-bs-toggle='modal' onclick='openUpdateModal(" + equity.id + ",\"" + equity.name + "\",\"" + equity.symbol + "\")'><i class='fa-solid fa-pen-to-square'></i></button>";
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
        window.location.reload();
    });
}

function setUpdateModalFields(id, name, symbol) {
    $("#id-update").val(id);
    $("#name-update").val(name);
    $("#symbol-update").val(symbol);
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
        window.location.reload();
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
        window.location.reload();
    });
}

