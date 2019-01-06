package com.era.erapay.Payment;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.era.erapay.Fund.LoadFundForm;
import com.era.erapay.common.ActivityHistoryApiCall;
import com.era.erapay.common.IpFinder;
import com.era.erapay.login.LoginFormBean;
import com.era.erapay.wallet.WalletToMerchantPaymentForm;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import erapayactranverify.ERAPAYACTRANVERIFY;


@Controller
public class PaymentMethodController {
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
	   @RequestMapping(value= "/erapay/paymentmethod")
		public String paymentmethod(Model model, HttpServletRequest request, @ModelAttribute("oWalletToMerchantPaymentForm")WalletToMerchantPaymentForm oWalletToMerchantPaymentForm , HttpServletResponse response) throws IOException {
			 HttpSession session = request.getSession(true);
		     session.setAttribute("GSMAILID","");
		     DateFormat df = new SimpleDateFormat("dd-MM-yyyy ");
	 		Date today = Calendar.getInstance().getTime();
	 		String reportDate = df.format(today);
	 		System.out.println("DATE"+reportDate);
		   String iP=ipFinder.getIp(request);
		   String sessionId= (String) session.getAttribute("SESSIONID");
		   String mailId= (String) session.getAttribute("photoemailid");
				String cusCode = (String) session.getAttribute("CUSCODE");
				session.setAttribute("KYCUPDATEMESSAGE", " ");
				session.setAttribute("transactionList", null);
				session.setAttribute("LoginMessage", " ");
				session.setAttribute("SignUpMessage", " ");
				LoginFormBean oLogInForm = new LoginFormBean();
				String responseCode = "";
				String responseStatus = "";
				String userName = "";
				String sessionID = "";
				String walletID = "";
				String mobileNo = "";
				String currentBalance = "";
				int errorexeception = 0;
				CloseableHttpResponse closeableHttpResponse = null;
				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/signInRest.do");
				session.setAttribute("KYCMessage", "");
				List<NameValuePair> params = new ArrayList<NameValuePair>();

				params.add(new BasicNameValuePair("api_pass", "usersignin"));
				params.add(new BasicNameValuePair("emailid", oWalletToMerchantPaymentForm.getEmail()));
				params.add(new BasicNameValuePair("password", oWalletToMerchantPaymentForm.getPassword()));
				System.out.println("Response ===== >>>>> " + oWalletToMerchantPaymentForm.getEmail());
				System.out.println("Response ===== >>>>> " + oWalletToMerchantPaymentForm.getPassword());
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(params));
					closeableHttpResponse = httpclient.execute(httpPost);
					errorexeception = closeableHttpResponse.getStatusLine().getStatusCode();
					System.out.println("ERORRRRRRRRR" + errorexeception);
					String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
					System.out.println("ERORRRRRRRRR" + responseString);
					JSONObject json = new JSONObject(responseString);
					responseCode = json.getString("Response_Code");
					responseStatus = json.getString("Response_Status");
			
