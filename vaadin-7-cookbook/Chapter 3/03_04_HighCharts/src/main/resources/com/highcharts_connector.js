window.com_Highcharts = function() {

	this.onStateChange = function() {
		var chart = new Highcharts.Chart(this.getState().data);
	}
}