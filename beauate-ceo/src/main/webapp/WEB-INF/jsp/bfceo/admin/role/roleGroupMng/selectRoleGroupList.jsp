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
			<form:form modelAttribute="roleVO" method="post" id="listForm">
				<form:hidden path="pageIndex"/>
				<form:hidden path="sortSubject"/>
				<form:hidden path="sortDescend"/>
				<div class="selectBox">
					
					<form:select path="searchCondition" class="w13p">
						<form:option value="athrCd" label="권한 코드"/>
						<form:option value="athrId" label="권한 아이디"/>
						<form:option value="athrNm" label="권한 그룹 명"/>
					</form:select>
					<form:input path="searchKeyword" class="searchName" cssStyle="width: 733px;"/>
					<button type="button" id="searchBtn" class="grayBtn ico" onclick="fn_search(1);">
						<img src="${imagePath}/ico_search.png"> 검색
					</button>
				</div>

				<div class="tableLayer">
				
					<table class="tableList">
						<colgroup>
							<col width="18%">
							<col width="18%">
							<col width="18%">
							<col width="46%">
						</colgroup>
						<thead>
							<th class="noBg">
								권한 아이디
								<span class="arrow_ascending"><a href="#"></a></span>
								<span class="arrow_descending"><a href="#"></a></span>
							</th>
							<th>
								권한 코드
								<span class="arrow_ascending"><a href="#"></a></span>
								<span class="arrow_descending"><a href="#"></a></span>
							</th>
							<th>
								권한 그룹명
								<span class="arrow_ascending"><a href="#"></a></span>
								<span class="arrow_descending"><a href="#"></a></span>
							</th>
							<th>권한분류</th>
						</thead>
						<tbody>
							<c:forEach items="${roleGroupList}" var="list">
								<tr class="row">
									<td><c:out value="${list.athrId}"/></td>
									<td><a href="javascript:void(0);" onclick="fn_detail('${list.athrId}');"><c:out value="${list.athrCd}"/></a></td>
									<td><c:out value="${list.athrNm}"/></td>
									<c:choose>
										<c:when test="${list.athrCl eq 'U'}">
											<td><c:out value="포탈 사용자 권한"/></td>
										</c:when>
										<c:when test="${list.athrCl eq 'A'}">
											<td><c:out value="관리자 권한"/></td>
										</c:when>
										<c:when test="${list.athrCl eq 'N'}">
											<td><c:out value="신규 가입 사용자"/></td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="T_btnLayer fr">
					<a href="javascript:void(0);"><button type="button" class="blueBtn L" onclick="fn_insert();">등록</button></a>
				</div>
				<!--페이징-->
				<div class="paging_place">
					<div class="paging_wrap">
						<comTag:paging totalCount="${roleGroupListCnt}" pageNo="${roleVO.pageIndex}" pageSize="${roleVO.pageSize}" clickPage="fn_search"/>
					</div>
				</div>
			</form:form>

			</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/bfceo/common/footer.jsp"%>

<form id="detailForm" method="post">
	<input type="hidden" name="athrId" id="athrId"/>
	<input type="hidden" name="pageIndex" id="pIndex"/>
	<input type="hidden" name="searchCondition" id="sCondition"/>
	<input type="hidden" name="searchKeyword" id="sKeyword"/>
</form>

<script type="text/javascript">
//검색, 페이지 이동
fn_search = function (_pageNo) {
	$("#pageIndex").val(_pageNo);
	$("#listForm").attr("action", "${basePath}/role/r/m/selectRoleGroupList.do").submit();
};

fn_insert = function () {
	$("#listForm").attr("action", "${basePath}/role/w/m/insertRoleGroup.do").submit();
};

fn_detail = function (_athrId) {
	$("#athrId").val(_athrId);
	$("#pIndex").val($("#pageIndex").val()); 			// form 이 두개 이기 때문에 id 값을 다르게 줬으나, 값은 같은 값이어야 하므로.
	$("#sCondition").val($("#searchCondition").val()); 	// form 이 두개 이기 때문에 id 값을 다르게 줬으나, 값은 같은 값이어야 하므로.
	$("#sKeyword").val($("#searchKeyword").val()); 		// form 이 두개 이기 때문에 id 값을 다르게 줬으나, 값은 같은 값이어야 하므로.
	$("#detailForm").attr("action", "${basePath}/role/r/m/selectRoleGroupDetail.do").submit();
};
</script>
</body>
</html>