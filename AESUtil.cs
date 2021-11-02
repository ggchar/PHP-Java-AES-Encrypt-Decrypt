using System;
using System.Security.Cryptography;
using System.Text;

namespace APEXDebuggingSoftware.Tools
{
    class AESUtil
    {
        public static string EncryptBase64(string plaintext, string key)
        {
            try
            {
                byte[] plaintextByte = Encoding.UTF8.GetBytes(plaintext);
                byte[] ciphertextByte = EncryptByte(plaintextByte, key);
                return Convert.ToBase64String(ciphertextByte, 0, ciphertextByte.Length);
            }
            catch
            {
                return null;
            }
        }

        public static string DecryptBase64(string ciphertext, string key)
        {
            try
            {
                byte[] ciphertextByte = Convert.FromBase64String(ciphertext);
                byte[] plaintextByte = DecryptByte(ciphertextByte, key);
                return Encoding.UTF8.GetString(plaintextByte);
            }
            catch
            {
                return null;
            }
        }

        public static string EncryptHexStr(string plaintext, string key)
        {
            try
            {
                byte[] plaintextByte = Encoding.UTF8.GetBytes(plaintext);
                byte[] ciphertextByte = EncryptByte(plaintextByte, key);
                return ParseByte2HexStr(ciphertextByte);
            }
            catch
            {
                return null;
            }
        }

        public static string DecryptHexStr(string ciphertext, string key)
        {
            try
            {
                byte[] ciphertextByte = ParseHexStr2Byte(ciphertext);
                byte[] plaintextByte = DecryptByte(ciphertextByte, key);
                return Encoding.UTF8.GetString(plaintextByte);
            }
            catch
            {
                return null;
            }
        }

        public static byte[] EncryptByte(byte[] plaintext, string key)
        {
            RijndaelManaged rm = new RijndaelManaged
            {
                Key = Encoding.UTF8.GetBytes(key),
                Mode = CipherMode.ECB,
                Padding = PaddingMode.PKCS7
            };

            ICryptoTransform cTransform = rm.CreateEncryptor();
            return cTransform.TransformFinalBlock(plaintext, 0, plaintext.Length);
        }

        public static byte[] DecryptByte(byte[] ciphertext, string key)
        {
            RijndaelManaged rm = new RijndaelManaged
            {
                Key = Encoding.UTF8.GetBytes(key),
                Mode = CipherMode.ECB,
                Padding = PaddingMode.PKCS7
            };

            ICryptoTransform cTransform = rm.CreateDecryptor();
            return cTransform.TransformFinalBlock(ciphertext, 0, ciphertext.Length);
        }

        public static byte[] ParseHexStr2Byte(string hexStr)
        {
            if (hexStr == null || hexStr.Length < 1)
                return null;
            hexStr = hexStr.Replace(" ", "");
            if ((hexStr.Length % 2) != 0)
                hexStr += " ";
            byte[] result = new byte[hexStr.Length / 2];
            for (int i = 0; i < result.Length; i++)
                result[i] = Convert.ToByte(hexStr.Substring(i * 2, 2), 16);

            return result;
        }

        public static string ParseByte2HexStr(byte[] buf)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < buf.Length; i++)
            {
                string hex = Convert.ToString(buf[i], 16).PadLeft(2, '0');
                sb.Append(hex.ToLower());
            }
            return sb.ToString();
        }

    }
}
