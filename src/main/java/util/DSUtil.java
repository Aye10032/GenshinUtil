package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 * @program: genshinutil
 * @className: DSUtil
 * @Description: 加密类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 4:17
 */
public class DSUtil {

    public static String getDS(String uid) {
        String time = (Calendar.getInstance().getTimeInMillis() + "").substring(0, 10);
        int random = 100001 + (int) (Math.random() * (200000 - 100001));
        String query = "role_id=" + uid + "&server=cn_gf01";
        String salt = "salt="+Data.CN_SALT+"&t=" + time + "&r=" + random + "&b=&q=" + query;
        MessageDigest md5Instance = null;
        try {
            md5Instance = MessageDigest.getInstance("MD5");
            md5Instance.update(salt.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md5Instance != null;
        byte[] digest = md5Instance.digest();

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int j = digest.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (byte byte0 : digest) {
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return time + "," + random + "," + new String(str);
    }

}
