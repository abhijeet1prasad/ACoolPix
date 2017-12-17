<?php
$server_name = "localhost";
$user_name = "id1966492_root";
$password = "password";
$db= 'id1966492_pv';
$conn = mysqli_connect($server_name, $user_name, $password,$db);

if(!$conn){
	die("Error Connection");
}

?>