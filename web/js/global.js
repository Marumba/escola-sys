$(function() {
    $("div.cursos-tab-menu>div.list-group>a").click(function(e) {
        e.preventDefault();
        $(this).siblings('a.active').removeClass("active");
        $(this).addClass("active");
        var index = $(this).index();
        $("div.cursos-tab>div.cursos-tab-content").removeClass("active");
        $("div.cursos-tab>div.cursos-tab-content").eq(index).addClass("active");
    });
});