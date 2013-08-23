<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<style type="text/css">
.welcome {
	background-color: #DDFFDD;
	border: 1px solid #009900;
	width: 200px;
}

.welcome li {
	list-style: none;
}
</style>
</head>
<body>
	<h1>Struts 2 Struts 2 ActionError &amp; ActionMessage Example</h1>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>

	<h4>

		<s:property value="getText('welcome.hello')" />
		:
		<s:property value="username" />

	</h4>

</body>
</html>