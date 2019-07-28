<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/bfceo/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>BASIC administrator</title>
<!--공통css-->
<link rel="stylesheet" type="text/css" href="${cssPath }/common.css">
<!--현업 main page-->
<link rel="stylesheet" type="text/css" href="${cssPath }/worksite.css">
<!--현업 login-->
<link rel="stylesheet" type="text/css" href="${cssPath }/loginstyle.css">
<!-- 스크립트 선언 -->
<script type="text/javascript" src="${scriptPath}/jquery/jquery-1.12.3.min.js"></script>
</head>
<body class="backcolor">
 	<form:form modelAttribute="beutyUser" id="loginForm" name="loginForm" method="post" action="${basePath}/login/a/n/afterLogin.do" > 
		<div class="login_wrap">
			<div class="loginBox">
				<h2>
					<img src="${imagePath }/logo.png" width="143" height="19" />
				</h2>
				<p class="txt_login">
					<span>Log in to Basic Administrator Account</span>
				</p>
				<dl class="box_area">
					<dt>
						<a href="#"><img src="${imagePath }/btn_login.jpg" width="97" height="78" onclick="javascript:fn_login();"/></a>
					</dt>
					<dd class="namebox">ID</dd>
					<dd class="boxin">
						<input name="emailAddr" id="user_id" type="text" />
					</dd>
					<dd class="namebox">PASSWORD</dd>
					<dd class="boxin">
						<input name="userPw" id="user_pw" type="password" onkeypress="if( event.keyCode==13 ){fn_login();}" autocomplete="false"/>
					</dd>
				</dl>
			</div>
		</div>
 	</form:form> 
<script type="text/javascript">
fn_login = function() {
	//로그인 아이디가 있으면 로그인 아이디에 세팅 
	if(!$.trim($("#user_id").val())){
		alert("아이디를 입력해 주십시오.");
		return;
	}
	if(!$.trim($("#user_pw").val())){
		alert("비밀번호를 입력해 주십시오.");
		return;
	}
	
	$("#loginForm").submit();
};
</script>
</body>
</html>