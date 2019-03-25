/*****
 * CONFIGURATION
 */
// Active ajax page loader
$.ajaxLoad = true;


//Main navigation
$.navigation = $('nav > ul.nav');

$.panelIconOpened = 'icon-arrow-up';
$.panelIconClosed = 'icon-arrow-down';

//Default colours
$.brandPrimary = '#20a8d8';
$.brandSuccess = '#4dbd74';
$.brandInfo = '#63c2de';
$.brandWarning = '#f8cb00';
$.brandDanger = '#f86c6b';

$.grayDark = '#2a2c36';
$.gray = '#55595c';
$.grayLight = '#818a91';
$.grayLighter = '#d1d4d7';
$.grayLightest = '#f8f9fa';

'use strict';

if ($.ajaxLoad) {

    var paceOptions = {
        elements: false,
        restartOnRequestAfter: false
    };


}


/****
 * MAIN NAVIGATION
 */

$(document).ready(function ($) {

    // Add class .active to current link - AJAX Mode off
    $.navigation.find('a').each(function () {

        var cUrl = String(window.location).split('?')[0];

        if (cUrl.substr(cUrl.length - 1) == '#') {
            cUrl = cUrl.slice(0, -1);
        }

        if ($($(this))[0].href == cUrl) {
            $(this).addClass('active');

            $(this).parents('ul').add(this).each(function () {
                $(this).parent().addClass('open');
            });
        }
    });

    // Dropdown Menu
    $.navigation.on('click', 'a', function (e) {

        if ($(this).hasClass('nav-dropdown-toggle')) {
            $(this).parent().toggleClass('open');
            resizeBroadcast();
        }
    });



    function resizeBroadcast() {

        var timesRun = 0;
        var interval = setInterval(function(){
            timesRun += 1;
            if(timesRun === 5){
                clearInterval(interval);
            }
            if (navigator.userAgent.indexOf('MSIE') !== -1 || navigator.appVersion.indexOf('Trident/') > 0) {
                var evt = document.createEvent('UIEvents');
                evt.initUIEvent('resize', true, false, window, 0);
                window.dispatchEvent(evt);
            } else {
                window.dispatchEvent(new Event('resize'));
            }
        }, 62.5);
    }

    /* ---------- Main Menu Open/Close, Min/Full ---------- */
    $('.sidebar-toggler').click(function () {
        $('body').toggleClass('sidebar-hidden');
    });

    $('.sidebar-minimizer').click(function () {
        $('body').toggleClass('sidebar-minimized');
    });

    $('.brand-minimizer').click(function () {
        $('body').toggleClass('brand-minimized');
    });

    $('.aside-menu-toggler').click(function () {
        $('body').toggleClass('aside-menu-hidden');
    });

    $('.mobile-sidebar-toggler').click(function () {
        $('body').toggleClass('sidebar-mobile-show');
    });

    $('.sidebar-close').click(function () {
        $('body').toggleClass('sidebar-opened').parent().toggleClass('sidebar-opened');
    });

    /* ---------- Disable moving to top ---------- */
    $('a[href="#"][data-top!=true]').click(function (e) {
        e.preventDefault();
    });

});

/****
 * CARDS ACTIONS
 */

$(document).on('click', '.card-actions a', function (e) {
    e.preventDefault();

    if ($(this).hasClass('btn-close')) {
        $(this).parent().parent().parent().fadeOut();
    } else if ($(this).hasClass('btn-minimize')) {
        if (!$(this).hasClass('collapsed')) {
            $('i', $(this)).removeClass($.panelIconOpened).addClass($.panelIconClosed);
        } else {
            $('i', $(this)).removeClass($.panelIconClosed).addClass($.panelIconOpened);
        }

    } else if ($(this).hasClass('btn-setting')) {
        $('#myModal').modal('show');
    }

});


function getQueryString(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); // 匹配目标参数
  var result = window.location.search.substr(1).match(reg); // 对querystring匹配目标参数
  if (result) {
    return result[2];
  }
}

function getTenantId(){
    var tenantId = getQueryString("tenantId");
    if (tenantId == undefined) {
        $.get({
                url : "/tenant/current",
                async : false,
                success : function(data) {
                    tenantId = data
                }
            })
    }
    return tenantId
}

function isCard(){
  return self !== top || getQueryString('isCard')==='true'
}

function applyCard() {
  if (isCard()) {
    var appHeader = document.getElementsByClassName('app-header');
    if (appHeader.length > 0) appHeader[0].style.display = 'none'
    var sidebar = document.getElementsByClassName('sidebar');
    if (sidebar.length > 0) sidebar[0].style.display = 'none'
    var breadCrumb = document.getElementsByClassName('breadcrumb');
    if (breadCrumb.length > 0) breadCrumb[0].style.display = 'none'
    var main = document.getElementsByClassName('main');
    if (main.length > 0) main[0].style.marginLeft = 0
    var appBody = document.getElementsByClassName('app-body');
    if (appBody.length > 0) appBody[0].style.marginTop = 0
  }
}

applyCard()