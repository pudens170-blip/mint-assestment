$('document').ready(function() {
	$('#searchCardInfoButton').click(function(e) {
		e.preventDefault();
		var bin = $('#bin').val();
		searchBIN(bin);

	})
});

function searchBIN(bin) {
	$('#searchCardInfoButton').html('Searching...');
	$('#searchCardInfoButton').attr('disabled', 'true')
	var url = "/card-scheme/verify/" + bin;
	$.ajax({
		url : url,
		method : 'GET',
		dataType : 'json',

		success : function(data) {
			$('#bin_table tr').first().after('');
			console.log(data);
			$('#searchCardInfoButton').html('Search');
			$('#searchCardInfoButton').removeAttr('disabled');
			var html = '<tr>' + '<td>' + bin + '</td>' + '<td>' + data.payload.scheme
					+ '</td>' + '<td>' + data.payload.type + '</td>' +'<td>' + data.payload.bank + '</td>' + '</tr>';
			$('#bin_table tr').first().after(html);
		},
		error : function(data) {
			$('#searchCardInfoButton').html('Search');
			$('#searchCardInfoButton').removeAttr('Search');

		}
	});
};