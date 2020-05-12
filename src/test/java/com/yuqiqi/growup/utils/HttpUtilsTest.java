package com.yuqiqi.growup.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuyunbo on 2019/5/23.
 */
public class HttpUtilsTest {
    public static void main(String[] args) {
        String url = "https://my.oschina.net/u/3195939";
        Map<String, String> headInfo = new HashMap<>();
        headInfo.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        headInfo.put("Accept-Encoding", "gzip, deflate, br");
        headInfo.put("Accept-Language", "zh-CN,zh;q=0.9");
        headInfo.put("Cache-Control", "max-age=0");
        headInfo.put("Connection", "keep-alive");
        headInfo.put("Cookie", "gr_user_id=b7b8f71a-82a6-43c9-9123-683265007476; grwng_uid=7840fcf7-9ddd-4930-88ca-49dd85ba21a3; _user_behavior_=96db5e14-092e-4191-afb2-1b0788bb42b1; oscid=cdWxd2NMy5ShlqXNDpJJM77p%2Bu2L7EvjNIr2pIPCFu4eZDAlyqs13Gg8QZbvUicGaiBVF9avwHbPFzBBwlyK%2BJGKFhSq5%2FRb%2FAMp9HAot4EbjgujVqs3E2WKe2cvcya6muYhDIfPfOkr6G9ggjrbQWuHB%2BplNWbT; Hm_lvt_a411c4d1664dd70048ee98afe7b28f0b=1556347560,1558590225; aliyungf_tc=AQAAAHLV/mR8oQgAgLVQcPgiZ/A2d4Ui; Hm_lpvt_a411c4d1664dd70048ee98afe7b28f0b=1558590320\n");
        headInfo.put("Host", "my.oschina.net");
        headInfo.put("Upgrade-Insecure-Requests", "1");
        headInfo.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
        Map<String, String> parmas = new HashMap<>();
        String responeStr = HttpUtils.sendGetRequest(url, headInfo, parmas);
        System.out.print(responeStr);
    }
}
