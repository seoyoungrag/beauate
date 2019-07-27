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
	<div class="wrap">
		<div class="container">
			<div class="sub_leftMenu">
				<%@ include file="/WEB-INF/jsp/bfceo/common/leftMenu.jsp" %>
			</div>
			<div class="contents">
				<p class="contentTitle">사용자 관리</p>
				<p class="sub_path">
					<img src="${imagePath }/ico_home.png" width="10" height="9" />&nbsp;〉&nbsp;사용자관리&nbsp;〉&nbsp;사용자관리
				</p>
				<form:form modelAttribute="userVO" id="userVO" name="listForm" method="post" action="${basePath}/usermgr/z/m/selectUserList.do">
					<form:hidden path="pageIndex" id="pageIndex" />
					<form:hidden path="sortSubject" id="sortSubject"/>
					<form:hidden path="sortDescend" id="sortDescend"/>
					<div class="selectBox">
						<form:select path="searchCondition" class="w13p">
							<form:option value="user_nm">이름</form:option>
							<form:option value="email_addr">메일</form:option>
						</form:select> 
						<form:input type="text" class="searchName" path="searchKeyword"/>
						<button type="button" class="grayBtn ico" onclick="javascript:fn_searchList(1);">
							<img src="${imagePath }/ico_search.png"> 검색
						</button>
						<button type="button" class="grayBtn02 ico" onclick="javascript:fn_searchInit();">초기화</button>
					</div>
				</form:form>
				<div class="tableLayer">
					<table class="tableList">
						<caption></caption>
						<colgroup>
							<col width="5%">
							<col width="10%">
							<col width="15%">
							<col width="*">
							<col width="20%">
						</colgroup>
						<thead>
							<th class="noBg">번호</th>
							<th>사용자일련번호
								<span class="arrow_ascending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'user_id')"></a></span>
								<span class="arrow_descending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'user_id')"></a></span>
							</th>
							<th>성명
								<span class="arrow_ascending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'user_nm')"></a></span>
								<span class="arrow_descending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'user_nm')"></a></span>
							</th>
							<th>메일
								<span class="arrow_ascending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'email_addr')"></a></span> 
								<span class="arrow_descending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'email_addr')"></a></span>
							</th>
							<th>가입일자 
								<span class="arrow_ascending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'join_dt')"></a></span> 
								<span class="arrow_descending"><a href="javascript:void(0);" onclick="javascript:fn_sort(this, 'join_dt')"></a></span>
							</th>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${fn:length(userList) != 0}">
									<c:forEach items="${userList}" var="list" varStatus="i">
										<tr class="row">
											<td><c:out value="${userVO.firstIndex + i.count}"/></td>
											<td><c:out value="${list.user_id}"/></td>
											<td><c:out value="${list.user_nm}"/></td>
											<td><a href="${basePath}/usermgr/z/m/selectUserDetail.do?user_id=<c:out value='${list.user_id}'/>"><c:out value="${list.email_addr}"/></a></td>
											<td><fmt:formatDate value="${list.join_dt}" pattern="yyyy-MM-dd"/></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<td  colspan="4">데이터가 없습니다.</td>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<div class="T_btnLayer fr">
						<a href="${basePath}/usermgr/z/m/insertUser.do"><button type="button" class="blueBtn L">등록</button></a>
					</div>
				</div>
				<!--페이징-->
				<div class="paging_place">
					<div class="paging_wrap">
						<comTag:paging totalCount="${userListCnt}" pageNo="${userVO.pageIndex}" pageSize="${userVO.pageSize}" clickPage="fn_searchList"/>
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
//검색, 페이지 이동
var fn_searchList = function(pageNo){
	var forms = document.listForm;
	forms.pageIndex.value = pageNo;
	forms.submit();
};

//정렬
var fn_sort = function(obj, target){
	var frm = document.listForm;
	var descend = ( $(obj.parentNode).hasClass("arrow_ascending") ) ?  "asc" : "desc";

	frm.sortDescend.value = descend;
	frm.sortSubject.value = target;
	frm.submit();
};

//초기화
var fn_searchInit = function() {
	var frm = document.listForm;
	frm.searchKeyword.value = null;
	frm.searchCondition.value = null;
	frm.sortDescend.value = null;
	frm.sortSubject.value = null;
	frm.pageIndex.value = 1;
	frm.submit();
};
</script>
</body>
</html>