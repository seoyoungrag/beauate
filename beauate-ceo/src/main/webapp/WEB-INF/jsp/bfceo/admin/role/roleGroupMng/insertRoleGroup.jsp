<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/bfceo/common/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Basic</title>
	
	<link rel="stylesheet" type="text/css" href="${cssPath}/common.css">
	<link rel="stylesheet" type="text/css" href="${cssPath}/worksite.css">
	<link rel="stylesheet" type="text/css" href="${cssPath}/buttonStyle.css">
	
	<script type="text/javascript" src="${scriptPath}/jquery/jquery-1.12.3.min.js" ></script>
</head>
<body>
<!-- Top -->
<div class="header">
	<jsp:include page="/WEB-INF/jsp/bfceo/common/top.jsp" flush="false" />
</div>

<div class="wrap">
	<div class="container">

		<!-- 좌측메뉴리스트 left_menu -->
		<%@ include file="/WEB-INF/jsp/bfceo/common/leftMenu.jsp" %>
		
		<!-- 본문 시작 -->
		<div class="contents">
			<p class="contentTitle">권한관리</p>
			<p class="sub_path">
				<img src="${imagePath}/ico_home.png" width="10" height="9" />
				&nbsp;〉&nbsp;포탈관리〉&nbsp;권한관리&nbsp;〉&nbsp;권한그룹관리
			</p>

			<h4 class="contentTitle_h4">권한 그룹 정보 등록</h4>
			<form:form modelAttribute="roleVO" method="post" id="insertForm">
				<form:hidden path="athrId"/>
				<form:hidden path="sortSubject"/>
				<form:hidden path="sortDescend"/>
				<form:hidden path="searchCondition"/>
				<form:hidden path="searchKeyword"/>
				<form:hidden path="pageIndex"/>
				<div class="tableLayer">
					<table class="table">
						<caption></caption>
						<colgroup>
							<col width="150px">
							<col width="*">
						</colgroup>
						<tbody class="line">
							<tr>
								<th class="bullet_orange">권한코드</th>
								<td>
									<div class="commonSearch_wrap">
										<label class="blind" for="athrCd"></label>
										<form:input path="athrCd" cssStyle="width:720px;"/> &nbsp;[<span class="color_red">0</span>/20]byte
									</div>
								</td>
							</tr>
							<tr>
								<th class="bullet_orange">권한그룹명</th>
								<td>
									<div class="commonSearch_wrap">
										<label class="blind" for="athrNm"></label>
										<form:input path="athrNm" cssStyle="width:720px;"/> &nbsp;[<span class="color_red">0</span>/30]byte
									</div>
								</td>
							</tr>
							<tr>
								<th class="bullet_orange">권한분류</th>
								<td>
									<form:select path="athrCl" cssClass="w30p">
										<form:option value="U" label="인증된 사용자 권한"/>
										<form:option value="A" label="관리자 권한"/>
										<form:option value="N" label="인증 되지 않은 사용자"/>
									</form:select>
								</td>
							</tr>
							<tr>
								<th>권한설명</th>
								<td class="pdtb3">
									<form:textarea path="athrCn" rows="5"/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="T_btnLayer fr">
					<a href="#"><button type="button" class="blueBtn L" onclick="fn_insertProc();">저장</button></a>
					<a href="#"><button type="button" class="blueBtn L" onclick="fn_cancel();">취소</button></a>
				</div>
			</form:form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/bfceo/common/footer.jsp"%>

<script type="text/javascript">
fn_cancel = function () {
	$("#insertForm").attr("action", "${basePath}/role/r/m/selectRoleGroupList.do").submit();
};

fn_insertProc = function () {
	$("#insertForm").attr("action", "${basePath}/role/w/n/insertRoleGroupProc.do").submit();
};
</script>
</body>
</html>