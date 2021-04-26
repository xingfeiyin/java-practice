package com.yinxf.weixin;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yinxf
 * @Date 2021/3/19
 * @Description  获取微信的openID
 **/
public class OpenIdTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        Map<String,String> params = new HashMap<>();
        params.put("appid","");
        params.put("secret","");
        params.put("js_code","");
        params.put("grant_type","authorization_code");
//        String result = HttpClientUtil.get("https://api.weixin.qq.com/sns/jscode2session?",params,60*1000);
//        JSONObject json = JSON.parseObject(result);
//        System.out.println(json);
//        if (json != null) {
//            //当请求成功HttpUtils
//            if (json.getString("errcode")==null) {
//                map.put("openid",json.getString("openid"));//用户的唯一标识
//                map.put("sessionKey",json.getString("session_key"));//会话密钥
//                if (json.getString("unionid") != null) {
//                    map.put("unionid", json.getString("unionid"));//用户在开放平台的唯一标识符
//                }
//            }else{
//                //当请求不成功的时候，将错误信息
//                map.put("errMessage",json.getString("errmsg"));
//            }
//        }
        System.out.println(JSON.toJSON(map));


    }
}
