<html>
<body>


<form action="message.php" method="post">
	Enter your message here: <input type="text" name = "message"><br/>
	<br/>
	Or
	<br/>
	<br/>
	Enter your hash here: <input type="text" name = "hash"> <br/>
<input type="submit" class="btn btn-info" role="button">
</form>

<?php
	$servername = "xo5.x10hosting.com";
	$username = "hashnsla";
	$password = "Cornel_1357";
	$database = "hashnsla_hashes";

	// Create connection
	$conn = new mysqli($servername, $username, $password, $database);

	// Check connection
	if ($conn->connect_error) {
	    die("Connection failed: " . $conn->connect_error);
	} 
	if (!empty($_POST["message"])) {
		$message =  htmlspecialchars($_POST["message"]);
		$calculatedhash = hash("sha256", $message);
		echo "<p> Your hash is: " . $calculatedhash . "</p>"; 
		$sql = 'INSERT INTO hashtable (hash, message) VALUES ("' . $calculatedhash . '","' . $message . '")';
		if (mysqli_query($conn, $sql)) {
			 	echo "Hash saved to database.";
			} else {
				echo "Error: " . $sql . "<br>" . mysqli_error($conn);
			}
	} else if (!empty($_POST["hash"])) {
		$hash =  $_POST["hash"];
		$sql = 'SELECT message FROM hashtable WHERE hash ="' . $hash . '"';
		$result = $conn->query($sql);

		if ($result->num_rows > 0) {
			$row = $result->fetch_assoc();
			echo "Your message was: " . $row["message"];
		} else {
			echo "Error 404: No such hash exists in database.";
		}

	} else if (!empty($_POST["message"]) && !empty($_POST["hash"])) {
		echo "Please set one text field";
	} else {
		echo "You have not entered anything!";
	}

	
?>


</body>
</html>