/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submit(link) {
    var form = document.createElement('form');
    form.setAttribute('action', "DoTakeQuiz");
    form.setAttribute('method', 'post');

    var inputField = document.createElement('input');
    inputField.setAttribute('type', 'textbox');
    inputField.setAttribute('name', 'endingTime');
    form.appendChild(inputField);
    form.submit();
}

function doCount(minute, second) {

    setInterval(function () {

        if (second > 0) {
            second--;
        } else {
            if (minute > 0) {
                minute--;
                second = 59;
            }
        }

        document.getElementById("minute").innerHTML = "" + minute;
        document.getElementById("second").innerHTML = "" + second;

        if (minute === 0 && second === 0) {
            submit();
        }
    }, 1000);
}
;

window.onload = function () {
    var minuteElement = document.getElementById("minute");
    var secondElement = document.getElementById("second");
    var minute, second;

    if (minuteElement !== null) {
        minute = parseInt(minuteElement.innerHTML);
        if (secondElement !== null) {
            second = parseInt(secondElement.innerHTML);
            doCount(minute, second);
        }
    }
};
