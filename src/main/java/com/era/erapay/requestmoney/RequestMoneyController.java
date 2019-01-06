package com.era.erapay.requestmoney;

import com.era.erapay.KYC.KycForm;
import com.era.erapay.common.ActivityHistoryApiCall;
import com.era.erapay.common.IpFinder;
import com.era.erapay.wallet.WalletToWalletForm;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class RequestMoneyController {
    IpFinder ipFinder =new IpFinder();
    ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
    Date today = Calendar.getInstance().getTime();
    String dateAndTime = df.format(today);
    String walletCurrencyResponseCode="";

    //Request Money Acknowledgement
    @RequestMapping(value= "/erapay/requestmoney")
    public String requestmoney(Model model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("orequestmoney") RequestMoneyForm orequestmoney) throws IOException {
        HttpSession session = request.getSession(true);
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");
        String userID = (String) session.getAttribute("GSMAILID");
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
        return "RequestMoney";
    }
    @RequestMapping(value= "/erapay/requestmoneyacknowledgement")
    public String requestmoneyacknowledgement(Model model, HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("oRequestMoneyForm") RequestMoneyForm oRequestMoneyForm) throws IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("REQUESTMONEYAKNOLWDGEMENTMSG"," ");
        String userID = (String) session.getAttribute("GSMAILID");
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");
        String walletId= (String) session.getAttribute("LoginWalletId");
        System.out.println("WalletID"+walletId);
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl="/erapay/requestmoneyacknowledgement";
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
        String walletID= (String) session.getAttribute("LoginWalletId");
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/searchRequestTransactionforMoney.do");
        //Map<String,Object> dateValue = new HashMap<String,Object>();
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("api_pass", "searchrequest"));
        params.add(new BasicNameValuePair("walletid",walletId ));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString);
            StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
            ArrayList<RequestMoneyForm> listOfResponse = new ArrayList<RequestMoneyForm>();
            int i = 0;
            RequestMoneyForm oRequestMoneyForm1 = new RequestMoneyForm();

            while (multiTokenizer.hasMoreTokens()) {
                String elem = multiTokenizer.nextToken();
                elem = elem.replace("[", "").replace("]", "").replace("\"", "");
                System.out.println("elem1111===>> " + elem);
                if (i % 7 == 0) {
                    System.out.println("elemTest1===>> " + elem);
                    oRequestMoneyForm1.setWalletId(elem);
                }
                else if (i % 7 == 1){
                    System.out.println("elemTest2===>> " + elem);
                    oRequestMoneyForm1.setName(elem);
                }
                else if (i % 7 == 2){
                    System.out.println("elemTest3===>> " + elem);
                    oRequestMoneyForm1.setRequestId(elem);
                }
                else if (i % 7 == 3) {
                    System.out.println("elemTest4===>> " + elem);
                  //  oRequestMoneyForm1.setAmount(elem);
                }
                else if (i % 7 == 4) {
                    System.out.println("elemTest5===>> " + elem);
                     oRequestMoneyForm1.setDate(elem);
                }
                else if (i % 7 == 5) {
                    System.out.println("elemTest6===>> " + elem);
                    oRequestMoneyForm1.setAmount(elem);
                }
                else if (i % 7 == 6) {
                    System.out.println("elemTest6===>> " + elem);
                    oRequestMoneyForm1.setNarration(elem);
                    listOfResponse.add(oRequestMoneyForm1);
                    oRequestMoneyForm1 = new RequestMoneyForm();
                }

                ++i;
            }
            oRequestMoneyForm.setTransctionHistoryList(listOfResponse);
           // session.setAttribute("transactionList", listOfResponse);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient.close();
        }
        return "RequestMoneyAcknowledgement";

    }
    @RequestMapping(value = "/erapay/executerequestmoneyotp")
    public String walletowalletotp(Model model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("orequestmoney") RequestMoneyForm orequestmoney) throws IOException {

        HttpSession session = request.getSession(true);
        String iP = ipFinder.getIp(request);
        String sessionId = (String) session.getAttribute("SESSIONID");
        String mailId = (String) session.getAttribute("photoemailid");
        String walletID = (String) session.getAttribute("LoginWalletId");
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl = "/erapay/executewalletowalletotp";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        session.setAttribute("REQUESTWALLETAMOUNT", orequestmoney.getAmount());
        session.setAttribute("REQUESTWALLETID", orequestmoney.getWalletId());
        session.setAttribute("REQUESTWALLETNarration", orequestmoney.getNarration());
        session.setAttribute("REQUESTNAME", orequestmoney.getName());
        String walletTowalletBtnValue = request.getParameter("requestbutton");
        orequestmoney.setButtonValue(walletTowalletBtnValue);
        System.out.println("Value oF button"+walletTowalletBtnValue);
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
        paramsHistory.add(new BasicNameValuePair("actionouttime", dateAndTime));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("ip_remote", iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        // Print what date is today!

        CloseableHttpResponse walletCurcloseableHttpResponse = null;
        CloseableHttpClient walletCurhttpclient = HttpClients.createDefault();
        HttpPost walletCurhttpclienthttpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/userAccountCurrentBalance.do");
        List<NameValuePair> walletCurhttpclienthttpPostparams = new ArrayList<>();
        //Map<String,Object> dateValue = new HashMap<String,Object>()
        // params.add(new BasicNameValuePair("action","addbank"));
        walletCurhttpclienthttpPostparams.add(new BasicNameValuePair("api_pass", "currentbalance"));
        walletCurhttpclienthttpPostparams.add(new BasicNameValuePair("walletid", walletID));
        System.out.println(walletCurhttpclienthttpPostparams);
        //params.add((NameValuePair) dateValue.put("timstamp", date));
        try {
            walletCurhttpclienthttpPost.setEntity(new UrlEncodedFormEntity(walletCurhttpclienthttpPostparams));
            walletCurcloseableHttpResponse = walletCurhttpclient.execute(walletCurhttpclienthttpPost);
            String responseString = EntityUtils.toString(walletCurcloseableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);
            walletCurrencyResponseCode = json.getString("Response_Code");
            Number walletCurrency = json.getNumber("Current_Balance");
            NumberFormat formatter = new DecimalFormat("#0.00");
            String formattedwalletCurrency=formatter.format(walletCurrency);
            System.out.println("Response ===== >>>>> " + walletCurrency);
            session.setAttribute("CURWALLETBALANCE",formattedwalletCurrency);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            walletCurhttpclient.close();
        }
        return "RequestMoney";
    }

    @RequestMapping(value = "/erapay/executerequestotp")
    public String dowalletowallet(Model model, HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("orequestmoney") RequestMoneyForm orequestmoney) throws IOException {

        HttpSession session = request.getSession(true);
        String outCode = "";
        String outMessage = "";
        String debitResponseCode="";
        String debitResponseStatus="";
        String userName=(String) session.getAttribute("GSUSERNAME");
        String userID = (String) session.getAttribute("GSMAILID");
        String iP = ipFinder.getIp(request);
        String sessionId = (String) session.getAttribute("SESSIONID");
        String mailId = (String) session.getAttribute("photoemailid");
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String signInApiUrl = "http://10.11.201.169:8080/ERAPAY/signInRest.do";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", signInApiUrl));
        paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
        paramsHistory.add(new BasicNameValuePair("actionouttime", dateAndTime));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("ip_remote", iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        System.out.println("DATA"+ orequestmoney.getAmount());
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/sendRequestforMoney.do");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String amount = (String) session.getAttribute("REQUESTWALLETAMOUNT");
        String walletId = (String) session.getAttribute("REQUESTWALLETID");
        String name = (String) session.getAttribute("REQUESTNAME");
        String narration = (String) session.getAttribute("REQUESTWALLETNarration");
        System.out.println("wallet test" + reportDate);
        List<NameValuePair> params = new ArrayList<>();
        String senderwalletId= (String) session.getAttribute("LoginWalletId");
        System.out.println("Debit"+senderwalletId);
        //Map<String,Object> dateValue = new HashMap<String,Object>()
        // params.add(new BasicNameValuePair("action","addbank"));
        params.add(new BasicNameValuePair("api_pass", "requestmoney"));
        params.add(new BasicNameValuePair("reqid", " "));
        params.add(new BasicNameValuePair("walletid", walletId));
        params.add(new BasicNameValuePair("reqtype", "WW"));
        params.add(new BasicNameValuePair("reqDate", reportDate));
        params.add(new BasicNameValuePair("tranamt", amount));
        params.add(new BasicNameValuePair("narration", narration));
        params.add(new BasicNameValuePair("oprstamp", userID));
        params.add(new BasicNameValuePair("timestamp", reportDate));
        params.add(new BasicNameValuePair("tranid", " "));
        params.add(new BasicNameValuePair("trandate", " "));
        params.add(new BasicNameValuePair("tranby", ""));
        params.add(new BasicNameValuePair("tranflg", ""));
        params.add(new BasicNameValuePair("name", userName));
        params.add(new BasicNameValuePair("senderwalletid", senderwalletId));

        System.out.println(params);
        //params.add((NameValuePair) dateValue.put("timstamp", date));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);
            debitResponseCode = json.getString("Response_Code");
            debitResponseStatus = json.getString("Response_Status");
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            httpclient.close();
        }
		/*
		if (debitResponseCode.equals("0")){
			CloseableHttpResponse closeableHttpResponse1 = null;
			CloseableHttpClient httpclient1 = HttpClients.createDefault();
			HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/waltowaltransfer.do");
			System.out.println("wallet test" + owallettowallet.getAmount());
			List<NameValuePair> params1 = new ArrayList<>();
			//Map<String,Object> dateValue = new HashMap<String,Object>()
			//params.add(new BasicNameValuePair("action","addbank"));
			params1.add(new BasicNameValuePair("api_pass", "C"));
			params1.add(new BasicNameValuePair("emailID", userID));
			params1.add(new BasicNameValuePair("debit_walletid", walletId));
			params1.add(new BasicNameValuePair("narration", narration));
			params1.add(new BasicNameValuePair("docnum", "123"));
			params1.add(new BasicNameValuePair("doctyp", "FND"));
			params1.add(new BasicNameValuePair("oprcod", "1"));
			params1.add(new BasicNameValuePair("trndat", reportDate));
			params1.add(new BasicNameValuePair("walletid", walletIdCredit));
			params1.add(new BasicNameValuePair("drcrcd", "C"));
			params1.add(new BasicNameValuePair("curcde", "BDT"));
			params1.add(new BasicNameValuePair("exrate", "1"));
			params1.add(new BasicNameValuePair("trnamt", amount));
			params1.add(new BasicNameValuePair("destwalletid", ""));
			params1.add(new BasicNameValuePair("srcrefno1", ""));
			params1.add(new BasicNameValuePair("srcrefno2", ""));
			params1.add(new BasicNameValuePair("srcrefno3", ""));
			params1.add(new BasicNameValuePair("srcrefno4", ""));
			params1.add(new BasicNameValuePair("narration", ""));
			params1.add(new BasicNameValuePair("terminalId", ""));
			params1.add(new BasicNameValuePair("oprstamp", userID));
			params1.add(new BasicNameValuePair("timestamp", reportDate));
			System.out.println(params1);
			//params.add((NameValuePair) dateValue.put("timstamp", date));
			try {
				httpPost1.setEntity(new UrlEncodedFormEntity(params1));
				closeableHttpResponse1 = httpclient1.execute(httpPost1);
				String responseString = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString);
				String[] parts = responseString.split(",");
				outMessage = parts[0];
				outCode = parts[1];
				//String DataResponse = responseString.replace("[", "").replace("]", "");
				//         result += responseBody;
				//       System.out.println("Response ===== >>>>> "+closeableHttpResponse);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				httpclient.close();
			}
		}
		*/
        if (debitResponseCode.equals("0")) {
            String walletID = (String) session.getAttribute("LoginWalletId");
            CloseableHttpResponse walletCurcloseableHttpResponse = null;
            CloseableHttpClient walletCurhttpclient = HttpClients.createDefault();
            HttpPost walletCurhttpclienthttpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/userAccountCurrentBalance.do");
            List<NameValuePair> walletCurhttpclienthttpPostparams = new ArrayList<>();
            //Map<String,Object> dateValue = new HashMap<String,Object>()
            // params.add(new BasicNameValuePair("action","addbank"));
            walletCurhttpclienthttpPostparams.add(new BasicNameValuePair("api_pass", "currentbalance"));
            walletCurhttpclienthttpPostparams.add(new BasicNameValuePair("walletid", walletID));
            System.out.println(walletCurhttpclienthttpPostparams);
            //params.add((NameValuePair) dateValue.put("timstamp", date));
            try {
                walletCurhttpclienthttpPost.setEntity(new UrlEncodedFormEntity(walletCurhttpclienthttpPostparams));
                walletCurcloseableHttpResponse = walletCurhttpclient.execute(walletCurhttpclienthttpPost);
                String responseString = EntityUtils.toString(walletCurcloseableHttpResponse.getEntity(), "UTF-8");
                System.out.println("Response ===== >>>>> " + responseString);
                JSONObject json = new JSONObject(responseString);
                walletCurrencyResponseCode = json.getString("Response_Code");
                Number walletCurrency = json.getNumber("Current_Balance");
                NumberFormat formatter = new DecimalFormat("#0.00");
                String formattedwalletCurrency=formatter.format(walletCurrency);
                System.out.println("Response ===== >>>>> " + walletCurrency);
                session.setAttribute("CURWALLETBALANCE",formattedwalletCurrency);

            } catch (Exception e) {

                e.printStackTrace();

            } finally {
                walletCurhttpclient.close();
            }
            //session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());
            session.setAttribute("WalletMsg", debitResponseStatus);
            session.setAttribute("WALLETAMOUNT", " ");
            session.setAttribute("WALLETIDCREDIT", " ");
            session.setAttribute("WALLETNarration", " ");
            return "RequestMoney";
        }
        else {
            session.setAttribute("WalletMsg", debitResponseStatus);
            return "RequestMoney";
        }
    }
    @RequestMapping(value = "/erapay/requestwalletsearch")
    public String requestwalletsearch(Model model, @ModelAttribute("owallettowallet") WalletToWalletForm owallettowallet, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        //	session.setAttribute("LOADFUNDAMOUNT",oLoadFundForm.getAmount());
        String cusCode = (String) session.getAttribute("CUSCODE");
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/searchDestinationWalletID.do");
        //Map<String,Object> dateValue = new HashMap<String,Object>();
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("api_pass", "serachwalletid"));
        params.add(new BasicNameValuePair("walletID", ""));
        params.add(new BasicNameValuePair("Name", ""));
        params.add(new BasicNameValuePair("MobileNo", ""));
        params.add(new BasicNameValuePair("customerID", cusCode));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject obj = new JSONObject(responseString);
            JSONArray arr = obj.getJSONArray("walletid");
            JSONArray arr1 = obj.getJSONArray("mobileno");
            JSONArray arr2 = obj.getJSONArray("username");
            ArrayList<WalletToWalletForm> listOfResponse = new ArrayList<WalletToWalletForm>();
            for (int i = 0; i < arr.length(); i++) {
                String walletid_FromJson=arr.getString(i);
                String mobileno_FromJson=arr1.getString(i);
                String username_FromJson=arr2.getString(i);
                WalletToWalletForm walletList = new WalletToWalletForm();
                walletList.setWalletId(walletid_FromJson);
                walletList.setMobileNO(mobileno_FromJson);
                walletList.setName(username_FromJson);
                listOfResponse.add(walletList);

            }
            owallettowallet.setWalletSearchList(listOfResponse);
			/*
			JSONObject obj = new JSONObject(responseString);
			JSONArray arr = obj.getJSONArray("walletid");
			JSONArray arr1 = obj.getJSONArray("mobileno");
			JSONArray arr2 = obj.getJSONArray("username");
			ArrayList listOfResponse = new ArrayList();
			ArrayList listOfResponse1 = new ArrayList();
			ArrayList listOfResponse2 = new ArrayList();
			System.out.println("EEE" + arr);
			System.out.println("EEE" + arr1);
           // WalletToWalletForm owallettowallet1 = new WalletToWalletForm();
		//	WalletToWalletForm owallettowallet2 = new WalletToWalletForm();
			//WalletToWalletForm owallettowallet3 = new WalletToWalletForm();
			int k=0;
            while(k < arr.length()) {
                WalletToWalletForm owallettowallet1 = new WalletToWalletForm();
				String walletId = (String) arr.get(k);
				owallettowallet1.setWalletId(walletId);
				listOfResponse.add(owallettowallet1);
				k++;
			}
            owallettowallet.setWalletSearchList(listOfResponse);
			int i=0;
			while(i < arr1.length()) {
                WalletToWalletForm owallettowallet2 = new WalletToWalletForm();
				String mobileno = (String) arr1.get(i);
                owallettowallet2.setMobileNO(mobileno);
				listOfResponse1.add(owallettowallet2);
				i++;
				//owallettowallet2 = new WalletToWalletForm();
			}
			owallettowallet.setMobileNoSearchList(listOfResponse1);
			int j=0;
            while(j < arr2.length()) {
                WalletToWalletForm owallettowallet3 = new WalletToWalletForm();
				String name = (String) arr2.get(j);
				owallettowallet3.setName(name);
				listOfResponse2.add(owallettowallet3);
				j++;
				//owallettowallet3 = new WalletToWalletForm();
			}
			owallettowallet.setNameSearchList(listOfResponse2);
   	                /*
   	                ArrayList<WalletToWalletForm> listOfResponse = new ArrayList<WalletToWalletForm>();
	                int i =0 ;
	                WalletToWalletForm owallettowallet1 = new WalletToWalletForm();
	                StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
	        		while (multiTokenizer.hasMoreTokens())
	        		{
	        			String elem = multiTokenizer.nextToken();
	        			elem=elem.replace("[", "").replace("]", "").replace("\"", "");
	        			 if( i%3 == 0 ){
	        				 System.out.println("elem0===>> "+elem);
	        				 owallettowallet1.setWalletId(elem);
	        			 }
	        			 else if( i%3 == 1){
	        				 owallettowallet1.setName(elem);
	        				 System.out.println("elem1===>> "+elem);
	        			 }
	        			 else if( i%3 == 2 ){
	        				 System.out.println("elem2===>> "+elem);
	        				 owallettowallet1.setMobileNO(elem);
	        				 listOfResponse.add(owallettowallet1);
	        				 owallettowallet1 = new WalletToWalletForm();
	        			 }

	        			 ++i;
		        	}
	        		owallettowallet.setWalletSearchList(listOfResponse);
	        		*/
            JSONArray topArray = null;
            try {
                // Getting your top array
                //THIS IS NOT NEEDED ANYMORE
                //topArray = json.getJSONArray(jsonString);
                //use this instead

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient.close();
        }
        String iP = ipFinder.getIp(request);
        String sessionId = (String) session.getAttribute("SESSIONID");
        String mailId = (String) session.getAttribute("photoemailid");
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl = "/erapay/walletsearch";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
        paramsHistory.add(new BasicNameValuePair("actionouttime", dateAndTime));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("ip_remote", iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        return "requestwalletsearch";
    }



    @RequestMapping(value = "/erapay/updaterequestmoney")
    public String updaterequestmoney(Model model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("oRequestMoneyFormtest") RequestMoneyForm oRequestMoneyFormtest,@RequestParam String amount,@RequestParam String optradio,@RequestParam String requestId,@RequestParam String date,@RequestParam  String walletId) throws IOException {
        HttpSession session = request.getSession(true);
        String iP = ipFinder.getIp(request);
        String erroCode=" ";
        String errorMesage=" ";
        String sessionId = (String) session.getAttribute("SESSIONID");
        String mailId = (String) session.getAttribute("photoemailid");
        String userID = (String) session.getAttribute("GSMAILID");
        System.out.println("TEST ALL DATA"+walletId+amount+optradio);
        String walletID = (String) session.getAttribute("LoginWalletId");
      //  CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        //String apiUrl = "/erapay/executewalletowalletotp";
        //HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/updateRequestTransactionforMoney.do");

       // activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        // Print what date is today!

        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //tpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/searchDestinationWalletID.do");
        //Map<String,Object> dateValue = new HashMap<String,Object>();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/updateRequestTransactionforMoney.do");
        //Map<String,Object> dateValue = new HashMap<String,Object>();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass", "updaterequest"));
        params.add(new BasicNameValuePair("trandate", dateAndTime));
        params.add(new BasicNameValuePair("tranamount", amount));
        params.add(new BasicNameValuePair("walletid", walletID));
        params.add(new BasicNameValuePair("tranby", userID));
        params.add(new BasicNameValuePair("tranflg", optradio));
        params.add(new BasicNameValuePair("senderwalletid", walletId));
        params.add(new BasicNameValuePair("reqstid", requestId));
        params.add(new BasicNameValuePair("curcde", "BDT"));
        params.add(new BasicNameValuePair("doctyp", "Send"));
        params.add(new BasicNameValuePair("userid", iP));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response U{DATE ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);
            erroCode=json.getString("Response_Code");
             errorMesage=json.getString("Response_Status");
             session.setAttribute("REQUESTMONEYAKNOLWDGEMENTMSG",errorMesage);
            ArrayList<WalletToWalletForm> listOfResponse = new ArrayList<WalletToWalletForm>();

			/*
			JSONObject obj = new JSONObject(responseString);
			JSONArray arr = obj.getJSONArray("walletid");
			JSONArray arr1 = obj.getJSONArray("mobileno");
			JSONArray arr2 = obj.getJSONArray("username");
			ArrayList listOfResponse = new ArrayList();
			ArrayList listOfResponse1 = new ArrayList();
			ArrayList listOfResponse2 = new ArrayList();
			System.out.println("EEE" + arr);
			System.out.println("EEE" + arr1);
           // WalletToWalletForm owallettowallet1 = new WalletToWalletForm();
		//	WalletToWalletForm owallettowallet2 = new WalletToWalletForm();
			//WalletToWalletForm owallettowallet3 = new WalletToWalletForm();
			int k=0;
            while(k < arr.length()) {
                WalletToWalletForm owallettowallet1 = new WalletToWalletForm();
				String walletId = (String) arr.get(k);
				owallettowallet1.setWalletId(walletId);
				listOfResponse.add(owallettowallet1);
				k++;
			}
            owallettowallet.setWalletSearchList(listOfResponse);
			int i=0;
			while(i < arr1.length()) {
                WalletToWalletForm owallettowallet2 = new WalletToWalletForm();
				String mobileno = (String) arr1.get(i);
                owallettowallet2.setMobileNO(mobileno);
				listOfResponse1.add(owallettowallet2);
				i++;
				//owallettowallet2 = new WalletToWalletForm();
			}
			owallettowallet.setMobileNoSearchList(listOfResponse1);
			int j=0;
            while(j < arr2.length()) {
                WalletToWalletForm owallettowallet3 = new WalletToWalletForm();
				String name = (String) arr2.get(j);
				owallettowallet3.setName(name);
				listOfResponse2.add(owallettowallet3);
				j++;
				//owallettowallet3 = new WalletToWalletForm();
			}
			owallettowallet.setNameSearchList(listOfResponse2);
   	                /*
   	                ArrayList<WalletToWalletForm> listOfResponse = new ArrayList<WalletToWalletForm>();
	                int i =0 ;
	                WalletToWalletForm owallettowallet1 = new WalletToWalletForm();
	                StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
	        		while (multiTokenizer.hasMoreTokens())
	        		{
	        			String elem = multiTokenizer.nextToken();
	        			elem=elem.replace("[", "").replace("]", "").replace("\"", "");
	        			 if( i%3 == 0 ){
	        				 System.out.println("elem0===>> "+elem);
	        				 owallettowallet1.setWalletId(elem);
	        			 }
	        			 else if( i%3 == 1){
	        				 owallettowallet1.setName(elem);
	        				 System.out.println("elem1===>> "+elem);
	        			 }
	        			 else if( i%3 == 2 ){
	        				 System.out.println("elem2===>> "+elem);
	        				 owallettowallet1.setMobileNO(elem);
	        				 listOfResponse.add(owallettowallet1);
	        				 owallettowallet1 = new WalletToWalletForm();
	        			 }

	        			 ++i;
		        	}
	        		owallettowallet.setWalletSearchList(listOfResponse);
	        		*/
            JSONArray topArray = null;
            try {
                // Getting your top array
                //THIS IS NOT NEEDED ANYMORE
                //topArray = json.getJSONArray(jsonString);
                //use this instead

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient.close();
        }



        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/searchRequestTransactionforMoney.do");
        //Map<String,Object> dateValue = new HashMap<String,Object>();
        List<NameValuePair> params1 = new ArrayList<>();
        params1.add(new BasicNameValuePair("api_pass", "searchrequest"));
        params1.add(new BasicNameValuePair("walletid",walletID ));
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            System.out.println("Response 3222 ===== >>>>> " + responseString);
            StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
            ArrayList<RequestMoneyForm> listOfResponse = new ArrayList<RequestMoneyForm>();
            int i = 0;
            RequestMoneyForm oRequestMoneyForm1 = new RequestMoneyForm();

            while (multiTokenizer.hasMoreTokens()) {
                String elem = multiTokenizer.nextToken();
                elem = elem.replace("[", "").replace("]", "").replace("\"", "");
                System.out.println("elem1111===>> " + elem);
                if (i % 7 == 0) {
                    System.out.println("elemTest1===>> " + elem);
                    oRequestMoneyForm1.setWalletId(elem);
                }
                else if (i % 7 == 1){
                    System.out.println("elemTest2===>> " + elem);
                    oRequestMoneyForm1.setName(elem);
                }
                else if (i % 7 == 2){
                    System.out.println("elemTest3===>> " + elem);
                    oRequestMoneyForm1.setRequestId(elem);
                }
                else if (i % 7 == 3) {
                    System.out.println("elemTest4===>> " + elem);
                    //  oRequestMoneyForm1.setAmount(elem);
                }
                else if (i % 7 == 4) {
                    System.out.println("elemTest5===>> " + elem);
                    oRequestMoneyForm1.setDate(elem);
                }
                else if (i % 7 == 5) {
                    System.out.println("elemTest6===>> " + elem);
                    oRequestMoneyForm1.setAmount(elem);
                }
                else if (i % 7 == 6) {
                    System.out.println("elemTest6===>> " + elem);
                    oRequestMoneyForm1.setNarration(elem);
                    listOfResponse.add(oRequestMoneyForm1);
                    oRequestMoneyForm1 = new RequestMoneyForm();
                }

                ++i;
            }
            oRequestMoneyFormtest.setTransctionHistoryListTest(listOfResponse);
            // session.setAttribute("transactionList", listOfResponse);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient1.close();
        }
        return "Acknowldgement";
    }
}
