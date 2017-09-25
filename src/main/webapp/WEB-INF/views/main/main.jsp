<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台主页面</title>
		<!-- basic styles -->
		<link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/resources/assets/css/font-awesome.min.css" />
		
		<!-- page specific plugin styles -->
		
		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		
		<!-- ace styles -->
		<link rel="stylesheet" href="/resources/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/resources/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="/resources/assets/css/ace-skins.min.css" />
		
		<script src="/resources/jquery/jquery-1.11.1.js"></script>
		<script src="/resources/assets/js/bootstrap.min.js"></script>
		<script src="/resources/assets/js/typeahead-bs2.min.js"></script>
		
		<!-- ace scripts -->
		<!-- 必须引入 ,否则导航栏不能用 -->
		<script src="/resources/assets/js/ace-extra.min.js"></script>
		<script src="/resources/assets/js/ace-elements.min.js"></script>
		<script src="/resources/assets/js/ace.min.js"></script>
		
		<script src="/resources/layer/layer.js"></script> 
		
		<!-- easyui -->
		<!-- 	    <link rel="stylesheet" type="text/css" href="/resources/jquery-easyui-1.5.3/themes/default/easyui.css"> -->
		<!-- 	    <link rel="stylesheet" type="text/css" href="/resources/jquery-easyui-1.5.3/themes/icon.css"> -->
		<!-- 	    <link rel="stylesheet" type="text/css" href="/resources/jquery-easyui-1.5.3/demo/demo.css"> -->
		<!-- 	    <script type="text/javascript" src="/resources/jquery-easyui-1.5.3/jquery.min.js"></script> -->
		<!-- 	    <script type="text/javascript" src="/resources/jquery-easyui-1.5.3/jquery.easyui.min.js"></script> -->
	</head>
	
	<!-- 去掉竖滚动条 -->
<!-- 	<body style="overflow:-Scroll;overflow-y:hidden" >   -->
	<!-- 去掉横滚动条 -->
	<body style="overflow:-Scroll;overflow-x:hidden">

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							权限管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
					
					
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="/resources/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎你</small>
									${username}
								</span>
								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										修改资料
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人详情
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="/loginOut">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li class="active">
							<a href="/main">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>

						<li>
							<a href="#" class="dropdown-toggle" >
								<span class="menu-text">申请管理 </span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="javascript:goNav('/AuthApplyMessage/applying')">
										<i class="icon-double-angle-right"></i>
										正在申请
									</a>
								</li>

								<li>
									<a href="javascript:goNav('/AuthApplyMessage/applysuccess')">
										<i class="icon-double-angle-right"></i>
										申请成功
									</a>
								</li>
								
								<li>
									<a href="javascript:goNav('AuthApplyMessage/applydefeated')">
										<i class="icon-double-angle-right"></i>
										申请失败
									</a>
								</li>
							</ul>
						</li>
						
						
						<li>
							<a href="#" class="dropdown-toggle">
								<span class="menu-text">个人中心 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										基本信息
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										修改基本资料
									</a>
								</li>

								<li>
									<a href="wysiwyg.html">
										<i class="icon-double-angle-right"></i>
										修改密码
									</a>
								</li>
							</ul>
						</li>
				</div>
				
			<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="/main">首页</a>
							</li>
							<li class="active">控制台</li>
						</ul><!-- .breadcrumb -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
				
<!-- 		在此位置需要引入一个框架页面iframe  -->
			<iframe src="/AuthApplyMessage/applying" id="rightIframe" frameborder="0"
				scrolling="no" marginheight="0" marginwidth="0" name="main"
				onload="autoHeight();">
			</iframe>
				
			<script type="text/javascript">
				function autoHeight() {
					var iframe = document.getElementById("rightIframe");
					if (iframe.Document) {//ie自有属性 iframe.style.height =
						iframe.Document.documentElement.scrollHeight;
						iframe.style.width = iframe.Document.documentElement.scrollWidth;
					} else if (iframe.contentDocument) {//ie,firefox,chrome,opera,safari
						iframe.height = document.documentElement.clientHeight-85.5;
						iframe.width = screen.width - $("#sidebar").width()-25;
					}
				} 
				
// 				window.onresize=function(){  
// 				     changeFrameHeight();  
// 				} 
				
				function goNav(url){
					
					$("#rightIframe").attr("src",url);
					
				}
			</script>
</body>
</html>
