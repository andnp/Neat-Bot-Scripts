<?PHP
require "ToJava.php";
$food = $_REQUEST["food"];
$wood = $_REQUEST["wood"];
$stone = $_REQUEST["stone"];
$iron = $_REQUEST["iron"];
$gold = $_REQUEST["gold"];
$minRes = $_REQUEST["min"];
$coords = $_REQUEST["coords"];
main();

function main(){
	$result = "sendresources " . $coords . " ";
	if($food < $minRes){
		$result = $result . "f ";
	}
	if($wood < $minRes){
		$result = $result . "w ";
	}
	if($stone < $minRes){
		$result = $result . "s ";
	}
	if($iron < $minRes){
		$result = $result . "i ";
	}
	if($gold < $minRes){
		$result = $result . "g";
	}
	sendDataToJava($result);
}
?>