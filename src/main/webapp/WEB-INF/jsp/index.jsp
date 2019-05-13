<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <title>超市首页</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/theme/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/theme/css/home.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/theme/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/theme/js/index.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/theme/js/js-tab.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/theme/js/MSClass.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/theme/js/jcarousellite.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/theme/js/top.js"></script>
	<script type="text/javascript">
         var intDiff = parseInt(80000);//倒计时总秒数量
         function timer(intDiff){
             window.setInterval(function(){
                 var day=0,
                         hour=0,
                         minute=0,
                         second=0;//时间默认值
                 if(intDiff > 0){
                     day = Math.floor(intDiff / (60 * 60 * 24));
                     hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                     minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                     second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
                 }
                 if (minute <= 9) minute = '0' + minute;
                 if (second <= 9) second = '0' + second;

                 $('#hour_show').html('<s id="h"></s>'+hour+'');
                 $('#minute_show').html('<s></s>'+minute+'');
                 $('#second_show').html('<s></s>'+second+'');
                 intDiff--;
             }, 1000);
         }

         $(function(){
             timer(intDiff);
         });
     </script>
 </head>
 <body>
  <!--header degin-->
   <header id="pc-header">
     <div class="BHeader">
	 </div>
	     <div class="container clearfix">
    
        <div class="head-mountain"></div>
    </div>
     <div class="yHeader">
	    <a href="login.html" style="float:right;color:#e4393c">后台登录</a>
	   <div class="yNavIndex">
	     <div class="pullDown">
		   <h2 class="pullDownTitle">超市分类</h2>   
		    <ul class="pullDownList">
				<li class="menulihover">
				     <i class="listi1"></i>
				     <a href="#" target="_blank">食品类</a>
				     <span></span>
				</li>
				<li>
				     <i class="listi2"></i>
				     <a href="#" target="_blank">服装类</a>
				     <span></span>
				</li>
				<li>
					 <i class="listi3"></i>
					 <a href="#" target="_blank">电子产品类</a>
					 <span></span>
				</li>
				<li>
					 <i class="listi4"></i>
					 <a href="#" target="_blank">家电类</a>
					 <span></span>
				</li>
                <li>
                    <i class="listi5"></i>
                    <a href="" target="_blank">办公</a>
                    <span></span>
                </li> 
            </ul>
	<div class="yMenuListCon">
        <div class="yMenuListConin">
          <div class="yMenuLCinLisi fl">
             <ul>
                 <li><a href="#">零食区<i class="fr">></i></a></li>  
                 <li><a href="#">肉区<i class="fr">></i></a></li>  
                 <li><a href="#">蔬菜区<i class="fr">></i></a></li>  
             </ul>
          </div>
		  <div class="yMenuLCinList fl">
             <p>
                <a href="" class="ecolor610">泡面</a>
                    <a href="">火腿肠</a>
                    <a href="">饮料</a>
                    <a href="">豆干</a>
             </p>
			 <br>
             <p>
                <a href="" class="ecolor610">鸡肉</a>
                    <a href="">猪肉</a>
					<a href="">鸭肉</a>
                    <a href="">鸡肉</a>
                    <a href="">牛肉</a>
                    <a href="">羊肉</a>
                    <a href="">淡水鱼</a>
                    <a href="">海鲜</a>
             </p>
			 <br>
             <p>
                <a href="" class="ecolor610">青菜</a>
                    <a href="">白菜</a>
                    <a href="">包菜</a>
                    <a href="">卷心菜</a>
                    <a href="">娃娃菜</a>
                    <a href="">青菜</a>
                    <a href="">海菜</a>
             </p>
	    </div>
	 </div>

	 <div class="yMenuListConin">
        <div class="yMenuLCinLisi fl">
             <ul>
                <li><a href="#">男装<i class="fr">></i></a></li>
                <li><a href="#">女装<i class="fr">></i></a></li>
                <li><a href="#">童装<i class="fr">></i></a></li>
            </ul>
        </div>
		<div class="yMenuLCinList fl">
                        <p>
                            <a href="" class="ecolor610">上装</a>
                            <a href=""> 下装</a>
                            <a href="">春季装</a>
                            <a href="">夏季装</a>
                            <a href="">秋季装</a>
							<a href="">鞋子</a>
                        </p>
						<br>
                        <p>
                            <a href="" class="ecolor610">裙装</a>
                            <a href="">下装</a>
                            <a href="">套装</a>
                            <a href="">晚装</a>
                            <a href="">连体装</a>
                            <a href="">内衣</a>
                            <a href="">袜子</a>
                            <a href="">礼服</a>
							<a href="">鞋子</a>
                        </p>
						<br>
                        <p>
                            <a href="" class="ecolor610">体形型</a>
                            <a href="">样式型</a>
                            <a href="">混合型</a>
							<a href="">鞋子</a>
             </p>
         </div>
    </div>

	 <div class="yMenuListConin">
        <div class="yMenuLCinLisi fl">
             <ul>
                <li><a href="#">手机<i class="fr">></i></a></li>
                <li><a href="#">平板<i class="fr">></i></a></li>
                <li><a href="#">个人电脑<i class="fr">></i></a></li>
            </ul>
        </div>
		<div class="yMenuLCinList fl">
                        <p>
                            <a href="" class="ecolor610">安卓</a>
                            <a href="">ios</a>
                        </p>
						<br>
                        <p>
                            <a href="" class="ecolor610">微软</a>
                            <a href="">苹果</a>
                        </p>
						<br>
                        <p>
                            <a href="" class="ecolor610">微软</a>
                            <a href="">苹果</a>
                            <a href="">联想</a>
                            <a href="">华硕</a>
                            <a href="">戴尔</a>
             </p>
         </div>
    </div>
	 <div class="yMenuListConin">
        <div class="yMenuLCinLisi fl">
             <ul>
                <li><a href="#">空调 器具<i class="fr">></i></a></li>
                <li><a href="#">清洁 器具<i class="fr">></i></a></li>
                <li><a href="#">厨房 器具<i class="fr">></i></a></li>
            </ul>
        </div>
		<div class="yMenuLCinList fl">
                        <p>
                            <a href="" class="ecolor610">电风扇</a>
                            <a href="">空调器</a>
                            <a href="">空气清洁器</a>
                        </p>
						<br>
                        <p>
                            <a href="" class="ecolor610">洗衣机</a>
                            <a href="">干衣机</a>
                            <a href="">淋浴器</a>
                            <a href="">抽烟机</a>
                            <a href="">排气扇</a>
                            <a href="">吸尘器</a>
                        </p>
						<br>
                        <p>
                            <a href="" class="ecolor610">电饭锅</a>
                            <a href="">电火锅</a>
                            <a href="">电烤箱</a>
                            <a href="">微波炉</a>
                            <a href="">电磁灶</a>
                            <a href="">开罐器</a>
                            <a href="">搅拌器</a>
                            <a href="">绞肉机</a>
                            <a href="">洗碗机</a>
                            <a href="">榨汁机</a>
             </p>
         </div>
    </div>

	 <div class="yMenuListConin">
        <div class="yMenuLCinLisi fl">
             <ul>
                <li><a href="#">办公<i class="fr">></i></a></li>
            </ul>
        </div>
		<div class="yMenuLCinList fl">
                        <p>
                            <a href="" class="ecolor610">办公</a>
                            <a href="">打印机</a>
                            <a href="">一体机</a>
                            <a href="">投影仪</a>
                            <a href="">办公用纸</a>
                            <a href="">点钞机 </a>
                            <a href="">硒鼓</a>
                            <a href="">门禁</a>
                            <a href="">保险箱</a>
                            <a href="">格子间</a>
                            <a href="">无线网卡</a>
                            <a href="">WiFi放大器</a> 
                            <a href="">无线呼叫器</a> 
                            <a href="">电脑桌</a> 
                            <a href="">迷你标签机</a> 
                            <a href="">理线器</a> 
                            <a href="">计算器</a> 
                            <a href="">荧光告示贴</a> 
                            <a href="">翻译笔</a> 
                            <a href="">毛笔</a> 
                            <a href="">文件收纳</a> 
                            <a href="">书写工具</a> 
                            <a href="">文具</a> 
                        </p>
            </div>
          </div>
         </div>
		 </div>
        </div>
    </div>
   </header>
   <!--header End-->

   <!--banner begin-->
