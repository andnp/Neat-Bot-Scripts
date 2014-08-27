<?PHP
require "ToJava.php";
main();

function main(){
	$coords = "(" . $_REQUEST['coords'] . ")";
	$food = $_REQUEST['food'];
	$wood = $_REQUEST['wood'];
	$stone = $_REQUEST['stone'];
	$iron = $_REQUEST['iron'];
	$gold = $_REQUEST['gold'];
	
	sendDataToJava("CheckIn" . $coords . " " . $food . " " . $wood . " " . $stone . " " . $iron . " " . $gold);
}

?>