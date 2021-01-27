package utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encryptor {

    //TODO: Move this value to a config
    private static final String ENCRYPTION_KEY = "NCMEC";

    private Encryptor() {}

    private static String encrypt(String textToEncrypt) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(ENCRYPTION_KEY);
        return textEncryptor.encrypt(textToEncrypt);
    }

    public static String decrypt(String textToDecrypt) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(ENCRYPTION_KEY);
        return textEncryptor.decrypt(textToDecrypt);
    }

//    TODO: Move this method.
   /* public static void main(String[] args) {
        System.out.println("Encrypted value is: " + encrypt(""));
        System.out.println("Decrypted value is: " + decrypt(""));
    }*/

}