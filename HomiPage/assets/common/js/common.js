/**
 * Created by magwanghwi on 2017. 4. 17..
 */

$(window).scroll(
  {
    previousTop: 0
  },
  function () {
    var currentTop = $(window).scrollTop();
    if (currentTop < this.previousTop) {
      $(".header").show();
    } else {
      $(".header").hide();
    }
    this.previousTop = currentTop;
  });