<section id="pc-banner">
    <div class="yBanner">
        <div class="banner" id="banner" >
            <a href="javascript:;" class="d1" style="background:url(${pageContext.request.contextPath }/theme/img/ad/banner1.jpg) center no-repeat;background-color: #f01a38; padding-left:180px;"></a>
            <a href="javascript:;" class="d1" style="background:url(${pageContext.request.contextPath }/theme/img/ad/banner2.jpg) center no-repeat;background-color: #a96ae3; padding-left:180px;"></a>
            <a href="javascript:;" class="d1" style="background:url(${pageContext.request.contextPath }/theme/img/ad/jp.jpg) center no-repeat;background-color: #202579; padding-left:180px;"></a>
            <a href="javascript:;" class="d1" style="background:url(${pageContext.request.contextPath }/theme/img/ad/jp1.jpg) center no-repeat;background-color: #ADF6DB; padding-left:180px;"></a>
            <a href="javascript:;" class="d1" style="background:url(${pageContext.request.contextPath }/theme/img/ad/jp2.jpg) center no-repeat;background-color: #863529; padding-left:180px;"></a>
            <div class="d2" id="banner_id">
                <ul>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>
        <div style="text-align:center;clear:both"></div>
    </div>
</section>
<!-- banner End -->


<!--- advert begin-->
<section id="pc-advert">
    <div class="container-c clearfix">
        <a href="page.html" target="_blank"><img src="${pageContext.request.contextPath }/theme/img/pd/pd1.png"></a>
        <a href="page.html" target="_blank"><img src="${pageContext.request.contextPath }/theme/img/pd/pd2.png"></a>
        <a href="page.html" target="_blank"><img src="${pageContext.request.contextPath }/theme/img/pd/pd3.png"></a>
        <a href="page.html" target="_blank"><img src="${pageContext.request.contextPath }/theme/img/pd/pd4.png"></a>
    </div>
