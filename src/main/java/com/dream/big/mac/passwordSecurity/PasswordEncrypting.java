package com.dream.big.mac.passwordSecurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypting {
	
	
	/**
	 * Description:用户密码加密
	 * 作者 : 蒋晨    
	 * 时间 : 2018-4-14  下午15:08:35
	 */

	public static String getHashEnocde(String source) {  
        // 用来将字节转换成 16 进制表示的字符  
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};  
        StringBuilder sb = new StringBuilder();  
        MessageDigest md5;  
        try {  
            md5 = MessageDigest.getInstance("SHA");  
            md5.update(source.getBytes());  
            byte[] encryptStr = md5.digest();  
            for (int i = 0; i < encryptStr.length; i++) {  
                int iRet = encryptStr[i];  
                if (iRet < 0) {  
                    iRet += 256;  
                }  
                int iD1 = iRet / 16;  
                int iD2 = iRet % 16;  
                sb.append(hexDigits[iD1] + "" + hexDigits[iD2]);  
            }  
            return sb.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  

}