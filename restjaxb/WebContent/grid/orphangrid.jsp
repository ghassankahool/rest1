<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="dojo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true"  />
<s:head />

<script type="text/javascript"> 

$.subscribe('rowselect_sub', function(event,data) { 
       // var s; 
       // s = $("#configureSetTable").jqGrid('getGridParam','selarrrow'); 
       // alert('Selected Rows : '+event.originalEvent.id);
      //  alert('Selected Rows : 'zn\z\nz\nnxx bnx bn n  n nxbcgg+event.originalEvent.status);
       // $.ajax("ajax/fee.html",success);
        $.get(
        	    "../model/orphanbyid.html?id="+event.originalEvent.id
        	    ,
        	    function(data) { $("#orphandt").html(data); },
        	    "html"
        	);
        	 
        	
        //alert("here"); 
        //var grid = jQuery('#configureSetVersionsTable'); 
        //var sel_id = grid.jqGrid('getGridParam', 'selrow'); 
        //var myCellData = grid.jqGrid('getCell',sel_id,'configSetVersion'); 
        //alert(myCellData); 

}); 
</script> 
<meta http-equiv="Content-Type"
	content="text/html; charset=UTF-8">
<title>Orphan Grid</title>
</head>
<body>
	<br />
	<s:url var="remoteurl" action="jsontable" />
	<sjg:grid id="gridtable" caption="Orphans" dataType="json"
		href="%{remoteurl}" pager="true" gridModel="listorphan"
		rowList="10,15,20" rowNum="15" rownumbers="true" onSelectRowTopics="rowselect_sub" >
		<sjg:gridColumn  key="true" name="OId" index="id" title="ID" formatter="integer"
			sortable="false" />
		<sjg:gridColumn name="OName" index="name" title="Name" sortable="true" />
		<sjg:gridColumn name="dob" index="dob" title="Date of birthday"
			sortable="false" formatter="date" dataType="Date"/>
		<sjg:gridColumn name="OFatherName" index="farher" title="Father Name"
			sortable="false" />
		
		<sjg:gridColumn name="town.TName" index="town" title="Town"
			sortable="false" />

	</sjg:grid>
	
	

  <div id="orphandt"></div>
	

</body>
</html>