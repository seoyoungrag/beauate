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
	<!-- header Start -->
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
				<p class="contentTitle">프로그램 관리</p>
				<p class="sub_path">
					<img src="${imagePath }/ico_home.png" width="10" height="9" />&nbsp;〉&nbsp;포탈관리&nbsp;〉&nbsp;프로그램관리
				</p>
				<h4 class="contentTitle_h4">프로그램 상세내용</h4>
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
								<th class="bullet_orange">프로그램명</th>
								<td><c:out value="${resultVO.prgr_nm}"/></td>
								<th class="bullet_orange">변수명</th>
								<td><c:out value="${resultVO.prgr_vriabl}"/></td>
							</tr>
							<tr>
								<th class="bullet_orange">프로그램 대표 URL</th>
								<td colspan="4"><c:out value="${resultVO.prgr_url}"/></td>
							</tr>
							<tr>
								<th>설명</th>
								<td colspan="4"><c:out value="${resultVO.prgr_cn}"/></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="T_btnLayer fr">
					<a href="javascript:void(0);" onclick="javascript:fn_updateProgram();"><button type="button" class="blueBtn L">수정</button></a>
					<a href="javascript:void(0);" onclick="javascript:fn_deleteProgram();"><button type="button" class="blueBtn L">삭제</button></a>
					<a href="${basePath}/program/z/m/selectProgramList.do"><button type="button" class="blueBtn L">목록</button></a>
				</div>
			</div>
		</div>
		<!--container End-->
	</div>
	<form:form modelAttribute="programVO" id="detailForm" name="detailForm" method="post" >
		<input type="hidden" name="prgr_id" id="prgr_id" value="${resultVO.prgr_id}">
	</form:form>
	<!--wrap End-->
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/bfceo/common/footer.jsp"%>
	</div>
	<!--//footer-->
	<script type="text/javascript">
	//수정
	fn_updateProgram = function() {
		$('#detailForm').attr("action","${basePath }/program/z/m/updateProgram.do");
		$('#detailForm').submit();
	};
	
	//삭제
	fn_deleteProgram = function() {
		if(confirm("삭제 하시겠습니까?")) {
			$('#detailForm').attr("action","${basePath }/program/z/n/deleteProgramProc.do");
			$('#detailForm').submit();
		}
	};
	</script>
</body>
</html>