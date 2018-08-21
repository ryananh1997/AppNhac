<?php 

	require("connect.php");

	class BaiHat{
		function BaiHat($idbaihat, $tenbaihat, $hinhbaihat, $casi, $linkbaihat, $luotthich){
			$this->IdBaiHat = $idbaihat;
			$this->TenBaiHat = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
			$this->CaSi = $casi;
			$this->LinkBaiHat = $linkbaihat;
			$this->LuotThich = $luotthich;
		}
	}


	$arraydanhsachbaihat = array();

	if(isset($_POST['idplaylist'])){
		$idplaylist = $_POST['idplaylist'];
		$query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idplaylist',idplaylist)";
	}

	if(isset($_POST['idquangcao'])){
			$idquangcao = $_POST['idquangcao'];
			$queryquangcao = "SELECT * FROM quangcao WHERE id='$idquangcao'";
			$dataquangcao = mysqli_query($conn, $queryquangcao);
			$rowquangcao = mysqli_fetch_assoc($dataquangcao);
			$id =  $rowquangcao['idbaihat'];
			$query = "SELECT * FROM baihat WHERE idbaihat='$id'";
	}

	
	$data = mysqli_query($conn, $query);
	while($row = mysqli_fetch_assoc($data)){
		array_push($arraydanhsachbaihat, new BaiHat($row['idbaihat'],
												   $row['tenbaihat'],
												   $row['hinhbaihat'],
												   $row['casi'],
												   $row['linkbaihat'],
												   $row['luotthich']));
		
	}

	echo json_encode($arraydanhsachbaihat);


?>