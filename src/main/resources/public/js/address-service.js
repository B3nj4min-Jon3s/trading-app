$(function () {
    display();

    $("#add-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        add(data);
    });

    $("#update-form").submit(function (event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        update(data);
    });
});

function display() {
    $.get("http://localhost:8282/trader/address/list", function (addresses) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(addresses, function (i, address) {
            console.log(address)
            html += "<div class='data-card'>"
            html += "<div class='hover-edit'>";
            html += "<button class='delete edit-icon' onclick=deleteById(" + address.id + ")><i class='fa-solid fa-trash'></i></button>";
            html += "<button class='update edit-icon' data-bs-target='#updateModal' data-bs-toggle='modal' onclick='openUpdateModal(" + address.id + ",\"" + address.line1 + "\",\"" + address.line2 + "\",\"" + address.line3 + "\",\"" + address.city + "\",\"" + address.county + "\",\"" + address.postcode + "\")'><i class='fa-solid fa-pen-to-square'></i></button>";
            html += "</div>";
            html += "<ul class='data-list'>";
            html += "<li><b>Line 1: </b>" + address.line1 + "</li>";
            html += "<li><b>Line 2: </b>" + address.line2 + "</li>";
            html += "<li><b>Line 3: </b>" + address.line3 + "</li>";
            html += "<li><b>City: </b>" + address.city + "</li>";
            html += "<li><b>County: </b>" + address.county + "</li>";
            html += "<li><b>Postcode: </b>" + address.postcode + "</li>";
            html += "</ul>";
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}

function deleteById(id) {

    let promise = new Promise(function (resolve, reject) {
        let urlStr = "http://localhost:8282/trader/address/" + id;
        $.ajax({
            type: "DELETE",
            url: urlStr
        });
        resolve(); // when successful
    });

    // "Consuming Code" (Must wait for a fulfilled Promise)
    promise.then(
        function (value) {
            display();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        window.location.reload();
    });
}

function setUpdateModalFields(id, line1, line2, line3, city, county, postcode) {
    $("#id-update").val(id);
    $("#addrLine1-update").val(line1);
    $("#addrLine2-update").val(line2);
    $("#addrLine3-update").val(line3);
    $("#city-update").val(city);
    $("#county-update").val(county);
    $("#postcode-update").val(postcode);
}

function openUpdateModal(id, name, symbol) {
    setUpdateModalFields(id, name, symbol);
}

function update(data) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "PUT",
            url: "http://localhost:8282/trader/address",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    // "Consuming Code" (Must wait for a fulfilled Promise)
    promise.then(
        function (value) {
            display();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        window.location.reload();
    });
}

function add(data) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8282/trader/address",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        resolve(); // when successful
    });

    // "Consuming Code" (Must wait for a fulfilled Promise)
    promise.then(
        function (value) {
            display();
        },
        function (error) { /* code if some error */ }
    ).then(function (value) {
        window.location.reload();
    });
}

