<?php 
    include "connect.php";
    $page = $_GET['page'];
    $idphim = $_POST['idphim'];
    $space = 4;
    $limit =($page - 1)*$space;
    $mangphim = array();
    $query = "SELECT * FROM phim WHERE idphim = $idphim LIMIT $limit,$space";
    $data = mysqli_query($conn,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangphim,new Phim(
            $row['id'],
            $row['tenphim'],
            $row['giaphim'],
            $row['hinhanhphim'],
            $row['mota'],
            $row['idphim']));
    }
    echo json_encode($mangphim);
    class Phim{
        function Phim($id,$tenphim,$giaphim,$hinhanhphim,$mota,$idphim){
            $this->id = $id;
            $this->tenphim = $tenphim;
            $this->giaphim = $giaphim;
            $this->hinhanhphim = $hinhanhphim;
            $this->mota = $mota;
            $this->idphim = $idphim;
        }
    }
?>