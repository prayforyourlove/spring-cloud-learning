<!-- <% @ page language = "java" import= "java.util.*" pageEncoding = "UTF-8" %> -->
<!DOCTYPE html>
<html lang="en">
<#assign base=request.contextPath />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=.6, maximum-scale=1.0, user-scalable=0"/>
    <!--[if gt IE 8]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <![endif]-->

    <title>主页界面</title>

    <link rel="icon" type="image/ico" href="favicon.ico"/>

    <link href="css/stylesheets.css" rel="stylesheet" type="text/css"/>
    <!--[if lt IE 8]>
    <link href="css/ie7.css" rel="stylesheet" type="text/css"/>
    <![endif]-->
    <link rel='stylesheet' type='text/css' href='css/fullcalendar.print.css' media='print'/>

    <script type='text/javascript' src='js/jquery.min.js'></script>
    <script type='text/javascript' src='js/jquery-ui.min.js'></script>
    <script type='text/javascript' src='js/plugins/jquery/jquery.mousewheel.min.js'></script>

    <script type='text/javascript' src='js/plugins/cookie/jquery.cookies.2.2.0.min.js'></script>

    <script type='text/javascript' src='js/plugins/bootstrap.min.js'></script>

    <script type='text/javascript' src='js/plugins/charts/excanvas.min.js'></script>
    <script type='text/javascript' src='js/plugins/charts/jquery.flot.js'></script>
    <script type='text/javascript' src='js/plugins/charts/jquery.flot.stack.js'></script>


</head>
<style type="text/css">

    /* 默认样式的类名 */
    *{
        margin: 0;
        padding: 0;
    }
    .mainPage {
        position:fixed;
        width: 100%;
        height:100%;
        background-color: #897715;
    }

    /* 头部脚部导航的样式设置 */
    .header, .footer {
        height: 20px;
        line-height: 20px;
        width: 100%;
        padding: 10px;
        display: flex;
        flex-direction: row;
        justify-content: center;
        background-color: #6e2e00;
    }
    .header .navi, .footer .navi{
        padding: 0 15px;
        border-right: 1px solid #c1c04d;
        color: #c1c04d;
    }
    .header .navi:nth-last-of-type(1), .footer .navi:nth-last-of-type(1){
        border: none;
    }

    .white-text{
        color: #fff;
    }

    /* 主体部分 */
    .container {
        width: 100%;
        padding: 0 20px;
        box-sizing: border-box;
        height: calc(100% - 80px);
        display: flex;
        flex-direction: row;
        justify-content: center;
    }

    .box-left {
        float:left;
        width: 30%;
        height:100%;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
    }

    .box-right {
        float:left;
        width: 60%;
        margin-left: 5%;
        height:100%;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
    }

    .box-right-center{
        float:left;
        /* width: 60%; */
        /* padding-left:50px; */
        display: flex;
        flex-direction: row;
        justify-content: space-around;
    }


    .box-center{
        width: 28%;
        padding: 20px;
        box-sizing: border-box;
        background-color: #c4af3b;
        border:2px solid #e8dd61;
        text-align: center;
        line-height: 1.8;
    }





</style>

<body >

<div class="mainPage">

    <div class="header">
        <!-- <p><a href="">VIP</a>|<a href="">Enroll</a>|<a href="">Book</a>|<a href="">comment</a>|<a href="">search</a></p> -->
        <div class="navi">XXX酒店欢迎您</div>
    </div>

    <div class="container">

        <div class="box-left">
            <h2 class="white-text">浙江中财酒店欢迎您</h2>
            <p>您满意的微笑，是我们最大的动力</p>

            <div >
                <img src="${base}/resources/admin/image/room.jpg" width="100%"  height="150px">
            </div>


            <div style="border-bottom: 1px dotted #000;padding-bottom: 20px;">
                <p><a href="">服务条款</a></p>
                <p>为您竭诚服务是我们不变的承诺，您在入住期间的主动配合会让我们更加细心地为您服务</p>
                <!-- <p>....................................................................................................</p> -->
            </div>

            <div >
                <img src="${base}/resources/admin/image/room.jpg" width="100%"  height="150px">
            </div>

            <div >
                <p class="white-text">特色服务</p>
                <p>中财酒店为您提供各种特色精品服务，种类有：会议宴请、按摩理疗、旅游介绍、租车服务、特产代购、儿童天地</p>

            </div>
            
        </div>


        <div class="box-right">
            <h2 class="white-text">浙江中财酒店</h2>
            <p>中财投资集团旗下的中高端品牌酒店，有融合奢华、舒适为一体的套房上白套。拥有设施完善的宴会和会议厅、融汇中西美食精华的餐厅、
                养生馆等众多设施，是集宿舍、餐饮、养生、娱乐于一体的星级酒店，无论商务、休闲还是旅游都将是您的不二选择。
            </p>

            <div class="box-right-center">
                <div class="box-center">
                    <img src="${base}/resources/admin/image/room.jpg" width="100%" height="150px">
                    <h3 class="white-text">高级豪华客房</h3>
                    <p>为您竭诚服务是我们不变的承诺，您在入住期间的主动配合会让我们更加细心地为您服务</p>
                    <button type="button" name="button"  style="margin-left:auto;"onclick="more()">More</button>
                </div>

                <div class="box-center" >
                    <img src="${base}/resources/admin/image/room.jpg" width="100%" height="150px">
                    <h3 class="white-text">豪华套房</h3>
                    <p>为您竭诚服务是我们不变的承诺，您在入住期间的主动配合会让我们更加细心地为您服务</p>
                    <button type="button" name="button"  style="margin-left:auto;"onclick="more()">More</button>
                </div>

                <div class="box-center">
                    <img src="${base}/resources/admin/image/room.jpg" width="100%" height="150px">
                    <h3 class="white-text">自主餐桌美食</h3>
                    <p>为您竭诚服务是我们不变的承诺，您在入住期间的主动配合会让我们更加细心地为您服务</p>
                    <button type="button" name="button"  style="margin-left:auto;"onclick="more()">More</button>
                </div>

            </div>

            <div >
                <h3>走近中财</h3>
                <p>中财投资集团旗下的中高端品牌酒店，有融合奢华、舒适为一体的套房上白套。拥有设施完善的宴会和会议厅、融汇中西美食精华的餐厅<a href="">了解更多</a></p>

            </div>

        </div>
        

    </div>

    <div class="footer">
        <#--<div class="navi">VIP</div>
        <div class="navi">HOME</div>
        <div class="navi">Enroll</div>
        <div class="navi">Book</div>
        <div class="navi">comment</div>
        <div class="navi">Refund</div>
        <div class="navi">search</div>-->
    </div>

</div>

</body>
</html>
