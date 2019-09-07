package com.beauate.ceo.admin.menu.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkageModuleController {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value = { "/linkage/analysisReq.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public String linkageCommit(HttpServletRequest request) {
		String pjtId = "";
		String pjtNm = "";
		String languages = "";
		String analysisId = "";
		String adminId = "";
		String reUrl = "";
		
		
		try {
			pjtId = URLDecoder.decode(request.getParameter("PJT_ID"), "utf-8");
			log.debug("pjtId : " + pjtId);
			
			pjtNm = URLDecoder.decode(request.getParameter("PJT_NM"), "utf-8");
			log.debug("pjtNm : " + pjtNm);
			
			languages = URLDecoder.decode(request.getParameter("LANGUAGE"), "utf-8");
			log.debug("languages : " + languages);

			adminId = URLDecoder.decode(request.getParameter("ADMIN_NAME"), "utf-8");
			log.debug("adminId : " + adminId);
			
			reUrl = URLDecoder.decode(request.getParameter("REURL_NAME"), "utf-8");
			log.debug("reUrl : " + reUrl);
			
			analysisId = "OK";
			
		} catch (UnsupportedEncodingException e) {
			return "ERROR : URL Decode Error!!";
		}
		return analysisId;
	}
}