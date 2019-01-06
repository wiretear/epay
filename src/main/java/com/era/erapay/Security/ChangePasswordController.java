package com.era.erapay.Security;

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
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ChangePasswordController {
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
	@RequestMapping(value = "/erapay/changepassword")
	public String changepassword(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oChangePasswordForm") ChangePasswordForm oChangePasswordForm) throws IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("CHANGEPASSWORDMESSAGE", " ");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/changepassword";
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
		return "ChangePassword";
	}
	@RequestMapping(value = "/erapay/executechangepassword")
	public String executesetpincode(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oChangePasswordForm") ChangePasswordForm oChangePasswordForm) throws IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("CHANGEPASSWORDMESSAGE", " ");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String errorCode = "";
		String errorMessage = "";
		System.out.println(oChangePasswordForm.getConfirmNewPassword());
		String cuscode = (String) session.getAttribute("CUSCODE");
		String userId = (String) session.getAttribute("GSMAILID");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		int passlength = oChangePasswordForm.getConfirmNewPassword().length();
		String passLength = Integer.toString(passlength);
		System.out.println("Date" + reportDate);
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/usersPasswordChange.do");
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass", "changepass"));
		params.add(new BasicNameValuePair("passid", ""));
		params.add(new BasicNameValuePair("passtype", "Individual"));
		params.add(new BasicNameValuePair("current_pass", oChangePasswordForm.getCurrentPassword()));
		params.add(new BasicNameValuePair("password", oChangePasswordForm.getConfirmNewPassword()));
		params.add(new BasicNameValuePair("passlength", passLength));
		params.add(new BasicNameValuePair("status", "Y"));
		params.add(new BasicNameValuePair("oprstamp", userId));
		params.add(new BasicNameValuePair("timstamp", reportDate));
		params.add(new BasicNameValuePair("user_id", userId));
		// System.out.println("TEST
		// VALUE"+oPinCodeForm.getPassword()+"again"+cuscode);

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			/*
			 * System.out.println("Response ===== >>>>> "+responseString);
			 * String[] parts = responseString.split(","); outMessage=parts[0];
			 * outCode=parts[1]; //osignUpFormBean.setErrorCode(outCode);
			 */
			System.out.println("Response ===== >>>>> " + responseString);
			JSONObject json = new JSONObject(responseString);
			errorCode = json.getString("Response_Code");
			errorMessage = json.getString("Response_Status");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/executechangepassword";
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

		if (errorCode.equals("0")) {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("CHANGEPASSWORDMESSAGE", errorMessage);
			return "ChangePassword";
		}

		else {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("CHANGEPASSWORDMESSAGE", errorMessage);
			return "ChangePassword";
		}
	}

}
