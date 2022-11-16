$(function () {
    display();
    getAddresses();

    $("#add-form").submit(function (event) {

        const address = $("#addresses").val();
        console.log(address);
        let addrArray = address.split(",")
        let addressJson = {
            "id": addrArray[0].trim(),
            "line1": addrArray[1].trim(),
            "line2": addrArray[2].trim(),
            "line3": addrArray[3].trim(),
            "city": addrArray[4].trim(),
            "county": addrArray[5].trim(),
            "postcode": addrArray[6].trim()
        }
        const obj = $(this).serializeJSON();
        obj.address = addressJson;
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
    $.get("http://localhost:8282/trader/counter_party/list", function (addresses) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        $.each(addresses, function (i, counterParty) {
            html += "<div class='data-card counter-party'>"
            html += "<div class='hover-edit'>";
            html += "<button class='delete edit-icon' onclick=deleteById(" + counterParty.id + ")><i class='fa-solid fa-trash'></i></button>";
            html += "<button class='update edit-icon' onclick=openUpdateModal(" + counterParty.id + ", " + counterParty.line1 + ", " + counterParty.line2 + ")><i class='fa-solid fa-pen-to-square'></i></button>";
            html += "</div>";
            html += "<h3>" + counterParty.name + "</h3>";
            html += "<div>"
            html += "<p><b>Phone: </b>" + counterParty.phoneNumber + "</p>";
            html += "<p><b>Email: </b>" + counterParty.emailAddress + "</p>";
            html += "</div>";
            html += "<div>";
            html += "<p class='cp-address'><b>Address</b></p>"
            html += "<ul class='data-list'>";
            html += "<li><b>Line 1: </b>" + counterParty.address.line1 + "</li>";
            html += "<li><b>Line 2: </b>" + counterParty.address.line2 + "</li>";
            html += "<li><b>Line 3: </b>" + counterParty.address.line3 + "</li>";
            html += "<li><b>City: </b>" + counterParty.address.city + "</li>";
            html += "<li><b>County: </b>" + counterParty.address.county + "</li>";
            html += "<li><b>Postcode: </b>" + counterParty.address.postcode + "</li>";
            html += "</ul>";
            html += "</div>"
            html += "</div>";
        });
        html += "</div>";
        $("#data-container").append($(html));
    });
}

function getAddresses() {
    $.get("http://localhost:8282/trader/address/list", function (addresses) {
        $.each(addresses, function (i, addr) {
            $("#addresses").append("<option>" + addr.id + ", " + addr.line1 + ", " + addr.line2 + ", " + addr.line3 + ", " + addr.city + ", " + addr.county + ", " + addr.postcode + "</option>");
        });
    });
}

function deleteById(id) {

    let promise = new Promise(function (resolve, reject) {
        let urlStr = "http://localhost:8282/trader/counter_party/" + id;
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

function update(data) {

    let promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: "PUT",
            url: "http://localhost:8282/trader/counter_party",
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
            url: "http://localhost:8282/trader/counter_party",
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

