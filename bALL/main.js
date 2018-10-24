(function() {
  window.addEventListener("load", init, false);
  var DEFAULT_TOP = "200px";
  var DEFAULT_LEFT = "200px";

  function init() {
    var elem = document.getElementById("elem");
    counterP = document.getElementById("counter");
    var bucket = document.getElementById("bucket");


    // console.log(bucket.getBoundingClientRect());
    // console.log(elem.getBoundingClientRect());

    counter = 0;
    var isOnTheWayToGoal = false;



    elem.addEventListener("mousedown", function(e) {
      drag(this, e);
    })
  }

  function drag(elementToDrag, event) {
    // координаты мыши в начале перетаскивания.
    var startX = event.clientX,
      startY = event.clientY;

    // начальные координаты элемента, который будет перемещаться.
    var origX = elementToDrag.offsetLeft,
      origY = elementToDrag.offsetTop;

    // разница между координатами мыши и координатами перетаскиваемого элемента.
    var deltaX = startX - origX,
      deltaY = startY - origY;

    // Регистрация событий mouseup и mousemove
    document.addEventListener("mousemove", moveHandler, true);
    document.addEventListener("mouseup", upHandler, true);

    function moveHandler(e) {
      if (!e) e = window.event;
      bucketCoords = bucket.getBoundingClientRect();
      // console.log(bucket.getBoundingClientRect());
      // console.log(elem.getBoundingClientRect());

      // перемещаем элемент с учетом отступа от первоначального клика.
      elementToDrag.style.left = (e.clientX - deltaX) + "px";
      elementToDrag.style.top = (e.clientY - deltaY) + "px";

      let elementCoords = elementToDrag.getBoundingClientRect();

      if ((elementCoords.left > bucketCoords.left) && (elementCoords.right <
          bucketCoords.right)) {
        //ball is above the bucket
        if (elementCoords.bottom < bucketCoords.top) {
          isOnTheWayToGoal = true;
          // console.log("on way = " + isOnTheWayToGoal);
        }
        //goal
        if (elementCoords.top > bucketCoords.top && isOnTheWayToGoal ==
          true) {
          counter++;
          counterP.innerHTML = counter;
          isOnTheWayToGoal = false;
          reset();
        }

      } else {
        isOnTheWayToGoal = false;
      }
    }

    function upHandler(e) {
      if (!e) e = window.event;

      document.removeEventListener("mouseup", upHandler, true);
      document.removeEventListener("mousemove", moveHandler, true);
    }

    function reset() {
      elementToDrag.style.top = DEFAULT_TOP;
      elementToDrag.style.left = DEFAULT_LEFT;
      upHandler();
    }
  }
})()
