/**
 * Created by ZhenXi on 2016/3/20.
 */
var page = 1;
var flag = true;

function orderByTime() {
    flag = true;
    $.ajax({
        url : url.getBooksOrderByModifiedDate + "?page=" + page,
        type : 'get',
        contentType : 'application/json',
        success : new function (res) {
            if (res.status == 0 && res.res != null) {
                loadContent(res.res);
            }
        }
    });
}

function orderByNum() {
    flag = false;
    $.ajax({
        url : url.getBooksOrderByBorrowNum + "?page=" + page,
        type : 'get',
        contentType : 'application/json',
        success : new function (res) {
            if (res.status == 0 && res.res != null) {
                loadContent(res.res);
            }
        }
    });
}

function next() {
    page ++;
    if (flag) {
        orderByTime();
    } else {
        orderByNum();
    }
}

function last() {
    page --;
    if (flag) {
        orderByTime();
    } else {
        orderByNum();
    }
}

function loadContent(data) {
    $.ajax({
        url:'js/item.ejs',
        cache:false,
        success:function(template){
            var content = $("#content");
            content.empty();
            content.html(ejs.compile(template)(data));
        }
    });
}