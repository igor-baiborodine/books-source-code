com_packtpub_vaadin_close_GoodbyeWorld = function() {
	window.onbeforeunload = function() {		
		return ('Goodbye, world!');
	};	
};