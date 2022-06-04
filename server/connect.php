<?php 
    $host = "localhost";
    $username = "root";
    $password = "";
    $database = "movie";

    $conn = mysqli_connect($host,$username,$password,$database);
    mysqli_query($conn,"SET NAMES 'utf-8'");
    
?>
