// sidebar.js dosyası
document.addEventListener("DOMContentLoaded", function () {
    const currentPageURL = window.location.pathname;

    const pages = [
        { url: "/products", sidebarItemClass: ".sidebar-list-item:nth-child(2)" },
        { url: "/categories", sidebarItemClass: ".sidebar-list-item:nth-child(3)" },
        { url: "/brands", sidebarItemClass: ".sidebar-list-item:nth-child(4)" },
        { url: "/suppliers", sidebarItemClass: ".sidebar-list-item:nth-child(5)" }
    ];

    pages.forEach(page => {
        if (currentPageURL.includes(page.url)) {
            const sidebarItem = document.querySelector(page.sidebarItemClass);
            sidebarItem.classList.add("active");
        }
    });
});
