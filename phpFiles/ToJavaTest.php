<?PHP
echo sendDataToJava("texttexttexttexttexttexttexttexttexttexttexttext");

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
		  echo fgets($fp);
		}
		fclose($fp);
	}
	return $return;
}
?>