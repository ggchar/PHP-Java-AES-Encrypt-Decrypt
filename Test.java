
import com.test.util.AESUtil;

public class Test {

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
}
