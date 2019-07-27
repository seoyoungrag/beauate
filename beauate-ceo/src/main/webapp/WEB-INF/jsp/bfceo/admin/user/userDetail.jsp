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
<body>
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/bfceo/common/top.jsp" flush="false" />
	</div>
	<!--header End-->
	<div class="wrap">
		<div class="container">
			<div class="sub_leftMenu">
				<%@ include file="/WEB-INF/jsp/bfceo/common/leftMenu.jsp" %>
			</div>
			<div class="contents">
				<p class="contentTitle">사용자 목록</p>
				<p class="sub_path">
					<img src="${imagePath }/ico_home.png" width="10" height="9" />&nbsp;〉&nbsp;사용자관리&nbsp;〉&nbsp;사용자관리
				</p>
				<h4 class="contentTitle_h4">로그인 정보</h4>
				<div class="tableLayer">
					<table class="table">
						<caption></caption>
						<colgroup>
							<col width="150px">
							<col width="340px">
							<col width="150px">
							<col width="340px">
						</colgroup>
						<tbody class="line">
							<tr>
								<th>사용자일련번호</th>
								<td><c:out value="${userVO.user_id}"/></td>
								<th>E-mail</th>
								<td><c:out value="${userVO.email_addr}"/></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><c:out value="${userVO.user_nm}"/></td>
								<th>가입일</th>
								<td colspan="4"><fmt:formatDate value="${userVO.join_dt}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</tbody>
					</table>
				</div>
				<h4 class="contentTitle_h4">개인 정보</h4>
				<div class="tableLayer">
					<table class="table">
						<caption></caption>
						<colgroup>
							<col width="150px">
							<col width="340px">
							<col width="150px">
							<col width="340px">
						</colgroup>
						<tbody class="line">
							<tr>
								<th>영문이름(여권표기명)</th>
								<td><c:out value="${userVO.user_eng_nm}"/></td>
								<th>전화번호</th>
								<td><c:out value="${userVO.pno}"/></td>
							</tr>
							<tr>
								<th>주소</th>
								<td colspan="4">(<c:out value="${userVO.zip_no}"/>) <c:out value="${userVO.addr}"/></td>
							</tr>
							<tr>
								<th>휴대폰</th>
								<td><c:out value="${userVO.mbl_pno}"/></td>
								<th>전화번호</th>
								<td><c:out value="${userVO.pno}"/></td>
							</tr>
							<tr>
								<th>팩스번호</th>
								<td><c:out value="${userVO.fax_no}"/></td>
								<th>수정일시</th>
								<td><c:if test="${empty userVO.mod_dt}">-</c:if><fmt:formatDate value="${userVO.mod_dt}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="T_btnLayer fr">
					<a href="${basePath}/usermgr/z/m/updateUser.do?user_id=${userVO.user_id}"><button type="button" class="blueBtn L">수정</button></a>
					<a href="javascript:void(0);" onclick="javascript:fn_deleteUserProc();"><button type="button" class="blueBtn L">삭제</button></a>
					<a href="${basePath}/usermgr/z/m/selectUserList.do"><button type="button" class="blueBtn L">목록</button></a>
				</div>
			</div>
		</div>
		<!--container End-->
	</div>
	<form:form modelAttribute="userVO" name="userVO" id="userVO" method="post" action="${basePath}/usermgr/z/n/deleteUserProc.do" onsubmit="return false;">
		<form:hidden path="user_id" id="user_id"/>
		<form:hidden path="email_addr" id="email_addr"/>
	</form:form>
	<!--wrap End-->
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/bfceo/common/footer.jsp"%>
	</div>
	<!--//footer-->
	<script type="text/javascript">
	var fn_deleteUserProc = function() {
		$("#user_id").val('${userVO.user_id}');
		$("#email_addr").val('${userVO.email_addr}');
		document.userVO.submit();
	};
	</script>
</body>
</html>