<%@include file="include.jsp"%>

<portlet:defineObjects />

<div class="soria" id="<portlet:namespace/>myPortletContent">
		<div id="<portlet:namespace/>msg" style="background-color: lightblue; color: black;">
		</div>
		<div id="<portlet:namespace/>bookUpdateMsg" style="background-color: blue; color: white; display: none;">
		</div>
        <div dojoType="dijit.layout.BorderContainer" style="width: 700px; height: 300px" id="<portlet:namespace/>borderContainer">
            <div dojoType="dijit.layout.TabContainer" region="center" id="<portlet:namespace/>tabContainer">
                <div dojoType="dijit.layout.ContentPane" title="Catalog" id="<portlet:namespace/>catalogData">
                </div>
                <div dojoType="dijit.layout.ContentPane" title="Add Book" id="<portlet:namespace/>addBookData">
                </div>
        	</div>
        </div>
</div>

<script type="text/javascript">
	function <portlet:namespace/>showBookUpdateMsg() {
		document.getElementById("<portlet:namespace/>bookUpdateMsg").innerHTML = "Book Catalog data has been modified. <a style='color: white;' href='#' onclick='<portlet:namespace/>getBooks();'>Refresh</a>";
		jQuery("#<portlet:namespace/>bookUpdateMsg").fadeIn(2000, function() {
			jQuery("#<portlet:namespace/>bookUpdateMsg").fadeOut(10000, function() {
				document.getElementById("<portlet:namespace/>bookUpdateMsg").innerHTML = "";
				});
			});
	}
</script>

<script type='text/javascript'>
	dwr.engine.setNotifyServerOnPageUnload(true);
	dwr.engine.setActiveReverseAjax(true);
	MyAjaxBean.startBookUpdateThread('<portlet:namespace/>');

	function <portlet:namespace/>removeBook(removeBookUrl) {
		if(confirm("Are you sure that you want to remove the book?")) {
			  jQuery.ajax(
						{
							type: "POST",
							url: removeBookUrl,
							cache: false,
							success: function( data ) {
								jQuery( '#<portlet:namespace/>catalogData' ).html( data );
							}
						}
				);
		}
	}

	function <portlet:namespace/>uploadToCFile(fileInputFieldId, isbnNumber) {
		document.getElementById("<portlet:namespace/>imageId").setAttribute("style", "visibility : visible");
		var file = {
				fileName : dwr.util.getValue(fileInputFieldId).value,
				tocFile : dwr.util.getValue(fileInputFieldId)
		};
		MyAjaxBean.uploadToCFile(file, isbnNumber, function(message) {
			document.getElementById("<portlet:namespace/>imageId").setAttribute("style", "visibility : hidden");
			document.getElementById("<portlet:namespace/>msg").innerHTML = message.responseMessage;
		});
	}

	function <portlet:namespace/>addBook(titleFieldId, authorFieldId, isbnNumberFieldId, titleErrorFieldId, authorErrorFieldId, isbnNumberErrorFieldId) {
		document.getElementById("<portlet:namespace/>imageId").setAttribute("style", "visibility : visible");
		var book = {
				name : dwr.util.getValue(titleFieldId),
				author : dwr.util.getValue(authorFieldId),
				isbnNumber : dwr.util.getValue(isbnNumberFieldId)
		};

		MyAjaxBean.addBook(book, function(message) {
			document.getElementById("<portlet:namespace/>msg").innerHTML = message.responseMessage;
			if(message.statusCode == "1") {
				if(message.responseData.name != undefined) {
					document.getElementById(titleErrorFieldId).innerHTML = message.responseData.name;
				} else {
					document.getElementById(titleErrorFieldId).innerHTML = "";
				}
				if(message.responseData.author != undefined) {
					document.getElementById(authorErrorFieldId).innerHTML = message.responseData.author;
				} else {
					document.getElementById(authorErrorFieldId).innerHTML = "";
				}
				if(message.responseData.isbnNumber != undefined) {
					document.getElementById(isbnNumberErrorFieldId).innerHTML = message.responseData.isbnNumber;
				} else {
					document.getElementById(isbnNumberErrorFieldId).innerHTML = "";
				}
			}
			document.getElementById("<portlet:namespace/>imageId").setAttribute("style", "visibility : hidden");
			if(message.statusCode == "0") {
				<portlet:namespace/>showCatalogTab();
				<portlet:namespace/>getBooks();
				MyAjaxBean.getObserverPortlet(function(namespaceValue) {
				  var fnName = namespaceValue + "getRecentBook";
				  window[fnName]();
				});
			}
		});
	}
</script>

<script type='text/javascript'>
	function <portlet:namespace/>showUploadToCForm( resourceUrl ) {
		  jQuery.ajax(
					{
						type: "GET",
						url: resourceUrl,
						cache: false,
						success: function( data ) {
							jQuery( '#<portlet:namespace/>catalogData' ).html( data );
						}
					}
			);
	}
</script>

<script type="text/javascript">
    dojo.require("dojo.parser");
    dojo.addOnLoad(function(){
        dojo.parser.parse();
        dojo.addOnLoad(<portlet:namespace/>getBooks);
    });
    dojo.require("dijit.layout.BorderContainer");
    dojo.require("dijit.layout.TabContainer");
    dojo.require("dijit.layout.ContentPane");
</script>

<script type="text/javascript">
	function <portlet:namespace/>getBooks() {
		var xhrArgs = {
			url: '<portlet:resourceURL id="books"/>',
			handleAs: 'text',
			preventCache: true,
			load: function(data) {
				var catalogDataContainer = dojo.byId("<portlet:namespace/>catalogData");
				catalogDataContainer.innerHTML = data;
			},
			error: function(error) {
				var msgContainer = dojo.byId("<portlet:namespace/>msg");
				msgContainer.innerHTML = "Exception occurred while loading catalog data. Cause : " + error;
			}
		}
		dojo.xhrGet(xhrArgs);
	}
	
	function <portlet:namespace/>showAddBookTab() {
		var tabs = dijit.byId("<portlet:namespace/>tabContainer");
		tabs.selectChild("<portlet:namespace/>addBookData");
	}

	function <portlet:namespace/>showCatalogTab() {
		var tabs = dijit.byId("<portlet:namespace/>tabContainer");
		tabs.selectChild("<portlet:namespace/>catalogData");
	}
	
	function <portlet:namespace/>showAddBookForm() {
		var xhrArgs = {
				url: '<portlet:resourceURL id="showAddBookForm"/>',
				handleAs: 'text',
				preventCache: true,
				load: function(data) {
					var catalogDataContainer = dojo.byId("<portlet:namespace/>addBookData");
					catalogDataContainer.innerHTML = data;
				},
				error: function(error) {
					var msgContainer = dojo.byId("<portlet:namespace/>msg");
					msgContainer.innerHTML = "Exception occurred while loading add book form. Cause : " + error;
				}
			}
		dojo.xhrGet(xhrArgs);
	}
</script>
<script type="text/javascript">
	dojo.subscribe("<portlet:namespace/>tabContainer-selectChild", function(child) {
		document.getElementById("<portlet:namespace/>msg").innerHTML = "";
	    if(child.id == '<portlet:namespace/>addBookData') {
	    	<portlet:namespace/>showAddBookForm();
	    }
	});
</script>