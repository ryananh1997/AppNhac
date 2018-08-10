<?php 

	require("connect.php");
	
	class Album{
		function Album($idalbum, $tenalbum, $tencasialbum, $hinhcasialbum){
			$this->IdAlbum = $idalbum;
			$this->TenAlbum = $tenalbum;
			$this->TenCaSiAlbum = $tencasialbum;
			$this->HinhCaSiAlbum = $hinhcasialbum;
		}
	}

	$query = "SELECT DISTINCT * FROM album ORDER BY rand(".date("Ymd").") LIMIT 4";
	$dataalbum = mysqli_query($conn, $query);



	$arrayAlbum = array();
	while($row = mysqli_fetch_assoc($dataalbum)){
		array_push($arrayAlbum, new Album($row['idalbum'],
										 $row['tenalbum'],
										 $row['tencasialbum'],
										 $row['hinhalbum']));
	}
	
	echo json_encode($arrayAlbum);

?>