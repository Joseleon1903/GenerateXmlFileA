package com.generating.xml.fl.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class IlluvatarMain {

    private static Logger log = LogManager.getLogger(IlluvatarMain.class);

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, KeyStoreException, IOException, UnrecoverableKeyException, CertificateException, NoSuchProviderException {

        char[] pwdArray = "KeyStoreMann@India*".toCharArray();
        KeyStore ks = KeyStore.getInstance("JCEKS");

        ks.load(new FileInputStream("tpagoKeyStore.jceks"), pwdArray);
        Key ssoSigningKey = ks.getKey("app-neo-secret", "KeyParamMannIndia%".toCharArray());
        SecretKey aesKey = new SecretKeySpec(ssoSigningKey.getEncoded(), "AES");
        log.debug("Llave retornada from keystore =>" + aesKey);
        log.debug("key in String :"+ Base64.getEncoder().encodeToString(aesKey.getEncoded()));


        log.debug("-------------------   IlluvatarMain  ------------------------------------");
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0OjgwOTQ0ODczNDg6MzU2OTM4MDM1NjQzODA5IiwiZXhwIjoxNTMzMzEyMTA1fQ.KtgrgVOVTMqowGq9QYqz9wTdaRFxYny4kRtgLIOkCkM";
        String aesPassword = "@T3STD4T4";
        //Prepare your key/password
        log.debug("token : "+ token);
        log.debug("AESPassword: "+ aesPassword);

        //SecretKey claveSecreta = generateSecretKey(aesPassword, new byte[12]);
        log.debug("generated secret Key....");
        // AES KEYGEN AND ENCRYPTION PROCESS
        log.debug("AES KEYGEN AND ENCRYPTION PROCESS");
        byte[] resultBytes = encryptData(aesKey, token.getBytes());
        log.debug("***-------AES ENCRYPTED DATA (BASE 64 ENCODED)------>>>>> " + Base64.getEncoder().encodeToString(resultBytes));
        // AES DECRYPTION PROCESS

        log.debug("***-----AES DECRYPTION BLOCK--------***");

        byte[] decryptedBytes = decryptData(aesKey, resultBytes);
        log.debug("***-------AES DECRYPTED DATA (BASE 64 ENCODED)------>>>>> " + Base64.getEncoder().encodeToString(decryptedBytes));

        String encodeBase64 = Base64.getEncoder().encodeToString(token.getBytes());
        log.debug("Encoded token 64: "+ encodeBase64);
        if(encodeBase64.equals( Base64.getEncoder().encodeToString(decryptedBytes))){
            log.debug("-------------------- You Win   --------------------------------");

        }
    }


    //AES 256 SECRET KEY GENERATOR
    public static SecretKey generateSecretKey(String password, byte [] saltBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {

        log.debug("AES 256 SECRET KEY GENERATOR");
        //GENERACION DE PARTE RANDOM CON SALT Y BASE 64
        log.debug("GENERACION DE PARTE RANDOM CON SALT Y BASE 64");
        Base64.Encoder encoder = Base64.getEncoder();
        SecureRandom srandom = new SecureRandom();
        byte[] salt = saltBytes;
        srandom.nextBytes(salt);
        System.out.println("Salt: " + encoder.encodeToString(salt));

        log.debug("GENRACION DE PASSWORD");
        //GENRACION DE PASSWORD
        char[] passwordChar = password.toCharArray();
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(passwordChar, salt, 65536, 256);
        SecretKey key = factory.generateSecret(spec);
        return key;
    }

    //AES DATA ENCRYPTION
    public static byte [] encryptData(SecretKey secretKey, byte [] data) throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException, NoSuchProviderException {
        log.debug("AES DATA ENCRYPTION");

        log.debug("Prepare the nonce");
        //Prepare the nonce
        SecureRandom secureRandom = new SecureRandom();

        log.debug("Noonce should be 12 bytes");
        //Noonce should be 12 bytes
        byte[] iv = new byte[12];
        secureRandom.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);

        log.debug("Encryption mode on!");
        //Encryption mode on!
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        log.debug("Encrypt the data");
        //Encrypt the data
        byte [] encryptedData = cipher.doFinal(data);

        log.debug("Concatenate everything and return the final data");
        log.debug("iv.length: "+ iv.length);
        log.debug("encryptedData.length: "+ encryptedData.length);

        //Concatenate everything and return the final data
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 + iv.length + encryptedData.length);
        byteBuffer.putInt(iv.length);
        byteBuffer.put(iv);
        byteBuffer.put(encryptedData);
        return byteBuffer.array();
    }


    public static byte [] decryptData(SecretKey secretKey, byte [] encryptedData)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException, NoSuchProviderException {

        log.debug("Wrap the data into a byte buffer to ease the reading process");

        //Wrap the data into a byte buffer to ease the reading process
        ByteBuffer byteBuffer = ByteBuffer.wrap(encryptedData);

        int noonceSize = byteBuffer.getInt();

        log.debug("Make sure that the file was encrypted properly");

        //Make sure that the file was encrypted properly
        if(noonceSize < 12 || noonceSize >= 16) {
            throw new IllegalArgumentException("Nonce size is incorrect. Make sure that the incoming data is an AES encrypted file.");
        }
        byte[] iv = new byte[12];
        byteBuffer.get(iv);

        //Prepare your key/password
        //SecretKey secretKey = generateSecretKey(key, iv);

        //get the rest of encrypted data
        log.debug("Prepare your key/password");
        log.debug("SecretKey secretKey = generateSecretKey(key, iv);");
        log.debug("get the rest of encrypted data");

        byte[] cipherBytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(cipherBytes);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);

        //Encryption mode on!
        log.debug("Encryption mode on!");

        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        //Encrypt the data
        log.debug("Encrypt the data");

        return cipher.doFinal(cipherBytes);

    }


}
