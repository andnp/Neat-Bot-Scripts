<?PHP
require "ToJava.php";

main();
function main(){
	$coords = $_REQUEST["coords"];
	echo sendDataToJava("RequestCommand (" . $coords . ")");
}
?>