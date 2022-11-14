$(function () {

    console.log($("#currency-form"));

    $("#currency-form").submit(function(event) {

        console.log("in submit form");
        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);
        console.log(data);
    
        $.ajax({
            type: "POST",
            url: "http://localhost:8282/admin/currency",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        // displayCurrencies();
    });

    
    $("#maintain-form").submit(function(event) {

        const obj = $(this).serializeJSON();
        const data = JSON.stringify(obj);

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/bookshop/addresses",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });

    });
    
    let myPromise = new Promise(function (myResolve, myReject) {
        // "Producing Code" (May take some time)
        displayCurrencies();
        myResolve(); // when successful
    });

    // "Consuming Code" (Must wait for a fulfilled Promise)
    myPromise.then(
        function (value) { 
            console.log("in promise success");
            setUpDelete();
        },
        function (error) { /* code if some error */ }
    );
    
    // $("#show").click(function () {
    //     addCurrency();
    // });

});

function displayCurrencies() {
    $.get("http://localhost:8282/trader/currencies", function (addresses) {
        $("#data-container").empty();
        let html = "<div class='editable-data'>";
        html += "<div class='hover-edit'>";
        html += "<a class='delete'><i class='fa-solid fa-trash'></i></a>";
        html += "<a class='update'><i class='fa-solid fa-pen-to-square'></i></a>";
        html += "</div>";
        $.each(addresses, function (i, currency) {
            html += "<h3>" + currency.name + " | " + currency.symbol + "</h3>";
            html += "<p class='hidden'>" + currency.id + "</p>";
        });
        html += "</div>";
        $("#data-container").append($(html));

    });
}

function setUpDelete() {

    console.log($(".delete"));

    $.each($(".delete"), function () {
        console.log($(this));
    });

}

function addCurrency() {

}



