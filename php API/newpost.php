<?php
 
 if($_SERVER['REQUEST_METHOD']=='POST'){
	 
	 $servername = "localhost";
$username = "id1966492_root";
$password = "password";
$dbname = "id1966492_pv"; 

// Create connection 
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
     die("Connection failed: " . $conn->connect_error);
} 
	 
	 

 //$trailer_no = $_POST['trailerno'];
 $chassis_no = $_POST['chassis_no'];
 // $ok_condition = $_POST['ok_condition'];
 
 

 $sql = "INSERT INTO post (content) VALUES ('$chassis_no')";
 
 
 if(mysqli_query($conn,$sql)){
 echo "Successfully";
 }else{
 echo "Could not register";
 
 }
 }else{
echo 'error';
}