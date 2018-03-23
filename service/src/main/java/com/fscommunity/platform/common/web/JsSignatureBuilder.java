package com.fscommunity.platform.common.web;

import com.fscommunity.platform.common.pojo.JsSignature;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-01-26
 */
@Service
public class JsSignatureBuilder {

    public JsSignature build(String ticket, String url) {
        JsSignature signature = new JsSignature();
        signature.setNonceStr(UUID.randomUUID().toString());
        signature.setTimestamp(Long.toString(System.currentTimeMillis() / 1000));
        signature.setJsapi_ticket(ticket);
        signature.setUrl(url);
        //注意这里参数名必须全部小写，且必须有序
        String string1 = "jsapi_ticket=" + signature.getJsapi_ticket() +
                "&noncestr=" + signature.getNonceStr() +
                "&timestamp=" + signature.getTimestamp() +
                "&url=" + url;

        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            String sig = byteToHex(crypt.digest());
            signature.setSignature(sig);
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }

        return signature;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
