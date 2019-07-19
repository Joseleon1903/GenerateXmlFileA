package com.generating.xml.fl.main;

import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.security.KeyStore;

public class keyMainSecondSon {

    public static void main( String[] args) {

        try {
            //GENERATING KEYSTORE
            KeyStore ks = KeyStore.getInstance("JCEKS");

            //PASSWORD PARA INICIAR EL KEYSTORE (NO TIENE QUE SER IGUAL AL KEY QUE SERA GUARDADO DENTRO DEL KEYSTORE)
            char[] pwdArray = "KeyStoreMann@India*".toCharArray();
            ks.load(null, pwdArray);

            //SAVING KEYSTORE
            try (FileOutputStream fos = new FileOutputStream("tpagoKeyStore.jceks")) {
                ks.store(fos, pwdArray);
            }
             /* param list => alias: used as a reference
             secret: key-encryption-combo
             password: password to access the keystore */
            SecretKey secret = IlluvatarMain.generateSecretKey("SecretMannKeyIndia$", new byte[12]);
            KeyStore.SecretKeyEntry entryKey = new KeyStore.SecretKeyEntry(secret);
            KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection("KeyParamMannIndia%".toCharArray());
            ks.setEntry("app-neo-secret", entryKey, password);

            try (FileOutputStream fos = new FileOutputStream("tpagoKeyStore.jceks")) {
                ks.store(fos, pwdArray);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }




    }


}
