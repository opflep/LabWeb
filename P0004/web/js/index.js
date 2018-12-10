/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function doSearch() {
    //alert(document.getElementById("search").value);
    url = "http://" + location.hostname + ":" + location.port + "/P0004/SearchController?search=" + document.getElementById("search").value;
    window.location.href = url;
}


