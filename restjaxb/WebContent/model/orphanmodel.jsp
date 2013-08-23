<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
 Orphan Name12:<b> <s:property value="orphan.OName"/> </b>
 <br />
 <s:textfield label="ORPHAN NAME" name="orphan.OName"> </s:textfield>
 <s:property value="%{orphan.OName}"/>
 <s:radio list="citys" listValue="CName" listTitle="CName" name="mycity" label="City" listKey="CId"></s:radio>
 <br />
 
 <s:combobox list="citys" label="City" listKey="CId" listValue="CName" name="oldcity" emptyOption="true" ></s:combobox>
 <br />
 <s:select list="citys" label="MYCity" listKey="CId" listValue="CName" headerKey="-1" headerValue="Select City" ></s:select>
</body>
</html>