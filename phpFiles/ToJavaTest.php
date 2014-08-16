<?PHP
echo sendDataToJava("text");

function sendDataToJava($data){
	$host = "tcp://localhost"; 
	$port = 6789;
	$data = $data . PHP_EOL;
	$errstr = '';
	$errno = '';
	$return = "";

	if ( ($fp = fsockopen($host, $port, $errno, $errstr, 3) ) === FALSE)
		echo "$errstr ($errno)";
	else {
		//print 'SUCCESS!<br />';
		fwrite($fp, $data);
		while (! feof($fp)) {
		  $return = fgets($fp, 4096);
		}
		fclose($fp);
	}
	return $return;
}
?>