<?php

	require('connect.php');
	
	$query = "SELECT * FROM playlist";
	$data = mysqli_query($conn, $query);

	class DanhSachPlaylist{
		function DanhSachPlaylist($idplaylist, $ten, $hinhnen, $hinhicon){
			$this->IdPlayList = $idplaylist;
			$this->Ten = $ten;
			$this->HinhNen = $hinhnen;
			$this->HinhIcon = $hinhicon;
		}
	}

	$arrayplaylist = array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayplaylist, new DanhSachPlaylist($row['idplaylist'],
													   $row['ten'],
													   $row['hinhnen'],
													   $row['hinhicon']));
		
	}
	
	echo json_encode($arrayplaylist);


?>