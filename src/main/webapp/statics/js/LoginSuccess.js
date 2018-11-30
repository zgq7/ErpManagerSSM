$(document).ready(function() {
    $(".ul-gls").hide();
    $(".levels").click(function() {
        if($(this).children(".ul-gls").is(":hidden")) {
            $(this).children(".ul-gls").show();
            $(this).children("span").addClass("glyphicon glyphicon-minus");
        }else{
            $(this).children(".ul-gls").hide();
            $(this).children("span").removeClass("glyphicon glyphicon-minus");
        }
    });
});