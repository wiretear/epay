package com.era.erapay.wallet;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.era.erapay.common.ActivityHistoryApiCall;
import com.era.erapay.common.IpFinder;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.era.erapay.Fund.LoadFundForm;


@Controller
public class tes {
    IpFinder ipFinder =new IpFinder();
    ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
    Date today = Calendar.getInstance().getTime();
    String dateAndTime = df.format(today);
    @RequestMapping(value= "/erapay/1")
    public String walletowallet(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("owallettowallet")WalletToWalletForm owallettowallet) throws IOException {
        HttpSession session = request.getSession(true);
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl="/erapay/wallettowallet";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
        paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        session.setAttribute("WalletMsg", " ");
        return "wallet";
    }


    @RequestMapping(value= "/erapay/12")
    public String dowalletowallet(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("owallettowallet")WalletToWalletForm owallettowallet) throws IOException {

        HttpSession session = request.getSession(true);
        String outCode="";
        String outMessage="";
        String userID = (String) session.getAttribute("GSMAILID");
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String signInApiUrl="http://10.11.201.169:8080/ERAPAY/signInRest.do";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", signInApiUrl));
        paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
        paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();;
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/waltowaltransfer.do");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String walletIdCredit = (String) session.getAttribute("WALLETIDCREDIT");
        String walletId = (String) session.getAttribute("LoginWalletId");
        String amount= (String) session.getAttribute("WALLETAMOUNT");
        String narration= (String) session.getAttribute("WALLETNarration");
        System.out.println ("wallet test"+reportDate);
        List<NameValuePair> params = new ArrayList<>();
        //Map<String,Object> dateValue = new HashMap<String,Object>()
        // params.add(new BasicNameValuePair("action","addbank"));
        params.add(new BasicNameValuePair("api_pass","D"));
        params.add(new BasicNameValuePair("docnum","123"));
        params.add(new BasicNameValuePair("doctyp","FND"));
        params.add(new BasicNameValuePair("oprcod","1"));
        params.add(new BasicNameValuePair("trndat",reportDate));
        params.add(new BasicNameValuePair("debit_walletid",walletId));
        params.add(new BasicNameValuePair("narration",narration));
        params.add(new BasicNameValuePair("emailID",userID));
        params.add(new BasicNameValuePair("drcrcd","D"));
        params.add(new BasicNameValuePair("curcde","BDT"));
        params.add(new BasicNameValuePair("exrate","1"));
        params.add(new BasicNameValuePair("trnamt",amount));
        params.add(new BasicNameValuePair("destwalletid",""));
        params.add(new BasicNameValuePair("srcrefno1",""));
        params.add(new BasicNameValuePair("srcrefno2",""));
        params.add(new BasicNameValuePair("srcrefno3",""));
        params.add(new BasicNameValuePair("srcrefno4",""));
        params.add(new BasicNameValuePair("narration",""));
        params.add(new BasicNameValuePair("terminalId",""));
        params.add(new BasicNameValuePair("oprstamp",userID));
        params.add(new BasicNameValuePair("timestamp",reportDate));
        System.out.println(params);
        //params.add((NameValuePair) dateValue.put("timstamp", date));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            System.out.println("Response ===== >>>>> "+responseString);
            //String DataResponse = responseString.replace("[", "").replace("]", "");
            //     result += responseBody;

            //       System.out.println("Response ===== >>>>> "+closeableHttpResponse);

        }catch(Exception e){

            e.printStackTrace();

        } finally {
            httpclient.close();
        }
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();;
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/waltowaltransfer.do");


        System.out.println ("wallet test"+owallettowallet.getAmount());
        List<NameValuePair> params1 = new ArrayList<>();
        //Map<String,Object> dateValue = new HashMap<String,Object>()
        //params.add(new BasicNameValuePair("action","addbank"));
        params1.add(new BasicNameValuePair("api_pass","C"));
        params1.add(new BasicNameValuePair("emailID",userID));
        params1.add(new BasicNameValuePair("debit_walletid",walletIdCredit));
        params1.add(new BasicNameValuePair("narration",narration));
        params1.add(new BasicNameValuePair("docnum","123"));
        params1.add(new BasicNameValuePair("doctyp","FND"));
        params1.add(new BasicNameValuePair("oprcod","1"));
        params1.add(new BasicNameValuePair("trndat",reportDate));
        params1.add(new BasicNameValuePair("walletid",walletIdCredit));
        params1.add(new BasicNameValuePair("drcrcd","C"));
        params1.add(new BasicNameValuePair("curcde","BDT"));
        params1.add(new BasicNameValuePair("exrate","1"));
        params1.add(new BasicNameValuePair("trnamt",amount));
        params1.add(new BasicNameValuePair("destwalletid",""));
        params1.add(new BasicNameValuePair("srcrefno1",""));
        params1.add(new BasicNameValuePair("srcrefno2",""));
        params1.add(new BasicNameValuePair("srcrefno3",""));
        params1.add(new BasicNameValuePair("srcrefno4",""));
        params1.add(new BasicNameValuePair("narration",""));
        params1.add(new BasicNameValuePair("terminalId",""));
        params1.add(new BasicNameValuePair("oprstamp",userID));
        params1.add(new BasicNameValuePair("timestamp",reportDate));


        //params.add((NameValuePair) dateValue.put("timstamp", date));

        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString = EntityUtils.toString(closeableHttpResponse1.getEntity(),"UTF-8");
            System.out.println("Response ===== >>>>> "+responseString);

            String[] parts = responseString.split(",");
            outMessage=parts[0];
            outCode=parts[1];
            //String DataResponse = responseString.replace("[", "").replace("]", "");
            //     result += responseBody;

            //       System.out.println("Response ===== >>>>> "+closeableHttpResponse);

        }catch(Exception e){

            e.printStackTrace();

        } finally {
            httpclient.close();
        }
        if (outCode.equals("0")) {
            //session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());
            session.setAttribute("WalletMsg","Transaction Completed Successfully");
            return "addbanktest";
        }
        else
        {
            session.setAttribute("WalletMsg","Transaction Completed Successfully");
            return "addbanktest";
        }
    }


}
