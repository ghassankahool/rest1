<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<sj:head  jquerytheme="eggplant"/>
<s:head />
</head>
<body>

 <h2>Default..</h2>
 <div id="div1">Div 1</div>
    <s:url id="ajaxTest" value="fee.html"/>
    <s:url id="ajaxTest1" value="fee1.html"/>

    <sj:a id="link1" href="%{ajaxTest}" targets="div1" effect="shake" 
		effectOptions="{ color : '#007700' }" 
		effectDuration="3000" >
      Update Content
    </sj:a>
    <sj:submit value="GOOO" buttonIcon="ui-icon-gear" button="true" openDialog="dlg1">Maria</sj:submit>
    <sj:dialog id="dlg1" href="%{ajaxTest1}" title="Hii" autoOpen="false" showEffect="slide" hideEffect="explode"></sj:dialog>
    
    
    <s:url id="orphanlist" value="../control/loop.html"></s:url>
    <sj:submit button="true" value="..." targets="div1" href="%{orphanlist}"></sj:submit>
    <br />
    <s:url var="jsonurl" action="jsonlanguages"/>
    <sj:autocompleter id="languages" list="%{languages}" />
    
    <sj:autocompleter id="languages2" list="%{languages}" />
    <br />
    <sj:autocompleter id="languages3" href="%{jsonurl}" ></sj:autocompleter>
</body>
</html>
