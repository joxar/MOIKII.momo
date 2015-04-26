$(function() {
	var textArea;
	
	$('#post').click(function() {
		textArea = $('#msg').val();
		$('#msg').val('');
		$('#board tbody > tr:eq(0)').before('<tr style="height:80"><td>' + textArea + '</td></tr>');
	});	
});