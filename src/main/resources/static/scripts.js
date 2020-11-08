function toOnload(){
    getDate();
    loggingChecking();
}

function getDate() {
    let today = new Date();

    let day = today.getDate() < 10 ? "0" + today.getDay() : today.getDay();
    let month = today.getMonth() + 1 < 10 ? "0" + today.getMonth() : today.getMonth();
    let year = today.getFullYear();

    let hours = today.getHours() < 10 ?  "0" + today.getHours() : today.getHours();
    let minutes = today.getMinutes() <10 ? "0" + today.getMinutes() : today.getMinutes();
    let seconds = today.getSeconds() <10 ? "0" + today.getSeconds() : today.getSeconds();

    document.getElementById('actualtime').innerText = day + "/" + month + "/" + year + "|" + hours + "/" + minutes + "/" + seconds;

    setTimeout("getDate()", 1000);
}

window.onload = toOnload();

function changePassword(actualPassword) {
    let provideOldPassword = document.getElementById("old-password-field").value
    let newPasswordFirst = document.getElementById("first-password-field").value
    let newPasswordSecond = document.getElementById("second-password-field").value


    let passwordIsTrue = actualPassword === provideOldPassword;
    let passwordsAreIdentical = newPasswordFirst === newPasswordSecond;

    if (!passwordIsTrue) {
        alert("Wrong password!!");
        return false
    }

    if (!passwordsAreIdentical) {
        alert("Passwords needs to be the same");
        return false
    }

    if (passwordIsTrue && passwordsAreIdentical && newPasswordFirst === actualPassword) {
        alert("New passwords need to be different from old one");
        return false
    }

    passwordLegitimate(newPasswordFirst)

    return true
}


function passwordLegitimate(newPasswordFirst) {

    let digits = /[1-9]/;
    let isDigit = newPasswordFirst.match(digits);
    if (!isDigit) {
        alert("Password must have a Digit")
        return false;
    }

    let smallLetter = /[a-z]/;
    let isSmallLetter = newPasswordFirst.match(smallLetter);
    if (!isSmallLetter) {
        alert("Password must have a small letter")
        return false;
    }

    let bigLetter = /[A-Z]/;
    let isBigLetter = newPasswordFirst.match(bigLetter);
    if (!isBigLetter) {
        alert("Password must have a big letter")
        return false;
    }

    let specialChar = /\W/;
    let isSpecialChar = newPasswordFirst.match(specialChar);
    if (!isSpecialChar) {
        alert("Password must have special character")
        return false;
    }

    let length = newPasswordFirst.length;
    if (length < 6) {
        alert("Password must have at least 8 characters")
        return false;
    }

    alert("Password changed!! XD XD XD")

    document.getElementById('password-form').submit();
}

function changeEmail(actualEmail){

    let provideOldEmail = document.getElementById("old-email-field").value
    let newEmailFirst = document.getElementById("first-email-field").value
    let newEmailSecond = document.getElementById("second-email-field").value

    let emailIsTrue = actualEmail === provideOldEmail;
    let emailsAreIdentical = newEmailFirst === newEmailSecond;

    if (!emailIsTrue) {
        alert("Wrong email!!");
        return false
    }

    if (!emailsAreIdentical) {
        alert("Emails needs to be the same");
        return false
    }

    let email = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    let isEmail = newEmailFirst.match(email);
    if (!isEmail) {
        alert("It don't look like an Email")
        return false;
    }

    if (emailIsTrue && emailsAreIdentical && newEmailFirst === actualEmail) {
        alert("New passwords need to be different from old one");
        return false
    }

    alert("Email changed!! XD XD XD");

    document.getElementById('email-form').submit();

    return true
}

function checkLevel(levelList, levelId) {

    let providedCoolcoins = document.getElementById("coolcoins-required").value

    if (providedCoolcoins < 0) {
        alert("Coolcoins required must be bigger than 0")
        return
    }

    const levelIdToSting = levelId + "";
    switch (levelIdToSting) {
        case "1":
            if (providedCoolcoins > 0) {
                alert("Level 1 must be 0.")
                return
            }
            break;

        case "2":
            if (providedCoolcoins >= levelList[2]) {
                alert("Level must be lower then: " + levelList[2])
                return
            }
            if (providedCoolcoins <= levelList[0]) {
                alert("Level must be bigger then: " + levelList[0])
                return
            }
            break;

        case "3":
            if (providedCoolcoins >= levelList[3]) {
                alert("Level must be lower then: " + levelList[3])
                return
            }
            if (providedCoolcoins <= levelList[1]) {
                alert("Level must be bigger then: " + levelList[1])
                return
            }
            break;

        case "4":
            if (providedCoolcoins >= levelList[4]) {
                alert("Level must be lower then: " + levelList[4])
                return
            }
            if (providedCoolcoins <= levelList[2]) {
                alert("Level must be bigger then: " + levelList[2])
                return
            }
            break;

        case "5":
            if (providedCoolcoins <= levelList[3]) {
                alert("Level must be bigger then: " + levelList[3])
                return
            }
            break;

        }
    document.getElementById('level-update').submit();

}

