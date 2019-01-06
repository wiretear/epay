package com.era.erapay.Himel;


import com.era.erapay.bank.AddBankAccountForm;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class AccountController {
    @RequestMapping(value = "/addbankaccount")
    public String addbank(Model model, HttpServletRequest request, @ModelAttribute("oAddBankAccountForm")AddBankAccountForm oAddBankAccountForm , HttpServletResponse response) throws Exception {
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBankforRegistration.do");
        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("api_pass", "getallbank"));
        params1.add(new BasicNameValuePair("bankName", ""));
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            System.out.println("Response :" + responseString1);
            Map<String, String> map = new HashMap<String, String>();
            model.addAllAttributes(map);
            oAddBankAccountForm.setBankMapValue(map);
            JSONArray jsonArray = new JSONArray(responseString1);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = jsonArray.getJSONObject(i);
                String bankcod = c.getString("bankcod");
                String banknam = c.getString("banknam");
                map.put(bankcod, banknam);
                System.out.println("bankcod" + bankcod);
                System.out.println("banknam" + banknam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient1.close();
        }
            return "addbank";
    }
    @RequestMapping(value = "/banksearchaddbank",method = RequestMethod.GET)
    public String addbranch(Model model, HttpServletRequest request, @ModelAttribute("oAddBankAccountForm")AddBankAccountForm oAddBankAccountForm , HttpServletResponse response, @RequestParam("bankcode") String bankcode) throws Exception {
        HttpSession session = request.getSession(true);
        HashMap<String, String> map1 = new HashMap<String, String>();
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBranchforAddBank.do");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass", "getallbranch"));
        params.add(new BasicNameValuePair("bankcode", bankcode));
        params.add(new BasicNameValuePair("branchName", ""));
        model.addAllAttributes(map1);
        oAddBankAccountForm.setMapValue(map1);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response : " + responseString);
            oAddBankAccountForm.setBankName(bankcode);
            JSONArray jArray = new JSONArray(responseString);
            for(int i=0; i < jArray.length(); i++) {
                JSONArray jArray1 = (JSONArray)jArray.getJSONArray(i);
                for(int j=0; j < jArray1.length(); j=j+2) {
                    String branchCode = (String)jArray1.get(j);
                    String branchName = (String)jArray1.get(j+1);
                    System.out.println("Response : " + branchName);
                   map1.put(branchCode,branchName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBankforRegistration.do");
        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("api_pass", "getallbank"));
        params1.add(new BasicNameValuePair("bankName", ""));
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            //System.out.println("Response :" + responseString1);
            Map<String, String> map = new HashMap<String, String>();
            model.addAllAttributes(map);
            oAddBankAccountForm.setBankMapValue(map);
            JSONArray jsonArray = new JSONArray(responseString1);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = jsonArray.getJSONObject(i);
                String bankcod = c.getString("bankcod");
                String banknam = c.getString("banknam");
                map.put(bankcod, banknam);
               // System.out.println("bankcod" + bankcod);
               // System.out.println("banknam" + banknam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient1.close();
        }
        return "addbank";
    }
    @RequestMapping(value = "/account")
    public String formsuccsess(Model model, @ModelAttribute("oAddBankAccountForm")AddBankAccountForm oAddBankAccountForm, HttpServletRequest request, SessionStatus status, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("message", "");
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/userAccountVerify.do");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass", "acverify"));
        params.add(new BasicNameValuePair("userId", "SSL"));
        params.add(new BasicNameValuePair("password", "123"));
        params.add(new BasicNameValuePair("requestNo", "000456"));
        params.add(new BasicNameValuePair("customerId", "00045270"));
        params.add(new BasicNameValuePair("accountNo", ""));
        String code = " ";
        String message = " ";
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response : " + responseString);
            //JSONObject object = new JSONObject(responseString);
            //code = object.getString("Response_Code");
           // message = object.getString("Response_Status");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        if (code.equals("0")) {
            session.setAttribute("message", message);
            return "bankaccount";
        } else {
            session.setAttribute("message", message);
            return "bankaccount";
        }
    }
}
