# PHP-Java-AES-Encrypt-Decrypt
Pass data AES encrypted between PHP and Java. Support two ways of encryption and decryption: Base64, Hexadecimal.

When you use encryptHexStr method, you will get a ciphertext which is an alphanumeric string. Obviously, when you need to decrypt it, you should call decryptHexStr method.

Java Dependencies
- Apache Commons Coded - http://commons.apache.org/codec/

PHP Dependencies
- None


*Java Test Preview:*

```Java
public static void main (String [] args) {
        //AES only supports key sizes of 16, 24 or 32 bytes.
        String key = "s+FZFDjBKMUVDpu=";
        String plainText = "abcdef";

        String ciphertextBase64 = AESUtil.encryptBase64(plainText,key);
        String plaintextBase64 = AESUtil.decryptBase64(ciphertextBase64,key);

        String ciphertextHexStr = AESUtil.encryptHexStr(plainText,key);
        String plaintextHexStr = AESUtil.decryptHexStr(ciphertextHexStr,key);

        System.out.println(ciphertextBase64);//output: /s9PA4KQBKUhRPJDp+v3UA==
        System.out.println(plaintextBase64);//output: abcdef
        
        System.out.println(ciphertextHexStr);//output: FECF4F03829004A52144F243A7EBF750
        System.out.println(plaintextHexStr);//output: abcdef
}

```

*PHP Test Preview:*

```PH
<?php
  include 'AESUtil.php';
  
  //AES only supports key sizes of 16, 24 or 32 bytes.
  $key = "s+FZFDjBKMUVDpu=";
  $plaintext = "abcdef";
  
  $ciphertextBase64 = AESUtil::encryptBase64($plaintext, $key);
  $plaintextBase64 = AESUtil::decryptBase64($ciphertextBase64, $key);
  
  $ciphertextHexStr = AESUtil::encryptHexStr($plaintext, $key);
  $plaintextHexStr = AESUtil::decryptHexStr($ciphertextHexStr, $key);
  
  
  echo $ciphertextBase64."<br/>";//output: /s9PA4KQBKUhRPJDp+v3UA==
  echo $plaintextBase64."<br/>";//output: abcdef
  
  echo $ciphertextHexStr."<br/>";//output: fecf4f03829004a52144f243a7ebf750
  echo $plaintextHexStr."<br/>";//output: abcdef
?>
```
