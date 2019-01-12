$(document).ready(function () {
    $('.data-button').on('click', function () {
        let button = $(this);
        let confirm = button.attr("data-confirm");
        if (typeof confirm != 'undefined') {
            if (!window.confirm(confirm)) {
                return;
            }
        }
        let method = button.attr('data-method');
        let target = button.attr('data-target');
        let data = button.attr('data');
        let params = button.attr('data-param');
        console.log(params);
        $.ajax({
            url: target + '?' + params,
            method: method,
            data: data
        }).done(function (data) {
            document.write(data);
        });
    })
});