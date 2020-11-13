package com.example.demo.yqcb;

import cn.hutool.core.util.StrUtil;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Description:
 * @author: lwg
 * @createTime: 2020年01月09日 12:04:00
 */
public class Base64Utils {

    public static String encodeBase64(String source) {
        if(StrUtil.isEmpty(source)){
            return "";
        }
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = new byte[0];
        try {
            bytes = source.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String retrunMsg = encoder.encodeToString(bytes);
       return retrunMsg.replace("%", "%25").replace("#", "%23")
               .replace("&", "%26").replace("+", "%2B")
               .replace("=", "%3D").replace(" ", "%20")
               .replace("/", "%2F").replace("\\", "%5C").
               replace("?", "%3F").replace(".", "%2E")
               .replace(":", "%3A");
    }

    public static String decodeBase64(String source) {
        if(StrUtil.isEmpty(source)){
            return "";
        }
        String replace = source.replace("%25", "%").replace("%23", "#").replace("%26", "&").replace("%2B", "+").replace("%3D", "=").replace("%20", " ").replace("%2F", "/").replace("%5C", "\\").replace("%3F", "?").replace("%2E", ".").replace("%3A", ":");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(replace.getBytes());
        String str = null;
        try {
            str = new String(decode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
