<?php

	require("connect.php");
	
	class BaiHat{
		function BaiHat($idbaihat, $tenbaihat,$hinhbaihat, $casi, $linkbaihat, $luotthich){
			$this->IdBaiHat = $idbaihat;
			$this->TenBaiHat = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
			$this->CaSi = $casi;
			$this->LinkBaiHat = $linkbaihat;
			$this->LuotThich = $luotthich;
			
		}
	}

	$arrayCasi = array();
	$query = "SELECT * FROM baihat ORDER BY luotthich DESC LIMIT 5";
	$data = mysqli_query($conn, $query);
	while($row = mysqli_fetch_assoc($data)){
		array_push($arrayCasi, new BaiHat($row['idbaihat'],
										 $row['tenbaihat'],
										 $row['hinhbaihat'],
										 $row['casi'],
										 $row['linkbaihat'],
										 $row['luotthich']));
	}

	echo json_encode($arrayCasi);


?>