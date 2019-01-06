package com.era.erapay.login;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.era.erapay.SignUp.SignUpFormBean;
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
import org.springframework.web.bind.annotation.RequestMethod;
import  com.era.erapay.KYC.KycForm;


@Controller
public class LoginController {
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
	String walletCurrencyResponseCode="";
	 String walletCurrency="";
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value = "/erapay/login")
	public String Login(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		logger.debug("Login()");
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
		session.setAttribute("KYCMessage", "");
		session.setAttribute("transactionList", null);
		session.setAttribute("LoginMessage", " ");
		session.setAttribute("SignUpMessage", " ");
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		session.setAttribute("USERINFORESPONSE", " ");
		session.setAttribute("KYCMessage", " ");
		session.setAttribute("LoadFundMessage", "");
		session.setAttribute("KYCMessage", "");
		session.setAttribute("LOADFUNDAMOUNT","");
		session.setAttribute("LOADFUNDACCOUNT", "");
		session.setAttribute("LOADFUNDACCOUNTTITTLE", "");
		session.setAttribute("LoadFundMessage", "");
		session.setAttribute("message", "");
		session.setAttribute("GSMAILID", "");
		session.setAttribute("photoemailid","");
		session.setAttribute("USERMOBILENO","");
		session.setAttribute("CUSCODE", "");
		session.setAttribute("LoginWalletId", "");
		session.setAttribute("WALLETBALANCE","");
		session.setAttribute("LoginMessage", "");
		session.setAttribute("PINCODEMESSAGE"," ");
		session.setAttribute("wallettomerchantpaymentMsg", "");
		session.setAttribute("GSSESSION", "");
		session.setAttribute("PINCODEMESSAGE"," ");
		session.setAttribute("CHANGEPASSWORDMESSAGE", " ");
		session.setAttribute("PasswordRecovery"," ");
		session.setAttribute("SignUpMessage", "");
		session.setAttribute("Talktimemsg"," ");
		session.setAttribute("WalletOpenErrorMessage","");
		session.setAttribute("CURWALLETBALANCE"," ");
		session.setAttribute("LOADFUNDAMOUNT", "");
		session.setAttribute("WALLETAMOUNT","");
		session.setAttribute("WALLETIDCREDIT", "");
		session.setAttribute("WALLETNarration","");
		session.setAttribute("WalletMsg", "");
		session.setAttribute("LoginMessage", "");
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		session.setAttribute("transactionList", null);
		session.setAttribute("LoginMessage", " ");
		session.setAttribute("SignUpMessage", " ");
		session.setAttribute("photoemailid","");
		session.setAttribute("USERMOBILENO","");
		session.setAttribute("CUSCODE", "");
		session.setAttribute("LoginWalletId", "");
		session.setAttribute("WALLETBALANCE","");
		session.setAttribute("GSUSERNAME", "");
        session.setAttribute("RequestCount", " ");
		return "testlogin";
	}
	@RequestMapping(value= "/erapay/signup1")
	public String SignUp(HttpServletRequest request,@ModelAttribute("osignUpFormBean")SignUpFormBean osignUpFormBean) {
		HttpSession session = request.getSession(true);
		session.setAttribute("SignUpMessage", " ");
		return "SignUpNew";
	}
	@RequestMapping(value = "/erapay/testhome")
	public String TestHOme(HttpServletRequest request, HttpServletResponse response, Model model,
						   @ModelAttribute("oKycForm") KycForm oKycForm) throws Exception {
		HttpSession session = request.getSession(true);
		String cusCode = (String) session.getAttribute("CUSCODE");
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		String walletID = (String) session.getAttribute("LoginWalletId");
		session.setAttribute("transactionList", null);
		logger.debug("Login()");
		session.setAttribute("LoginMessage", "");
		String iP=ipFinder.getIp(request);
		String sessionID= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/testhome";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionID));
		paramsHistory.add(new BasicNameValuePair("actionname", apiUrl));
		paramsHistory.add(new BasicNameValuePair("actionTime",dateAndTime ));
		paramsHistory.add(new BasicNameValuePair("actionouttime",""));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", oKycForm.getMailId()));
		paramsHistory.add(new BasicNameValuePair("timestamp",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		System.out.println("Response ===== >>>>> " + oKycForm.getMailId());
		System.out.println("Response ===== >>>>> " + oKycForm.getPassword());
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		CloseableHttpResponse closeableHttpResponse1 = null;
		CloseableHttpClient httpclient1 = HttpClients.createDefault();
		HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getTransactionHistory.do");
		List<NameValuePair> params1 = new ArrayList<NameValuePair>();
		params1.add(new BasicNameValuePair("api_pass", "tranhistory"));
		System.out.println("wallid" + walletID);
		params1.add(new BasicNameValuePair("walletid", walletID));
		try {
			httpPost1.setEntity(new UrlEncodedFormEntity(params1));
			closeableHttpResponse1 = httpclient1.execute(httpPost1);
			String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString1);
			StringTokenizer multiTokenizer = new StringTokenizer(responseString1, ",");
			ArrayList<KycForm> listOfResponse = new ArrayList<KycForm>();
			int i = 0;
			KycForm oKycForm1 = new KycForm();
			while (multiTokenizer.hasMoreTokens()) {
				String elem = multiTokenizer.nextToken();
				elem = elem.replace("[", "").replace("]", "").replace("\"", "");
				System.out.println("elem1111===>> " + elem);
                if (i % 5 == 0) {
                    System.out.println(" Test elem1===>>");
                    oKycForm1.setTrandat(elem);
                }
                else if (i % 5 == 1){
                    oKycForm1.setWalletID(elem);
                    System.out.println(" Test elem2===>> " + elem);
                }
                else if (i % 5 == 2)
                {
                    {
                        System.out.println(" Test elem3===>> " + elem);
                        oKycForm1.setTrnamt1(elem);
                    }
                }
                else if (i % 5 == 3)
                {
                    oKycForm1.setDocType(elem);
                    System.out.println(" Test elem4===>> " + elem);
                }
                else if (i % 5 == 4) {
                    oKycForm1.setNarration(elem);
                    System.out.println("Test elem5===>> " + elem);
                    listOfResponse.add(oKycForm1);
                    oKycForm1 = new KycForm();
                }
                ++i;
			}
			oKycForm.setTransctionHistoryList(listOfResponse);
			session.setAttribute("transactionList", listOfResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseableHttpResponse walletCurcloseableHttpResponse = null;
		CloseableHttpClient walletCurhttpclient = HttpClients.createDefault();
		HttpPost walletCurhttpclienthttpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/userAccountCurrentBalance.do");
		List<NameValuePair> walletCurhttpclienthttpPostparams = new ArrayList<>();
		//Map<String,Object> dateValue = new HashMap<String,Object>()
		// params.add(new BasicNameValuePair("action","addbank"));
		walletCurhttpclienthttpPostparams.add(new BasicNameValuePair("api_pass", "currentbalance"));
		walletCurhttpclienthttpPostparams.add(new BasicNameValuePair("walletid", walletID));

		//params.add((NameValuePair) dateValue.put("timstamp", date));
		try {
			walletCurhttpclienthttpPost.setEntity(new UrlEncodedFormEntity(walletCurhttpclienthttpPostparams));
			walletCurcloseableHttpResponse = walletCurhttpclient.execute(walletCurhttpclienthttpPost);
			String responseString = EntityUtils.toString(walletCurcloseableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response  WALLET===== >>>>> " + responseString);
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
		return "HomeScreenWallet";
	}
	@RequestMapping(value = "/erapay/testlogin")
	public String TestLogin(HttpServletRequest request, HttpServletResponse response, Model model,
							@ModelAttribute("oKycForm") KycForm oKycForm) throws Exception {
		IpFinder ipFinder=new IpFinder();
        String iP=ipFinder.getIp(request);
		HttpSession session = request.getSession(true);
		logger.debug("Login()");
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		session.setAttribute("transactionList", " ");
		session.setAttribute("LoginMessage", " ");
		session.setAttribute("SignUpMessage", " ");
		session.setAttribute("photoemailid", "");
		session.setAttribute("USERMOBILENO","");
		session.setAttribute("SESSIONID"," ");
		session.setAttribute("WALLETBALANCE"," ");
		String userType=" ";
		LoginFormBean oLogInForm = new LoginFormBean();
		String responseCode = " ";
		String responseStatus = "";
		String userName = "";
		String sessionID = "";
		String cusCode = " ";
		String walletID =  " ";
		String mobileNo = "";
		String currentBalance = "";
		int errorexeception = 0;
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/signInRest.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("api_pass", "usersignin"));
		params.add(new BasicNameValuePair("emailid", oKycForm.getMailId()));
		params.add(new BasicNameValuePair("password", oKycForm.getPassword()));
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
			if (responseCode.equals("2")) {
				userType=json.getString("usertype");
				 userName=json.getString("User_Name");
				 session.setAttribute("GSUSERNAME", userName);
				System.out.println("UserType"+userType);
				oLogInForm.setErrorCode(responseCode);
				session.setAttribute("USERTYPE",userType);
			}
			if (responseCode.equals("0")) {
				session.setAttribute("USERTYPE",userType);
				userType=json.getString("usertype");
				userName = json.getString("User_Name");
				cusCode = json.getString("CusCode");
				walletID = json.getString("Wallet_ID");
				responseCode = json.getString("Response_Code");
				Number currentBalance1 = json.getNumber("current_Bal");
				NumberFormat formatter = new DecimalFormat("#0.00");
				String curbal2=formatter.format(currentBalance1);
				long requestCount= json.getLong("requestcount");
				String requestCount1= String.valueOf(requestCount);
				//double d = Double.parseDouble(currentBalance);
				System.out.println("doble"+curbal2);
				sessionID=json.getString("Session");
				session.setAttribute("photoemailid", oKycForm.getMailId());
				session.setAttribute("USERMOBILENO", mobileNo);
				session.setAttribute("CUSCODE", cusCode);
				session.setAttribute("SESSIONID",sessionID);
				session.setAttribute("LoginWalletId", walletID);
				session.setAttribute("WALLETBALANCE", curbal2);
                session.setAttribute("RequestCount", requestCount1);
				// sessionID =parts[3];
			}
			session.setAttribute("GSSESSION", sessionID);
			oLogInForm.setErrorCode(responseCode);
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String signInApiUrl="/erapay/testlogin";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", oKycForm.getMailId()));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionID));
		paramsHistory.add(new BasicNameValuePair("actionname", signInApiUrl));
		paramsHistory.add(new BasicNameValuePair("actionTime",dateAndTime ));
		paramsHistory.add(new BasicNameValuePair("actionouttime",""));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", oKycForm.getMailId()));
		paramsHistory.add(new BasicNameValuePair("timestamp",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		System.out.println("Response ===== >>>>> " + oKycForm.getMailId());
		System.out.println("Response ===== >>>>> " + oKycForm.getPassword());
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		String cuscode = (String) session.getAttribute("CUSCODE");
		System.out.println("CusCOde" + cuscode);
		if (oLogInForm.getErrorCode().equals("0")) {
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("LoginMessage", responseStatus);
			session.setAttribute("GSUSERNAME", userName);
			return "OTP";
		}
		else if (oLogInForm.getErrorCode().equals("1")) {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("LoginMessage", responseStatus);
			return "testlogin";
		} else if (oLogInForm.getErrorCode().equals("2") ) {
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			session.setAttribute("KYCMessage", "Please Fill Up Kyc Form");
			if(userType.equals("C"))
			{
				return "BuisnessKyc";
			}
			else if(userType.equals("P"))
			{
				return "kycnew";
			}
			return "kycnew";
		} else if (errorexeception > 0) {
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			session.setAttribute("KYCMessage", "Please Fill Up Kyc Form");
			return "error";
		} else {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			session.setAttribute("KYCMessage", "Please Fill Up Kyc Form");
			return "error";
		}
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String Home(HttpServletRequest request, HttpServletResponse response, Model model,
					   @ModelAttribute("oKycForm") KycForm oKycForm) throws Exception {
		LoginFormBean oLogInForm = new LoginFormBean();
		HttpSession session = request.getSession(true);
		String responseCode = "";
		String responseStatus = "";
		String userName = "";
		String sessionID = "";
		String cusCode = "";
		String walletID = "";
		String mobileNo = "";
		String currentBalance = "";
		String iP=ipFinder.getIp(request);
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/signInRest.do");

		session.setAttribute("KYCMessage", "");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("api_pass", " ignin"));
		params.add(new BasicNameValuePair("emailid", oKycForm.getMailId()));
		params.add(new BasicNameValuePair("password", oKycForm.getPassword()));
		System.out.println("Response ===== >>>>> " + oKycForm.getMailId());
		System.out.println("Response ===== >>>>> " + oKycForm.getPassword());
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			JSONObject json = new JSONObject(responseString);
			responseCode = json.getString("Response_Code");
			responseStatus = json.getString("Response_Status");

			if (responseCode.equals("0")) {
				userName = json.getString("User_Name");
				cusCode = json.getString("User_Name");
				walletID = json.getString("Wallet_ID");
				responseCode = json.getString("Response_Code");
				currentBalance = json.getString("Response_Code");
				session.setAttribute("CUSCODE", cusCode);
				session.setAttribute("LoginWalletId", walletID);
				// sessionID =parts[3];
			}
			session.setAttribute("GSSESSION", sessionID);
			oLogInForm.setErrorCode(responseCode);
		}

		catch (Exception e) {
			e.printStackTrace();

		} finally {
			httpclient.close();
		}
		CloseableHttpResponse closeableHttpResponseHistory = null;
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String signInApiUrl="http://10.11.201.169:8080/ERAPAY/signInRest.do";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		String sessionId= (String) session.getAttribute("SESSIONID");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", oKycForm.getMailId()));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", signInApiUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", oKycForm.getMailId()));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		System.out.println("Response ===== >>>>> " + oKycForm.getMailId());
		System.out.println("Response ===== >>>>> " + oKycForm.getPassword());
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);

		String cuscode = (String) session.getAttribute("CUSCODE");
		System.out.println("CusCOde" + cuscode);
		if (oLogInForm.getErrorCode().equals("0")) {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("LoginMessage", responseCode);
			session.setAttribute("GSUSERNAME", responseStatus);
			session.setAttribute("GSUSERMOBILE", mobileNo);
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			CloseableHttpResponse closeableHttpResponse1 = null;
			CloseableHttpClient httpclient1 = HttpClients.createDefault();
			HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getTransactionHistory.do");

			List<NameValuePair> params1 = new ArrayList<NameValuePair>();
			params1.add(new BasicNameValuePair("api_pass", "tranhistory"));
			try {
				httpPost1.setEntity(new UrlEncodedFormEntity(params1));
				closeableHttpResponse1 = httpclient1.execute(httpPost1);
				String responseString1 = EntityUtils.toString(closeableHttpResponse1.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString1);
				StringTokenizer multiTokenizer = new StringTokenizer(responseString1, ",");
				ArrayList<KycForm> listOfResponse = new ArrayList<KycForm>();
				int i = 0;
				KycForm oKycForm1 = new KycForm();

				while (multiTokenizer.hasMoreTokens()) {
					String elem = multiTokenizer.nextToken();
					elem = elem.replace("[", "").replace("]", "").replace("\"", "");
					System.out.println("elem1111===>> " + elem);
					if (i % 4 == 0)
						oKycForm1.setTrandat(elem.toString());
					else if (i % 4 == 1)
						oKycForm1.setWalletID(elem);
					else if (i % 4 == 2)
						oKycForm1.setTrnamt1(elem);
					else if (i % 4 == 3) {
						oKycForm1.setDocType(elem);
						listOfResponse.add(oKycForm1);
						oKycForm1 = new KycForm();
					}
					++i;
				}
				oKycForm.setTransctionHistoryList(listOfResponse);
				session.setAttribute("transactionList", listOfResponse);

			} catch (Exception e) {
				e.printStackTrace();
			}
			CloseableHttpResponse closeableHttpResponse2 = null;
			CloseableHttpClient httpclient2 = HttpClients.createDefault();

			HttpPost httpPost2 = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserImage.do");
			String userID = (String) session.getAttribute("GSMAILID");
			List<NameValuePair> params2 = new ArrayList<NameValuePair>();
			// Map<String,Object> dateValue = new HashMap<String,Object>()
			// params.add(new BasicNameValuePair("action","addbank"));
			params2.add(new BasicNameValuePair("api_pass", "image"));
			params2.add(new BasicNameValuePair("user_ID", userID));
			System.out.println(params2);

			// params.add((NameValuePair) dateValue.put("timstamp", date));

			try {
				httpPost2.setEntity(new UrlEncodedFormEntity(params2));
				// httpPost2.getRequestLine().get
				closeableHttpResponse2 = httpclient2.execute(httpPost2);
				String responseString2 = EntityUtils.toString(closeableHttpResponse2.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString2);
				String[] parts = responseString2.split(",");
				responseStatus = parts[0];
				String image = parts[1];
				System.out.println(image);
				byte[] data64 = Base64.getDecoder().decode(image);
				File file12 = new File("D:/images/" + cuscode + ".jpg");
				FileOutputStream fileOutputStream = new FileOutputStream(file12);
				fileOutputStream.write(data64);
				fileOutputStream.close();
				String base64Image = Base64.getEncoder().encodeToString(data64);
				oKycForm.setImage(base64Image);
				System.out.println("image" + base64Image);
				/*
				 * byte[] byteData = image.getBytes(); BufferedImage img = null;
				 * ByteArrayInputStream bis = new
				 * ByteArrayInputStream(byteData); BufferedImage bImage2 =
				 * ImageIO.read(bis); URL url = new
				 * URL("http://www.mkyong.com/image/mypic.jpg"); img =
				 * ImageIO.read(url); ImageIO.write(img, "jpg", new
				 * File("D:\\output.jpg") );
				 */
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


			return "HomeScreenWallet";
		}

		else if (oLogInForm.getErrorCode().equals("1")) {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("LoginMessage", responseStatus);
			return "paymentlogin";
		} else if (oLogInForm.getErrorCode().equals("2")) {
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			session.setAttribute("CUSCODE", cusCode);
			session.setAttribute("KYCMessage", "Please Fill Up Kyc Form");
			return "kycnew";
		} else {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("GSMAILID", oKycForm.getMailId());
			session.setAttribute("KYCMessage", "Please Fill Up Kyc Form");
			return "kycnew";
		}
	}

	@RequestMapping(value = "/home1")
	public String executehome(Model model, HttpServletRequest request, HttpServletResponse response,
							  @ModelAttribute("oLogInForm") LoginFormBean oLogInForm) throws IOException {
		HttpSession session = request.getSession(true);

		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getTransactionHistory.do");
		String outMessage = "";
		String outCode = "";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy ");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		System.out.println("DATE" + reportDate);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("api_pass", "tranhistory"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString);
			StringTokenizer multiTokenizer = new StringTokenizer(responseString, ",");
			ArrayList<LoginFormBean> listOfResponse = new ArrayList<LoginFormBean>();
			int i = 0;
			LoginFormBean oLoginFormBean = new LoginFormBean();
			while (multiTokenizer.hasMoreTokens()) {
				String elem = multiTokenizer.nextToken();
				elem = elem.replace("[", "").replace("]", "").replace("\"", "");
				// System.out.println("elem1111===>> "+elem);
				if (i % 4 == 0)
					oLoginFormBean.setWalletID(elem);
				else if (i % 4 == 1)
					oLoginFormBean.setDocType(elem);
				else if (i % 4 == 2) {
					oLoginFormBean.setTrandat(elem.toString());
				} else if (i % 4 == 3) {
					oLoginFormBean.setTrnamt(elem.toString());
					oLoginFormBean.setTrandat(elem.toString());
					listOfResponse.add(oLoginFormBean);
					oLoginFormBean = new LoginFormBean();
				}
				++i;
			}
			oLogInForm.setTransctionHistoryList(listOfResponse);
			session.setAttribute("transactionList", listOfResponse);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			httpclient.close();
		}
		return " /HomeScreenWallet";
	}
	@RequestMapping(value = "/erapay/index")
	public String Sign(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		logger.debug("Login()");
		return "NewFile";
	}

	@RequestMapping(value = "/logout")
	public String Logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		logger.debug("Login()");
		return "Login";
	}

	@RequestMapping(value = "homescreenwallet")
	public String Homescreenwallet(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		logger.debug("addbankaccount()");
		return "HomeScreenWallet";
	}
	@RequestMapping(value = "walletopen")
	public String Walletopen(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute("WalletOpenErrorMessage", " ");
		logger.debug("addbankaccount()");
		return " /WalletOpen";
	}
	/*
	 * @RequestMapping(value = "/executeaddbankaccountinfo") public String
	 * Executeaddbankaccountinfo(Model model,
	 *
	 * @ModelAttribute("oSignUpFormBean") SignUpFormBean oSignUpFormBean,
	 * HttpServletRequest request, SessionStatus status, HttpServletResponse
	 * response) throws Exception { HttpSession session =
	 * request.getSession(true); System.out.println("Name95656564 ");
	 * oAddBankAccountBO =
	 * oAddBankAccountDAO.getAddBankAccountInfo(oAddBankAccountForm.getEmail());
	 * if (oAddBankAccountBO.getErrorCode()==0) {
	 * //session.setAttribute("sErrorMessage",
	 * oMenuGenarationBO.getErrorMessage()); return " /kyc"; } else {
	 * System.out.println("Name95656564 =====>>>>>>> "); // sSuccess =
	 * sFatalErrorAction; // System.out.println("Name95656564 =====>>>>>>> " +
	 * // oAdminUserProfileBo.getEmail()); return " /MenuGenaration"; } }
	 */
	@RequestMapping(value = "/transfertobankaccount")
	public String transfertobankaccount(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		logger.debug("addbankaccount()");
		return " /TransferToBankAccount";
	}
	@RequestMapping(value = "/otptest")
	public String otptest(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(true);
		logger.debug("addbankaccount()");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://203.76.150.133/MissCallAlertAPI/talkTimeMissedCallAlert.do");
		String outMessage = "";
		String outCode = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		System.out.println("DATE" + reportDate);
		HashMap<String, String> headerMap = new HashMap<>();
		headerMap.put("api_userid", "himel");
		headerMap.put("api_pass", "123");
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("referenceNo", "123456"));
		params.add(new BasicNameValuePair("mobileNo", "01718836550"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
		return "OTP";
	}
	@RequestMapping(value = "/erapay/typeofsignup")
	public String typeofsignup(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		logger.debug("Login()");
		return "TypeOfSignUp";
	}
}
	
