package com.bsuir.piskun.util;

import com.bsuir.piskun.exceptions.HashCreationException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCreator {

    public static boolean comparePasswords(String toCheck, String realPassw) throws HashCreationException {
        return countHash(toCheck).equals(realPassw);
    }

    public static String encryptWithMD5(String pass) throws HashCreationException{
        return countHash(pass);
    }

    private static String countHash(String string) throws HashCreationException{
        String output;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            output = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new HashCreationException("No such algorithm", e);
        }
        return output;
    }
}
