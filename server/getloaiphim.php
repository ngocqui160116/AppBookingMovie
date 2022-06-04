<?php 
    include "connect.php";
    $query = "SELECT * FROM loaiphim";
    $data = mysqli_query($conn,$query);
    $mangloaiphim = array();
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangloaiphim, new Loaiphim( 
            $row['id'],
            $row['tenloaiphim'],
            $row['hinhanhloaiphim']));
    }
    echo json_encode($mangloaiphim);
    class Loaiphim{
        function Loaiphim($id,$tenloaiphim,$hinhanhloaiphim){
            $this->id =$id;
            $this->tenloaiphim =$tenloaiphim;
            $this->hinhanhloaiphim =$hinhanhloaiphim;
        }
    }
?>