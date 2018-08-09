<?php
	require("connect.php");
	$query = "SELECT DISTINCT * FROM playlist ORDER BY rand(".date("Ymd").") LIMIT 3";


	class playlisttoday{
		function playlisttoday($idplaylist, $ten, $hinh, $icon){
			$this->IdPlayList = $idplaylist;
			$this->TenPlayList = $ten;
			$this->HinhPlayList = $hinh;
			$this->IconPlayList = $icon;
		}
	}

	$arrylistfortoday = array();
	$data = mysqli_query($conn, $query);
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrylistfortoday, new playlisttoday($row['idplaylist'],
													   $row['ten'],
													   $row['hinhnen'],
													   $row['hinhicon']));
	}

	echo json_encode($arrylistfortoday);


?>