package com.era.erapay.Fund;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


import erapayactranverify.ERAPAYACTRANVERIFY;

@Controller
public class LoadFundController {
	private final Logger logger = LoggerFactory.getLogger(LoadFundController.class);
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
	@RequestMapping(value = "/erapay/loadfund")
	public String LoadFund(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oLoadFundForm") LoadFundForm oLoadFundForm) throws IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("LoadFundMessage", " ");
		logger.debug("LoadFund()");
		String userId = "SSL";
		String password = "123";
		String requestNo = "000456";
		String requestDate = "";
		String customerId = "00045270";
		String bankCode = "090";
		String branchCode = "15013";
		String accountNo = "00434007314";
		String accountTitle = "Hamida Virani";
		String amount = "500000";
		String remarks = "epay";
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		// String responsePaygat = EraPayAccountVerify.eftRequest(userId,
		// password, requestNo, requestDate, customerId, bankCode, branchCode,
		// accountNo, accountTitle, amount, remarks);
		// System.out.println("Response->>>"+responsePaygat);
		session.setAttribute("LoadFundMessage", "");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/loadfund";
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
		return "LoadFund";
	}
	@RequestMapping(value = "/erapay/executeloadfundotp")
	public String executeOTP(Model model, @ModelAttribute("oLoadFundForm") LoadFundForm oLoadFundForm,
			HttpServletRequest request) throws IOException {

		HttpSession session = request.getSession(true);
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		session.setAttribute("LoadFundMessage", " ");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/executeloadfundotp";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		session.setAttribute("LOADFUNDAMOUNT", oLoadFundForm.getAmount());
		session.setAttribute("LOADFUNDACCOUNT", oLoadFundForm.getBankAccount());
		session.setAttribute("LOADFUNDACCOUNTTITTLE", oLoadFundForm.getAccountTittle());
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
		return "LoadFundOTP";

	}

