$(function() {
	
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
	 
	    /**
		 * _.templateSettingsにてテンプレートの区切り文字を変更してます。
		 * デフォルトは<%%>なので、{{}}に変えてます。 
		 */
		_.templateSettings = {
		  interpolate : /\{\{(.+?)\}\}/g
		};
	
	//twt画面の投稿ボタンを押下した時に呼び出し
	$('#postForm').submit(function(event) {
		//HTMLでの送信をキャンセル
		event.preventDefault();
		 
		 momo.momo.momo_contents = $('#postContents').val();
		
		$('#postContents').val('');
		
		$.ajax({
			contentType: 'application/json; charset=UTF-8',
			type : 'POST',
			url : 'http://localhost:8080/app/twt/json',
			dataType : 'json',
			data : JSON.stringify(momo),
			success : function(callback) {
				
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
	
	//返信用リンクをクリックすると呼び出し
	$('.reply-link').one('click', function(){
		
		$('.reply-link').attr("id",function(i){
			return 'reply-link-' + i;
		});
		
		//クリックしたリンクのidを取得
		var linkId = $(this).attr('id');
		
		//返信フォームを表示
		var template = $('#tmplCommentBox').html();
	
		var compiled = _.template(template);
		$(this).after(compiled());
		
		$('.replyForm').attr("id",function(i){
			return 'replyForm-' + i;
		});
		
		$('.replyButton').attr("id",function(i){
			return 'replyButton-' + i;
		});
		
		//精製した返信メッセージのidを取得
		var replyFormId = $(this).closest('.replyForm').attr('id');
		var replyButtonId = $(this).closest('.replyButton').attr('id');
		$(this).hide();
		
		//返信フォームのボタン押下で呼び出し
		//↓
		$(document).on('click','#' + replyButtonId,function() {
			 
			 momo.momo.momo_contents = $('#replyContent').val();
			$('#replyContent').val('');
			
			$.ajax({
				contentType: 'application/json; charset=UTF-8',
				type : 'POST',
				url : 'http://localhost:8080/app/twt/reply',
				dataType : 'json',
				data : JSON.stringify(momo),
				success : function(callback) {
					
					//controllerから、コメントと投稿者と投稿時間を取得
					var contents = JSON.parse(JSON.stringify(callback.momo.momo_contents));
					var name = JSON.parse(JSON.stringify(callback.momo.createName));
					var time = JSON.parse(JSON.stringify(callback.momo.create_date));
	
					var message = {"contents" : contents,
									"name" : name,
									"time" : time};
					
					var template = $("#tmplReplyComment").html();
					
					var compiled = _.template(template);
					
					//$(this).parents('.replyForm').before(compiled(message));
					$('.replyForm').before(compiled(message));
				},
				error : function(XMLHttpRequest, textStatus, errorThrown){
					console.log("XMLHttpRequest : " + XMLHttpRequest.status);
		            console.log("textStatus : " + textStatus);
		            console.log("errorThrown : " + errorThrown);
	            }
			});
		});
	});
	
})
