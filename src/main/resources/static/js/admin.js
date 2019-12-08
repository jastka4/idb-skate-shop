const sideNavs = document.querySelectorAll('.sidenav');
for (let i = 0; i < sideNavs.length; i++) {
    M.Sidenav.init(sideNavs[i]);
}

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, {});
});