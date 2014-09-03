<?PHP
require "ToJava.php";
main();

function main(){
	$coords = $_REQUEST["coords"];
	$wo = $_REQUEST["wo"];
	$w = $_REQUEST["w"];
	$s = $_REQUEST["s"];
	$p = $_REQUEST["p"];
	$sw = $_REQUEST["sw"];
	$a = $_REQUEST["a"];
	$c = $_REQUEST["c"];
	$cata = $_REQUEST["cata"];
	$t = $_REQUEST["t"];
	$b = $_REQUEST["b"];
	$cat = $_REQUEST["cat"];
	
	$string = "Troops ($coords) $wo $w $s $p $sw $a $c $cata $t $b $cat";
	sendDataToJava($string);
}
?>