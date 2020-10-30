function getDate()
{
    let today = new Date();

    let day = today.getDate();
    let month = today.getMonth()+1;
    let year = today.getFullYear();

    let hours = today.getHours();
    let minutes = today.getMinutes();
    let seconds = today.getSeconds();

    document.getElementById('actualtime').innerText = day+"/"+month+"/"+year+"|"+hours+"/"+minutes+"/"+seconds;

    setTimeout("getDate()",1000);
}

getDate();