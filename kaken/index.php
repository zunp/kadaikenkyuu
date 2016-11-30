<?php
ini_set("display_errors", On);
error_reporting(E_ALL);
?>
<!DOCTYPE HTML>
<html lang="en-US">
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
		<script>
			$(function(){
				getUpdate();
				//addUpdate();
			});
			function getUpdate(){
				$.post('comet2.php?mode=view', {}, function(data){
					$('dd#view').html(data);
					checkUpdate();
				});
			}
			function checkUpdate(){
				$.post('comet2.php?mode=check', {}, function(data){
					$('dd#view').html(data);
					checkUpdate();
				});
			}
			function addUpdate(){
				$('form#add').submit(function(){
					var param = $('input[name="str"]').val();
					$.post('comet2.php?mode=add', {str:param}, function(data){
						$('input[name="str"]').val("");
						$('dd#view').html(data);
					});
				return false;
				});
			}
		</script>
	</head>
	<body>
		<dl>
			<dt>データ<dt>
			<dd id="view">ここにデータ</dd>
		</dl>
		<form id="add" action="comet2.php?mode=add" method="post">
			<p>
				<input type="text" name="str" value="" />
				<input type="submit" value="追加" />
			</p>
		</form>
	</body>
</html>