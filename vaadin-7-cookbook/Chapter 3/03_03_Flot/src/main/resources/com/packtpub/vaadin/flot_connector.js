window.com_packtpub_vaadin_FlotChart = function() {
    var element = $(this.getElement());
    
    this.onStateChange = function() {
        var state = this.getState();
        var options = state.options;
        var data = state.data;
        $.plot(element, data, options);
    }
}