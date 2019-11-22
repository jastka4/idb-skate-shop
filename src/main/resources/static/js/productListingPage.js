const collapsibles = document.querySelectorAll('.collapsible');
for (let i = 0; i < collapsibles.length; i++) {
    M.Collapsible.init(collapsibles[i]);
}

const sideNavs = document.querySelectorAll('.sidenav');
for (let i = 0; i < sideNavs.length; i++) {
    M.Sidenav.init(sideNavs[i]);
}
