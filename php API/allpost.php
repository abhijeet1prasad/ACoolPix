<?php
// With authentication 


// if( $_GET["dealer"] || $_GET["trailer"]) {


//$button = $_POST ['search'];
//$search = $_POST ['searchterm']; 
//$search1 = $_POST ['searchtermt']; 

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
$sql = "SELECT content FROM post";
//$a=$_GET["dealer"]; 
//$b=$_GET["trailer"]; 
/*$sql = "SELECT user_details.dealer_id, trailer.trailer_no, chassis.chassis_no
FROM user_details
INNER JOIN trailer ON user_details.dealer_id = trailer.dealer_id  
INNER JOIN chassis ON trailer.trailer_no = chassis.trailer_no WHERE trailer.trailer_no like '%$b%' AND user_details.dealer_id like '%$a%'"; */
$result = $conn->query($sql); 

if ($result->num_rows > 0) {
     // output data of each row
     while($row = $result->fetch_assoc()) { 
       
		 $msg[] = array("content" => $row["content"]);
		// $msg[] = array("dealer_id" => $row["dealer_id"],"trailer no" => $row["trailer_no"], "chassis_no" => $row["chassis_no"]);
	     }
		 
		 $json = $msg;
 
header('content-type: application/json');
echo json_encode($json,JSON_PRETTY_PRINT);
} else {
     echo "0 results";
}

$conn->close();

exit();
   //}


// $msg[] = array("dealer_id" => $row["dealer_id"],"trailer no" => $row["trailer_no"], "chassis_no" => $row["chassis_no"]);
//for testing
//DL111
//MH12AB0123


