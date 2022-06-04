<?php 
    include "connect.php";
    $mangphimmoinhat = array();
    $query = "SELECT * FROM phim ORDER BY id DESC LIMIT 4";
    $data = mysqli_query($conn,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangphimmoinhat,new Phimmoinhat(
            $row['id'],
            $row['tenphim'],
            $row['giaphim'],
            $row['hinhanhphim'],
            $row['mota'],
            $row['idphim']));
    }
    echo json_encode($mangphimmoinhat);
    class Phimmoinhat{
        function Phimmoinhat($id,$tenphim,$giaphim,$hinhanhphim,$mota,$idphim){
            $this->id = $id;
            $this->tenphim = $tenphim;
            $this->giaphim = $giaphim;
            $this->hinhanhphim = $hinhanhphim;
            $this->mota = $mota;
            $this->idphim = $idphim;
        }
    }
?>