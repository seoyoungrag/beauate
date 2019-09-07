<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/bfceo/common/include.jsp"%>
<form:form commandName="menuVO" id="detailForm" name="detailForm" method="post" action="${basePath}/menu/z/n/updateMenuProc.do">
	<form:hidden path="menuId"/>
	<form:hidden path="uprMenuId"/>
	<form:hidden path="menuLvl" />
	<!-- 정렬값 비교 때문에 이전값을 세팅해둠 -->
	<input type="hidden" name ="preMenuLup" value="${menuVO.menuLup }" />
	
	<h4 class="contentTitle_h4">메뉴상세정보</h4>
	<!--메뉴체계도-->
	<div class="menuBigTable">
		<p class="detailTitle">메뉴정보</p>
		<table class="menu_table">
			<caption></caption>
			<colgroup>
				<col width="148px">
				<col width="212px">
				<col width="148px">
				<col width="212px">
			</colgroup>
			<tbody class="line">
				<tr>
					<th class="bullet_orange">메뉴명</th>
					<td>
						<div class="commonSearch_wrap">
							<label class="blind" for=" ">d</label>
							<form:input path="menuName" id="menuName" name="menuName" cssStyle="width: 193px" cssClass="bdcolor" onfocus="checker(this, 30 , 'nbytes_menuName');" onblur="stopchecker();"/>
						</div>       
					</td>
					<th>메뉴구분</th>
					<td>
	              		<c:if test="${menuVO.menuDiv eq '1' }">일반</c:if>
                    	<c:if test="${menuVO.menuDiv eq '2' }">관리자</c:if>
	              	</td>
	              	<form:hidden path="menuDiv"/>
				</tr>
				<tr>
					<th>사용유무</th>
					<td>
						<form:select path="useYn" class="w50p">
                    		<form:option value="Y" label="사용"></form:option>
                    		<form:option value="N" label="미사용"></form:option>
                    	</form:select>
					</td>
					<th>정렬순서</th>
					<td>
						<form:select path="menuLup" class="w30p">
							<c:forEach begin="1" end="${uprMenuCnt}" step="1" varStatus="status">
								<form:option value="${status.index }">${status.index }</form:option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<th>메뉴설명</th>
					<td colspan="4">
						<div class="commonSearch_wrap">
							<label class="blind" for=""></label>
							<form:input path="menuDes" cssStyle="width: 553px" cssClass="bdcolor" onfocus="checker(this, 200 , 'nbytes_menuDes');" onblur="stopchecker();"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>타겟영역</th>
					<td colspan="4">
						<form:radiobutton path="pupYn" value="N"/><label for="radio01" class="mr15">메인영역(컨텐츠)</label>
                    		<form:radiobutton path="pupYn" value="Y"/><label for="radio02"> 창(팝업)</label>              
					</td>
				</tr>
				<tr id="popSet"  <c:if test="${menuVO.pupYn eq 'N' }">style="display: none;"</c:if>>
               		<th scope="row">팝업크기(가로)</th>
                    	<td ><form:input path="pupWidth" title="팝업크기(가로)" id="pupWidth" cssStyle="width:40%" cssClass="bdcolor"/>px</td>
                    	<th scope="row">팝업크기(세로)</th>
                    	<td ><form:input path="pupHeight" title="팝업크기(세로)" id="pupHeight" cssStyle="width:40%" cssClass="bdcolor"/>px</td>
                	</tr>
				<tr>
                		<th rowspan="2">대상연결</th>
                    	<td colspan="4"><input type="radio" name="ojDiv" id="url" value="url"/><label for="radio02">URL 입력</label>
                    		<div class="commonSearch_wrap align40_Left">
                    			<label class="blind" for=" ">d</label> 
							<form:input path="otUrl" id="otUrl" name="otUrl" style="width: 250px" disabled="true" onfocus="checker(this, 200 , 'nbytes_otUrl');" onblur="stopchecker();"/>                                            
						</div>      
                    	</td>
                	</tr>
                	<tr> 
                    	<td colspan="4">
                    		<input type="radio" name="ojDiv" id="pgm"  value="pgm" /><label for="radio01" class="mr15">프로그램 연결</label>
							<div class="commonSearch_wrap align3_Left">
								<form:hidden path="pgmId" id="pgmId"/>
								<label class="blind" for=" "></label> 
	                     		<form:input path="pgmName" id="pgmName" cssClass="bdcolor" cssStyle="width: 250px;" readonly="true" />
							</div>
							<button type="button" class="grayBtn M" onclick="javascript:fn_PgmRoleListPop('P');">검색</button>       
                    	</td>
                	</tr>
			</tbody>
		</table>
	</div>
	<div class="T_btnLayer fr">
		<a href="javascript:void(0);" onclick="javascript:fn_updateMenuProc();"><button type="button" class="blueBtn L">저장</button></a>
		<a href="javascript:void(0);" onclick="javascript:fn_loadContents('${menuVO.menuId}','${menuVO.menuLvl}');"><button type="button" class="blueBtn L">취소</button></a>
	</div>      
</form:form>
<script>
//수정
//url ,프로그램 연결 radio 버튼 체크 
fn_checkDiv = function(){
	
	var pgmId =  "${menuVO.pgmId}"; 
	var otUrl = "${menuVO.otUrl}"; 
	
	if(pgmId != ""){
		$("#pgm").attr("checked", true);
		$("#otUrl").val("http://");
	}else if(otUrl != ""){
		$("#url").attr("checked", true);
		$("#otUrl").attr('disabled',false);
	}else{
		$("#otUrl").val("http://");
	}
};

//메뉴 수정 저장
fn_updateMenuProc = function(){
	
	if(!$.trim($("#detailForm #menuName").val())) {
		alert("메뉴 명을 등록해주세요");
		$("#detailForm #menuName").focus();
		return;
	};
	
	// 팝업 값이 Y 면 크기 적어줘야함 , 크기 시 1024 768 자리 이하 ,  숫자로만
	if($("input[name='pupYn']:checked").val() == 'Y'){
		if(!$("#detailForm #pupWidth").batweenCheck(0,1024)){
			$("#detailForm #pupWidth").focus();
			return 
		};
		if(!$("#detailForm #pupHeight").batweenCheck(0,768)){
			$("#detailForm #pupHeight").focus();
			return 
		};
	};
	
	if(!confirm("저장 하시겠습니까?")){
		return;
	};
	
	$('#detailForm').submit();
};

//HTML 로딩후
$(document).ready(function(){
	//타켓영역 팝업 값 세팅
	$(document).on('click', 'input[name="pupYn"]' , function(){
		
		if($(this).val() == 'N'){
			$("#popSet").hide();
		}else{
			//기본값 세팅
			$("#popSet").show();
		}
	});
	
	//대상연결 초기 세팅
	fn_checkDiv();
	
	//대상연결 radio 버튼 설정시
	$(document).on('click', 'input[name="ojDiv"]' , function(){
		if($(this).is(':checked')){
			if($(this).val() == 'url'){
				$("#detailForm #otUrl").attr('disabled',false);
				$("#detailForm #pgmName").attr('disabled',true);
				$("#detailForm #pgmId").val(null);
				$("#detailForm #pgmName").val(null);
			}else{
				$("#detailForm #otUrl").attr('disabled',true);
				$("#detailForm #otUrl").val("http://");
				$("#detailForm #pgmName").attr('disabled',false);
			}
		};
	});
});

</script>