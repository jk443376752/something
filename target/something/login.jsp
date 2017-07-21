<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<!-- basic styles -->
		<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css" />
		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-rtl.min.css" />
		<!-- js -->
		<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.11.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/bootstrap3.3.7/js/bootstrap.min.js"></script>
		<script>
			$(function(){
				$("#button").on("click",function(){
			 		var username = $("#username").val();
					var password = $("#password").val();
					if(username.length==0 || password.length==0){
						$("#myContent").empty();
		    	    	$("#myContent").append("<h4>用户名或密码不能为空<h4>");
						$('#myModal').modal('show');
						return;
					}
					var loginUser = [];
					loginUser.username = username;
					loginUser.password = password;
					
				    $.post('login/check',
		    	    {
		    			username:loginUser.username,
		    			password:loginUser.password
		    	    },
		    	    function(data,status){
		    	    	
		    	      if(data.is_abnormal==1){
		    	    	window.location.href="/main"; 
		      	      	return;
		    	      }
		    	      if(data.is_abnormal==0){
		    	    	  $("#myContent").empty();
		    	    	  var remark = "<h4>"+data.remark+"<h4>";
		    	    	  $("#myContent").append(remark);
		    	    	  $('#myModal').modal('show');
				 		  var username = $("#username").empty();
						  var password = $("#password").empty();
		      	      	return;
		      	      }
		    	    });
				})
			})
		</script>
	</head>

	<div style="margin-top:130px">
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">somthing项目</span>
								</h1>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入您的信息
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" id="username" class="form-control" placeholder="请输入用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> 记住我</span>
														</label>

														<button type="button" id="button" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
													<i class="icon-arrow-left"></i>
													忘记密码
												</a>
											</div>

											<div>
												<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													注册
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
			
			
			<!-- bootstrap模态框开始 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" 
			                        aria-hidden="true">×
			                </button>
			                <h4 class="modal-title" id="myModalLabel">
			                   		<b>温馨提示:</b> 
			                </h4>
			            </div>
			            <div class="modal-body" id="myContent">
			            </div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" 
			                        data-dismiss="modal">确认
			                </button>
			            </div>
			        </div><!-- /.modal-content -->
			    </div><!-- /.modal-dialog -->
			</div>
			<!-- 模态框结束 -->
	</body>
</div>
</html>