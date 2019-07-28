<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/bfceo/common/include.jsp"%>
<div class="header_centerBox">
	<h1>
		<img src="${imagePath }/logo.png" width="143" height="19" />
	</h1>
	<div class="lnb">
		<dl>
			<dt class="hidden">로그인, 로그아웃, 사이트맵 , 설정이 들어가는 자리입니다.</dt>
			<dd>관리자님 환영합니다.</dd>
			<dd>
				<a href="#" class="lbtn">로그아웃</a>
			</dd>
			<dd class="lbar">
				<img src="${imagePath }/lnb_bar.gif" width="1" height="10" />
			</dd>
			<dd>
				<a href="#">사이트맵</a>
			</dd>
			<dd class="lbar">
				<img src="${imagePath }/lnb_bar.gif" width="1" height="10" />
			</dd>
			<dd>
				<a href="#">설정</a>
			</dd>
		</dl>
	</div>
	<!--Local Navigation Bar End-->

	<div class="gnbWrap">
		<div id="menuArea">
			<ul id="navi">
				<li id="menu" class="selectMenu"><a href="#">사용자관리</a></li>
				<li id="menu"><a href="#">포탈관리</a></li>
				<li id="menu"><a href="#">게시판관리</a></li>
				<li id="menu"><a href="#">설문관리</a></li>
			</ul>
		</div>
	</div>
</div>
<!--header_centerBox End-->