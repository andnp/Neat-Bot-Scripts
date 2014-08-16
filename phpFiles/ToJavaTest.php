<?PHP
$host = "tcp://localhost"; 
$port = 6789;
$data = 'test' . PHP_EOL;
$errstr = '';
$errno = '';

if ( ($fp = fsockopen($host, $port, $errno, $errstr, 3) ) === FALSE)
    echo "$errstr ($errno)";
else {
    print 'SUCCESS!<br />';
    fwrite($fp, $data);
    while (! feof($fp)) {
      echo fgets($fp, 4096);
    }
    fclose($fp);
}
?>