</section>
<!--banner End-->

 <!--商城资讯degin-->
 <section id="pc-information">
    <div class="containers">
        <div class="pc-info-mess  clearfix" style="position: relative;">
            <h2 class="fl" style="margin-right:20px;">商城快讯</h2>
            <div id="MarqueeDiv" class="MarqueeDiv">
	        <a href="#">[特惠]新一代Moto 360智能手表登陆</a>
            <a href="#">[特惠]洗护节 跨品牌满199减100</a>
            <a href="#">[特惠]仁怀政府开启“仁怀酱香酒馆”</a>
            <a href="#">[特惠]洗护节 跨品牌满199减100</a>
            <a href="#">逛商城赚话费，商城通信51城全线抢购 </a>
            <a href="#">文艺蓝牙音箱 火热众筹中 </a>
            <a href="#">[公告]第1000家商城帮服务店落户遵义</a>
            <a href="#">[特惠]新一代Moto 360智能手表登陆</a>
            <a href="#">[特惠]新一代Moto 360智能手表登陆</a>
            <a href="#">[特惠]新一代Moto 360智能手表登陆</a>
	   </div>
	     <a href="#" style="position:absolute;right:15px;top:0;">更多资讯</a>
	 </div>
   </div>
 </section>
 <!--商城抢购 End-->

 <!--限时抢购begin-->
 <div class="time-lists clearfix">
    <div class="time-list fl">
        <div class="time-title">
            <h2>限时抢购</h2>
            <div class="time-item clearfix fl" style="padding-left:10px;">
                <strong id="hour_show">00</strong>
                <strong class="pc-clear-sr">:</strong>
                <strong id="minute_show">00</strong>
                <strong class="pc-clear-sr">:</strong>
                <strong id="second_show">00</strong>
            </div><!--倒计时模块-->
            <a href="sale-begin.html" class="fr">更多抢购商品</a>
        </div>
        <div class="time-border">
            <div class="yScrollList">
                <div class="yScrollListIn">
                	<a class="yScrollListbtn yScrollListbtnl" id="prev-01"></a>
                    <div class="yScrollListInList yScrollListInList1 jCarouselLite" style="display:block;margin-left: 20px;" id="demo-01">
                        <ul>
                            <li>
                                <a href="page.html" target="_blank">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p1.jpg">
                                    <p class="head-name">酷比魔方（Cube）iPlay 10 10.6英寸平板电脑(2GB/32GB 1920*1080大屏四核WIFI平板)前白后银</p>
                                    <p><span class="price">￥678.00</span><span class="discount">￥1280.00</span></p>
                                    <p class="label-default">4.5折</p>
                                </a>
                            </li>
                            <li>
                                <a href="page.html" target="_blank">
                                    <img src="theme/img/pd/p2.jpg">
                                    <p class="head-name">鲁花 食用油 5S压榨一级花生油 6.18L</p>
                                    <p><span class="price">￥168.00</span><span class="discount">￥250.00</span></p>
                                    <p class="label-default">8.8折</p>
                                </a>
                            </li>
                            <li>
                                <a href="page.html" target="_blank">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p3.jpg">
                                    <p class="head-name">极米（XGIMI）Z4Air 家用 投影机 投影仪（720P高清分辨率 办公/便携/手机投影 无屏电视）深空灰</p>
                                    <p><span class="price">￥2200.00</span><span class="discount">￥2499.00</span></p>
                                    <p class="label-default">7.9折</p>
                                </a>
                            </li>
                            <li>
                                <a href="page.html" target="_blank">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p4.jpg">
                                    <p class="head-name">【黑色键盘套装】微软（Microsoft）Surface Pro 二合一平板电脑 12.3英寸（Core M3 4G内存 128G存储 ）</p>
                                    <p><span class="price">￥5888.00</span><span class="discount">￥6588</span></p>
                                    <p class="label-default">8.7折</p>
                                </a>
                            </li>
                        </ul>                    
                    </div>
                    <a class="yScrollListbtn yScrollListbtnr" id="next-01"></a>
                </div>
            </div>
        </div>
    </div>
    <div class="news-list fr">
        <div class="time-title time-clear"><h2>商城快讯</h2><a href="#" class="fr"> 更多资讯</a> </div>
        <div class="time-border" style="border-left:none;">
            <ul class="news">
                <li><a href="#">[特惠]洗护节 跨品牌满199减100</a> </li>
                <li><a href="#">[特惠]新一代Moto 360智能手表登陆</a> </li>
                <li><a href="#">[特惠]惠氏品牌日 两件立享85折</a> </li>
                <li><a href="#">[特惠]洗护节 跨品牌满199减100</a> </li>
                <li><a href="#">[特惠]仁怀政府开启“仁怀酱香酒馆”</a> </li>
            </ul>
            <div class="time-poduse"><img src="${pageContext.request.contextPath }/theme/img/pd/pj1.png"></div>
        </div>
    </div>
