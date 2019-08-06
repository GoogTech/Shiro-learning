//切换页面
$(function () {
    $(".changePage").click(function () {
        $("#rightMain").prop("src", $(this).data("url"));
    });
});