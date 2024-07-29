function filter(){
    var input, filter, table, tr, td, i, text, search;
    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    table = document.getElementById("table");
    tr = table.getElementsByTagName("tr");
    search = document.getElementById("search_by").value;
    for(i = 0; i < tr.length; i++){

        td = tr[i].getElementsByTagName("td")[0];
        if(search == "fname"){
            td = tr[i].getElementsByTagName("td")[1];
        }
        else if(search == "lname"){
            td = tr[i].getElementsByTagName("td")[2];
        }
        else if(search == "dob"){
            td = tr[i].getElementsByTagName("td")[3];
        }
        else if(search == "year"){
            td = tr[i].getElementsByTagName("td")[4];
        }

        if(td){
            text = td.textContent || td.innerText;
            if(text.toUpperCase().indexOf(filter) > -1){
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

