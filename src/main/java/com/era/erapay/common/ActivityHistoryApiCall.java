package com.era.erapay.common;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;
public class ActivityHistoryApiCall {
    public static void getHistory(CloseableHttpClient closeableHttpClientHistory, HttpPost httpPostHistory, List<NameValuePair> paramsHistory) throws IOException {
        CloseableHttpResponse closeableHttpResponseHistory;
        try {
            httpPostHistory.setEntity(new UrlEncodedFormEntity(paramsHistory));
            closeableHttpResponseHistory = closeableHttpClientHistory.execute(httpPostHistory);
            String responseString2 = EntityUtils.toString(closeableHttpResponseHistory.getEntity(), "UTF-8");
            System.out.println("RESPONSE HISTORY" + responseString2);
            JSONObject json = new JSONObject(responseString2);
            String historyResponseCode = json.getString("Response_Code");
            String historyresponseStatus = json.getString("Response_Status");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeableHttpClientHistory.close();
        }
    }

}
