/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.security;

/**
 *
 * @author kai.du
 */
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.*;
import javax.crypto.spec.SecretKeySpec; 
import javax.crypto.Mac;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;

public class EncryptionUtils {
    static private org.slf4j.Logger logger = LoggerFactory.getLogger(EncryptionUtils.class);
    static public String calculateSignature(String key,String hmac, String charset) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException{
       
        final Charset charSet = Charset.forName(charset);
        final Mac sha256_HMAC = Mac.getInstance(hmac);

        final SecretKeySpec secret_key = new javax.crypto.spec.SecretKeySpec(charSet.encode("key").array(), hmac);
   
        
        sha256_HMAC.init(secret_key);
    
        final byte[] mac_data = sha256_HMAC.doFinal(key.getBytes(charset));
        StringBuilder builder = new StringBuilder();
        for (final byte element : mac_data)
        {
           builder.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
       // System.out.println("Result:[" + result + "]");
        return builder.toString();
    }
    
    public static String shaEncode(String key, String data, String hmac, String charset) throws Exception {
        Mac sha256_HMAC = Mac.getInstance(hmac);
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(charset), hmac);
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes(charset)));
    }
    public static String base64UrlDecode(String input) {
        String result = null;
        Base64 decoder = new Base64(true);
        byte[] decodedBytes = decoder.decode(input);
        result = new String(decodedBytes,StandardCharsets.UTF_8);
        return result;
    }
     public static String base64UrlEncode(String input) {
        String result = null;
        Base64 encoder = new Base64(true);
        byte[] encodedBytes;
        try {
            //encoder.
            encodedBytes = encoder.encode(input.getBytes("UTF-8"));
             result = new String(encodedBytes,StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException ex) {
            logger.error(ex.getMessage());
        }
       
        return result;
    }
   
}
