<?PHP
$fbp = $_REQUEST("fbp");
$wbp = $_REQUEST("wbp");
$sbp = $_REQUEST("sbp");
$ibp = $_REQUEST("ibp");
$fsp = $_REQUEST("fsp");
$wsp = $_REQUEST("wsp");
$ssp = $_REQUEST("ssp");
$isp = $_REQUEST("isp");
$fa = $_REQUEST("fa");
$wa = $_REQUEST("wa");
$sa = $_REQUEST("sa");
$ia = $_REQUEST("ia");
$ga = $_REQUEST("ga");
main();

function main(){
	makeDecision("food", "buy", $fbp, $fa) ||
	makeDecision("wood", "buy", $wbp, $wa) ||
	makeDecision("stone", "buy", $sbp, $sa) ||
	makeDecision("iron", "buy", $ibp, $ia) ||
	makeDecision("food", "sell", $fsp, $fa) ||
	makeDecision("wood", "sell", $wsp, $wa) ||
	makeDecision("stone", "sell", $ssp, $sa) ||
	makeDecision("iron", "sell", $isp, $ia);
}

function averageFromString($str){
	$avg = 0;
	$array = explode(" ", $str);
	for($i = 0; $i < 10; $i++){
		$avg += floatval($array[$i]);
	}
	return $avg / 10;
}

function stanDevFromString($str, $mean){
	$stanDev = 0;
	$array = explode(" ", $str);
	for($i = 0; $i < 10; $i++){
		$stanDev += pow($array[$i] - $mean, 2);
	}
	$stanDev = $stanDev / 10;
	return sqrt($stanDev);
}

function getCurrentPrice($str){
	return explode(" ", $str)[9];
}

function makeDecision($type,$action,$prices, $amount){
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