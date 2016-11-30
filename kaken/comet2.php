<?php
	ini_set("display_errors", On);
	error_reporting(E_ALL);
	require_once('config.php');
	require_once('function.php');

	$dbh = connectDB();

	if(isset($_GET['mode'])){
		switch($_GET['mode']){
			case 'view':
				$data = getUpdate($dbh);
				break;

			case 'check':
				$data = checkUpdate($dbh);
				break;
		}
		for ($i = 0; $i < count($data); $i++) {
			echo $data[$i]['name']."<br>";
		}
		//var_dump($data);
	}

	function getUpdate($dbh){
		return $dbh->query("select name from devices")->fetchAll();
	}

	function setUpdate($data,$dbh){
		$res = $dbh->exec("insert into devices (name) values ('".$data.")");
	}

	function checkUpdate($dbh){
		$data = getUpdate($dbh);
		$temp = $data;
		$count = 0;
		while ($temp[0]["id"] === $data[0]["id"]) {
			$temp = getUpdate($dbh);
			usleep(500000);
			$count++;
			if($count > 50) break;
		}
		return $temp;
	}
/*
	function addUpdate($str,$dbh){
		if(!empty($str)){
			$str = str_replace(array("\n", "\r"), '', $str);
			setUpdate($str,$dbh);
		}
		return getUpdate($dbh);
	}
*/
?>