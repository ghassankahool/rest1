<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
    <%@ taglib prefix="s"  uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head ajaxhistory="true" jquerytheme="overcast" jqueryui="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Orphan List</title>
</head>
<body>
<table>
<sj:textfield ></sj:textfield>
<sj:datepicker name="xs" changeMonth="true" changeYear="true"  ></sj:datepicker>
<sj:menu cssStyle="width:50%" list="orphanlist" listKey="OId" listValue="OName">
  <sj:menuItem title="Main"  ></sj:menuItem>
  <sj:menuItem title="Test" ></sj:menuItem>
  <sj:menuItem title="About" ></sj:menuItem>
</sj:menu>
 <s:iterator value="orphanlist" var="ob" status="gstat">
 <s:if test="#gstat.even == true"> <tr></s:if>
 <s:else>
  <tr style="background: #CCCCCC">
 </s:else>
  
     <td><s:property value="#ob.OId"/></td>
     <td><s:property value="#ob.OName"/></td>
     <td><s:property value="#ob.Dob"/></td>
     <td><s:property value="#ob.Documming"/></td>
     <td><s:property value="#ob.Education"/></td>
     <td><s:property value="#ob.BrokerName"/></td>
   </tr>
 </s:iterator>

 </table>
</body>
</html>