package com.era.erapay.PinCode;

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
import com.era.erapay.wallet.WalletOpenBO;
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



@Controller
public class PinCodeController {
	private final Logger logger = LoggerFactory.getLogger(PinCodeController.class);
    WalletOpenBO oWalletOpenBO =new WalletOpenBO();
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
    @RequestMapping(value= "/erapay/setpincode")
	public String Sign(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("oPinCodeForm") PinCodeForm oPinCodeForm) throws IOException {
		 HttpSession session = request.getSession(true);
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		session.setAttribute("PINCODEMESSAGE"," ");DateFormat df = new SimpleDateFormat("dd-MM-yyyy ");
 		Date today = Calendar.getInstance().getTime();
 		String reportDate = df.format(today);
 		System.out.println("DATE"+reportDate);
 		String userID = (String) session.getAttribute("GSMAILID");
 		String cusCode = (String) session.getAttribute("CUSCODE");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="http://10.11.201.169:8080/ERAPAY/signInRest.do";
		HttpPost httpPostHistory = new HttpPost("/erapay/setpincode");
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
		 return "SetPinCode";
	}
    @RequestMapping(value= "/erapay/executesetpincode")
 	public String executesetpincode(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("oPinCodeForm") PinCodeForm oPinCodeForm) throws IOException {
 		 HttpSession session = request.getSession(true);
 	     session.setAttribute("PINCODEMESSAGE"," ");
		 String iP=ipFinder.getIp(request);
		 String sessionId= (String) session.getAttribute("SESSIONID");
		 String mailId= (String) session.getAttribute("photoemailid");
 		 CloseableHttpResponse closeableHttpResponse = null;
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 String errorCode="";
		 String errorMessage="";
		 String cuscode = (String) session.getAttribute("CUSCODE");
		 String userId = (String) session.getAttribute("GSMAILID");
		 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date today = Calendar.getInstance().getTime();
			String reportDate = df.format(today);




			System.out.println("Date"+reportDate);
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/executesetpincode";
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
		 HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/setUserPinCode.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
	
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass","setpin"));
		params.add(new BasicNameValuePair("user_pass",oPinCodeForm.getPassword()));
		params.add(new BasicNameValuePair("userid",userId));
		params.add(new BasicNameValuePair("cuscod",cuscode));
		params.add(new BasicNameValuePair("seccod",oPinCodeForm.getConfirmNewPin()));
		params.add(new BasicNameValuePair("Actdate",reportDate));
		params.add(new BasicNameValuePair("oprstamp",userId));
		params.add(new BasicNameValuePair("actflg","Y"));
		params.add(new BasicNameValuePair("Timstamp",reportDate));
	System.out.println("TEST VALUE"+oPinCodeForm.getPassword()+"again"+cuscode);
	
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
			JSONObject json = new JSONObject(responseString);
			errorCode=json.getString("Response_Code");
			errorMessage=json.getString("Response_Status");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}

        if (errorCode.equals("0")) {
			//session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());	
			session.setAttribute("PINCODEMESSAGE",errorMessage);
			return "SetPinCode";
		} 
        
        else  {
			//session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());	
			session.setAttribute("PINCODEMESSAGE",errorMessage);
			 return "SetPinCode";
		}		
 	}
}
