package com.generating.xml.fl.main;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;

public class Keymain {

    public static void main(String args[]){

        try {
            //GENERATING KEYSTORE
            KeyStore ks = KeyStore.getInstance("JCEKS");

            //PASSWORD PARA INICIAR EL KEYSTORE (NO TIENE QUE SER IGUAL AL KEY QUE SERA GUARDADO DENTRO DEL KEYSTORE)
            char[] pwdArray = "keystorepassword".toCharArray();
            char[] pwdkey = "secretkeypassword".toCharArray();


            ks.load(null, pwdArray);

            //SAVING KEYSTORE
            try (FileOutputStream fos = new FileOutputStream("tpagoKeyStore.jceks")) {
                ks.store(fos, pwdArray);
            }


            //FINDING AND LOADING KEYSTORE FOR USE (THIS SCENARIO KEYSTORE IS EMPTY)
//            KeyStore ksLoad = KeyStore.getInstance("JCEKS");
//            ks.load(new FileInputStream("tpagoKeyStore.jceks"), pwdArray);


//            CREATION SIMPLE KEY TO BE STORED IN KEYSTORE
            String algo = "HMACSHA256";
            KeyGenerator kgen = KeyGenerator.getInstance(algo);
            SecretKey skey = kgen.generateKey();
            System.out.println(skey);

            KeyStore.SecretKeyEntry secret = new KeyStore.SecretKeyEntry(skey);
            KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection(pwdkey);
        /* param list => alias: used as a reference
                         secret: key-encryption-combo
                         password: password to access the keystore */
            ks.setEntry("app-neo-secret", secret, password);


            //reading key from keystore
            Key ssoSigningKey = ks.getKey("app-neo-secret", pwdkey);
            //SAVING KEYSTORE
            try (FileOutputStream fos = new FileOutputStream("tpagoKeyStore.jceks")) {
                ks.store(fos, pwdArray);
            }
            System.out.println("Llave retornada from keystore =>" + ssoSigningKey);
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());

        }
    }



}
