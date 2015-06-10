$(function() {
	
	$('#postForm').submit(function(event) {
		//HTMLでの送信をキャンセル
		event.preventDefault();
		
		//momoオブジェクトのJSON
		 var momo ={ "momo": {
		        "phase": "",
		        "create_id": "",
		        "update_id": "",
		        "create_date": "",
		        "update_date": "",
		        "momoNum": "",
		        "stream_stream_num": "",
		        "momo_contents": "",
		        "updateId": "",
		        "user_master_member_id": "",
		        "createName": ""
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
				
				/**
				 * _.templateSettingsにてテンプレートの区切り文字を変更してます。
				 * デフォルトは<%%>なので、{{}}に変えてます。 
				 */
				_.templateSettings = {
				  interpolate : /\{\{(.+?)\}\}/g
				};
				
				//controllerから、コメントと投稿者と投稿時間を取得
				var contents = JSON.parse(JSON.stringify(callback.momo.momo_contents));
				var name = JSON.parse(JSON.stringify(callback.momo.createName));
				var time = JSON.parse(JSON.stringify(callback.momo.create_date));

				var message = {"contents" : contents,
								"name" : name,
								"time" : time};
				
				var template = $("#tmplString").text();
				var compiled = _.template(template);
				$('#board tbody > tr:eq(0)').before(compiled(message));
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				console.log("XMLHttpRequest : " + XMLHttpRequest.status);
	            console.log("textStatus : " + textStatus);
	            console.log("errorThrown : " + errorThrown);
            }
		});
	});
})
