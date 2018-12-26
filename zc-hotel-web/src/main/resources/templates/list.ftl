<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign base=request.contextPath />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <title>链接列表</title>

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
                &raquo;房间列表
            </div>
        </div>

        <!-- 表单 -->
        <div class="ibox-content">

            <form id="listForm">

                <div class="table-responsive">
                    <table id="listUrlTable"
                           class="table table-bordered table-striped table-hover">

                        <tr>
                            <th class="check"><input type="checkbox"
                                                     id="selectAll" disabled/>
                            </th>
                            <th>房间号</th>
                            <th>数量</th>
                            <th>类型</th>
                            <th>操作</th>
                        </tr>
				<#--	<#list urlBeans as urlBean>-->
                        <tr>
                            <td><input type="checkbox" name="ids"
                                       value=" " disabled/></td>
                            <td>3</td>
                            <td>2</td>
                            <td>large</td>
                            <td>
                                <a href="${base}/order/"
                                   class="btn btn-sm btn-white btn-bitbucket">
                                    <i class="fa fa-edit"></i> 预订
                                </a>
                                <a href="${base}/delete/"
                                   class="btn btn-sm btn-white btn-bitbucket">
                                    <i class="fa fa-edit"></i> 删除
                                </a>
                                <a href="${base}/add"
                                   class="btn btn-sm btn-white btn-bitbucket">
                                    <i class="fa fa-edit"></i> 添加
                                </a>
                            </td>

                        </tr>
				<#--	</#list>-->
                    </table>
                </div>

            </form>
        </div>
        <!--ibox content end-->
    </div>
    <!--ibox end-->
</div>
</body>


</html>