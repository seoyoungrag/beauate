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
				<form:form modelAttribute="programVO" id="listForm" name="listForm" method="post" action="${basePath}/program/z/m/selectProgramList.do">
					<form:hidden path="prgr_id"/>
					<form:hidden path="sortSubject"/>
					<form:hidden path="sortDescend"/>
					<form:hidden path="pageIndex"/>
					<div class="selectBox">
						<form:select path="searchCondition" class="w13p">
							<form:option value="prgr_nm" label="프로그램명"></form:option>
							<form:option value="prgr_vriabl" label="변수명"></form:option>
						</form:select>
						<form:input path="searchKeyword" onkeydown="if(event.keyCode==13){javascript:fn_searchList(1);}" class="searchName" style="width: 733px;"></form:input>
						<button type="button" class="grayBtn ico" onclick="javascript:fn_searchList(1);"><img src="${imagePath }/ico_search.png"> 검색</button>
					</div>
				</form:form>
				<div class="tableLayer">
					<table class="tableList">
						<caption></caption>
						<colgroup>
							<col width="18%">
							<col width="18%">
							<col width="18%">
							<col width="46%">
						</colgroup>
						<thead>
							<th sortId="prgr_id" class="noBg">프로그램_일련번호
								<span class="arrow_descending"><a  onclick="javascript:fn_sort(this.parentNode);"></a></span>
								<span class="arrow_ascending"><a  onclick="javascript:fn_sort(this.parentNode);"></a></span>
							</th>
							<th sortId="prgr_nm">프로그램명
								<span class="arrow_descending"><a  onclick="javascript:fn_sort(this.parentNode);"></a></span>
								<span class="arrow_ascending"><a  onclick="javascript:fn_sort(this.parentNode);"></a></span>				
							</th>
							<th sortId="prgr_vriabl">변수명
								<span class="arrow_descending"><a  onclick="javascript:fn_sort(this.parentNode);"></a></span>
								<span class="arrow_ascending"><a  onclick="javascript:fn_sort(this.parentNode);"></a></span>		
							</th>
							<th>프로그램 대표 URL</th>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${fn:length(programList) != 0}">
									<c:forEach items="${programList}" var="list" varStatus="i">
										<tr class="row" style="cursor: pointer;" onclick="fn_programDetail('${list.prgr_id}');">
											<td title="<c:out value='${list.prgr_id}'/>">
												<c:out value="${list.prgr_id}"/>
											</td>
											<td>
												<div title='<c:out value="${list.prgr_nm }"/>'>
													<c:out value="${list.prgr_nm}"></c:out>
												</div>
											</td>
											<td>
												<div title='<c:out value="${list.prgr_vriabl }"/>'>
													<c:out value="${list.prgr_vriabl}"></c:out>
												</div>
											</td>
											<td style="text-align: left;">
												<div title='<c:out value="${list.prgr_url }"/>'>
													<c:out value="${list.prgr_url}"></c:out>
												</div>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<td  colspan="4">데이터가 없습니다.</td>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				<div class="T_btnLayer fr">
					<a href="${basePath}/program/z/m/insertProgram.do"><button type="button" class="blueBtn L">등록</button></a>
				</div>
				<!--페이징-->
				<div class="paging_place">
					<div class="paging_wrap">
						<comTag:paging totalCount="${programListCnt}" pageNo="${programVO.pageIndex}" pageSize="${programVO.pageSize}" clickPage="fn_searchList"/>
					</div>
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
	//정렬
	var fn_sort = function(obj) {
		var frm = document.listForm;
		frm.sortDescend.value = obj.className == "arrow_ascending" ? "asc" : "desc";
		frm.sortSubject.value = obj.parentNode.getAttributeNode("sortId").value;
		frm.submit();
	};

	//프로그램 상세정보
	var fn_programDetail = function(prgr_id) {
		var frm = document.listForm;
		frm.prgr_id.value = prgr_id;
		frm.action = "<c:url value='${basePath}/program/z/m/selectProgramDetail.do'/>";
		frm.submit();
	};
	
	//검색, 페이지 이동
	var fn_searchList = function(pageNo){
		var frm = document.listForm;
		frm.pageIndex.value = pageNo;
		frm.submit();
	};
	</script>
</body>
</html>
