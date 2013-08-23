<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="windows-1256"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.errors li {
	list-style: none;
}
</style>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Struts 2 ActionError &amp; ActionMessage Example</h1>
 
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
 
<s:form action="Welcome2">
	<s:textfield key="global.username" name="username"/>
	<s:password key="global.password" name="password"/>
	<s:submit key="global.submit" name="submit"/>
</s:form>
</body>
</html>