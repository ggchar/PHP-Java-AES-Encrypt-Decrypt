<?php
  include 'AESUtil.php';
  
  $plaintext = "abcdef";
  //AES only supports key sizes of 16, 24 or 32 bytes.
  $key = "s+FZFDjBKMUVDpu=";
  
  $ciphertextBase64 = AESUtil::encryptBase64($plaintext, $key);
  $plaintextBase64 = AESUtil::decryptBase64($ciphertextBase64, $key);
  
  $ciphertextHexStr = AESUtil::encryptHexStr($plaintext, $key);
  $plaintextHexStr = AESUtil::decryptHexStr($ciphertextHexStr, $key);
  
  
  echo $ciphertextBase64."<br/>";//output: /s9PA4KQBKUhRPJDp+v3UA==
  echo $plaintextBase64."<br/>";//output: abcdef
  
  echo $ciphertextHexStr."<br/>";//output: fecf4f03829004a52144f243a7ebf750
  echo $plaintextHexStr."<br/>";//output: abcdef
?>