</div>
<!-- 限时抢购 End -->

<!-- 卖场推荐 begin -->
<div class="container-c time-lists clearfix">
    <div class="time-list fl">
        <div class="time-title time-clear"><h2>卖场推荐</h2><a href="javascript:;" class="pc-spin fr">换一换</a> </div>
        <div class="time-poued clearfix">
            <a href="#"><img src="theme/img/ad/a2.png"></a>
            <a href="#"><img src="theme/img/ad/a3.png"></a>
            <a href="#"><img src="theme/img/ad/a4.png"></a>
            <a href="#"><img src="theme/img/ad/a5.png"></a>
        </div>
    </div>
    <div class="news-list fr">
        <div class="time-title time-clear"><h2>今日值得购买</h2></div>
        <div class="news-right"><a href="#"><img src="theme/img/ad/a1.png"></a></div>
    </div>
</div>
<!-- 卖场推荐 End -->

<div class="time-lists clearfix">
    <div class="time-list time-list-w fl">
        <div class="time-title time-clear"><h2>热卖区</h2><div class="pc-font fl"></div><a class="pc-spin fr" href="javascript:;">换一换</a> </div>
        <div class="time-border">
            <div class="yScrollList">
                <div class="yScrollListIn">
                    <div style="display:block;" class="yScrollListInList yScrollListInList1">
                        <ul>
                            <li>
                                <a href="">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p5.png">
                                    <p class="head-name pc-pa10">【送大礼包】华为(HUAWEI) M3 青春版 8.0英寸 平板电脑(哈曼卡顿音效 3G内存/32G存储 全网通) 皎月白</p>
                                    <p class="label-default">2.1折</p>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p6.jpg">
                                    <p class="head-name pc-pa10">美的（Midea）电水壶WHJ1705C 304不锈钢电热水壶 1.7L容量 双层防烫烧水壶（时尚青春范）</p>
                                    <p class="label-default">5.1折</p>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p8.jpg">
                                    <p class="head-name pc-pa10">拓浦24英寸纤薄细边框HDMI接口2K电脑显示器 1920分辨率纤薄</p>
                                    <p class="label-default">5.75折</p>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p0.jpg">
                                    <p class="head-name pc-pa10">荣耀8 4GB+64GB 全网通4G手机 魅海蓝</p>
                                    <p class="label-default">8.8折</p>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p81.jpg">
                                    <p class="head-name pc-pa10">【第二支1元 拍2支自动减】ILISYA眉笔眉粉双头造型笔3色选</p>
                                    <p class="label-default">7.8折</p>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="${pageContext.request.contextPath }/theme/img/pd/p9.jpg">
                                    <p class="head-name pc-pa10">华硕(ASUS) 灵耀S4000UA 14英寸超窄边框超轻薄笔记本电脑(i5-7200U 4G 256GSSD FHD IPS)金属蓝灰</p>
                                    <p class="label-default">7.6折</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="time-lists  clearfix">
    <div class="time-list time-list-w fl">
        <div class="time-title time-clear-f"><h2>商品区</h2>
            <ul class="brand-tab H-table clearfix fr" id="H-table">
                <li class="cur"><a href="javascript:void(0);" class="cur" style="margin-top: -18px;">食品</a></li>
                <li><a href="javascript:void(0);" style="margin-top: -18px;">服装</a></li>
                <li><a href="javascript:void(0);" style="margin-top: -18px;">电子产品</a></li>
                <li><a href="javascript:void(0);" style="margin-top: -18px;">家电</a></li>
                <li><a href="javascript:void(0);" style="margin-top: -18px;">办公</a></li>
            </ul>
        </div>
        <div class="time-border time-border-h clearfix">
            <div class="brand-poa fl">
                <div class="brand-poa H-over clearfix">
                    <ul>
                        <li>
                            <div class="brand-imgss"><a href="#" ><img src="${pageContext.request.contextPath }/theme/img/aj/a1.jpg"></a></div>
                            <div class="brand-title"><a href="#">戴尔DELL XPS13-9360-R1609 13.3英寸轻薄窄边框笔记本电脑(i5-7200U 8G 256GSSD FHD Win10)无忌银</a> </div>
                            <div class="brand-price">￥6999.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/a2.jpg"></a></div>
                            <div class="brand-title"><a href="#">联想(Lenovo)小新潮7000 14英寸轻薄窄边框笔记本电脑(I5-8250U 8G 1T+128G PCIE 940MX 2G)花火银</a> </div>
                            <div class="brand-price">￥5699.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="theme/img/aj/a3.jpg"></a></div>
                            <div class="brand-title"><a href="#">华硕(ASUS) 灵耀S4000UA 14英寸超窄边框超轻薄笔记本电脑(i5-7200U 8G 256GSSD FHD IPS)金属蓝灰</a> </div>
                            <div class="brand-price">￥4999.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/a4.jpg"></a></div>
                            <div class="brand-title"><a href="#">联想（ThinkPad） E470c（20H3A013CD）14英寸笔记本电脑（i5-6200U 8G 500G Win10）黑色</a> </div>
                            <div class="brand-price">￥3989.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/a5.jpg"></a></div>
                            <div class="brand-title"><a href="#">LG Gram（15Z970-G.AA52C）15.6英寸超轻薄笔记本电脑（i5-7200U 8G 256GB SSD FHD IPS Win10）深邃银</a> </div>
                            <div class="brand-price">￥7999.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/a6.jpg"></a></div>
                            <div class="brand-title"><a href="#">三星（SAMSUNG）500R4K-X08 14英寸笔记本电脑（i5-5200U 8G 256G固态硬盘 2G独显 Win10） 极地白</a> </div>
                            <div class="brand-price">￥3799.00 </div>
                        </li>
                    </ul>
                </div>
                <div class="brand-poa H-over clearfix" style="display:none;">
                    <ul>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/b1.jpg"></a></div>
                            <div class="brand-title"><a href="#">西部数据（WD） Elements 新元素 </a> </div>
                            <div class="brand-price">￥369.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/b2.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷蛇（Razer）锐蝮蛇竞技版 Lance</a> </div>
                            <div class="brand-price">￥499.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/b3.jpg"></a></div>
                            <div class="brand-title"><a href="#">金士顿（Kingston）DT 100G3 64</a> </div>
                            <div class="brand-price">￥189.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/b4.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷柏（Rapoo） MT750 蓝牙多模式</a> </div>
                            <div class="brand-price">￥199.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/b5.jpg"></a></div>
                            <div class="brand-title"><a href="#">迪锐克斯（DXRACER）DENIAL战</a> </div>
                            <div class="brand-price">￥1887.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/b6.jpg"></a></div>
                            <div class="brand-title"><a href="#">Ninebot One A1九号单轮平衡车 电</a> </div>
                            <div class="brand-price">￥2199.00 </div>
                        </li>
                    </ul>
                </div>
                <div class="brand-poa H-over clearfix" style="display:none;">
                    <ul>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c1.jpg"></a></div>
                            <div class="brand-title"><a href="#">西部数据（WD） Elements 新元素 </a> </div>
                            <div class="brand-price">￥3369.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c2.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷蛇（Razer）锐蝮蛇竞技版 Lance</a> </div>
                            <div class="brand-price">￥4899.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c3.jpg"></a></div>
                            <div class="brand-title"><a href="#">金士顿（Kingston）DT 100G3 64</a> </div>
                            <div class="brand-price">￥1689.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c4.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷柏（Rapoo） MT750 蓝牙多模式</a> </div>
                            <div class="brand-price">￥1989.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c5.jpg"></a></div>
                            <div class="brand-title"><a href="#">迪锐克斯（DXRACER）DENIAL战</a> </div>
                            <div class="brand-price">￥1887.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c6.jpg"></a></div>
                            <div class="brand-title"><a href="#">Ninebot One A1九号单轮平衡车 电</a> </div>
                            <div class="brand-price">￥2199.00 </div>
                        </li>
                    </ul>
                </div>

				<div class="brand-poa H-over clearfix" style="display:none;">
                    <ul>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c1.jpg"></a></div>
                            <div class="brand-title"><a href="#">西部数据（WD） Elements 新元素 </a> </div>
                            <div class="brand-price">￥3369.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c2.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷蛇（Razer）锐蝮蛇竞技版 Lance</a> </div>
                            <div class="brand-price">￥4899.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c3.jpg"></a></div>
                            <div class="brand-title"><a href="#">金士顿（Kingston）DT 100G3 64</a> </div>
                            <div class="brand-price">￥1689.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c4.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷柏（Rapoo） MT750 蓝牙多模式</a> </div>
                            <div class="brand-price">￥1989.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c5.jpg"></a></div>
                            <div class="brand-title"><a href="#">迪锐克斯（DXRACER）DENIAL战</a> </div>
                            <div class="brand-price">￥1887.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c6.jpg"></a></div>
                            <div class="brand-title"><a href="#">Ninebot One A1九号单轮平衡车 电</a> </div>
                            <div class="brand-price">￥2199.00 </div>
                        </li>
                    </ul>
                </div>

				<div class="brand-poa H-over clearfix" style="display:none;">
                    <ul>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c1.jpg"></a></div>
                            <div class="brand-title"><a href="#">西部数据（WD） Elements 新元素 </a> </div>
                            <div class="brand-price">￥3369.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c2.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷蛇（Razer）锐蝮蛇竞技版 Lance</a> </div>
                            <div class="brand-price">￥4899.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c3.jpg"></a></div>
                            <div class="brand-title"><a href="#">金士顿（Kingston）DT 100G3 64</a> </div>
                            <div class="brand-price">￥1689.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c4.jpg"></a></div>
                            <div class="brand-title"><a href="#">雷柏（Rapoo） MT750 蓝牙多模式</a> </div>
                            <div class="brand-price">￥1989.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c5.jpg"></a></div>
                            <div class="brand-title"><a href="#">迪锐克斯（DXRACER）DENIAL战</a> </div>
                            <div class="brand-price">￥1887.00 </div>
                        </li>
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${pageContext.request.contextPath }/theme/img/aj/c6.jpg"></a></div>
                            <div class="brand-title"><a href="#">Ninebot One A1九号单轮平衡车 电</a> </div>
                            <div class="brand-price">￥2199.00 </div>
                        </li>
                    </ul>
                </div>


            </div>
        </div>
    </div>
</div>
<script type="text/javascript">banner()</script>
</body>
</html>