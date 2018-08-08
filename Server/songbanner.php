<?php

	require("connect.php");

	$query = "SELECT quangcao.id,quangcao.hinhanh, quangcao.noidung, quangcao.idbaihat, baihat.tenbaihat, baihat.hinhbaihat FROM baihat INNER JOIN quangcao ON quangcao.idbaihat = baihat.idbaihat WHERE quangcao.idbaihat = baihat.idbaihat ";

	$data = mysqli_query($conn, $query);

	
	class Quangcao{
		function Quangcao($idquangcao, $hinhanh, $noidung, $idbaihat, $tenbaihat, $hinhbaihat){
			$this->IdQuangCao = $idquangcao;
			$this->HinhAnh = $hinhanh;
			$this->NoiDung = $noidung;
			$this->IdBaiHat = $idbaihat;
			$this->TenBaiHat = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
		}
	}
		
		$mangquangcao=array();
		
		while($row = mysqli_fetch_assoc($data)){
			array_push($mangquangcao, new Quangcao($row['id'],
												  $row['hinhanh'],
												  $row['noidung'],
												  $row['idbaihat'],
												  $row['tenbaihat'],
												  $row['hinhbaihat']));		 		
											}
		
	echo json_encode($mangquangcao);

?>