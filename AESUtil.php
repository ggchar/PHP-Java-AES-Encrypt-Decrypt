<?php
class AESUtil {
	public static function encryptBase64($plaintext, $key) {
		$data = AESUtil::encrypt($plaintext, $key);
		$data = base64_encode($data);
		return $data; 
	}
	public static function encryptHexStr($plaintext, $key) {
		$data = AESUtil::encrypt($plaintext, $key);
		$data = bin2hex($data);
		return $data; 
	}
 
	public static function decryptBase64($ciphertext, $key) {
		$ciphertext = base64_decode($ciphertext);
		$plaintext = AESUtil::decrypt($ciphertext, $key);	
		return $plaintext; 
	}
	public static function decryptHexStr($ciphertext, $key) {
		$ciphertext = hex2bin($ciphertext);
		$plaintext = AESUtil::decrypt($ciphertext, $key);	
		return $plaintext; 
	}
	
	private static function encrypt($plaintext, $key) {
		$size = mcrypt_get_block_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_ECB); 
		$pad = $size - (strlen($plaintext) % $size); 
		$plaintext = $plaintext . str_repeat(chr($pad), $pad); 
		$td = mcrypt_module_open(MCRYPT_RIJNDAEL_128, '', MCRYPT_MODE_ECB, ''); 
		$iv = mcrypt_create_iv (mcrypt_enc_get_iv_size($td), MCRYPT_RAND); 
		mcrypt_generic_init($td, $key, $iv); 
		$data = mcrypt_generic($td, $plaintext); 
		mcrypt_generic_deinit($td); 
		mcrypt_module_close($td);
		return $data; 
	}
	
	private static function decrypt($ciphertext, $key) {
		$plaintext= mcrypt_decrypt(
			MCRYPT_RIJNDAEL_128,
			$key, 
			$ciphertext,
			MCRYPT_MODE_ECB
		);
		$dec_s = strlen($plaintext); 
		$padding = ord($plaintext[$dec_s-1]); 
		$plaintext = substr($plaintext, 0, -$padding);
		return $plaintext;
	}	
}
?>
