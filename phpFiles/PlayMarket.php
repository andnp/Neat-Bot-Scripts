<?PHP
String $fbp = $_REQUEST("fbp");
String $wbp = $_REQUEST("wbp");
String $sbp = $_REQUEST("sbp");
String $ibp = $_REQUEST("ibp");
String $fsp = $_REQUEST("fsp");
String $wsp = $_REQUEST("wsp");
String $ssp = $_REQUEST("ssp");
String $isp = $_REQUEST("isp");
int $fa = $_REQUEST("fa");
int $wa = $_REQUEST("wa");
int $sa = $_REQUEST("sa");
int $ia = $_REQUEST("ia");
int $ga = $_REQUEST("ga");
main();

function main(){
	
}

function averageFromString(String $str){
	$avg = 0;
	$array = explode(" ", $str);
	for(int $i = 0; $i < 10; $i++){
		$avg += floatval($array[$i]);
	}
	return $avg / 10;
}

function stanDevFromString(String $str, $mean){
	$stanDev = 0;
	$array = explode(" ", $str);
	for(int $i = 0; $i < 10; $i++){
		$stanDev += pow($array[$i] - $mean, 2);
	}
	$stanDev = $stanDev / 10;
	return sqrt($stanDev);
}
?>