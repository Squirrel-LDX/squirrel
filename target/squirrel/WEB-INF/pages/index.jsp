<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>鲁大二手工坊</title>
		<link rel="stylesheet" href="css/index.css" />
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/index.bundle.js" ></script>
		<script type="text/javascript" src="js/materialize.min.js" ></script>
		<link rel="stylesheet" href="css/materialize-icon.css" />
		<script>
			function showLogin() {
				if($("#signup-show").css("display")=='block'){
					$("#signup-show").css("display","none");
				}
				if($("#login-show").css("display")=='none'){
					$("#login-show").css("display","block");
				}else{
					$("#login-show").css("display","none");
				}
			}
			function showSignup() {
				if($("#login-show").css("display")=='block'){
					$("#login-show").css("display","none");
				}
				if($("#signup-show").css("display")=='none'){
					$("#signup-show").css("display","block");
				}else{
					$("#signup-show").css("display","none");
				}
			}
		</script>
	<body ng-view="ng-view">
		<!--
        	作者：hlk_1135@outlook.com
        	时间：2017-05-05
        	描述：顶部
        -->
		<div ng-controller="headerController" class="header stark-components navbar-fixed ng-scope">
			<nav class="white nav1">
				<div class="nav-wrapper">
					<a href="" class="logo">
						<em class="em1">鲁大</em>
						<em class="em2">二手工坊</em>
						<em class="em3">ldu.market</em>
					</a>
					<div class="nav-wrapper search-bar">
						<form ng-submit="search()" class="ng-pristine ng-invalid ng-invalid-required">
							<div class="input-field">
								<input id="search" type="search" ng-model="keyword" placeholder="搜点什么吧233..." 
									required="required" class="ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required"/>
								<label for="search" class="active">
									<i ng-click="search()" class="iconfont"></i>
								</label>
							</div>
						</form>
					</div>
					<ul class="right">
						<li class="publish-btn">
							<button ng-click="showLogin()" data-position="bottom" data-delay="50"
							data-tooltip="需要先登录哦！" class="red lighten-1 waves-effect waves-light btn" data-tooltip-id="510d3084-e666-f82f-3655-5eae4304a83a"	>
							我要发布</button>
						</li>
<						<c:if test="${empty user}">
							<li>
								<a href="">我发布的商品</a>
							</li>
							<li>
								<a>${user.username}</a>
							</li>
							<li class="notification">
								<i ng-click="showNotificationBox()" class="iconfont"></i>
								<div ng-show="notification.tagIsShow" class="notification-amount red lighten-1 ng-binding ng-hide">0 </div>
							</li>
							<li>
								<a ng-click="changeMoreVertShow()">
									<i class="iconfont"></i>
								</a>
								<div class="more-vert">
									<ul ng-show="moreVertIsShow" class="dropdown-content ng-hide">
										<li><a>邮箱验证</a></li>
										<li><a>更改用户名</a></li>
										<li><a>退出登录</a></li>
									</ul>
								</div>
							</li>
						</c:if>
