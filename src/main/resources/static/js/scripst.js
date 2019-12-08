const collapsibles = document.querySelectorAll('.collapsible');
for (let i = 0; i < collapsibles.length; i++) {
    M.Collapsible.init(collapsibles[i]);
}

const sideNavs = document.querySelectorAll('.sidenav');
for (let i = 0; i < sideNavs.length; i++) {
    M.Sidenav.init(sideNavs[i]);
}

const close = document.getElementById("close");
close.addEventListener('click', function () {
    let note = document.getElementById("note");
    note.classList.add("collapsed");
}, false);
