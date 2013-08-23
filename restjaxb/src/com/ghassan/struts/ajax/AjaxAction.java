package com.ghassan.struts.ajax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSONParameter;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/ajax")
@ResultPath("/")
@ParentPackage("json-default")
public class AjaxAction extends ActionSupport {

	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(AjaxAction.class);
	private static final long serialVersionUID = 1L;

	private static String[] staticLanguages = { "Actionscript (Flash)",
			"ABAP Objects", "Ada", "Aleph", "AppleScript", "Beta", "BlitzMax",
			"Boo", "C++", "C#", "Cecil", "Clarion", "Cobol ISO 2002",
			"CoDeSys", "CFML (ColdFusion Markup Language)",
			"Common Lisp Object System (CLOS)", "Component Pascal",
			"CorbaScript", "D", "Delphi", "Eiffel", "Fpii",
			"Fortran - ab Fortran 2003", "Gambas", "IDL", "IDLscript",
			"incr Tcl", "Java", "JavaScript / ECMAScript", "Lexico", "Lingo",
			"Modula-3", "Modelica", "NewtonScript", "Oberon", "Objective-C",
			"Objective CAML", "Object Pascal", "Perl", "PHP", "PowerBuilder",
			"Progress OpenEdge", "Python", "Ruby", "R", "Sather", "Scala",
			"Seed7", "Self", "Simula", "Smalltalk", "SuperCollider",
			"Superx++", "STOOOP", "Visual Basic", "Visual Basic .NET (VB.NET)",
			"Visual Basic Script", "Visual Objects", "XBase", "XOTcl", "Zonnon" };

	private String term;
	
	
	private String[] languages = AjaxAction.staticLanguages;

	@Action(value = "fee", results = { @Result(name = "success", location = "ok.jsp") })
	public String fee() {
		return SUCCESS;
	}

	@Action(value = "fee1", results = { @Result(name = "success", location = "ok1.jsp") })
	public String fee1() {
		logger.info("ghassan");
		return SUCCESS;
	}

	
	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	@Action(value = "aa", results = { @Result(name = "success", location = "default.jsp") })
	public String default1() {
		return SUCCESS;
	}

	@Actions({
			@Action(value = "autocompleter-select", results = { @Result(location = "autocompleter-select.jsp", name = "success") }),
			@Action(value = "autocompleter"),
			@Action(value = "jsonlanguages", results = { @Result(type = "json", name = "success",params = {
	                "root",
	                "languages"}) }) })
	public String execute11() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		String a1 = req.getParameter("languages");
		logger.info("a1=" + a1);
		logger.info("trem is" + getTerm());
		String a2 = req.getParameter("languages2");
		logger.info("a2=" + a1);

		if (term != null && term.length() >= 1) {
			ArrayList<String> tmp = new ArrayList<String>();
			for (int i = 0; i < staticLanguages.length; i++) {
				if (StringUtils.startsWith(staticLanguages[i].toLowerCase(),
						term.toLowerCase())) {
					tmp.add(staticLanguages[i]);
				}
			}
			logger.info("temp list size is :="+tmp.size());
			languages = tmp.toArray(new String[tmp.size()]);
		}
		return SUCCESS;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}