						userName = json.getString("User_Name");
						cusCode = json.getString("CusCode");
						session.setAttribute("GSMAILID", oWalletToMerchantPaymentForm.getEmail());
						walletID = json.getString("Wallet_ID");
						responseCode = json.getString("Response_Code");
						currentBalance = json.getString("current_Bal");
						System.out.println("mobileNo==========>>> " + mobileNo);
						session.setAttribute("photoemailid", oWalletToMerchantPaymentForm.getEmail());
						session.setAttribute("USERMOBILENO", mobileNo);
						session.setAttribute("CUSCODE", cusCode);
						session.setAttribute("LoginWalletId", walletID);
						session.setAttribute("WALLETBALANCE", currentBalance);
						session.setAttribute("LoginMessage", responseStatus);
						// sessionID =parts[3];
					session.setAttribute("GSSESSION", sessionID);
					oLogInForm.setErrorCode(responseCode);
				}

				catch (Exception e) {
					e.printStackTrace();

				} finally {
					httpclient.close();
				}
		   CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		   String apiUrl="/erapay/paymentmethod";
		   HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
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
			 return "paymentmethod";
				}
				else
				{
					 return "erapaypaymentlogin";
				}
		}
	   @RequestMapping(value= "/erapay/paymentmethodthroughbank")
			public String paymentmethodthroughbank(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
				 HttpSession session = request.getSession(true);
			     session.setAttribute("PINCODEMESSAGE"," ");
			     DateFormat df = new SimpleDateFormat("dd-MM-yyyy ");
		 		 Date today = Calendar.getInstance().getTime();
		 		 String reportDate = df.format(today);
		 		 System.out.println("DATE"+reportDate);
		   String iP=ipFinder.getIp(request);
		   String sessionId= (String) session.getAttribute("SESSIONID");
		   String mailId= (String) session.getAttribute("photoemailid");
		 		 String userID = (String) session.getAttribute("GSMAILID");
		 		 String cusCode = (String) session.getAttribute("CUSCODE");
		   CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		   String apiUrl="/erapay/paymentmethodthroughbank";
		   HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
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

		   return "paymentmethodbank";
			}
	   @RequestMapping(value = "/erapay/excutepaymentmethodthroughbank")

	   public String LoadFundSearch(Model model, HttpServletRequest request, HttpServletResponse response,
				@ModelAttribute("oLoadFundForm") LoadFundForm oLoadFundForm) throws IOException {
			HttpSession session = request.getSession(true);
		   String iP=ipFinder.getIp(request);
		   String sessionId= (String) session.getAttribute("SESSIONID");
		   String mailId= (String) session.getAttribute("photoemailid");
		   CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		   String apiUrl="/erapay/excutepaymentmethodthroughbank";
		   HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
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
			CloseableHttpResponse closeableHttpResponse = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getCustomerBankAccountInfo.do");
			String outMessage = "";
			String outCode = "";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			String userID = (String) session.getAttribute("GSMAILID");
			params.add(new BasicNameValuePair("api_pass", "customerbankinfo"));
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
			return "paymentmethodbank";
		}
	   @RequestMapping(value = "/execute")
	   public String Submit(@RequestParam("bankName") String bankName,@RequestParam("branchName") String branchName,@RequestParam("accountNo") String accountNo,@RequestParam("accountTitle") String accountTitle,HttpServletRequest request) {
	       System.out.println("aaaa"+bankName);
	       WalletToMerchantPaymentForm  oWalletToMerchantPaymentForm =new WalletToMerchantPaymentForm();
			HttpSession session = request.getSession(true);
	       String userId = "SSL";
			String password = "123";
			String requestDate ="";
			String customerId = "00045270";
			String bankCode = "090";
			String branchCode = "15013";
			String debitCreditCode = "D";
			String requestNo = " ";
			String remarks = "epay";
			String amount ="5000";
			String resAmount= (String)session.getAttribute("resAmount");
			String resNarration= (String)session.getAttribute("resNarration");
			String transactionNo= (String)session.getAttribute("transactionNo");
			String resCharge= (String)session.getAttribute("resCharge");
			String redirectUrl= (String)session.getAttribute("redirectUrl");
			System.out.print("Refernece"+redirectUrl);
	           oWalletToMerchantPaymentForm.setAmount(resAmount);
	           // oWalletToMerchantPaymentForm.setOrderNo(referenceNo);
	           oWalletToMerchantPaymentForm.setCharge(resCharge);
	           oWalletToMerchantPaymentForm.setDescription(resNarration);
	   	    String responsePaygat  = ERAPAYACTRANVERIFY.eftRequest(userId, password, debitCreditCode, requestNo, requestDate, customerId, bankCode, branchCode, accountNo, accountTitle, amount, remarks);
			System.out.println("Response ===== >>>>> "+responsePaygat);
			session.setAttribute("wallettomerchantpaymentMsg", "Payment Succsesfull");
	       return "wallettomerchantpayment";
	   }
	   @RequestMapping(value = "/erapay/executeerapayement")
		public String paymentmethod1(Model model, HttpServletRequest request,@ModelAttribute("oWalletToMerchantPaymentForm")WalletToMerchantPaymentForm oWalletToMerchantPaymentForm ,HttpServletResponse response) throws IOException {
		   HttpSession session = request.getSession(true);
		   System.out.println("==>>>>>> "+(String)session.getAttribute("referenceNo"));	
		   String  referenceNo=" ";
           referenceNo= (String)session.getAttribute("referenceNo");
           String resAmount= (String)session.getAttribute("resAmount");
           String resNarration= (String)session.getAttribute("resNarration");
           String transactionNo= (String)session.getAttribute("transactionNo");
           String resCharge= (String)session.getAttribute("resCharge");
           String redirectUrl= (String)session.getAttribute("redirectUrl");
           System.out.print("Refernece"+redirectUrl);
           oWalletToMerchantPaymentForm.setAmount(resAmount);
           oWalletToMerchantPaymentForm.setOrderNo(referenceNo);
           oWalletToMerchantPaymentForm.setCharge(resCharge);
           oWalletToMerchantPaymentForm.setDescription(resNarration);
		   String iP=ipFinder.getIp(request);
		   String sessionId= (String) session.getAttribute("SESSIONID");
		   String mailId= (String) session.getAttribute("photoemailid");
		   CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		   String apiUrl="/erapay/executeerapayement";
		   HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
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
	       return "EpayWalletPayment";
	   }
	   @RequestMapping(value = "/executejs")
	   public  @ResponseBody String executejs(@RequestParam("bankName") String bankName,@RequestParam("branchName") String branchName,@RequestParam("accountNo") String accountNo,@RequestParam("accountTitle") String accountTitle) {
	      String bankName1=bankName;
	      System.out.println("aaaa"+bankName);
		return bankName1;
	   }
}
