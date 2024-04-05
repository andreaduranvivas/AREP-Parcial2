/**
 * Performs a linear search on a list of numbers and displays the result on the web page.
 *
 * @param {string} list - A string representing the list of numbers separated by commas.
 * @param {string} number - The number to search for in the list.
 */
function linear() {
    let list = document.getElementById("list").value;
    let number = document.getElementById("number").value;

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        let response = JSON.parse(this.responseText);
        let responseText = `Operation: <strong>${response.operation}</strong><br><br>Input List: <strong>${response.inputlist}</strong><br><br>Value: <strong>${response.value}</strong><br><br>Output: <strong>${response.output}</strong>`;
        document.getElementById("getrespmsg").innerHTML = responseText;
        document.getElementById("getrespmsg").style.display = "block";
    }
    xhttp.open("GET", "/proxy?operation=linearsearch&list=" + list + "&value=" + number);
    xhttp.send();
}


/**
 * Performs a binary search on a list of numbers and displays the result on the web page.
 *
 * @param {string} list - A string representing the list of numbers separated by commas.
 * @param {string} number - The number to search for in the list.
 */
function binary() {
    let list = document.getElementById("list").value;
    let number = document.getElementById("number").value;

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        let response = JSON.parse(this.responseText);
        let responseText = `Operation: <strong>${response.operation}</strong><br><br>Input List: <strong>${response.inputlist}</strong><br><br>Value: <strong>${response.value}</strong><br><br>Output: <strong>${response.output}</strong>`;
        document.getElementById("getrespmsg").innerHTML = responseText;
        document.getElementById("getrespmsg").style.display = "block";
    }
    xhttp.open("GET", "/proxy?operation=binarysearch&list=" + list + "&value=" + number);
    xhttp.send();
}