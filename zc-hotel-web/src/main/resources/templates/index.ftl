<!DOCTYPE html>
<html>
<#assign base=request.contextPath />
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>宾馆预订 - 主页</title>

    <link href="${base}/resources/admin/css/bootstrap.min.css?v=3.3.6"
          rel="stylesheet">
    <link href="${base}/resources/admin/css/font-awesome.min.css?v=4.4.0"
          rel="stylesheet">
    <link href="${base}/resources/admin/css/animate.css" rel="stylesheet">
    <link href="${base}/resources/admin/css/style.css?v=4.1.0" rel="stylesheet">

    <style>
        #side-menu .loading {
            display: none;
        }
    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-rounded"
                                   src=""/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle"
                           href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong
                                       class="font-bold">HOTEL</strong></span>
                                <span class="text-muted text-xs block">酒店管理<b
                                        class="caret"></b></span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">Flash
                    </div>
                </li>

                <li class="loading">
                    <a href="#">
                        <i class="fa fa-file"></i>
                        <span class="nav-label">管理菜单</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${base}/list">房间列表</a>
                        </li>
                        <li><a class="J_menuItem"
                               href="${base}/search">查询房间</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row content-tabs">
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab"
                       data-id="index_v1.html">首页</a>
                </div>
            </nav>
        </div>

        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%"
                    src="${base}/mainPage.jhtml" frameborder="0"
                    data-id="index_v1.html" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

        </div>
    </div>
    <!--右侧边栏结束-->
</div>


<!-- 全局js -->
<script src="${base}/resources/admin/js/jquery.min.js?v=2.1.4"></script>
<script src="${base}/resources/admin/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${base}/resources/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${base}/resources/admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script type="text/javascript"
        src="${base}/resources/admin/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${base}/resources/admin/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript"
        src="${base}/resources/admin/js/contabs.js"></script>

<!-- 第三方插件 -->
<script src="${base}/resources/admin/js/plugins/pace/pace.min.js"></script>
<script>
    $(".J_menuItem").click(function () {
        $(".J_iframe").each(function () {
            if ($(this).css("display") == "inline") {
                $(this).attr('src', $(this).attr('src'));
            }
        });
    });

    $(".nav-second-level").each(function () {
        var i = $(this).children().size();
        if (i == 0) {
            $(this).parent().remove();
        }
    });

    $("#side-menu .loading").fadeIn(1000, function () {
        $(this).removeClass("loading");
    });
</script>

</body>

</html>
