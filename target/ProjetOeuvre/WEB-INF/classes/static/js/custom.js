$("#toggleSidebar").click(() => $(".sidebar").toggleClass("hidden"));
$("#toggleSidebar").click();
let currentUrl = location.href;
let currentUrl_exploded = currentUrl.split("/");
if (currentUrl_exploded [currentUrl_exploded.length - 1].includes("login")) $("#toggleSidebar").hide();

$(document).ready(() => $(".data-table").DataTable(
    {
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.25/i18n/French.json"
        }
    }
));