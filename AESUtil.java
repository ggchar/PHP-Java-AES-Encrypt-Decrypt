
import org.apache.commons.codec.binary.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;


public class AESUtil {

    public static String encryptBase64(String plaintext, String key){
        String ciphertextBase64 = null;
        try {
            byte[] plaintextByte = plaintext.getBytes("UTF-8");
            byte[] ciphertextByte = encryptByte(plaintextByte,key);
            byte[] ciphertextBase64Byte = Base64.encodeBase64(ciphertextByte);
            ciphertextBase64 = new String(ciphertextBase64Byte,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciphertextBase64;
    }

    public static String decryptBase64(String ciphertext, String key){
        String plaintext = null;
        try{
            byte[] ciphertextByte = Base64.decodeBase64(ciphertext);
            byte[] plaintextByte = decryptByte(ciphertextByte,key);
            plaintext = new String(plaintextByte,"UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        return plaintext;
    }

    public static String encryptHexStr(String plaintext, String key){
        String ciphertextHexStr = null;
        try{
            byte[] plaintextByte = plaintext.getBytes("UTF-8");
            byte[] ciphertextByte = encryptByte(plaintextByte,key);
            ciphertextHexStr = parseByte2HexStr(ciphertextByte);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ciphertextHexStr;
    }

    public static String decryptHexStr(String ciphertext, String key) {
        String plaintext = null;
        try {
            byte[] ciphertextByte = parseHexStr2Byte(ciphertext);
            byte[] plaintextByte = decryptByte(ciphertextByte,key);
            plaintext = new String(plaintextByte,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plaintext;
    }

    public static byte[] encryptByte(byte[] plaintext, String key){
        byte[] ciphertext = null;
        try{
            SecretKeySpec skey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            ciphertext = cipher.doFinal(plaintext);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ciphertext;
    }

    public static byte[] decryptByte(byte[] ciphertext, String key){
        byte[] plaintext = null;
        try{
            SecretKeySpec skey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            plaintext = cipher.doFinal(ciphertext);
        }catch(Exception e){
            e.printStackTrace();
        }
        return plaintext;
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


}
