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

    setTimeout("getDate()", 1000);
}

window.onload = getDate();




function changePassword(actualPassword)
{
    let provideOldPassword = document.getElementById("old-password-field").value
    let newPasswordFirst = document.getElementById("first-password-field").value
    let newPasswordSecond = document.getElementById("second-password-field").value


    let passwordIsTrue = actualPassword===provideOldPassword;
    let passwordsAreIdentical = newPasswordFirst===newPasswordSecond;

    if(!passwordIsTrue){
        alert("Wrong password!!");
        return false
    }

    if(!passwordsAreIdentical) {
        alert("Passwords needs to be the same");
        return false
    }

    if(passwordIsTrue && passwordsAreIdentical && newPasswordFirst===actualPassword) {
        alert("New passwords need to be different from old one");
        return false
    }

    passwordLegitimate(newPasswordFirst)

    return true
    }


function passwordLegitimate(newPasswordFirst) {

    let digits = /[1-9]/;
    let isDigit = newPasswordFirst.match(digits);
    if(!isDigit){alert("Password must have a Digit")
        return false;
    }

    let smallLetter = /[a-z]/;
    let isSmallLetter = newPasswordFirst.match(smallLetter);
    if(!isSmallLetter){alert("Password must have a small letter")
        return false;
    }

    let bigLetter = /[A-Z]/;
    let isBigLetter = newPasswordFirst.match(bigLetter);
    if(!isBigLetter){alert("Password must have a big letter")
        return false;
    }

    let specialChar = /\W/;
    let isSpecialChar = newPasswordFirst.match(specialChar);
    if(!isSpecialChar){alert("Password must have special character")
        return false;
    }

    let length = newPasswordFirst.length;
    if(length<6){alert("Password must have at least 8 characters")
        return false;
    }

    alert("Password changed!! XD XD XD")



    // document.getElementById('password-form').action = "/student/group";
    alert("Przekierowanie na studenta")
    document.getElementById('password-form').submit();



}