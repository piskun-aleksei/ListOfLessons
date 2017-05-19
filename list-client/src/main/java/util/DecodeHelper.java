package util;

import java.io.UnsupportedEncodingException;

public class DecodeHelper {

    public static String decode(String parameter) throws UnsupportedEncodingException {
        return new String(parameter.getBytes("ISO-8859-1"), "UTF8");
    }

}