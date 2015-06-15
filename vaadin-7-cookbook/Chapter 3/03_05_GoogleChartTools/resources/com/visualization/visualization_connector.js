window.com_visualization_LineGraph = function() {
	// var element = $(this.getElement());
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);

	this.onStateChange = function() {
		var data = this.getState().data;

	}
}

function drawChart() {
	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Topping');
	data.addColumn('number', 'Slices');
	data.addRows([ [ 'Mushrooms', 3 ], [ 'Onions', 1 ], [ 'Olives', 1 ],
			[ 'Zucchini', 1 ], [ 'Pepperoni', 2 ] ]);

	var options = {
		'title' : 'How Much Pizza I Ate Last Night',
		'width' : 400,
		'height' : 300
	};
	var element = document.getElementById('chart');
	var chart = new google.visualization.PieChart(element);
	chart.draw(data, options);
}