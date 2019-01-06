package com.era.erapay.QRCODE;

import com.era.erapay.SignUp.SignUpFormBean;
import com.era.erapay.bank.AddBankAccountForm;
import com.era.erapay.common.ActivityHistoryApiCall;
import com.era.erapay.common.IpFinder;
import erapayactranverify.ERAPAYACTRANVERIFY;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TestController {
    IpFinder ipFinder =new IpFinder();
    ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();


    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
    Date today = Calendar.getInstance().getTime();
    String dateAndTime = df.format(today);

    @RequestMapping(value = "/erapay/addbankaccountbanksearch")
    public String display33(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("oAddBankSearchListBO", null);
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");

        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl="/erapay/addbankaccountbanksearch";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid",sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionTime",dateAndTime ));
        paramsHistory.add(new BasicNameValuePair("actionouttime",""));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("timestamp",dateAndTime));
        paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
        return "AddBankAccountBankSearch";
    }
    @RequestMapping(value = "/erapay/addbankhome")
    public String addbankhome(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");
        session.setAttribute("oAddBankSearchListBO", null);

		/*
		String userId = "SSL";
		String password = "123";
		String requestNo = "000456";
		String customerId = "00045270";
		String accountNo = "00434007314";
		*/
        CloseableHttpResponse closeableHttpResponseHistory = null;
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl="/erapay/addbankhome";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid",sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionTime",dateAndTime ));
        paramsHistory.add(new BasicNameValuePair("actionouttime",""));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("timestamp",dateAndTime));
        paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);

        //String responsePaygat  =
        // .accountVerify(userId, password, requestNo, customerId, accountNo);
        //System.out.println("Response ===== >>>>> "+responsePaygat);
        //	String[] responseparts = responsePaygat.split("#");
        // String outMessage = responseparts[1];
        // String outCode = responseparts[0];
        //String mobileNo=responseparts[0];
        // System.out.println("Message"+outMessage+outCode+"mobileNo);
        //String responsePaygat  = ERAPAYACTRANVERIFY.accountVerify(userId, password, requestNo, customerId, accountNo);
        //System.out.println("Response ===== >>>>> "+responsePaygat);
        return "addbankhome";
    }

    @RequestMapping(value = "/erapay/executeaddbankotp")
    public String executeOTP(Model model, @ModelAttribute("oAddBankAccountForm") AddBankAccountForm oAddBankAccountForm,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");

        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl="/erapay/executeaddbankotp";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionTime",dateAndTime ));
        paramsHistory.add(new BasicNameValuePair("actionouttime",""));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("timestamp",dateAndTime));
        paramsHistory.add(new BasicNameValuePair("ip_remote",iP));

        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);

        System.out.println("LOADBRANCH" + oAddBankAccountForm.getBranchName());
        session.setAttribute("ADDBANKNAME", oAddBankAccountForm.getBankName());
        session.setAttribute("LOADBRANCH", oAddBankAccountForm.getBranchName());
        session.setAttribute("LOADACCOUNTNO", oAddBankAccountForm.getAccountNo());
        session.setAttribute("LOADACCOUNTTITTLE", oAddBankAccountForm.getAccountTittle());
        session.setAttribute("LOADMOBILENO", oAddBankAccountForm.getMobileNo());
        return "AddBankOtp";

    }

    @RequestMapping(value = "/erapay/executeaddbank")
    public String formsuccsess(Model model,
                               @ModelAttribute("oAddBankAccountForm") AddBankAccountForm oAddBankAccountForm, HttpServletRequest request,
                               SessionStatus status, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        //	EraPayAccountVerify paygat = new EraPayAccountVerify();
        String api_user_id = "";
        String api_pass = "";
        String terminal_id = "";
        String userid = "";
        String sessionid = "";
        String result = "";
        String bankCode = "";
        String bankType = "";
        String bankName = "";
        String businessAddress = "";
        String mobileNo = "";
        String faxNo = "";
        String commRate = "";
        String remark = "";
        String bankstatus = "";
        String BankCode = "";
        String BankName = "";
        String branchName = "";
        //	String accountNo = "";
        String accountTittle = "";
        String outCode = "";
        String outMessage = "";
        String  errorCode="";
        String errorMessage="";
        String iP=ipFinder.getIp(request);
        String sessionId= (String) session.getAttribute("SESSIONID");
        String mailId= (String) session.getAttribute("photoemailid");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String userID = (String) session.getAttribute("GSMAILID");
        String cusCode = (String) session.getAttribute("CUSCODE");
        System.out.println("Date" + reportDate);
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String userId = "SSL";
        String password = "123";
        String requestNo = "000456";
        String customerId = "00045270";
        String accountNo = "";
        bankName = (String) session.getAttribute("ADDBANKNAME");
        branchName = (String) session.getAttribute("LOADBRANCH");
        accountNo = (String) session.getAttribute("LOADACCOUNTNO");
        accountTittle = (String) session.getAttribute("LOADACCOUNTTITTLE");
        mobileNo = (String) session.getAttribute("LOADMOBILENO");
        System.out.println("Response ===== >111111>>>> "+bankName);
        String responsePaygat  = ERAPAYACTRANVERIFY.accountVerify(userId, password, requestNo, customerId, accountNo);
        System.out.println("Response ===== >>>>> "+responsePaygat);
        String[] responseparts = responsePaygat.split("#");
        String accountOutMessage = responseparts[1];
        String accountOutCode = responseparts[0];
        CloseableHttpResponse closeableHttpResponseHistory = null;
        CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
        String apiUrl="/erapay/executeaddbank";
        HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
        session.setAttribute("KYCMessage", "");
        List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
        paramsHistory.add(new BasicNameValuePair("userid", mailId));
        paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
        paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
        paramsHistory.add(new BasicNameValuePair("actionTime",dateAndTime ));
        paramsHistory.add(new BasicNameValuePair("actionouttime",""));
        paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
        paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
        paramsHistory.add(new BasicNameValuePair("timestamp",dateAndTime));
        paramsHistory.add(new BasicNameValuePair("ip_remote",iP));

        activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
if(accountOutCode.equals("0")) {
    HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addbank.do");
    // Map<String,Object> dateValue = new HashMap<String,Object>();
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("action", "addbank"));
    params.add(new BasicNameValuePair("mailid", userID));
    params.add(new BasicNameValuePair("bankcod", bankName));
    params.add(new BasicNameValuePair("accno", accountNo));
    params.add(new BasicNameValuePair("acctitle", accountTittle));
    params.add(new BasicNameValuePair("mobileno", mobileNo));
    params.add(new BasicNameValuePair("cusotp", "123"));
    params.add(new BasicNameValuePair("reqdate", reportDate));
    params.add(new BasicNameValuePair("cuscod", cusCode));
    params.add(new BasicNameValuePair("timstamp", reportDate));
    params.add(new BasicNameValuePair("oprstamp", userID));
    // params.add((NameValuePair) dateValue.put("timstamp", date));
    try {
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        closeableHttpResponse = httpclient.execute(httpPost);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject json = new JSONObject(responseString);
        errorCode = json.getString("Response_Code");
        errorMessage = json.getString("Response_Status");
        // String DataResponse = responseString.replace("[",
        // "").replace("]", "");
        // result += responseBody;

        // System.out.println("Response ===== >>>>>
        // "+closeableHttpResponse);
    } catch (Exception e) {

        e.printStackTrace();
    } finally {
        httpclient.close();
    }
}
        CloseableHttpResponse closeableHttpResponse2 = null;
        CloseableHttpClient httpclient2 = HttpClients.createDefault();
        String userName = (String) session.getAttribute("GSUSERNAME");
        HttpPost httpPost2 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBranchforAddBank.do");
        List<NameValuePair> params2 = new ArrayList<NameValuePair>();
        params2.add(new BasicNameValuePair("actions", "getallbranch"));

        try {
            httpPost2.setEntity(new UrlEncodedFormEntity(params2));
            closeableHttpResponse2 = httpclient2.execute(httpPost2);
            String responseString = EntityUtils.toString(closeableHttpResponse2.getEntity(), "UTF-8");
            // System.out.println("Response ===== >>>>> "+responseString);
            StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
            Map<String, String> mapValue = new HashMap<String, String>();

            while (multiTokenizer.hasMoreTokens()) {
                String key = multiTokenizer.nextToken();
                key = key.replace("[", "").replace("]", "").replace("\"", "");

                String value = multiTokenizer.nextToken();
                value = value.replace("[", "").replace("]", "").replace("\"", "");
                // System.out.println(key+"-"+value);
                mapValue.put(key, value);
                // break;
                // ++i;
                // if(i==30000)
                // break;
            }
            model.addAllAttributes(mapValue);
            oAddBankAccountForm.setAccountTittle(userName);
            oAddBankAccountForm.setMapValue(mapValue);

            // System.out.println(mapValue);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient2.close();
        }
        session.setAttribute("AddBankMessage", "");
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();

        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBankforRegistration.do");
        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("actions", "getallbank"));
        try {





            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString1);
            StringTokenizer multiTokenizer = new StringTokenizer(responseString1, ",");
            Map<String, String> map = new HashMap<String, String>();
            // Map<String,String> mainMapValue1 = new HashMap<String,String>();
            while (multiTokenizer.hasMoreTokens()) {
                String key = multiTokenizer.nextToken().replace("[", "").replace("]", "").replace("\"", "");
                String value = multiTokenizer.nextToken().replace("[", "").replace("]", "").replace("\"", "");
                map.put(key, key + "--" + value);
                // mainMapValue1.put(key, value);

            }
            model.addAllAttributes(map);
            oAddBankAccountForm.setBankMapValue(map);
            System.out.println("a" + map);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient.close();
        }

        oAddBankAccountForm.setOutCode(errorCode);
        if (oAddBankAccountForm.getOutCode().equals("0")) {
            // session.setAttribute("sErrorMessage",
            // oMenuGenarationBO.getErrorMessage());
            session.setAttribute("AddBankMessage", accountOutMessage);
            return "addbank";
        } else {
            // session.setAttribute("sErrorMessage",
            // oMenuGenarationBO.getErrorMessage());
            session.setAttribute("AddBankMessage", accountOutMessage);
            return "addbank";
        }

    }

    @RequestMapping(value = "/erapay/addbankaccount")
    public String responsiveaddbank(Model model, HttpServletRequest request,
                                    @ModelAttribute("oAddBankAccountForm") AddBankAccountForm oAddBankAccountForm, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("LoginMessage", "");
        String userID = (String) session.getAttribute("GSMAILID");
        String cusCode = (String) session.getAttribute("CUSCODE");
        System.out.println("CUSCODE12413213" + cusCode);
        System.out.println("===========>>>>>>>>>>> " + userID);
        // HttpSession session = request.getSession(true);
        String api_user_id = "";
        String api_pass = "";
        String terminal_id = "";
        String userid = "";
        String sessionid = "";
        String outCode = "";
        String outMessage = "";
        String userName = (String) session.getAttribute("GSUSERNAME");


        session.setAttribute("AddBankMessage", "");
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBankforRegistration.do");
        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("api_pass", "getallbank"));
        params1.add(new BasicNameValuePair("bankName", " "));
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString1);
            Map<String, String> bankMapValue = new HashMap<String, String>();
            JSONArray topArray = null;
            try {
                // Getting your top array

                //THIS IS NOT NEEDED ANYMORE
                //topArray = json.getJSONArray(jsonString);
                //use this instead
                topArray = new JSONArray(responseString1);
                for(int i = 0; i < topArray.length(); i++){
                    JSONObject c = topArray.getJSONObject(i);
                    //list holding row data
                    // Storing each json item in variable
                    String bankName = c.getString("banknam");
                    String bankCode = c.getString("bankcod");
                    bankMapValue.put(bankCode,bankName);
                    model.addAllAttributes(bankMapValue);
                    oAddBankAccountForm.setAccountTittle(userName);
                    oAddBankAccountForm.setBankMapValue(bankMapValue);

                    System.out.println(bankMapValue);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient1.close();
        }
        return "addbank";
    }
    @RequestMapping(value = "/erapay/addbankaccountbranchsearch")
    public String addbankaccountbranchsearch(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("oAddBankBranchSearchListBO", null);

        return "AddBankAccountBranchSearch";
    }

    @RequestMapping(value = "/erapay/bankaccounttomerchantepayment")
    public String bankaccounttomerchantepayment(Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("oAddBankBranchSearchListBO", null);

        return "BankAccountTomerchantePayment";
    }
    @RequestMapping(value = "/erapay/banksearchaddbank", method = RequestMethod.GET)
    public String banksearchaddbank(Model model, HttpServletRequest request,@ModelAttribute("oAddBankAccountForm") AddBankAccountForm oAddBankAccountForm, HttpServletResponse response,@RequestParam("bankcode") String bankcode)
            throws Exception {
        System.out.println("CODE"+bankcode);
        String code=bankcode;
        HttpSession session = request.getSession(true);
        session.setAttribute("ADDBANKNAME", oAddBankAccountForm.getBankName());
        HashMap<String, String> bankMapValue1 = new HashMap<String, String>();
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBranchforAddBank.do");
        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("api_pass", "getallbranch"));
        params1.add(new BasicNameValuePair("bankcode", bankcode));
        params1.add(new BasicNameValuePair("branchName", ""));
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>>4646546 " + responseString1);
            //oAddBankAccountForm.setBankName(bankcode);
            JSONArray topArray = null;
            JSONArray h = null;
            try {

                topArray = new JSONArray(responseString1);
                for(int i = 0; i < topArray.length(); i++){
                    System.out.println(topArray.get(i));
                    h= (JSONArray) topArray.get(i);
                    for(int j = 0; j < h.length(); j++) {
                        String branchName= (String) h.get(0);
                        String branchCode= (String) h.get(1);
                        bankMapValue1.put(branchName,branchCode);
                        oAddBankAccountForm.setMapValue(bankMapValue1);
                    }

                    //System.out.println("BankName"+bankName);
                   /* JSONObject c = topArray.getJSONObject(i);
                    //list holding row data
                    // Storing each json item in variable
                    String bankName = c.getString("brnnam");
                    String bankCode = c.getString("brncod");
                    bankMapValue1.put(bankCode,bankName);
                    oAddBankAccountForm.setMapValue(bankMapValue1);
                    model.addAllAttributes(bankMapValue1);
                    System.out.println(bankMapValue1);
                    */
                }
                session.setAttribute("aa",bankMapValue1);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient1.close();
        }
        CloseableHttpResponse closeableHttpResponse2 = null;
        CloseableHttpClient httpclient2 = HttpClients.createDefault();
        HttpPost httpPost2 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBankforRegistration.do");
        List<NameValuePair> params2 = new ArrayList<NameValuePair>();
        params2.add(new BasicNameValuePair("api_pass", "getallbank"));
        params2.add(new BasicNameValuePair("bankName", " "));
        try {
            httpPost2.setEntity(new UrlEncodedFormEntity(params2));
            closeableHttpResponse2 = httpclient2.execute(httpPost2);
            String responseString1 = EntityUtils.toString(closeableHttpResponse2.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString1);
            Map<String, String> bankMapValue = new HashMap<String, String>();
            JSONArray topArray = null;
            try {
                topArray = new JSONArray(responseString1);
                for(int i = 0; i < topArray.length(); i++){
                    JSONObject c = topArray.getJSONObject(i);
                    //list holding row data
                    // Storing each json item in variable
                    String bankName = c.getString("banknam");
                    String bankCode = c.getString("bankcod");
                    bankMapValue.put(bankCode,bankName);
                    model.addAllAttributes(bankMapValue);
                    oAddBankAccountForm.setBankMapValue(bankMapValue);
                    System.out.println(bankMapValue);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient2.close();
        }
        return "addbank";
    }
	/*
	@RequestMapping(value = "/erapay/branchsearchajax", method = RequestMethod.GET)
	public @ResponseBody
	Set<City> citiesForState(
			@RequestParam(value = "stateName", required = true) String state) {
		logger.debug("finding cities for state " + state);
		return this.geoService.findCitiesForState(state);
	}
	*/

    @RequestMapping(value = "/erapay/branchsearchajax")
    @ResponseBody
    public String branchsearchajax(Model model, HttpServletRequest request, HttpServletResponse response,@RequestParam("bankcode") String bankcode)
            throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("oAddBankBranchSearchListBO", null);
        String bk=bankcode;
        return bk;
    }


    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:banksearchaddbank";
    }
    @RequestMapping(value="/erapay/banksearchaddbankajax", method=RequestMethod.GET,produces = "application/json")
    public @ResponseBody HashMap<String, String>  likePage(Model model,@RequestParam("bankcode") String bankcode,HttpServletRequest request,@ModelAttribute("oAddBankAccountForm") AddBankAccountForm oAddBankAccountForm, HttpServletResponse response) throws IOException {
        System.out.println("Prod ID:  " + bankcode);
        HttpSession session = request.getSession(true);
        HashMap<String, String> bankMapValue1 = new HashMap<String, String>();
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getAllBranchforAddBank.do");
        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("api_pass", "getallbranch"));
        params1.add(new BasicNameValuePair("bankcode", bankcode));
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>>4646546 " + responseString1);
            oAddBankAccountForm.setBankName(bankcode);
            JSONArray topArray = null;
            try {

                topArray = new JSONArray(responseString1);
                for(int i = 0; i < topArray.length(); i++){
                    JSONObject c = topArray.getJSONObject(i);
                    //list holding row data
                    // Storing each json item in variable
                    String bankName = c.getString("brnnam");
                    String bankCode = c.getString("brncod");
                    bankMapValue1.put(bankCode,bankName);
                    oAddBankAccountForm.setMapValue(bankMapValue1);
                    model.addAllAttributes(bankMapValue1);
                    System.out.println(bankMapValue1);
                }
                session.setAttribute("aa",bankMapValue1);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            httpclient1.close();
        }
        return  bankMapValue1;
        //else
        //  return false;
    }

    @RequestMapping(value= "/erapay/wallet")
    public String wallet(Model model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("wallet")Wallet wallet) throws IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("WalletMsg", " ");

        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/MissCallAlertAPI/getSessionInitialize.do");
        HashMap<String, String> headerMap = new HashMap<String, String>();

        headerMap.put("api_pass", "99FrHBglmE2WZHmx6MuZJYvKtrD/TT5oAT//IbKI6vg=");
        headerMap.put("api_userid", "BankAsia");
        headerMap.put("vendor_id", "SSL001");
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        /*List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass","99FrHBglmE2WZHmx6MuZJYvKtrD/TT5oAT//IbKI6vg="));
        params.add(new BasicNameValuePair("api_userid","BankAsia"));
        */
        try {
          //  httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            /*
                System.out.println("Response ===== >>>>> "+responseString);
                String[] parts = responseString.split(",");
                outMessage=parts[0];
                outCode=parts[1];
                //osignUpFormBean.setErrorCode(outCode);
                 */
            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return "wallet";
    }
    @RequestMapping(value= "/erapay/123")
    public String executewallet(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("wallet")Wallet wallet) throws IOException {
        HttpSession session = request.getSession(true);
        String outCode="";
        String outMessage="";
        String userID = (String) session.getAttribute("GSMAILID");
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();;
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/waltowaltransfer.do");
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String walletId = (String) session.getAttribute("WALLETID");
        String amount= (String) session.getAttribute("WALLETAMOUNT");
        String narration= (String) session.getAttribute("WALLETNarration");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("api_pass","D"));
        params.add(new BasicNameValuePair("docnum","123"));
        params.add(new BasicNameValuePair("doctyp","FND"));
        params.add(new BasicNameValuePair("oprcod","1"));
        params.add(new BasicNameValuePair("trndat",reportDate));
        params.add(new BasicNameValuePair("debit_walletid",userID));
        params.add(new BasicNameValuePair("narration",narration));
        params.add(new BasicNameValuePair("emailID",userID));
        params.add(new BasicNameValuePair("drcrcd","D"));
        params.add(new BasicNameValuePair("curcde","BDT"));
        params.add(new BasicNameValuePair("exrate","1"));
        params.add(new BasicNameValuePair("trnamt","50"));
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
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            System.out.println("Response ===== >>>>> "+responseString);
        }catch(Exception e){
            e.printStackTrace();

        } finally {
            httpclient.close();
        }
      //  String amt=wallet.getAmount();
        CloseableHttpResponse closeableHttpResponse1 = null;
        CloseableHttpClient httpclient1 = HttpClients.createDefault();;
        HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/waltowaltransfer.do");
        List<NameValuePair> params1 = new ArrayList<>();
        params1.add(new BasicNameValuePair("api_pass","C"));
        params1.add(new BasicNameValuePair("emailID",userID));
        params1.add(new BasicNameValuePair("debit_walletid"," "));
        params1.add(new BasicNameValuePair("narration",narration));
        params1.add(new BasicNameValuePair("docnum","123"));
        params1.add(new BasicNameValuePair("doctyp","FND"));
        params1.add(new BasicNameValuePair("oprcod","1"));
        params1.add(new BasicNameValuePair("trndat",reportDate));
        params1.add(new BasicNameValuePair("walletid",""));
        params1.add(new BasicNameValuePair("drcrcd","C"));
        params1.add(new BasicNameValuePair("curcde","BDT"));
        params1.add(new BasicNameValuePair("exrate","1"));
        params1.add(new BasicNameValuePair("trnamt",wallet.getAmount()));
        params1.add(new BasicNameValuePair("destwalletid",""));
        params1.add(new BasicNameValuePair("srcrefno1",""));
        params1.add(new BasicNameValuePair("srcrefno2",""));
        params1.add(new BasicNameValuePair("srcrefno3",""));
        params1.add(new BasicNameValuePair("srcrefno4",""));
        params1.add(new BasicNameValuePair("narration",""));
        params1.add(new BasicNameValuePair("terminalId",""));
        params1.add(new BasicNameValuePair("oprstamp",userID));
        params1.add(new BasicNameValuePair("timestamp",reportDate));
        System.out.println(params1);
        try {
            httpPost1.setEntity(new UrlEncodedFormEntity(params1));
            closeableHttpResponse1 = httpclient1.execute(httpPost1);
            String responseString = EntityUtils.toString(closeableHttpResponse1.getEntity(),"UTF-8");
            System.out.println("Response ===== >>>>> "+responseString);
            JSONObject json = new JSONObject(responseString);
            outCode=json.getString("Response_Code");
            outMessage=json.getString("Response_Status");
        }catch(Exception e){
            e.printStackTrace();

        } finally {
            httpclient1.close();
        }
        if (outCode.equals("0")) {
            session.setAttribute("WalletMsg",outMessage);
            return "wallet";
        }
        else
        {
            session.setAttribute("WalletMsg",outMessage);
            return "wallet";
        }
    }

    @RequestMapping(value= "/jwttest")
    public String jst(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("wallet")Wallet wallet) throws IOException {
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/userTestingHimel.do");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass","test"));
        params.add(new BasicNameValuePair("user_id,","2"));
        params.add(new BasicNameValuePair("password","$2a$10$GaqyjA0hX5C8ApkBBVFJQOp6gVZirMm0DFdsoerM28iHuhCYItJve"));
        params.add(new BasicNameValuePair("salary,","28500"));
        params.add(new BasicNameValuePair("age","40"));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            /*
                System.out.println("Response ===== >>>>> "+responseString);
                String[] parts = responseString.split(",");
                outMessage=parts[0];
                outCode=parts[1];
                //osignUpFormBean.setErrorCode(outCode);
                 */
            System.out.println("Response ===== >>>>> " + responseString);
            //JSONObject json = new JSONObject(responseString);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return "wallet";
    }
}
