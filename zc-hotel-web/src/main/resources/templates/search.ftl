<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign base=request.contextPath />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <title>查询房间</title>

    <link href="${base}/resources/admin/css/bootstrap.min.css?v=3.3.6"
          rel="stylesheet">
    <link href="${base}/resources/admin/css/font-awesome.css?v=4.4.0"
          rel="stylesheet">
    <link href="${base}/resources/admin/css/animate.css" rel="stylesheet">
    <link href="${base}/resources/admin/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/resources/admin/css/iCheck/custom.css" rel="stylesheet">
    <script type="text/javascript"
            src="${base}/resources/admin/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="${base}/resources/admin/js/jquery.validate.js"></script>
    <script type="text/javascript"
            src="${base}/resources/admin/js/common.js"></script>
    <script type="text/javascript"
            src="${base}/resources/admin/js/input.js"></script>
    <script type="text/javascript"
            src="${base}/resources/admin/js/plugins/layer/layer.min.js"></script>


</head>

<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="ibox">
        <!-- 面包屑 -->
        <div class="ibox-title">
            <div class="path">
                管理员
                &raquo;查询房间
            </div>
        </div>

        <!-- 表单 -->
        <div class="ibox-content">

            <!-- 表单 -->
            <form action="${base}/search" method="post"  class="form-horizontal">

                <div class="form-group">
                    <label class="col-sm-1 control-label"><b style="color: red">*</b>房间号:</label>
                    <div class="col-sm-2">
                        <input type="text" name="roomNo"
                               class="form-control " maxlength="100" value=""/>
                    </div>
                    <label class="col-sm-1 control-label"><b style="color: red">*</b>房间类型:</label>
                    <div class="col-sm-2">
                        <input type="text" name="type"
                               class="form-control" maxlength="100" value=""/>
                    </div>
                    <label class="col-sm-1 control-label"><b style="color: red">*</b>房间数量:</label>
                    <div class="col-sm-2">
                        <input type="text" name="count" class="form-control"
                               maxlength="100" value=""/>
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </div>



            </form>
        </div>
        <!--ibox content end-->
    </div>
    <!--ibox end-->
</div>
</body>


</html>