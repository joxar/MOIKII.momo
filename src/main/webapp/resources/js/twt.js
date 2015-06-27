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
		
		//返信用linkにidを割り当てる
		$('.reply-link').attr("id",function(i){
			return 'reply-link-' + i;
		});
	
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
				
				var template = $("#tmplComment").text();
				var compiled = _.template(template);
				
				$('#board tbody > tr:eq(0)').before(compiled(message));
				
				//返信用linkにidを再割り当て
				$('.reply-link').attr("id",function(i){
					return 'reply-link-' + i;
				});
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				console.log("XMLHttpRequest : " + XMLHttpRequest.status);
	            console.log("textStatus : " + textStatus);
	            console.log("errorThrown : " + errorThrown);
            }
		});
	});
	
	//返信用リンクをクリックすると呼び出し
	$(document).on('click','.reply-link', function(){
		
		//クリックした返信用リンクのidを取得
		var clickLinkId = $(this).attr('id');
		//返信フォームを表示
		var template = $('#tmplReplyForm').html();
		var compiled = _.template(template);
		$(this).after(compiled());
		
		//返信フォームにidを割り振る
		$('*[name=replyForm]').attr("id",function(i){
			return 'replyForm-' + i;
		});
		
		//返信コメント投下ボタンにidを割り振る
		$('*[name=replyButton]').attr("id",function(i){
			return 'replyButton-' + i;
		});
		
		//返信フォームにidを割り振る
		$('*[name=replyContent]').attr("id",function(i){
			return 'replyContent-' + i;
		});
		
		//精製した返信メッセージのidを取得

		var replyButtonId = $(this).next().children().next().children().attr('id');
	
		console.log('replyButtonId:' + replyButtonId);
		
		//Linkをhide
		$(this).hide();
	    var clickButton = '#' +  replyButtonId;
	    
		//返信フォームのボタン押下で呼び出し
		$(document).on('click',clickButton,function() {	 

			var replyFormId = $(this).parent().parent().attr('id');
			console.log('replyFormId:' + replyFormId);
			var clickFormSelector = '#' + replyFormId;
			
			var replyContentId = $(this).parent().prev().attr('id');
			console.log('replyContentId:' + replyContentId);
			var replyContentSelector = '#' + replyContentId;
			
			 momo.momo.momo_contents = $(replyContentSelector).val();
			$(replyContentSelector).val('');

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
					$(clickFormSelector).before(compiled(message));
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