<						<c:if test="${!empty user}">
							<li>
								<a onclick="showLogin()">登录</a>
							</li>
							<li>
								<a onclick="showSignup()">注册</a>
							</li>
						</c:if>
					</ul>
				</div>
			</nav>
		</div>
		<!--
        	作者：hlk_1135@outlook.com
        	时间：2017-05-05
        	描述：登录
        -->
        <div ng-controller="loginController" class="ng-scope">
        	<div id="login-show" class="login stark-components">
        		<div class="publish-box z-depth-4">
        			<div class="row">
        				<div class="col s12 title"></div>
						<form:form action="/user/loginValidate" method="post" commandName="user" role="form">
        				<div class="input-field col s12">
							<input type="text" name="phone" required="required" pattern="^1[0-9]{10}$" class="validate ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-pattern ng-touched" />
							<label>手机</label>
        				</div>
        				<div class="input-field col s12">
        					<input type="password" ng-model="password" ng-keyup="checkEnter($event)" required="required" class="validate ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required" />
        					<label>密码</label>
        					<a ng-click="showForget()" class="forget-btn">忘记密码？</a>
        				</div>
        				<button ng-click="login()" class="waves-effect waves-light btn login-btn red lighten-1">
        					<i class="iconfont left"></i>
        					<em>登录</em>
        				</button>
        				<div class="col s12 signup-area">
        					<em>没有账号？赶快</em>
        					<a onclick="showSignup()" class="signup-btn">注册</a>
        					<em>吧！</em>
        				</div>
        				</form:form>
        			</div>
        		</div>
        	</div>
        </div>
        <!--
        	作者：hlk_1135@outlook.com
        	时间：2017-05-06
        	描述：注册
        -->
        <div ng-controller="signupController" class="ng-scope">
        	<div id="signup-show" class="signup stark-components">
        		<div class="publish-box z-depth-4">
        			<div class="row">
        				<div class="col s12 title"></div>
						<form:form action="/user/addUser" method="post" commandName="user" role="form">
							<div class="input-field col s12">
								<input type="text" name="username" required="required" class="validate ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-pattern ng-touched" />
								<label>昵称</label>
							</div>
							<div class="input-field col s12">
								<input type="text" name="phone" required="required" pattern="^1[0-9]{10}$" class="validate ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-pattern ng-touched" />
								<label>手机</label>
							</div>
							<div class="input-field col s12">
								<input type="password" name="password" required="required" class="validate ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required" />
								<label>密码</label>
							</div>
							<div ng-show="checkTelIsShow" class="col s12">
								<button type="submit" class="waves-effect waves-light btn verify-btn red lighten-1">
									<i class="iconfont left"></i>
									<em>点击注册</em>
								</button>
							</div>
							<div ng-show="checkTelIsShow" class="login-area col s12">
								<em>已有账号？去</em>
								<a onclick="showLogin()">登录</a>
							</div>
						</form:form>
        			</div>
        		</div>
        	</div>
        </div>
		<!--
        	作者：hlk_1135@outlook.com
        	时间：2017-05-05
        	描述：左侧导航条
        -->
        <div ng-controller="sidebarController" class="sidebar stark-components ng-scope">
        	<li ng-class="{true: 'active'}[isAll]">
        		<a href="" class="index">
        			<img src="img/index.png">
        			<em>最新发布</em>
        		</a>
        	</li>
        	<li ng-class="{true: 'active'}[isDigital]">
        		<a href="" class="digital">
        			<img src="img/digital.png"  />
        			<em>闲置数码</em>
        		</a>
        	</li>
        	<li ng-class="{true: 'active'}[isRide]">
        		<a href="" class="ride">
        			<img src="img/ride.png"/>
        			<em>校园代步</em>
        		</a>
        	</li>
        	<li ng-class="{true: 'active'}[isCommodity]">
        		<a href="" class="commodity">
        			<img src="img/commodity.png"/>
        			<em>电器日用</em>
        		</a>
        	</li>
        	<li ng-class="{true: 'active'}[isBook]">
        		<a href="" class="book">
        			<img src="img/book.png"/>
        			<em>图书教材</em>
        		</a>
        	</li>
        	<li ng-class="{true: 'active'}[isMakeup]">
        		<a href="/category/makeup" class="makeup">
        			<img src="img/makeup.png"/>
        			<em>美妆衣物</em>
        		</a>
        	</li>
        	<li ng-class="{true: 'active'}[isSport]">
        		<a href="/category/sport" class="sport">
        			<img src="img/sport.png"/>
        			<em>运动棋牌</em>
        		</a>
			</li>
			<li ng-class="{true: 'active'}[isSmallthing]">
				<a href="" class="smallthing">
					<img src="img/smallthing.png"/>
					<em>票券小物</em>
				</a>
			</li>
			<div class="info">
				<a href="" target="_blank">关于我们</a><em>-</em>
				<a href="">联系我们</a>
				<p>©2017 LDUACM工作室</p>
			</div>
        </div>
        <!--
        	作者：hlk_1135@outlook.com
        	时间：2017-05-05
        	描述：右侧显示部分
        -->
        <div class="main-content">
        	<!--
	        	作者：hlk_1135@outlook.com
	        	时间：2017-05-05
	        	描述：右侧banner（图片）部分
	        -->
        	<div class="slider-wapper">
        		<div class="slider" style="height: 440px; touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
        			<ul class="slides" style="height: 400px;">
        				<li class="active" style="opacity: 1;">
        					<a href="">
        						<img src="img/findfun.png"/>
        					</a>
        				</li>
        			</ul>
        			<ul></ul>
        		</div>
        	</div>
        	<!--
	        	作者：hlk_1135@outlook.com
	        	时间：2017-05-05
	        	描述：最新发布
	        -->
	        <div class="index-title">
	        	<a href="">最新发布</a>
	        	<hr class="hr1">
	        	<hr class="hr2">
	        </div>
        
	        <div class="waterfoo stark-components row">
	        	<div class="item-wrapper normal">
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        	</div>
	        </div>
        	<!--
	        	作者：hlk_1135@outlook.com
	        	时间：2017-05-05
	        	描述：闲置数码
	        -->
	        <div class="index-title">
	        	<a href="">闲置数码</a>
	        	<hr class="hr1">
	        	<hr class="hr2">
	        </div>
        
	        <div class="waterfoo stark-components row">
	        	<div class="item-wrapper normal">
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        	</div>
	        </div>
        	<!--
	        	作者：hlk_1135@outlook.com
	        	时间：2017-05-05
	        	描述：校园代步
	        -->
	        <div class="index-title">
	        	<a href="">校园代步</a>
	        	<hr class="hr1">
	        	<hr class="hr2">
	        </div>
        
	        <div class="waterfoo stark-components row">
	        	<div class="item-wrapper normal">
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        		<div class="card col">
	        			<a href="">
	        				<div class="card-image" style="background-image:url(img/file-1493726053986.JPG)"></div>
	        				<div class="card-content item-price">￥1300</div>
	        				<div class="card-content item-name">
	        					<p>B&O h5 蓝牙无线耳机</p>
	        				</div>
	        				<div class="card-content item-location">
	        					<p>主校区</p>
	        					<p>3天前</p>
	        				</div>
	        			</a>
	        		</div>
	        	</div>
	        </div>
        	
        </div>
	</body>
</html>
