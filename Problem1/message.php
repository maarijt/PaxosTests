<html>
<body>

<?php
	echo $_POST["message"];
	echo $_POST["hash"];
?>

<form action="message.php" method="post">
	Enter your message: <input type="text" name = "message"><br/>
	Enter your hash here: <input type="text" name = "hash"> <br/>
<input type="submit">
</form>



</body>
</html>