<?php

	require("connect.php");

	$arraytheloai = array();
	$arraychude = array();

	class TheLoai{
		function TheLoai($idtheloai, $idchude, $tentheloai, $hinhtheloai){
			$this->IdTheLoai = $idtheloai;
			$this->IdChuDe = $idchude;
			$this->TenTheLoai = $tentheloai;
			$this->HinhTheLoai = $hinhtheloai;
		}
	}

	class ChuDe{
		function ChuDe($idchude, $tenchude,  $hinhchude){;
			$this->IdChuDe = $idchude;
			$this->TenChuDe = $tenchude;
			$this->HinhChuDe = $hinhchude;
		}
	}



	$querytheloai = "SELECT DISTINCT * FROM theloai ORDER BY rand(".date("Ymd").") LIMIT 4 ";
	$datatheloai = mysqli_query($conn, $querytheloai);
	while($row = mysqli_fetch_assoc($datatheloai)){
		array_push($arraytheloai, new TheLoai($row['idtheloai'],
											 $row['idchude'],
											 $row['tentheloai'],
											 $row['hinhtheloai']));
	}


	$querychude = "SELECT DISTINCT * FROM chude ORDER BY rand(".date("Ymd").") LIMIT 4 ";
	$datachude = mysqli_query($conn, $querychude);
	while($row = mysqli_fetch_assoc($datachude)){
		array_push($arraychude, new ChuDe( $row['idchude'],
											 $row['tenchude'],
											 $row['hinhchude']));
	}

	$arraychudetheloai = array('TheLoai'=>$arraytheloai, 'ChuDe'=>$arraychude);

	echo json_encode($arraychudetheloai);



?>