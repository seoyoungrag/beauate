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
<script type="text/javascript" src="${scriptPath}/validation/validation.js"></script>
<script type="text/javascript" src="${scriptPath}/common.js"></script>
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
				<p class="contentTitle">프로그램 관리</p>
				<p class="sub_path">
					<img src="${imagePath }/ico_home.png" width="10" height="9" />&nbsp;〉&nbsp;포탈관리&nbsp;〉&nbsp;프로그램관리
				</p>
				<form:form modelAttribute="programVO" name="programVO" id="programVO" method="post" action="${basePath}/program/z/n/insertProgramProc.do" >
					<form:hidden path="sortSubject"/>
					<form:hidden path="sortDescend"/>
					<form:hidden path="searchCondition"/>
					<form:hidden path="searchKeyword"/>
					<form:hidden path="pageIndex"/>
					<h4 class="contentTitle_h4">프로그램 등록</h4>
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
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="prgr_nm" style="width: 240px;" type="text" onfocus="checker(this, 30 , 'nbytes_prgr_nm');" onblur="stopchecker();"/>
											&nbsp;[<span id="nbytes_prgr_nm" class="color_red">0</span>/30]byte
										</div>
									</td>
									<th class="bullet_orange">변수명</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="prgr_vriabl" style="width: 240px;" type="text" onfocus="checker(this, 20 , 'nbytes_prgr_vriabl');" onblur="stopchecker();"/>
											&nbsp;[<span id="nbytes_prgr_vriabl" class="color_red">0</span>/20]byte
										</div>
									</td>
								</tr>
								<tr>
									<th class="bullet_orange">프로그램 대표 URL</th>
									<td colspan="4">
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="prgr_url" style="width: 730px;" type="text" onfocus="checker(this, 50 , 'nbytes_prgr_url');" onblur="stopchecker();"/>
											&nbsp;[<span id="nbytes_prgr_url" class="color_red">0</span>/50]byte
										</div>
									</td>
								</tr>
								<tr>
									<th>설명</th>
									<td colspan="4" class="pdtb3"> <!-- textarea 의 경우는 td에  class="pdtb3" 패딩 클래스 추가 -->
										<form:textarea path="prgr_cn" rows="5" onfocus="checker(this, 200 , 'nbytes_prgr_cn');" onblur="stopchecker();"/><br/>
										&nbsp;[<span id="nbytes_prgr_cn" class="color_red">0</span>/200]byte
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
				<div class="T_btnLayer fr">
					<a href="javascript:void(0);" onclick="fn_insertProgramProc();"><button type="button" class="blueBtn L">등록</button></a>
					<a href="${basePath}/program/r/m/selectProgramList.do"><button type="button" class="blueBtn L">취소</button></a>
				</div>
			</div>
		</div>
		<!--container End-->
	</div>
	<!--wrap End-->
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/bfceo/common/footer.jsp"%>
	</div>
	<!--//footer-->
	<script type="text/javascript">
	//등록하기
	var fn_insertProgramProc = function(){
		if (!TypeChecker.required($("#prgr_nm").val())) {
			alert("'프로그램명'은  "+ TypeChecker.requiredText);
			$("#prgr_nm").focus();
			return;
		}
		
		if (!TypeChecker.required($("#prgr_vriabl").val())) {
			alert("'변수명'은  "+ TypeChecker.requiredText);
			$("#prgr_vriabl").focus();
			return;
		}
		
 		if (!TypeChecker.alphanum($("#prgr_vriabl").val())) {
			alert("'변수명'은 "+TypeChecker.alphanumText);
			$("#prgr_vriabl").focus();
			return;
		}
 		
 		if (!TypeChecker.required($("#prgr_url").val())) {
			alert("'프로그램 대표 URL'은  "+ TypeChecker.requiredText);
			$("#prgr_url").focus();
			return;
		}

 		if (!TypeChecker.programUrl($("#prgr_url").val())) {
			alert("'프로그램 대표 URL'은  "+ TypeChecker.programUrlText);
			$("#prgr_url").focus();
			return;
		}

		if ($("#prgr_url").val().indexOf('/' + $("#prgr_vriabl").val().trim() + '/') == '-1') {
			alert("'프로그램 대표 URL'은 '변수명'을 맨앞에 포함된 형태가 되어야합니다.");
			$("#prgr_url").focus();
			return;
		}

		if (!confirm("저장 하시겠습니까?")) {
			return;
		}
		
		//중복체크
		$.ajax(
		{ 	url: "${basePath}/program/z/n/selectProgramParamChk.do",
			type: 'POST',
			dataType : "json",
			data : $("#programVO").serialize(),
			error: function() {
				 alert("현재 조회 서비스가 원할하지 않습니다.\n잠시후 다시 이용해 주십시요.");
				 return;
			},
			success: function(r) {
				if (r.chkResult == 'N') {
					alert("변수명이 중복되었습니다 다른값으로 입력바랍니다.");
					$("#prgr_vriabl").focus();
					return;
				} else {
					document.programVO.submit();
				}
			}
		}); 
	};	
	</script>
</body>
</html>