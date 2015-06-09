$(function() {
	
	$('#postForm').submit(function(event) {
		//HTMLでの送信をキャンセル
		event.preventDefault();
		
		//momoオブジェクトのJSON
		 var momo ={ "momo": {
		        "phase": "",
		        "create_id": "",
		        "update_id": "",
		        "update_date": "",
		        "momoNum": "",
		        "stream_stream_num": "",
		        "momo_contents": "",
		        "updateId": "",
		        "user_master_member_id": ""
		    }};
		 
		 momo.momo.momo_contents = $('#postContents').val();
		
		$('#postContents').val('');
		
		$.ajax({
			contentType: 'application/json; charset=UTF-8',
			type : 'POST',
			url : 'http://localhost:8080/app/twt/json',
			dataType : 'json',
			data : JSON.stringify(momo),
			success : function(callback) {
				var contents = JSON.parse(JSON.stringify(callback.momo.momo_contents));
				var message = {"contents" : "<" + contents + ">"};
				var template = $("#tmplString").text();
				var compiled = _.template(template);
				$('#board tbody > tr:eq(0)').before(compiled());
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				console.log("XMLHttpRequest : " + XMLHttpRequest.status);
	            console.log("textStatus : " + textStatus);
	            console.log("errorThrown : " + errorThrown);
            }
		});
	});
})
