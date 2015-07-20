$(function() {
	
	var index,tmpId,count;
	
	//現在のURLを取得し、変数にセット。Ajaxに使用する
	var href = $(location).attr('href');
	var postUrl = href + '/post';
	var replyUrl = href + '/reply';
	
	//momoオブジェクトのJSON
	 var momo ={ "momo": {
		    "momoNum": "",
	        "stream_stream_num": "",
	        "phase": "",
	        "momo_contents": "",
	        "create_id": "",
	        "create_date": "",
	        "update_id": "",
	        "update_date": "",
	        "user_master_member_id": "",
	        "createName": ""
	    }};
	 
	 //ReturnCommentのJSON
	 var returnComment ={ "returnComment": {
	        "id": "",
	        "momo_momo_num": "",
	        "child_num": "",
	        "phase": "",
	        "return_contents": "",
	        "create_id": "",
	        "create_date": "",
	        "update_id": "",
	        "update_date": "",
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
	    
		//クリックしたsideMenuの項目をactiveにする。
		var url_parts = location.href.split('/');
		var last_segment = url_parts[url_parts.length-1];
		 $('ul.nav.nav-pills.nav-stacked > li > a[href*="'+ last_segment +'"]').parents('li').addClass('active');
		
		//返信用linkに対して降順にidを割り振る
		$('.reply-link').attr("id",function(i){
			index = $('.reply-link').size() - 1;
			index -= i;
			return 'reply-link-' + index;
		});
		
		//momoに対して降順にidを割り振る
		$('.momoComment').attr("id",function(i){
			index = $('.momoComment').size() - 1;
			index -= i;
			return 'momoComment-' + index;
		});
		
		//返信フォームにidを割り振る（先に追加されたフォームから)
		count = $('*[name=replyForm]').size();
		$('*[name=replyForm]').each(function(index, element) {
			tmpId = $(element).attr('id');
			if(typeof tmpId === 'undefined') {
				count--;
				$(element).attr('id','replyForm-' + count);
				tmpId = $(element).attr('id');
			}
		});
		
		//返信コメント投下ボタンにidを割り振る
		count = $('*[name=replyButton]').size();
		$('*[name=replyButton]').each(function(index, element) {
			tmpId = $(element).attr('id');
			if(typeof tmpId === 'undefined') {
				count--;
				$(element).attr('id','replyButton-' + count);
			}
		});
		
		//返信フォームにidを割り振る
		count = $('*[name=replyContent]').size();
		$('*[name=replyContent]').each(function(index, element) {
			tmpId = $(element).attr('id');
			if(typeof tmpId === 'undefined') {
				count--;
				$(element).attr('id','replyContent-' + count);
			}
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
			url : postUrl,
			dataType : 'json',
			data : JSON.stringify(momo),
			success : function(callback) {
				
				//controllerから、コメントと投稿者と投稿時間を取得
				var contents = JSON.parse(JSON.stringify(callback.momo.momo_contents));
				var name = JSON.parse(JSON.stringify(callback.momo.createName));
				var time = JSON.parse(JSON.stringify(callback.momo.create_date));
				var momoNum = JSON.parse(JSON.stringify(callback.momo.momoNum));

				var message = {"contents" : contents,
								"name" : name,
								"time" : time,
								"momoNum" : momoNum};
				
				var template = $("#tmplComment").text();
				var compiled = _.template(template);
				
				$('#board tbody > tr:eq(0)').before(compiled(message));
				
				//返信用linkに対して降順にidを割り振る
				$('.reply-link').attr("id",function(i){
					index = $('.reply-link').size() - 1;
					index -= i;
					return 'reply-link-' + index;
				});
				
				//momoに対して降順にidを割り振る
				$('.momoComment').attr("id",function(i){
					index = $('.momoComment').size() - 1;
					index -= i;
					return 'momoComment-' + index;
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
		var linkId = $(this).attr('id');

		//返信フォームを表示
		var template = $('#tmplReplyForm').html();
		var compiled = _.template(template);
		$(this).after(compiled());
		
		//返信フォームにidを割り振る（先に追加されたフォームから)
		count = $('*[name=replyForm]').size();
		$('*[name=replyForm]').each(function(index, element) {
			tmpId = $(element).attr('id');
			if(typeof tmpId === 'undefined') {
				count--;
				$(element).attr('id','replyForm-' + count);
				tmpId = $(element).attr('id');
			}
		});
		
		//返信コメント投下ボタンにidを割り振る
		count = $('*[name=replyButton]').size();
		$('*[name=replyButton]').each(function(index, element) {
			tmpId = $(element).attr('id');
			if(typeof tmpId === 'undefined') {
				count--;
				$(element).attr('id','replyButton-' + count);
			}
		});
		
		//返信フォームにidを割り振る
		count = $('*[name=replyContent]').size();
		$('*[name=replyContent]').each(function(index, element) {
			tmpId = $(element).attr('id');
			if(typeof tmpId === 'undefined') {
				count--;
				$(element).attr('id','replyContent-' + count);
			}
		});

		//replyLinkをhide
		$(this).hide();
	    
	});
	
	//返信フォームのボタン押下で呼び出し
	$(document).on('click','*[name=replyButton]',function() {	 
		var buttonId = $(this).attr('id');
		
		//ボタンを押下した返信フォームのIDを取得
		var replyFormId = $(this).parent().parent().attr('id');
		
		var clickFormSelector = '#' + replyFormId;
		
		//ボタンを押下した返信テキストエリアのIDを取得
		var replyContentId = $(this).parent().prev().attr('id');

		var replyContentSelector = '#' + replyContentId;
		
		//返信テキストエリア内の入力テキストを取得
		returnComment.returnComment.return_contents = $(replyContentSelector).val();
		$(replyContentSelector).val('');
		
		//返信対象のmomoBeanのIdを取得
		var momoId = $(this).parent().prev().parent().parent().parent().prev().prev().prev().val();
		
		if(typeof momoId === 'undefined' ) {
			//返信コメントがあると、momoBeanのIdの位置が変わるため、再取得
			momoId = $(this).parent().prev().parent().prev().val();
		}
		
		//返信対象のmomoを格納している<td>のID
		var MomoTdId = '#' + $(this).closest('.momoComment').attr('id');

		console.log('MomoTdId:' + MomoTdId);
		
		//返信したmomoの配下のコメント数を取得
	    MomoTdId = MomoTdId + ' .replyComment'
	    var childNum = $(MomoTdId).size();
		
		console.log('childNum:' + childNum);
		
		//返信対象のmomoの何番目の子要素かをセット(0始まり)
		returnComment.returnComment.child_num = childNum;
	
		//返信対象のmomoIDをreturnCommentBeanにセット
		returnComment.returnComment.momo_momo_num = momoId;

		$.ajax({
			contentType: 'application/json; charset=UTF-8',
			type : 'POST',
			url : replyUrl,
			dataType : 'json',
			data : JSON.stringify(returnComment),
			success : function(callback) {
				
				//controllerから、コメントと投稿者と投稿時間を取得
				var contents = JSON.parse(JSON.stringify(callback.returnComment.return_contents));
				var name = JSON.parse(JSON.stringify(callback.returnComment.createName));
				var time = JSON.parse(JSON.stringify(callback.returnComment.create_date));
				var momoNum = JSON.parse(JSON.stringify(callback.returnComment.momo_momo_num));

				var message = {"contents" : contents,
								"name" : name,
								"time" : time,
								"momoNum" : momoNum};		
				
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
	
})
