$(document).ready(function () {
    /*$(".level01").children("a").children(".gl").addClass("current");*/
    $(".ul02").hide();
    $(".level01 > a").click(function () {
       var qt =  $(this).next();
       if(qt.is(":visible")){
           qt.hide();
           $(this).children("a").children(".gl").removeClass("current");
       }else {
           qt.show();
           /*$(this).children("a").children(".gl").addClass("current");*/
           $(this).addClass("current");
       }
        console.log(1);
    });
});