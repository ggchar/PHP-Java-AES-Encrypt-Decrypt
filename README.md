# PHP-Java-C#-AES-Encrypt-Decrypt
To encrypt and decrypt text using AES/ECB/PKCS5Padding encryption algorithm, and pass data AES encrypted between PHP and Java.
Two output types can be used in encryption and decryption: Base64, Hexadecimal.

AESUtil.java Dependencies & environment
- Apache Commons Coded - http://commons.apache.org/codec/
- Java Version: 1.8+

AESUtil5.php Dependencies & environment
- None
- PHP Version: 5.x 7.0

AESUtil7.php Dependencies & environment
- OpenSSL
- PHP Version: 5.x 7.0 7.1 7.2

AESUtil.cs Dependencies & environment
- .NETFramework 4.0+

*How to Use?*
1. Please see the samples below.
2. Call decryptHexStr() to decrypt a ciphertext which is encrypted by encryptHexStr().
3. Call decryptBase64() to decrypt a ciphertext which is encrypted by encryptBase64().


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
  include 'AESUtil5.php';
  
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


```PH
<?php
  include 'AESUtil7.php';
  
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

*C# Test Preview:*
```C#
static void Main() {
            //AES only supports key sizes of 16, 24 or 32 bytes.
            string key = "s+FZFDjBKMUVDpu=";
            string plainText = "abcdef";

            string ciphertextBase64 = AESUtil.EncryptBase64(plainText, key);
            string plaintextBase64 = AESUtil.DecryptBase64(ciphertextBase64, key);

            string ciphertextHexStr = AESUtil.EncryptHexStr(plainText, key);
            string plaintextHexStr = AESUtil.DecryptHexStr(ciphertextHexStr, key);

            Console.WriteLine(ciphertextBase64);//output: /s9PA4KQBKUhRPJDp+v3UA==
            Console.WriteLine(plaintextBase64);//output: abcdef

            Console.WriteLine(ciphertextHexStr);//output: fecf4f03829004a52144f243a7ebf750
            Console.WriteLine(plaintextHexStr);//output: abcdef
        }
        
```
