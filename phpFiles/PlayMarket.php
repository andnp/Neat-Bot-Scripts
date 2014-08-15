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
	makeDecision("food", "buy", $fbp, $fa) ||
	makeDecision("wood", "buy", $wbp, $wa) ||
	makeDecision("stone", "buy", $sbp, $sa) ||
	makeDecision("iron", "buy", $ibp, $ia) ||
	makeDecision("food", "sell", $fsp, $fa) ||
	makeDecision("wood", "sell", $wsp, $wa]) ||
	makeDecision("stone", "sell", $ssp, $sa) ||
	makeDecision("iron", "sell", $isp, $ia);
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

function getCurrentPrice(String $str){
	return explode(" ", $str)[9];
}

function makeDecision(String $type, String $action, String $prices, $amount){
	$mean = averageFromString($prices);
	$stanDev = stanDevFromString($prices, $mean);
	$currentPrice = getCurrentPrice($prices);
	$zscore = ($currentPrice - $mean) / $stanDev;
	$acted = false;
	if($action == "buy"){
		if($zscore > .5){
			echo "buy " . $type . " " . ($ga * .1) . " " . $currentPrice;
			$acted = true;
		}
	} else {
		if($zscore < -.5){
			echo "sell " . $type . " " . ($amount * .1) . " " . $currentPrice;
			$acted = true;
		}
	}
	return $acted;
}
?>