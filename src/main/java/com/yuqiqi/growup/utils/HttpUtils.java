package com.yuqiqi.growup.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuyunbo on 2019/5/23.
 */
public class HttpUtils {


    public static String sendPostRequest(String url, Map<String, String> headInfo, Map<String, String> params) {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        httpPost.setHeaders(getHeadData(headInfo));
        List<NameValuePair> nameValuePairs = getRequestParam(params);
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, Charset.defaultCharset()));
        return executeRequest(closeableHttpClient,httpPost);
    }

    public static String sendGetRequest(String url, Map<String, String> headInfo, Map<String, String> params) {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(getHeadData(headInfo));

        return executeRequest(closeableHttpClient,httpGet);
    }

    private static String executeRequest(CloseableHttpClient closeableHttpClient,HttpRequestBase httpRequestBase){
        String responseStr = null;
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(httpRequestBase);
            HttpEntity httpEntity = response.getEntity();
            if(httpEntity != null){
                responseStr= EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    private static Header[] getHeadData(Map<String, String> headInfo) {
        List<Header> valuePairList = new ArrayList<>();
        for (String key : headInfo.keySet()) {
            valuePairList.add(new BasicHeader(key, headInfo.get(key)));
        }
        return valuePairList.toArray(new BasicHeader[0]);
    }

    private static List<NameValuePair> getRequestParam(Map<String, String> params) {
        List<NameValuePair> list = new ArrayList<>();
        for (String key : params.keySet()) {
            list.add(new BasicNameValuePair(key, params.get(key)));
        }
        return list;
    }
}
