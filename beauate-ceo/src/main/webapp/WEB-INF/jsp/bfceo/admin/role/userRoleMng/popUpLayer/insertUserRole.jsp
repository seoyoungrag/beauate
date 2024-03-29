<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/bfceo/common/include.jsp"%>

<p class="windowTitle">사용자 권한등록</p>
<span class="btn_close">
	<a href="javascript:void(0);" onclick="fn_PopClose();"><img src="${imagePath}/btn_close.gif" width="27" height="27" /></a>
</span>
<div class="w_potalMenu">
	<div class="w_menuWrapLeft">
		<h4 class="w_contentTitle_h4">등록할 수 있는 권한</h4>
		<div class="w_menuBigTable" id="targetDiv_L">
			<c:forEach items="${rslt.roleList}" var="list" varStatus="st">
				<p class="user_name" idx="${st.index}">
					<input type="radio" name="roleForUpdate" value="${list.athrNm} / ${list.athrCd}"/>&nbsp;
					<label id="label${st.index}"><c:out value="${list.athrNm} / ${list.athrCd}"/></label>
					<input type="hidden" id="listathrId${st.index}" value="${list.athrId}"/>
				</p>
			</c:forEach>
		</div>
	</div>
	<div class="add_minus">
		<ul><li><a href="javascript:void(0);" onclick="fn_addRole();"></a></li></ul>
	</div>
	<div class="w_menuWrapRight">
		<div class="user_info">
			<h4 class="h4_other">현재 권한</h4>
			<!--메뉴체계도-->
			<div class="w_menuBigTable" id="targetDiv_R">
				<p class="user_name" >
					<label id="pLabel"><c:out value="${rslt.tempRole.athrNm} / ${rslt.tempRole.athrCd}"/></label>
				</p>
				<input type="hidden" value="${rslt.tempRole.athrId}" id="tempRoleId"/>
			</div>
		</div>
	</div>
</div>

<div class="T_btnLayer fr">
	<a href="javascript:void(0);"><button type="button" class="blueBtn L" onclick="fn_updateRoleProc();">저장</button></a>
	<a href="javascript:void(0);"><button type="button" class="blueBtn L" onclick="fn_PopClose();">취소</button></a>
</div>

<form id="updateForm" method="post">
	<input type="hidden" name="userId" value="${rslt.tempRole.userId}">
	<input type="hidden" name="athrId" id="formathrId">
</form>

<script type="text/javascript">
var _clickCount = 0;

/* 선택 된 사용자 추가 */
fn_addRole = function() {
	var _updateRole = $("input[name=roleForUpdate]:checked");
	var _athrId = $("input[name=roleForUpdate]:checked").siblings("input").val();
	
	if (_athrId != undefined) {
		var _val = $(_updateRole).val();
		var _idx = $(_updateRole).parent().attr("idx");
		var _tempathrId = $("#tempRoleId").val();
		var _pLabelText = $("#pLabel").text();
		
		// 우측 목록을 선택 한 값으로 변경
		$("#pLabel").text(_val);
		$("#tempRoleId").val(_athrId);
		
		// 좌측 목록의 내용을 변경
		$("#label" + _idx).text(_pLabelText);
		$("#listathrId" + _idx).val(_tempathrId);
		$(_updateRole).val(_pLabelText);

		$("input[name=roleForUpdate]").prop("checked", false);
		_clickCount++;
	}
};

/* 변경 된 정보 저장 처리 */
fn_updateRoleProc = function () {
	var _athrId = $("#tempRoleId").val();
	var _url = "${basePath}/userrole/z/n/saveUserRoleProc.do";
	
	if (confirm("권한을 변경 하시겠습니까?")) {
		if (_clickCount == 0) {
			alert("변경 된 사항이 없습니다.");
			return false;
		}
		$("#formathrId").val(_athrId);
		$("#updateForm").attr("action", _url).submit();
	}
};
</script>
