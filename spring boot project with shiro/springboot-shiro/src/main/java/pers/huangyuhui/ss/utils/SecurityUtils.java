package pers.huangyuhui.ss.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @project: springboot-shiro
 * @description: 加密工具
 * @author: 黄宇辉
 * @date: 8/5/2019-9:09 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class SecurityUtils {

    public static void main(String[] args) {
        //admin-pwd [source:demo+salt:admin+hashIterations:3] :  257e3b15d67a9127d230175e43118e40
        //tea-pwd [source:demo+salt:tea+hashIterations:3] : f97ccdcf125073d5f19bd3de0b67eb40
        //stu-pwd [source:demo+salt:stu+hashIterations:3] : e1a1c9a1340d179077086b5dbee621b4
        String md5Pwd = new SimpleHash("md5", "demo", ByteSource.Util.bytes("stu"), 3).toHex();
        System.out.println(md5Pwd);
    }
}