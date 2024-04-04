function linear() {
        let list = document.getElementById("list").value;
        let number = document.getElementById("number").value;

        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("getrespmsg").innerHTML =
            this.responseText;
        }
        xhttp.open("GET", "/proxy?operation=linearsearch&list=" + list + "&value=" + number);
        xhttp.send();
}

function binary() {
        let list = document.getElementById("list").value;
        let number = document.getElementById("number").value;

        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("getrespmsg").innerHTML =
            this.responseText;
        }
        xhttp.open("GET", "/proxy?operation=binarysearch&list=" + list + "&value=" + number);
        xhttp.send();
}