package com.era.erapay.TalkTime;

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
public class TalktimeController {
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
	String talkTimeErrorCode="";
	String talkTimeErrorMesage="";
	 @RequestMapping(value= "/erapay/talktime")
		public String TalkTime(Model model,@ModelAttribute("oTalkTimeForm") TalkTimeForm oTalkTimeForm, HttpServletRequest request, HttpServletResponse response) throws IOException {
			 HttpSession session = request.getSession(true);
		 String iP=ipFinder.getIp(request);
		 String sessionId= (String) session.getAttribute("SESSIONID");
		 String mailId= (String) session.getAttribute("photoemailid");
		 CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		 String apiUrl="/erapay/talktime";
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
			 session.setAttribute("Talktimemsg", "");
			 return "TalkTimeRecharge";
		}
	 @RequestMapping(value= "/erapay/otp")
		public String OTP(Model model,@ModelAttribute("oTalkTimeForm22") TalkTimeForm oTalkTimeForm, HttpServletRequest request, HttpServletResponse response) {
			 HttpSession session = request.getSession(true);
			 session.setAttribute("Talktimemsg", "");
			 return "OTP";
		}
	 @RequestMapping(value= "/erapay/executetalktime")
		public String executeTalkTime(Model model,@ModelAttribute("oTalkTimeForm")TalkTimeForm oTalkTimeForm, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	            HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/mobileRecharge.do");
	        	DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    		Date today = Calendar.getInstance().getTime();
	    		String reportDate = df.format(today);
	    		String amount = (String) session.getAttribute("GSAMOUNT");
	    		 String mobileNO = (String) session.getAttribute("GSMOBILE");
	    		 String bill = (String) session.getAttribute("BILL");
	    		 System.out.println(amount);
	         //Map<String,Object> dateValue = new HashMap<String,Object>();
	            List<NameValuePair> params = new ArrayList<>();
	           // params.add(new BasicNameValuePair("action","addbank"));
	            params.add(new BasicNameValuePair("api_pass","recharge"));
	            params.add(new BasicNameValuePair("docnum","123"));
	            params.add(new BasicNameValuePair("sactnum","001"));
	            params.add(new BasicNameValuePair("dactnum",""));
	            params.add(new BasicNameValuePair("billtype",bill));
	            params.add(new BasicNameValuePair("mobileno",mobileNO));
	            params.add(new BasicNameValuePair("amount",amount));
	            params.add(new BasicNameValuePair("status","Y"));
	            params.add(new BasicNameValuePair("posttrid",""));
	            params.add(new BasicNameValuePair("rvdocnum",""));
	            params.add(new BasicNameValuePair("returnnum",""));
	            params.add(new BasicNameValuePair("errcode",""));
	            params.add(new BasicNameValuePair("oprstamp",userID));
	            params.add(new BasicNameValuePair("timstamp",reportDate));
	            System.out.println("value"+oTalkTimeForm.getMobileNo());
	           
	            //params.add((NameValuePair) dateValue.put("timstamp", date));
	            
	            try {
	            	httpPost.setEntity(new UrlEncodedFormEntity(params));
	                closeableHttpResponse = httpclient.execute(httpPost);
	                String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	                System.out.println("Response ===== >>>>> "+responseString);
					JSONObject json = new JSONObject(responseString);
					talkTimeErrorCode=json.getString("Response_Code");
					talkTimeErrorMesage=json.getString("Response_Status");
					//System.out.println("test jason"+errorCode+"again"+errorMessage);
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
	    			session.setAttribute("Talktimemsg",talkTimeErrorMesage);
	    			oTalkTimeForm.setFlag("Y");
	    			return "TalkTimeRecharge";
	    		} 
	            else
	            {
	    			//session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());	
	    			session.setAttribute("Talktimemsg",talkTimeErrorMesage);
	    			return"TalkTimeRecharge";
	    		} 
	 }
	            @RequestMapping(value= "/erapay/executeotp")
	    		public String executeOTP(Model model,@ModelAttribute("oTalkTimeForm1")TalkTimeForm oTalkTimeForm1, HttpServletRequest request, HttpServletResponse response) throws IOException {
	    		 HttpSession session = request.getSession(true);
	    		 String outCode="";
	             String outMessage="";
	             String userID = (String) session.getAttribute("GSMAILID");
	             String sessionID=  (String)session.getAttribute("GSSESSION");
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
	             CloseableHttpClient httpclient = HttpClients.createDefault();

	    	            HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/otpGenerate.do");
	    	        	DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    	    		Date today = Calendar.getInstance().getTime();
	    	    		String reportDate = df.format(today);
	    
	    	         //Map<String,Object> dateValue = new HashMap<String,Object>();
	    	            List<NameValuePair> params = new ArrayList<>();
	    	           // params.add(new BasicNameValuePair("action","addbank"));
	    	            session.setAttribute("BILL",oTalkTimeForm1.getBillType());
	    	            session.setAttribute("GSMOBILE",oTalkTimeForm1.getMobileNo());
	    	            session.setAttribute("GSAMOUNT",oTalkTimeForm1.getAmount());
	    	            String a=oTalkTimeForm1.getMobileNo();
	    	            params.add(new BasicNameValuePair("api_pass","otp"));
	    	            params.add(new BasicNameValuePair("userid","userID"));
	    	            params.add(new BasicNameValuePair("sessionid",sessionID));
	    	            params.add(new BasicNameValuePair("docdat",reportDate));
	    	            params.add(new BasicNameValuePair("seccod"," "));
	    	            params.add(new BasicNameValuePair("mobileno",a));
	    	            params.add(new BasicNameValuePair("email","neazahsan65@gmail.com"));
	    	            params.add(new BasicNameValuePair("status","N"));
	    	            params.add(new BasicNameValuePair("terminalid",""));
	    	            params.add(new BasicNameValuePair("oprstamp","neazahsan65@gmail.com"));
	    	            params.add(new BasicNameValuePair("timstamp",reportDate));
	    	            //params.add((NameValuePair) dateValue.put("timstamp", date));
	    	            
	    	            try {
	    	            	httpPost.setEntity(new UrlEncodedFormEntity(params));
	    	                closeableHttpResponse = httpclient.execute(httpPost);
	    	                String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
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
	    	    			session.setAttribute("Talktimemsg",outMessage);
	    	    			oTalkTimeForm1.setFlag("Y");
	    	    			return "talktime1";
	    	    		} 
	    	            else
						{
	    	    			//session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());	
	    	    			session.setAttribute("Talktimemsg",outMessage);
	    	    			return "talktime1";
	    	    		} 
	    			 
			 
		}
}
