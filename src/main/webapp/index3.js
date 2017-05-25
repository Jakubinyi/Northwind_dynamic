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
            console.log(data);
            var array = data;

            var table = document.createElement('TABLE');
            document.body.appendChild(table);

            var tableRow = document.createElement('TR');
            table.appendChild(tableRow);

            for (var n in Object.keys(array[0])) {
                var tableHeader = document.createElement('TH');
                console.log
                //console.log(Object.keys(array[0])[n]);
                tableHeader.innerHTML = Object.keys(array[0])[n];

                table.appendChild(tableHeader);
            }

            for (var i in array) {
                //console.log(array[i]);
                var newTableRow = document.createElement('TR');

                for (var x in array[i]) {
                    //var item = JSON.stringify(array[i][x]);
                    var item = array[i][x];

                    var tableCell = document.createElement('TD');
                    tableCell.innerHTML = item;

                    newTableRow.appendChild(tableCell);

                }
                table.appendChild(newTableRow);
            }
            queryDiv.append(table);
        }
    });
}

