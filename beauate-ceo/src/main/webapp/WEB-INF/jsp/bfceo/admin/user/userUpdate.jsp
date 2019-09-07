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
<script type="text/javascript" src="${scriptPath}/common.js"></script>
<script type="text/javascript" src="${scriptPath}/validation/validation.js"></script>
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
				<form:form modelAttribute="userVO" name="userVO" id="userVO" method="post" action="${basePath}/usermgr/z/n/updateUserProc.do" onsubmit="return false;">
					<form:hidden path="userId" id="userId"/>
					<form:hidden path="emailAddr" id="emailAddr"/>
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
									<th>사용자 일련번호</th>
									<td><c:out value="${userVO.userId}"/></td>
									<th>E-mail</th>
									<td><c:out value="${userVO.emailAddr}"/></td>
								</tr>
								<tr>
									<th class="bullet_orange">이름</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="userNm" onfocus="checker(this, 100 , 'nbytes_usrNm');" onblur="stopchecker();" style="width: 320px;" type="text" placeholder="${userVO.userNm}"/>
										</div>
									</td>
									<th class="bullet_orange">패스워드</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:password path="userPw" id="userPw" readonly="true" onfocus="checker(this, 20 , 'nbytes_usrPw');" onblur="stopchecker();" autocomplete="off" style="width: 180px;"/> &nbsp; 
											<label class="blind" for=""></label>
											<input type="checkbox" value="" id="pwChange"></input> 체크시 패스워드 변경
										</div>
									</td>
									
								</tr>
								<tr>
									<th class="bullet_orange">가입일</th>
									<td><fmt:formatDate value="${userVO.joinDt}" pattern="yyyy-MM-dd"/></td>
									<th>패스워드 확인</th>
									<td>
										<div class="commonSearch_wrap">
											<input type="password" id="userPw_confirm" readonly="true" onfocus="checker(this, 20 , 'nbytes_usrPw');" onblur="stopchecker();" autocomplete="off" style="width: 180px;"/> &nbsp; 
											<label class="blind" for=""></label>
											<span id="pwd_check_false" style="color:red; display: none">패스워드가 다릅니다</span>
											<span id="pwd_check_true" style="color:blue; display: none">패스워드가 일치합니다</span>
										</div>
									</td>
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
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="userEngNm" id="userEngNm" style="width: 320px;" onfocus="checker(this, 100 , 'nbytes_userNm');" onblur="stopchecker();" />
										</div>
									</td>
									<th>전화번호</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="pno" id="pno" style="width: 320px;" onfocus="checker(this, 15 , 'nbytes_pno');" onblur="stopchecker();" />
										</div>
									</td>
								</tr>
								<tr>
									<th>우편번호</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label> 
											<form:input path="zipNo" id="zipNo" style="width: 80px;" readonly="true" onfocus="this.blur();"/>
											<div class="T_btnLayer fr">
												<a href="javascript:void(0);" onclick="fn_jusoPopup();"><button type="button" class="blueBtn L">주소찾기</button></a>
											</div>
										</div>
									</td>
									<th>휴대폰</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="mblPno" id="mblPno" style="width: 320px;" onfocus="checker(this, 15 , 'nbytes_mblPno');" onblur="stopchecker();" />
										</div>
									</td>
								</tr>
								<tr>
									<th>주소</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="addr" id="addr" style="width: 320px;" readonly="true" onfocus="this.blur();"/>
										</div>
									</td>
									<th>FAX</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<form:input path="faxNo" id="faxNo" style="width: 320px;" onfocus="checker(this, 15 , 'nbytes_faxNo');" onblur="stopchecker();" />
										</div>
									</td>
								</tr>
								<tr>
									<th>상세주소</th>
									<td>
										<div class="commonSearch_wrap">
											<label class="blind" for=" ">d</label>
											<input type="text" id="addr_detail" style="width: 320px;" readonly onfocus="this.blur();"/>
										</div>
									</td>
									<th>수정일시</th>
									<td><c:if test="${empty userVO.modDt}">-</c:if><fmt:formatDate value="${userVO.modDt}" pattern="yyyy-MM-dd"/></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
				<div class="T_btnLayer fr">
					<a href="javascript:void(0);" onclick="javascript:fn_updateUserProc();"><button type="button" class="blueBtn L">수정</button></a>
					<a href="${basePath}/usermgr/z/m/selectUserDetail.do?userId=${userVO.userId}"><button type="button" class="blueBtn L">취소</button></a>
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
		//수정
		var fn_updateUserProc = function(){
			var userPw = $("#userVO #userPw").val();
			var userPw_confirm = $("#userVO #userPw_confirm").val();
			if(!$.trim($("#userVO #userNm").val())) {
				alert("이름을 입력해 주세요");	
				$("#userVO #userNm").focus();
				return;
			}
			if($("#pwChange").is(':checked')){
				$("#pwChangeGubun").val("Y");
				if(!$.trim(userPw)) {
					alert("패스워드 변경을 체크하셨습니다. \n패스워드를 입력해 주세요");	
					$("#userVO #userPw").focus();
					return;
				}
				if(!$.trim(userPw_confirm)) {
					alert("패스워드 변경을 체크하셨습니다. \n패스워드 확인을 입력해 주세요");	
					$("#userVO #userPw_confirm").focus();
					return;
				}
				//비밀번호 9~20자의 영문, 특수문자 1자(%,$,#,@,!) 세가지 조합
				if(!fn_checkPass("userPw")) {
					return;
				}
				if(userPw != userPw_confirm) {
					alert("패스워드를 확인해주세요");
					$("#userVO #userPw").focus();
					return;
				}
			}else{
				$("#pwChangeGubun").val("N");
			}
			
			if($("#userVO #addr").val() !== "undefined" || $("#userVO #addr").val() !== null || $("#userVO #addr").val() !== "") {
				document.userVO.addr.value = $("#addr").val() + $("#addr_detail").val();
			}
			
			if (!confirm("수정 하시겠습니까?")) {
				return;
			}
			$("#userId").val('${userVO.userId}');
			$("#emailAddr").val('${userVO.emailAddr}');
			document.userVO.submit();
		};
		
		
		$(function() {
			//패스워드 변경 클릭시
			$("#pwChange").click(function() {
				$("#userPw").val("");
				$("#userPw_confirm").val("");
				if ($("#pwChange").is(':checked')) {
					$("#userPw").attr('readonly', false);
					$("#userPw_confirm").attr('readonly', false);
				} else {
					$("#userPw").attr('readonly', true);
					$("#userPw_confirm").attr('readonly', true);
				}
			});
		});
		
		//패스워드 비교
		$("#userPw").keyup(function() {
			var pwd1=$("#userPw").val();
			var pwd2=$("#userPw_confirm").val();
			if(pwd1.length != 0 || pwd2.length != 0){
				if(pwd1 == pwd2){
					$("#pwd_check_false").css("display","none");
					$("#pwd_check_true").css("display","");
				}else{
					$("#pwd_check_false").css("display","");
					$("#pwd_check_true").css("display","none");
				}	
			}
		});
		$("#userPw_confirm").keyup(function() {
			var pwd1=$("#userPw").val();
			var pwd2=$("#userPw_confirm").val();
			if(pwd1.length != 0 || pwd2.length != 0){
				if(pwd1 == pwd2){
					$("#pwd_check_false").css("display","none");
					$("#pwd_check_true").css("display","");
				}else{
					$("#pwd_check_false").css("display","");
					$("#pwd_check_true").css("display","none");
				}	
			}
		});
		
		//주소찾기 팝업 도로명API
		var fn_jusoPopup = function() {
			var pop = window.open("/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");
		}
		function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
			// 2017년 2월 제공항목이 추가되었습니다. 원하시는 항목을 추가하여 사용하시면 됩니다.
// 			document.userVO.addr.value = roadFullAddr;
			document.userVO.addr.value = roadAddrPart1;
// 			document.form.roadAddrPart2.value = roadAddrPart2;
// 			document.userVO.addr_detail.value = addrDetail;
			$("#addr_detail").val(addrDetail);
			document.userVO.zipNo.value = zipNo;
		}
	</script>
</body>
</html>
