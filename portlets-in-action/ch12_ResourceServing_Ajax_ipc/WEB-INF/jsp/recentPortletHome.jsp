<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.*,chapter12.code.listing.utils.Constants, chapter12.code.listing.domain.*"%>

<portlet:defineObjects />
<portlet:resourceURL var="retrieveRecentBook" id="retrieveRecentBook" />

<script type="text/javascript">
	var resourceURL = "${retrieveRecentBook}";
	
	function <portlet:namespace/>getRecentBook() {
		jQuery.ajax({
			type : "GET",
			url : resourceURL,
			cache : false,
			success : function(data) {
				document.getElementById("<portlet:namespace/>recentBookDiv").innerHTML = data;
			}
		});
	}
	window.onload = <portlet:namespace/>getRecentBook();
</script>
<div id="<portlet:namespace/>recentBookDiv">
</div>