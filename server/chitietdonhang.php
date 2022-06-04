<?php 
    include "connect.php";
    $json = $_POST['json']; 
    //$json = '[{"giaphim":50000,"madonhang":"1","soluongphim":1,"tenphim":"Avatar","maphim":1}]';
    $data = json_decode($json,true);
    foreach($data as $value){
        $madonhang = $value['madonhang'];
        $maphim = $value['maphim'];
        $tenphim = $value['tenphim'];
        $giaphim = $value['giaphim'];
        $soluongphim = $value['soluongphim'];
        $query = "INSERT INTO chitietdonhang (id,madonhang,maphim,tenphim,giaphim,soluongphim) 
        VALUES (null,'$madonhang','$maphim','$tenphim','$giaphim','$soluongphim')";
        $Dta = mysqli_query($conn,$query);
    }
    if($Dta){
        echo "1";
    }
    else{
        echo"0";
    }
?>