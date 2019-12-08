const collapsibles = document.querySelectorAll('.collapsible');
for (let i = 0; i < collapsibles.length; i++) {
    M.Collapsible.init(collapsibles[i]);
}

const sideNavs = document.querySelectorAll('.sidenav');
for (let i = 0; i < sideNavs.length; i++) {
    M.Sidenav.init(sideNavs[i]);
}

const closes = document.querySelectorAll(".close");
for (let i = 0; i < closes.length; i++) {
    closes[i].addEventListener('click', function () {
        let note = closes[i].parentElement;
        note.classList.add("collapsed");
    }, false);
}

function setCookie(name,value,days) {
    let expires = "";
    if (days) {
        const date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
function getCookie(name) {
    let nameEQ = name + "=";
    let ca = document.cookie.split(';');
    for(let i=0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0)===' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {
    document.cookie = name+'=; Max-Age=-99999999;';
}

const cookieConsent = getCookie('CONSENT');
if (cookieConsent !== "true") {
    document.getElementById("cookies").classList.remove("collapsed");
    setCookie('CONSENT',true,1);
}
