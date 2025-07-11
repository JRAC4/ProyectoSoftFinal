/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class Encriptar {

    // Clave de 16 caracteres (128 bits)
    private static final String CLAVE_SECRETA = "1234567890abcdef";

    // Método para encriptar texto
    public static String encriptar(String texto) {
        try {
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            byte[] cifrado = cipher.doFinal(texto.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cifrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar", e);
        }
    }

    // Método para desencriptar texto
    public static String desencriptar(String textoCifrado) {
        try {
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, clave);
            byte[] decodificado = Base64.getDecoder().decode(textoCifrado);
            byte[] original = cipher.doFinal(decodificado);
            return new String(original, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("Error al desencriptar", e);
        }
    }
}
