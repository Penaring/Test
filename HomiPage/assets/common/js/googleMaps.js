/**
 * Created by magwanghwi on 2017. 4. 14..
 */

function myMap() {
  var myLatLng = new google.maps.LatLng(36.083296, 127.285139);

  var mapProp= {
    center: myLatLng,
    zoom:17,
    draggable: true,
    scrollwheel: false,
    navigationControl: false,
    mapTypeControl: false,
    scaleControl: false,

  };

  var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
  var marker;
  marker = new google.maps.Marker({
    position: myLatLng,
    map: map,
    title: 'Welcome to HOMI!',
    draggable: false,
    animation: google.maps.Animation.DROP,
  });

  marker.setMap(map);
  marker.addListener('click',toggleBounce);
    function toggleBounce() {
        if (marker.getAnimation() !== null) {
            marker.setAnimation(null);
        } else {
            marker.setAnimation(google.maps.Animation.BOUNCE);
        }
    }

  var infowindow = new google.maps.InfoWindow({

    content: '<IMG BORDER="0" ALIGN="Left" SRC="common/img/contact/googlemap.jpg"> </br> <p class="mapTitleInfo">HOMI</p> ' +
    '</br> <div class="mapSubtitleInfo"><p>----------------------------------------</p><p>1338</p>' +
    '<p>Unju-myeon,Daedunsan-ro</p>' +
    '<p>Wanju_Gun  Jeollabuk-do</p>' +
    '<p>Republic of Korea</p>' +
     '</div>'

  });

  google.maps.event.addListener(infowindow, 'domready', function() {

    // Reference to the DIV which receives the contents of the infowindow using jQuery
    var iwOuter = jQuery('.gm-style-iw');

    /* The DIV we want to change is above the .gm-style-iw DIV.
     * So, we use jQuery and create a iwBackground variable,
     * and took advantage of the existing reference to .gm-style-iw for the previous DIV with .prev().
     */
    var iwBackground = iwOuter.prev();

    // Remove the background shadow DIV
    iwBackground.children(':nth-child(2)').css({'display' : 'none'});

    // Remove the white background DIV
    iwBackground.children(':nth-child(4)').css({'display' : 'none'});

    // Moves the shadow of the arrow 76px to the left margin
    iwBackground.children(':nth-child(1)').attr('style', function(i,s){ return s + 'left: 76px !important;'});

// Moves the arrow 76px to the left margin
    iwBackground.children(':nth-child(3)').attr('style', function(i,s){ return s + 'left: 76px !important;'})

    // Changes the desired color for the tail outline.
// The outline of the tail is composed of two descendants of div which contains the tail.
// The .find('div').children() method refers to all the div which are direct descendants of the previous div.
    iwBackground.children(':nth-child(3)').find('div').children().css({'box-shadow': 'rgba(72, 181, 233, 0.6) 0px 1px 6px', 'z-index' : '1'});

    // Taking advantage of the already established reference to
// div .gm-style-iw with iwOuter variable.
// You must set a new variable iwCloseBtn.
// Using the .next() method of JQuery you reference the following div to .gm-style-iw.
// Is this div that groups the close button elements.
    var iwCloseBtn = iwOuter.next();

// Apply the desired effect to the close button
    iwCloseBtn.css({
      opacity: '1', // by default the close button has an opacity of 0.7
      right: '45px', top: '20px', // button repositioning
      border: '2px solid #48b5e9', // increasing button border and new color
      'border-radius': '13px', // circular effect
      'box-shadow': '0 0 5px #3990B9' // 3D effect to highlight the button
    });

// The API automatically applies 0.7 opacity to the button after the mouseout event.
// This function reverses this event to the desired value.
    iwCloseBtn.mouseout(function(){
      jQuery(this).css({opacity: '1'});
    });
  });

  infowindow.open(map, marker);
}


