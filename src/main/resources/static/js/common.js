function Type(value, title) {
    this.value = value
    this.title = title
}


function Row(title, date = new Date(), type = new Type(-1, '不限'), price = 0, info = '') {
    this.title = title
    this.date = date
    this.type = type
    this.price = price
    this.info = info
}

Vue.filter('dateFormat', function (dateStr) {
    var date = new Date(dateStr);
    var yyyy = date.getFullYear();
    var MM = (date.getMonth() + 1).toString().padStart(2, "0");
    var dd = (date.getDate()).toString().padStart(2, "0");
    var hh = date.getHours().toString().padStart(2, "0");
    var mm = date.getMinutes().toString().padStart(2, "0");
    var ss = date.getSeconds().toString().padStart(2, "0");

    return `${yyyy}-${MM}-${dd} ${hh}:${mm}:${ss}`;
});
