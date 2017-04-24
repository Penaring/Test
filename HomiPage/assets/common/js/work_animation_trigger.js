/**
 * Created by magwanghwi on 2017. 4. 18..
 */

$(window).scroll(function() {
  $('#stack2').each(function(){
    var imagePos = $(this).offset().top;
    var topOfWindow = $(window).scrollTop();

    if (imagePos < topOfWindow+800) {
      $(this).addClass("slideLeft");
    }
  });

  $('#stack3').each(function(){
    var imagePos = $(this).offset().top;
    var topOfWindow = $(window).scrollTop();

    if (imagePos < topOfWindow+800) {
      $(this).addClass("slideRight");
    }
  });

  for(var i = 1; i < 9; i++) {
    $('#stack4-' + i).each(function () {
      var imagePos = $(this).offset().top;
      var topOfWindow = $(window).scrollTop();

      if (imagePos < topOfWindow + 800) {
        $(this).addClass("fadeIn");
      }
    });
  }

  $('#stack5').each(function(){
    var imagePos = $(this).offset().top;
    var topOfWindow = $(window).scrollTop();

    if (imagePos < topOfWindow+800) {
      $(this).addClass("slideLeft");
    }
  });

  $('#stack6').each(function(){
    var imagePos = $(this).offset().top;
    var topOfWindow = $(window).scrollTop();

    if (imagePos < topOfWindow+800) {
      $(this).addClass("fadeIn");
    }
  });
});