	@RequestMapping(value = "/erapay/executeloadfund")
	public String addloadfund(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oLoadFundForm") LoadFundForm oLoadFundForm) throws Exception {
		HttpSession session = request.getSession(true);
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		String outCode = "";
		String outMessage = "";
		String requestNo = "";
		String userID = (String) session.getAttribute("GSMAILID");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addLoadFund.do");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		String amount = (String) session.getAttribute("LOADFUNDAMOUNT");
		String walletId = (String) session.getAttribute("LoginWalletId");
		//String accountNo = (String) session.getAttribute("LOADFUNDACCOUNT");
		String accountTitle = (String) session.getAttribute("LOADFUNDACCOUNTTITTLE");
		String LoadFundOutMessage = "";
		String LoadFundaccountOutCode = "";
		String responseCode = "";
		String responseStatus = "";

		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// params.add(new BasicNameValuePair("action","addbank"));
		params.add(new BasicNameValuePair("api_pass", "addloadfund"));
		params.add(new BasicNameValuePair("docnum", " "));
		params.add(new BasicNameValuePair("doctyp", "FND"));
		params.add(new BasicNameValuePair("oprcod", "1"));
		params.add(new BasicNameValuePair("trndat", reportDate));
		params.add(new BasicNameValuePair("walletid", walletId));
		params.add(new BasicNameValuePair("drcrcd", "C"));
		params.add(new BasicNameValuePair("curcde", "BDT"));
		params.add(new BasicNameValuePair("exrate", "1"));
		params.add(new BasicNameValuePair("trnamt", amount));
		params.add(new BasicNameValuePair("amount", amount));
		params.add(new BasicNameValuePair("destwalletid", " "));
		params.add(new BasicNameValuePair("srcrefno1", ""));
		params.add(new BasicNameValuePair("srcrefno2", ""));
		params.add(new BasicNameValuePair("srcrefno3", ""));
		params.add(new BasicNameValuePair("srcrefno4", ""));
		params.add(new BasicNameValuePair("narration", ""));
		params.add(new BasicNameValuePair("terminalId", ""));
		params.add(new BasicNameValuePair("oprstamp", userID));
		params.add(new BasicNameValuePair("timstamp", reportDate));
		// params.add((NameValuePair) dateValue.put("timstamp", date));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString);
			JSONObject json = new JSONObject(responseString);
			responseCode = json.getString("Response_Code");
			responseStatus = json.getString("Response_Status");
			requestNo = json.getString("requestno");
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
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/executeloadfund";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		session.setAttribute("LOADFUNDAMOUNT", oLoadFundForm.getAmount());
		session.setAttribute("LOADFUNDACCOUNT", oLoadFundForm.getBankAccount());
		session.setAttribute("LOADFUNDACCOUNTTITTLE", oLoadFundForm.getAccountTittle());
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
		if (responseCode.equals("0")) {
			String userId = "SSL";
			String password = "123";
			String requestDate = df.format(today);
			String customerId = "00045270";
			String bankCode = "090";
			String branchCode = "15013";
			String accountNo = "00434007314";
			System.out.println("AccountNo >>>>>>"+accountNo);
			String remarks = "epay";
			String debitCreditCode = "C";
			String responsePaygat = ERAPAYACTRANVERIFY.eftRequest(userId, password, debitCreditCode, requestNo,
					requestDate, customerId, bankCode, branchCode, accountNo, accountTitle, amount, remarks);

			System.out.println("Response ===== >>>>> " + responsePaygat);
			String[] responseparts = responsePaygat.split("#");
			LoadFundOutMessage = responseparts[1];
			LoadFundaccountOutCode = responseparts[0];
			System.out.println(amount);
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("LoadFundMessage", LoadFundOutMessage);
			return "LoadFund";
		} else {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("LoadFundMessage", outMessage);
			return "LoadFund";
		}
	}
	@RequestMapping(value = "/erapay/loadfundsearch")
	public String LoadFundSearch(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oLoadFundForm") LoadFundForm oLoadFundForm) throws IOException {
		HttpSession session = request.getSession(true);
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		logger.debug("LoadFund()");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getCustomerBankInfo.do");
		String outMessage = "";
		String outCode = "";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String userID = (String) session.getAttribute("GSMAILID");
		params.add(new BasicNameValuePair("actions", "getallcustomerbankinfo"));
		params.add(new BasicNameValuePair("mailid", userID));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString);
			StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
			ArrayList<LoadFundForm> listOfResponse = new ArrayList<LoadFundForm>();
			int i = 0;
			LoadFundForm oLoadFundForm1 = new LoadFundForm();
			while (multiTokenizer.hasMoreTokens()) {
				String elem = multiTokenizer.nextToken();
				elem = elem.replace("[", "").replace("]", "").replace("\"", "");
				if (i % 7 == 0) {
					System.out.println("elem0===>> " + elem);
					oLoadFundForm1.setUserId(elem);
				} else if (i % 7 == 1) {
					oLoadFundForm1.setBankCode(elem);
					System.out.println("elem1===>> " + elem);
				} else if (i % 7 == 2) {
					System.out.println("elem2===>> " + elem);
					oLoadFundForm1.setBankName(elem);
				} else if (i % 7 == 3) {
					System.out.println("elem2===>> " + elem);
					oLoadFundForm1.setBranchCode(elem);
				} else if (i % 7 == 4) {
					oLoadFundForm1.setBranchName(elem);
					System.out.println("elem1===4>> " + elem);
				} else if (i % 7 == 5) {
					System.out.println("elem1===5>> " + elem);
					oLoadFundForm1.setBankAccount(elem);
				} else if (i % 7 == 6) {
					System.out.println("elem1===6>> " + elem);
					oLoadFundForm1.setAccountTittle(elem);
					listOfResponse.add(oLoadFundForm1);
					oLoadFundForm1 = new LoadFundForm();
				}

				++i;

			}

			oLoadFundForm.setBankSearchList(listOfResponse);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			httpclient.close();
		}

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String signInApiUrl="http://10.11.201.169:8080/ERAPAY/signInRest.do";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
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
		return "loadfundsearch";
	}
}
