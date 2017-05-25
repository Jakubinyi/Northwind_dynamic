function executeQuery() {
    var text = $("#text").val();
    var queryDiv = $("#query");
    queryDiv.empty();

    $.ajax({
        url: '/query',
        method: 'GET',
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
        data: {text:text},
        success: function (data) {
            var array = data;

            console.log(Object.keys(array[0]));

            for (var i in array) {
                console.log(array[i]);
                var item = JSON.stringify(array[i]);

                queryDiv.append(item);
                queryDiv.append("<br>");
            }
        }
    });
}

