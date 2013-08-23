<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
    <%@ taglib prefix="txt" uri="/struts-jquery-richtext-tags" %>
    <%@ taglib prefix="simg" uri="/struts-images" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orphan By ID</title>
</head>
<body>
  <s:form action="../model/saveorphan.html">
   <s:url action="orphanimageid" var="imgid"  >
    <s:param name="id"><%= request.getParameter("id") %></s:param>
   </s:url>
   
   <s:textfield name="orphan.OId" label="ID" readonly="true"></s:textfield>
   <s:textfield name="orphan.OName" label="Name" ></s:textfield>
   <s:textfield name="orphan.OFatherName" label="Father" ></s:textfield>
   <sj:datepicker  id="d1" name="orphan.DateofFD" label="Father Die"  ></sj:datepicker>
   <sj:datepicker id="d2" name="orphan.Dob" label="DOB" ></sj:datepicker>
   <s:select list="sectors" name="sec_id" label="Sector" listKey="SecId" listValue="SecName" ></s:select>
   <s:select list="towns" name="town_id" label="Town" listKey="TId" listValue="TName"></s:select>
   <s:a href="%{imgid}">
   <simg:image src="%{imgid}" id="qq" alt="Ghassan" height="50" width="50"/></s:a>
   <s:textfield name="orphan.OMotherName" label="Mother"></s:textfield>
   <s:textfield name="orphan.BrokerName" label="Broker"></s:textfield>
   <s:textfield name="orphan.BrokerContact" label="Broker Concat" size="60"></s:textfield>
   <sj:datepicker id="d3" name="orphan.Docomming" label="Comming Date" ></sj:datepicker>
   <s:radio     label="Gender" list="genders" listKey="Id" listValue="Name" name="orphan.Gender" ></s:radio>
   <txt:ckeditor id="edutxt" name="orphan.Education" label="Education"  ></txt:ckeditor>
   <sj:submit value="Save" ></sj:submit>
  </s:form>
</body>
</html>