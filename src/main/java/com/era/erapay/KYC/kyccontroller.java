package com.era.erapay.KYC;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.era.erapay.common.ActivityHistoryApiCall;
import com.era.erapay.common.IpFinder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
/*import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;*/
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.apache.taglibs.standard.extra.spath.Path;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class kyccontroller {
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
 

	@RequestMapping(value = "/erapay/kycnew")
	public String kycnew(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/kycnew";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
        session.setAttribute("USERINFORESPONSEADDRESS", " ");
        session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
        session.setAttribute("USERINFORESPONSE", " ");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
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

		return "kychome";
	}
	@RequestMapping(value = "/erapay/kyc")
	public String kyc(HttpServletRequest request, HttpServletResponse response,
						 @ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/kycnew";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
		session.setAttribute("USERINFORESPONSE", " ");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
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

		return "kychome";
	}
    @RequestMapping(value = "/erapay/updatekycbasicinfo")
    public String updatekycbasicinfo(HttpServletRequest request, HttpServletResponse response,
                         @ModelAttribute("oKycForm") KycForm oKycForm) throws IOException, ParseException {
        HttpSession session = request.getSession(true);
		String cusCode = (String) session.getAttribute("CUSCODE");
		String basicinfo = request.getParameter("basicinfo");
		System.out.println("Button"+basicinfo);
        String errorCode = "";
        String errorMessage = "";
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        // Print what date is today!
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
        System.out.println("Report Date: " + reportDate);
        String userID = (String) session.getAttribute("GSMAILID");
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/updateUserBasicInfoDetails.do");
        // Map<String,Object> dateValue = new HashMap<String,Object>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = formatter.parse(oKycForm.getDateOfBirth());
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String fbirthDate =df1.format(birthDate);
        System.out.println("OHHH DATE"+fbirthDate);
		System.out.println("OHHH NAME"+cusCode);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("api_pass","updateuserbasicinfo"));
        params.add(new BasicNameValuePair("cuscod", cusCode));
        params.add(new BasicNameValuePair("cusnam",oKycForm.getName()));
        params.add(new BasicNameValuePair("opndat",reportDate));
        params.add(new BasicNameValuePair("custyp","regular"));
        params.add(new BasicNameValuePair("ctitle","regular"));
        params.add(new BasicNameValuePair("ftitle","mr"));
        params.add(new BasicNameValuePair("fname",  oKycForm.getFatherName()));
        params.add(new BasicNameValuePair("mtitle","mrs"));
        params.add(new BasicNameValuePair("mname",oKycForm.getMotherName()));
        params.add(new BasicNameValuePair("cusdob",fbirthDate));
        params.add(new BasicNameValuePair("gender","m"));
        params.add(new BasicNameValuePair("stitle", ""));
        params.add(new BasicNameValuePair("spname",""));
        params.add(new BasicNameValuePair("emailid", oKycForm.getEmail()));
        params.add(new BasicNameValuePair("mobileno", oKycForm.getContactNo()));
        params.add(new BasicNameValuePair("teleno",oKycForm.getContactNo()));
        params.add(new BasicNameValuePair("telxno", " "));
        params.add(new BasicNameValuePair("faxno",""));
        params.add(new BasicNameValuePair("nid",oKycForm.getNationalId()));
        params.add(new BasicNameValuePair("passportno", oKycForm.getPassport()));
        params.add(new BasicNameValuePair("TimeStamp",reportDate));
        params.add(new BasicNameValuePair("oprstamp",oKycForm.getName()));
        params.add(new BasicNameValuePair("terminalid", ""));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);
            errorCode=json.getString("Response_Code");
            errorMessage=json.getString("Response_Status");
            System.out.println("test jason"+errorCode+"again"+errorMessage);

            session.setAttribute("KYCUPDATEMESSAGE", "BasicInfo Added Successfully");
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
		String apiUrl="/erapay/updatekycbasicinfo";
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
        if(errorCode.equals("0"))
        {
            session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
            return "kychome";
        }
        else
        {
            session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
            return "kychome";
        }
    }

	@RequestMapping(value = "/erapay/kycintroducerinfo")
	public String kycintroducerinfo(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String userID = (String) session.getAttribute("GSMAILID");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String cuscode = (String) session.getAttribute("CUSCODE");
        String flag = " ";
		System.out.println("Cuse"+cuscode);
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserIntroducerDetails.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass","userintroducerinfo"));
		params.add(new BasicNameValuePair("oprstamp",userID));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);

			//	JSONObject responseString = (JSONObject) closeableHttpResponse.getEntity();
			//	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			//	System.out.println("Response ===== >>>>> " + responseString);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			int stringLen = responseString.length();
			System.out.println("LENGTH" + responseString);
            if ( responseString.equals("")) {
                flag = "flag";
                System.out.println("LENGTH Flag" + flag);
                session.setAttribute("USERINFORESPONSEINTRODUCER", flag);
            }

			if ( !responseString.equals("[]")) {

				System.out.println("ResponseOrginal ===== >>>>> " + responseString);
				System.out.println("Response ===== >>>>> " + responseString);
				JSONObject json = new JSONObject(responseString);
				String introname = json.getString("introname");
				String introaddr = json.getString("introaddr");
				//String dateOfBirth=json.getString("cusdob");
				String ocupation = json.getString("ocupation");
				String mobileno = json.getString("mobileno");
				System.out.println("DEE"+introname+introaddr);
				oKycForm.setIntroducerMobileNo(mobileno);
				oKycForm.setIntroducerOccupation(ocupation);
				oKycForm.setIntroducerName(introname);
				oKycForm.setIntroducerAddress(introaddr);
		}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			httpclient.close();
		}

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apUrl="/erapay/kycintroducerinfo";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", apUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));

		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		return "kycintroducer";
	}
	@RequestMapping(value = "/erapay/kycaddressinfo")
	public String kycaddressinfo(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String userID = (String) session.getAttribute("GSMAILID");
		String LoginWalletId = (String) session.getAttribute("LoginWalletId");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		String userType= (String) session.getAttribute("USERTYPE");
		System.out.println("USERTYPE"+userType);
		System.out.println("wall" + LoginWalletId);
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String cuscode = (String) session.getAttribute("CUSCODE");

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/kycaddressinfo";
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
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserAddressDetails.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass", "useraddressinfo"));
		params.add(new BasicNameValuePair("emailid", userID));

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("responseString" + responseString);
			int stringLen = responseString.length();
			System.out.println("LENGTH" + stringLen);
			String flag=" ";
            if (responseString.equals("[]")) {
                flag = "flag";
                session.setAttribute("USERINFORESPONSEADDRESS", flag);
            }
			if (!responseString.equals("[]")) {


				System.out.println("LogWall ===== >>>>> " + LoginWalletId);
				String DataResponse = responseString.replace("[", "").replace("]", "");
				String DataResponse1 = DataResponse.replace("\"", "");
				System.out.println("DataResponse ===== >>>>> " + DataResponse);
				System.out.println("DataResponse ===== >>>>> " + DataResponse1);
				String[] parts = DataResponse1.split(",");
				String presentadr1 = parts[0];
				String presentadr2 = parts[1];
				String presentadr3 = parts[2];
				String presentcitycode = parts[3];
				String presentcountry = parts[4];
				String permamnentadr1 = parts[5];
				System.out.println(" permamnentadr1===== >>>>> " + permamnentadr1);
				String permamnentadr2 = parts[6];
				String permamnentadr3 = parts[7];
				String permamnentcitycode = parts[8];
				String permamnentcountry = parts[9];
				oKycForm.setPresentAddress(presentadr1);
				oKycForm.setPermanentAddress(permamnentadr1);
				oKycForm.setPermanentCity(permamnentcitycode);
				oKycForm.setPresentCity(presentcitycode);
			/*
			 String DataResponse = responseString.replace("[", "{").replace("]", "}");
				System.out.println("Response ===== >>>>> " + DataResponse);
			JSONObject json = new JSONObject(DataResponse);
			String presentAddress=json.getString("addrs1");
			String permanentAddress=json.getString("addrs2");
			JSONArray arr = new JSONArray(DataResponse);
			
			String a="";
			String b="";
			String c="";
			String d="";
			String e="";
			String f="";
			System.out.println("length"+arr.length());
			for(int i = 0; i < arr.length(); i++){
				JSONObject obj = arr.getJSONObject(i);
				a=obj.getString("emailid");
				b=obj.getString("addrs1");
				c=obj.getString("addrs2");
			}
			oKycForm.setPresentAddress(presentAddress);
			oKycForm.setPermanentAddress(permanentAddress);
			//String dateOfBirth=json.getString("cusdob");
	

		
			//JSONObject temp1 = new JSONObject(json_string);
			//JSONObject json = new JSONObject(closeableHttpResponse);	
		
			/*String[] parts = responseString.split(",");
			 String emailid =request.getParameter("emailid"); */
				//	 System.out.println("EMAIL"+emailid);
				// String DataResponse = responseString.replace("[",
				// "").replace("]", "");
				// result += responseBody;

				// System.out.println("Response ===== >>>>>
				// "+closeableHttpResponse);

		}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			httpclient.close();
		}
		return "kycaddress";

}
	@RequestMapping(value = "/erapay/kycinfoparameter")
	public String kycinfoparameter(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		 String userID = (String) session.getAttribute("GSMAILID");
		 String useremail = (String) session.getAttribute("GSMAILID");
		 String username = (String) session.getAttribute("GSUSERNAME");
		String cuscode = (String) session.getAttribute("CUSCODE");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		String flag=" ";
		 oKycForm.setName(username);
		 oKycForm.setEmail(useremail);
		 System.out.println("USER ID"+userID);

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apUrl="/erapay/kycinfoparameter";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", apUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		System.out.println("ResponseCus"+cuscode);

		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserInfoDetails.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass","userbasicinfo"));
		params.add(new BasicNameValuePair("userid",userID));
	try {
		httpPost.setEntity(new UrlEncodedFormEntity(params));
		closeableHttpResponse = httpclient.execute(httpPost);
		//	JSONObject responseString = (JSONObject) closeableHttpResponse.getEntity();

		//	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//	System.out.println("Response ===== >>>>> " + responseString);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("responseString" + responseString);
			int stringLen = responseString.length();
			System.out.println("LENGTH" + stringLen);
			JSONObject json = new JSONObject(responseString);
			System.out.println(" ");
		String errorCode = json.getString("Response_Code");
		if (errorCode.equals("1")) {
			flag = "flag1";
			session.setAttribute("USERINFORESPONSE", flag);
		}
		else if (errorCode.equals("0")) {
			String email = json.getString("emailid");
			String name = json.getString("cusnam");
			String dateOfBirth = json.getString("cusdob");
			String fatherName = json.getString("fname");
			String motherName = json.getString("mname");
			String contactNO = json.getString("mobileno");
			String nationalId = json.getString("passportno");
			String passportNo = json.getString("nid");
			String gender = json.getString("gender");
			//System.out.println("Date"+json.getd);
			oKycForm.setContactNo(contactNO);
			//oKycForm.setDateOfBirth(dateOfBirth);
			oKycForm.setFatherName(fatherName);
			oKycForm.setMotherName(motherName);
			oKycForm.setName(name);
			oKycForm.setEmail(email);
			oKycForm.setNationalId(nationalId);
			oKycForm.setPassport(passportNo);
			oKycForm.setDateOfBirth(dateOfBirth);

			//JSONObject temp1 = new JSONObject(json_string);
			//JSONObject json = new JSONObject(closeableHttpResponse);

			/*String[] parts = responseString.split(",");
			 String emailid =request.getParameter("emailid"); */
			//	 System.out.println("EMAIL"+emailid);
			// String DataResponse = responseString.replace("[",
			// "").replace("]", "");
			// result += responseBody;

			// System.out.println("Response ===== >>>>>
			// "+closeableHttpResponse);

		}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			httpclient.close();
		}
		return "kycbasicinfo";
	}



	@RequestMapping(value = "/erapay/executekycbasicinfo")
	public String kycbasicinfo(HttpServletRequest request, KycForm oKycForm) throws IOException, ParseException {
		HttpSession session = request.getSession(true);
		String basicInfoBtn = request.getParameter("basicinfo");
		String basicInfoBtn1 = request.getParameter("clicked_button");
		System.out.println("Button123" + basicInfoBtn1);
		String errorCode = "";
		String errorMessage = "";
		session.setAttribute("USERINFORESPONSE"," ");
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
		String userType= (String) session.getAttribute("USERTYPE");
		System.out.println("USERTYPE"+userType);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		// Print what date is today!
		System.out.println("Report Date: " + reportDate);
		String userID = (String) session.getAttribute("GSMAILID");
		String cusCode = (String) session.getAttribute("CUSCODE");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		session.setAttribute("USERINFORESPONSE"," ");
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apUrl="/erapay/executekycbasicinfo";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", apUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		if (basicInfoBtn1.equals("Update")) {
			CloseableHttpResponse closeableHttpResponse = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/updateUserBasicInfoDetails.do");
			// Map<String,Object> dateValue = new HashMap<String,Object>();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate = formatter.parse(oKycForm.getDateOfBirth());
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			String fbirthDate = df1.format(birthDate);
			System.out.println("OHHH DATE" + fbirthDate);
			System.out.println("OHHH NAME" + cusCode);
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("api_pass", "updateuserbasicinfo"));
			params.add(new BasicNameValuePair("cuscod", cusCode));
			params.add(new BasicNameValuePair("cusnam", oKycForm.getName()));
			params.add(new BasicNameValuePair("opndat", reportDate));
			params.add(new BasicNameValuePair("custyp", "regular"));
			params.add(new BasicNameValuePair("ctitle", "regular"));
			params.add(new BasicNameValuePair("ftitle", "mr"));
			params.add(new BasicNameValuePair("fname", oKycForm.getFatherName()));
			params.add(new BasicNameValuePair("mtitle", "mrs"));
			params.add(new BasicNameValuePair("mname", oKycForm.getMotherName()));
			params.add(new BasicNameValuePair("cusdob", fbirthDate));
			params.add(new BasicNameValuePair("gender", "m"));
			params.add(new BasicNameValuePair("stitle", ""));
			params.add(new BasicNameValuePair("spname", ""));
			params.add(new BasicNameValuePair("emailid", oKycForm.getEmail()));
			params.add(new BasicNameValuePair("mobileno", oKycForm.getContactNo()));
			params.add(new BasicNameValuePair("teleno", oKycForm.getContactNo()));
			params.add(new BasicNameValuePair("telxno", " "));
			params.add(new BasicNameValuePair("faxno", ""));
			params.add(new BasicNameValuePair("nid", oKycForm.getNationalId()));
			params.add(new BasicNameValuePair("passportno", oKycForm.getPassport()));
			params.add(new BasicNameValuePair("TimeStamp", reportDate));
			params.add(new BasicNameValuePair("oprstamp", oKycForm.getName()));
			params.add(new BasicNameValuePair("terminalid", ""));

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				closeableHttpResponse = httpclient.execute(httpPost);
				String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString);
				JSONObject json = new JSONObject(responseString);
				errorCode = json.getString("Response_Code");
				errorMessage = json.getString("Response_Status");
				System.out.println("test jason" + errorCode + "again" + errorMessage);

				session.setAttribute("KYCUPDATEMESSAGE", "BasicInfo Added Successfully");
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
			if (errorCode.equals("0")) {
				session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
				return "kychome";
			} else {
				session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
				return "kychome";
			}
		}
		else
			{
				if(userType.equals("C")){
					CloseableHttpResponse closeableHttpResponse = null;
					CloseableHttpClient httpclient = HttpClients.createDefault();
					HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addBasicInfoKyc.do");
					// Map<String,Object> dateValue = new HashMap<String,Object>();
					System.out.println("OHHH DATE" + oKycForm.getDateOfBirth());
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					//Date birthDate = formatter.parse(oKycForm.getDateOfBirth());
					DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
					//String fbirthDate = df1.format(birthDate);
					//System.out.println("OHHH DATE" + fbirthDate);
					List<NameValuePair> params = new ArrayList<>();
					params.add(new BasicNameValuePair("api_pass", "kycbasicinfo"));
					params.add(new BasicNameValuePair("cuscod", ""));
					params.add(new BasicNameValuePair("cusnam", oKycForm.getName()));
					params.add(new BasicNameValuePair("opndat", reportDate));
					params.add(new BasicNameValuePair("custyp", "regular"));
					params.add(new BasicNameValuePair("ctitle", "regular"));
					params.add(new BasicNameValuePair("ftitle", "mr"));
					params.add(new BasicNameValuePair("fname", oKycForm.getFatherName()));
					params.add(new BasicNameValuePair("mtitle", "mrs"));
					params.add(new BasicNameValuePair("mname", oKycForm.getMotherName()));
					params.add(new BasicNameValuePair("cusdob",reportDate));
					params.add(new BasicNameValuePair("gender", "m"));
					params.add(new BasicNameValuePair("stitle", ""));
					params.add(new BasicNameValuePair("spname", ""));
					params.add(new BasicNameValuePair("emailid", oKycForm.getEmail()));
					params.add(new BasicNameValuePair("mobileno", oKycForm.getContactNo()));
					params.add(new BasicNameValuePair("teleno", oKycForm.getContactNo()));
					params.add(new BasicNameValuePair("telxno", " "));
					params.add(new BasicNameValuePair("faxno", ""));
					params.add(new BasicNameValuePair("nid", oKycForm.getNationalId()));
					params.add(new BasicNameValuePair("passportno", oKycForm.getPassport()));
					params.add(new BasicNameValuePair("TimeStamp", reportDate));
					params.add(new BasicNameValuePair("oprstamp", oKycForm.getName()));
					params.add(new BasicNameValuePair("terminalid", "C"));
					params.add(new BasicNameValuePair("businesstype", "Software"));
					try {
						httpPost.setEntity(new UrlEncodedFormEntity(params));
						closeableHttpResponse = httpclient.execute(httpPost);
						String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
						System.out.println("Response ===== >>>>> " + responseString);
						JSONObject json = new JSONObject(responseString);
						errorCode = json.getString("Response_Code");
						errorMessage = json.getString("Response_Status");
						System.out.println("test jason" + errorCode + "again" + errorMessage);

						session.setAttribute("KYCUPDATEMESSAGE", "BasicInfo Added Successfully");
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
					if (errorCode.equals("0")) {
						session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
						return "kychome";
					} else {
						session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
						return "kychome";
					}
				}
				else{
					CloseableHttpResponse closeableHttpResponse = null;
					CloseableHttpClient httpclient = HttpClients.createDefault();
					HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addBasicInfoKyc.do");
					// Map<String,Object> dateValue = new HashMap<String,Object>();
					System.out.println("OHHH DATE" + oKycForm.getDateOfBirth());
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date birthDate = formatter.parse(oKycForm.getDateOfBirth());
					DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
					String fbirthDate = df1.format(birthDate);
					System.out.println("OHHH DATE" + fbirthDate);
					List<NameValuePair> params = new ArrayList<>();
					params.add(new BasicNameValuePair("api_pass", "kycbasicinfo"));
					params.add(new BasicNameValuePair("cuscod", ""));
					params.add(new BasicNameValuePair("cusnam", oKycForm.getName()));
					params.add(new BasicNameValuePair("opndat", reportDate));
					params.add(new BasicNameValuePair("custyp", "regular"));
					params.add(new BasicNameValuePair("ctitle", "regular"));
					params.add(new BasicNameValuePair("ftitle", "mr"));
					params.add(new BasicNameValuePair("fname", oKycForm.getFatherName()));
					params.add(new BasicNameValuePair("mtitle", "mrs"));
					params.add(new BasicNameValuePair("mname", oKycForm.getMotherName()));
					params.add(new BasicNameValuePair("cusdob", fbirthDate));
					params.add(new BasicNameValuePair("gender", "m"));
					params.add(new BasicNameValuePair("stitle", ""));
					params.add(new BasicNameValuePair("spname", ""));
					params.add(new BasicNameValuePair("emailid", oKycForm.getEmail()));
					params.add(new BasicNameValuePair("mobileno", oKycForm.getContactNo()));
					params.add(new BasicNameValuePair("teleno", oKycForm.getContactNo()));
					params.add(new BasicNameValuePair("telxno", " "));
					params.add(new BasicNameValuePair("faxno", ""));
					params.add(new BasicNameValuePair("nid", oKycForm.getNationalId()));
					params.add(new BasicNameValuePair("passportno", oKycForm.getPassport()));
					params.add(new BasicNameValuePair("TimeStamp", reportDate));
					params.add(new BasicNameValuePair("oprstamp", oKycForm.getName()));
					params.add(new BasicNameValuePair("terminalid", "P"));

					try {
						httpPost.setEntity(new UrlEncodedFormEntity(params));
						closeableHttpResponse = httpclient.execute(httpPost);
						String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
						System.out.println("Response ===== >>>>> " + responseString);
						JSONObject json = new JSONObject(responseString);
						errorCode = json.getString("Response_Code");
						errorMessage = json.getString("Response_Status");
						System.out.println("test jason" + errorCode + "again" + errorMessage);

						session.setAttribute("KYCUPDATEMESSAGE", "BasicInfo Added Successfully");
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
					if (errorCode.equals("0")) {
						session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
						return "kycnew";
					} else {
						session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
						return "kycnew";
					}

				}
		}
	}
	@RequestMapping(value = "/erapay/executekycaddress")
	public String kycaddress(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String errorCode = "";
		String errorMessage = "";
		String userType= (String) session.getAttribute("USERTYPE");
		System.out.println("USERTYPE"+userType);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		String addressInfoUpdateBtn =" ";
		// Print what date is today!
		session.setAttribute("USERINFORESPONSE"," ");
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
		System.out.println("Report Date: " + reportDate);
		String basicInfoBtn1 = request.getParameter("clicked_button");
		 addressInfoUpdateBtn = request.getParameter("AddressInfoUpdateBtn");
		System.out.println("Button55464646464646464" + addressInfoUpdateBtn);
		System.out.println("Button64646664646464646464" + basicInfoBtn1);
		String userID = (String) session.getAttribute("GSMAILID");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");


		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apUrl="/erapay/executekycaddress";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", apUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		if (basicInfoBtn1.equals("Update")) {
			CloseableHttpResponse closeableHttpResponse = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/updateUserAddressInfoDetails.do");
			// Map<String,Object> dateValue = new HashMap<String,Object>();

			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("api_pass", "updateuseraddressinfo"));
			params.add(new BasicNameValuePair("mailid", userID));
			params.add(new BasicNameValuePair("pres_addrs", oKycForm.getPresentAddress()));
			params.add(new BasicNameValuePair("pres_city", oKycForm.getPresentCity()));
			params.add(new BasicNameValuePair("pres_country", "Bangaldesh"));
			params.add(new BasicNameValuePair("permn_addrs", oKycForm.getPermanentAddress()));
			params.add(new BasicNameValuePair("permn_city", oKycForm.getPermanentCity()));
			params.add(new BasicNameValuePair("permn_country", "Bangaldesh"));
			params.add(new BasicNameValuePair("adrtype", "adrtype"));
			params.add(new BasicNameValuePair("addrs2", "Yet To Decalre"));
			params.add(new BasicNameValuePair("addrs3", "Not Yet  Decalre"));
			params.add(new BasicNameValuePair("zipcod", "1236"));
			params.add(new BasicNameValuePair("upazila_code", "1023"));
			params.add(new BasicNameValuePair("district_code", "85"));
			params.add(new BasicNameValuePair("division_code", "74"));
			params.add(new BasicNameValuePair("period", "21"));
			params.add(new BasicNameValuePair("ownerent", "yes"));
			params.add(new BasicNameValuePair("teleno", "226546546"));
			params.add(new BasicNameValuePair("telexno", "54444"));
			params.add(new BasicNameValuePair("faxno", "74151211"));
			params.add(new BasicNameValuePair("moblno", "0168746546"));
			params.add(new BasicNameValuePair("emailid", userID));
			params.add(new BasicNameValuePair("oprstamp", userID));
			params.add(new BasicNameValuePair("TimeStamp", reportDate));
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				closeableHttpResponse = httpclient.execute(httpPost);
				String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString);
				JSONObject json = new JSONObject(responseString);
				errorCode = json.getString("Response_Code");
				errorMessage = json.getString("Response_Status");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				httpclient.close();
			}
			session.setAttribute("KYCUPDATEMESSAGE", errorMessage);
			return "kychome";
		}

	if(userType.equals("C")){
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addAddressInfoKyc.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass", "kycadressinfo"));
		params.add(new BasicNameValuePair("mailid", userID));
		params.add(new BasicNameValuePair("pres_addrs", oKycForm.getPresentAddress()));
		params.add(new BasicNameValuePair("pres_city", oKycForm.getPresentCity()));
		params.add(new BasicNameValuePair("pres_country", "Bangaldesh"));
		params.add(new BasicNameValuePair("permn_addrs", oKycForm.getPermanentAddress()));
		params.add(new BasicNameValuePair("permn_city", oKycForm.getPermanentCity()));
		params.add(new BasicNameValuePair("permn_country", "Bangaldesh"));
		params.add(new BasicNameValuePair("adrtype", "adrtype"));
		params.add(new BasicNameValuePair("addrs2", "Yet To Decalre"));
		params.add(new BasicNameValuePair("addrs3", "Not Yet  Decalre"));
		params.add(new BasicNameValuePair("zipcod", "1236"));
		params.add(new BasicNameValuePair("upazila_code", "1023"));
		params.add(new BasicNameValuePair("district_code", "85"));
		params.add(new BasicNameValuePair("division_code", "74"));
		params.add(new BasicNameValuePair("period", "21"));
		params.add(new BasicNameValuePair("ownerent", "yes"));
		params.add(new BasicNameValuePair("teleno", "226546546"));
		params.add(new BasicNameValuePair("telexno", "54444"));
		params.add(new BasicNameValuePair("faxno", "74151211"));
		params.add(new BasicNameValuePair("moblno", "0168746546"));
		params.add(new BasicNameValuePair("emailid", userID));
		params.add(new BasicNameValuePair("oprstamp", userID));
		params.add(new BasicNameValuePair("TimeStamp", reportDate));
		params.add(new BasicNameValuePair("terminalid", "C"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString);
			String[] parts = responseString.split(",");

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
		session.setAttribute("KYCUPDATEMESSAGE", "Address Added Successfully");
		return "BuisnessKyc";
	}
			CloseableHttpResponse closeableHttpResponse = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addAddressInfoKyc.do");
			// Map<String,Object> dateValue = new HashMap<String,Object>();
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("api_pass", "kycadressinfo"));
			params.add(new BasicNameValuePair("mailid", userID));
			params.add(new BasicNameValuePair("pres_addrs", oKycForm.getPresentAddress()));
			params.add(new BasicNameValuePair("pres_city", oKycForm.getPresentCity()));
			params.add(new BasicNameValuePair("pres_country", "Bangaldesh"));
			params.add(new BasicNameValuePair("permn_addrs", oKycForm.getPermanentAddress()));
			params.add(new BasicNameValuePair("permn_city", oKycForm.getPermanentCity()));
			params.add(new BasicNameValuePair("permn_country", "Bangaldesh"));
			params.add(new BasicNameValuePair("adrtype", "adrtype"));
			params.add(new BasicNameValuePair("addrs2", "Yet To Decalre"));
			params.add(new BasicNameValuePair("addrs3", "Not Yet  Decalre"));
			params.add(new BasicNameValuePair("zipcod", "1236"));
			params.add(new BasicNameValuePair("upazila_code", "1023"));
			params.add(new BasicNameValuePair("district_code", "85"));
			params.add(new BasicNameValuePair("division_code", "74"));
			params.add(new BasicNameValuePair("period", "21"));
			params.add(new BasicNameValuePair("ownerent", "yes"));
			params.add(new BasicNameValuePair("teleno", "226546546"));
			params.add(new BasicNameValuePair("telexno", "54444"));
			params.add(new BasicNameValuePair("faxno", "74151211"));
			params.add(new BasicNameValuePair("moblno", "0168746546"));
			params.add(new BasicNameValuePair("emailid", userID));
			params.add(new BasicNameValuePair("oprstamp", userID));
			params.add(new BasicNameValuePair("TimeStamp", reportDate));
		params.add(new BasicNameValuePair("terminalid", "P"));
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				closeableHttpResponse = httpclient.execute(httpPost);
				String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString);
				String[] parts = responseString.split(",");

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
			session.setAttribute("KYCUPDATEMESSAGE", "Address Added Successfully");
			return "kychome";

	}
	@RequestMapping(value = "/erapay/executekycintroducer")
	public String kycintroducer(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String errorCode = "";
		String errorMessage = "";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		// Print what date is today!
		System.out.println("Report Date: " + reportDate);

		String userID = (String) session.getAttribute("GSMAILID");
		CloseableHttpResponse closeableHttpResponse = null;
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addIntroducerKyc.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();



		String userType= (String) session.getAttribute("USERTYPE");
		if(userType.equals("C")){
			CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
			String apiUrl="erapay/executekycintroducer";
			HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
			session.setAttribute("KYCMessage", "");
			List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
			session.setAttribute("USERINFORESPONSE"," ");
			session.setAttribute("USERINFORESPONSEADDRESS", " ");
			session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
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
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("api_pass","kycintroducer"));
			params.add(new BasicNameValuePair("introid", ""));
			params.add(new BasicNameValuePair("introname",oKycForm.getIntroducerName()));
			params.add(new BasicNameValuePair("introaddr",oKycForm.getIntroducerAddress()));
			params.add(new BasicNameValuePair("ocupation",oKycForm.getIntroducerOccupation()));
			params.add(new BasicNameValuePair("mobileno",oKycForm.getIntroducerMobileNo()));
			params.add(new BasicNameValuePair("actflg","Y"));
			params.add(new BasicNameValuePair("oprstamp",userID));
			params.add(new BasicNameValuePair("TimeStamp",reportDate));
			params.add(new BasicNameValuePair("terminalid","C"));

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				closeableHttpResponse = httpclient.execute(httpPost);
				String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
				System.out.println("Response ===== >>>>> " + responseString);
				JSONObject json = new JSONObject(responseString);
				errorCode=json.getString("Response_Code");
				errorMessage=json.getString("Response_Message");
				System.out.println("test jason"+errorCode+"again"+errorMessage);
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
			session.setAttribute("KYCUPDATEMESSAGE", "Intrdoucer Info Added Successfully");
			return "BuisnessKyc";
		}
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="erapay/executekycintroducer";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		session.setAttribute("USERINFORESPONSE"," ");
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
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
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass","kycintroducer"));
		params.add(new BasicNameValuePair("introid", ""));
		params.add(new BasicNameValuePair("introname",oKycForm.getIntroducerName()));
		params.add(new BasicNameValuePair("introaddr",oKycForm.getIntroducerAddress()));
		params.add(new BasicNameValuePair("ocupation",oKycForm.getIntroducerOccupation()));
		params.add(new BasicNameValuePair("mobileno",oKycForm.getIntroducerMobileNo()));
		params.add(new BasicNameValuePair("actflg","Y"));
		params.add(new BasicNameValuePair("oprstamp",userID));
		params.add(new BasicNameValuePair("TimeStamp",reportDate));
		params.add(new BasicNameValuePair("terminalid","P"));
		
		
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString);
			JSONObject json = new JSONObject(responseString);
			errorCode=json.getString("Response_Code");
			errorMessage=json.getString("Response_Status");
			System.out.println("test jason"+errorCode+"again"+errorMessage);
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
		session.setAttribute("KYCUPDATEMESSAGE", "Intrdoucer Info Added Successfully");
		return "kychome";
	}
	@RequestMapping(value = "/erapay/kycapproval")
	public String kycapproval(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("oKycForm") KycForm oKycForm) {
		return "users/kycapproval";
	}
	@RequestMapping(value = "/executekyc12")
	public String kyc(Model model, @ModelAttribute("oKycForm") KycForm oKycForm, HttpServletRequest request,
			SessionStatus status, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		String outCode = "";
		String outMessage = "";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		// Print what date is today!
		System.out.println("Report Date: " + reportDate);

		String userID = (String) session.getAttribute("GSMAILID");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addkyc.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		File file = new File(oKycForm.getImageFile().toString());
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass", "kyc"));
		params.add(new BasicNameValuePair("pres_addrs", "kyc"));
		params.add(new BasicNameValuePair("pres_city", "kyc"));
		params.add(new BasicNameValuePair("pres_country", "kyc"));
		params.add(new BasicNameValuePair("permn_addrs", "kyc"));
		params.add(new BasicNameValuePair("permn_city", "kyc"));
		params.add(new BasicNameValuePair("permn_country", "kyc"));
		params.add(new BasicNameValuePair("emailid", oKycForm.getEmail()));
		params.add(new BasicNameValuePair("cusnam", oKycForm.getName()));
		params.add(new BasicNameValuePair("mobileno", oKycForm.getContactNo()));
		params.add(new BasicNameValuePair("fname", oKycForm.getFatherName()));
		params.add(new BasicNameValuePair("nid", oKycForm.getNationalId()));
		params.add(new BasicNameValuePair("passportno", oKycForm.getPassport()));
		params.add(new BasicNameValuePair("mname", oKycForm.getMotherName()));
		params.add(new BasicNameValuePair("introname", oKycForm.getIntroducerName()));
		params.add(new BasicNameValuePair("introaddr", oKycForm.getIntroducerAddress()));
		params.add(new BasicNameValuePair("ocupation", oKycForm.getIntroducerOccupation()));
		params.add(new BasicNameValuePair("mobileNo", oKycForm.getIntroducerMobileNo()));
		params.add(new BasicNameValuePair("TimeStamp", reportDate));
		params.add(new BasicNameValuePair("image", file.toString()));
		// MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		// Add image file to upload
		// builder.addBinaryBody("imgFile", imgFile,ContentType.DEFAULT_BINARY,
		// imgFile.getName());

		/*
		 * File file = new File(oKycForm.getImageFile().toString());
		 * MultipartEntity mpEntity = new MultipartEntity(); ContentBody cbFile
		 * = new FileBody(file); mpEntity.addPart("file", cbFile);
		 * 
		 * 
		 * httpPost.setEntity(mpEntity);
		 * 
		 */
		// DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
		// yyyy-MM-dd HH:mm:ss
		// Date date = new Date();
		// System.out.println("Daete ========= "+dateFormat.format(date));
		// params.add(new
		// BasicNameValuePair("timstamp",dateFormat.format(date)));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("Response ===== >>>>> " + responseString);
			String[] parts = responseString.split(",");
			outMessage = parts[0];
			outCode = parts[1];

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
		HttpClient httpclient1 = new DefaultHttpClient();
		httpclient1.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/addkycImage.do");
        String UPLOAD_DIRECTORY ="/images";  
		//String filepath=null;
        ServletContext context = session.getServletContext();  
        String path = context.getRealPath(UPLOAD_DIRECTORY);  
        String filename = oKycForm.getImageFile().toString(); 
        System.out.println(path+" "+filename);       
      
		File file1 = new File(path+filename); //new File("C:\\Users\\himel\\Downloads\\img_4\\98-ASHRAFIL.jpg");   
		MultipartEntity mpEntity = new MultipartEntity();
		ContentBody cbFile = new FileBody(file1);
		mpEntity.addPart("file", cbFile);
	
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("api_pass","kycimage");
        headerMap.put("mailid",oKycForm.getEmail());
        headerMap.put("timstamp",reportDate);
        headerMap.put("oprstamp",oKycForm.getEmail());
        for (Entry<String, String> entry : headerMap.entrySet()) {
        	httpPost1.addHeader(entry.getKey(), entry.getValue());
        	
        }
        httpPost1.setEntity(mpEntity);
		System.out.println("executing request " + httpPost1.getRequestLine());
		HttpResponse response1 = httpclient1.execute(httpPost1);
		HttpEntity resEntity = response1.getEntity();
		System.out.println(response1.getStatusLine());
		if (resEntity != null) {
			System.out.println(EntityUtils.toString(resEntity));
		}
		if (outCode.equals("0")) {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("KYCMessage", outMessage);
			return "users/paymentlogin";
		} else if (outCode.equals("1")) {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("KYCMessage", outMessage);
			return "users/kyc1";
		} else {
			// session.setAttribute("sErrorMessage",
			// oMenuGenarationBO.getErrorMessage());
			session.setAttribute("KYCMessage", outMessage);
			return "kyc1";
		}
	}

	@RequestMapping(value = "/erapay/executekyc123")
	public String kyc1111(Model model, @ModelAttribute("oKycForm") KycForm oKycForm, HttpServletRequest request,
		SessionStatus status, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		String userID = (String) session.getAttribute("GSMAILID");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		
		HttpClient httpclient1 = new DefaultHttpClient();
		httpclient1.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/addkycImage.do");
        String UPLOAD_DIRECTORY ="/images";  
		//String filepath=null;
        ServletContext context = session.getServletContext();  
        String path = context.getRealPath(UPLOAD_DIRECTORY);  
        String filename = oKycForm.getImageFile().toString(); 
        System.out.println(path+""+filename);       
		File file1 = new File("C:\\Users\\himel\\Downloads\\img_4\\98-ASHRAFIL.jpg");   
		MultipartEntity mpEntity = new MultipartEntity();
		ContentBody cbFile = new FileBody(file1);
		mpEntity.addPart("file", cbFile);
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("api_pass","kycimage");
        headerMap.put("mailid",oKycForm.getEmail());
        headerMap.put("timstamp",reportDate);
        headerMap.put("oprstamp",oKycForm.getEmail());
        for (Entry<String, String> entry : headerMap.entrySet()) {
        	httpPost1.addHeader(entry.getKey(), entry.getValue());
        	
        }
        httpPost1.setEntity(mpEntity);
		System.out.println("executing request " + httpPost1.getRequestLine());
		HttpResponse response1 = httpclient1.execute(httpPost1);
		HttpEntity resEntity = response1.getEntity();
		System.out.println(response1.getStatusLine());
		if (resEntity != null) {
			System.out.println(EntityUtils.toString(resEntity));
		}
		
		return "kyc1";
	}
	@RequestMapping(value = "/erapay/image1")
	public String image(Model model, HttpServletRequest request,
		SessionStatus status, HttpServletResponse response) throws Exception {
		return "image";
	}
	@RequestMapping(value = "/erapay/executeimagettest")
	public String executeimagettest(Model model, @ModelAttribute("oKycForm") KycForm oKycForm, HttpServletRequest request,
		SessionStatus status, HttpServletResponse response,@RequestParam CommonsMultipartFile file) throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		HttpSession session = request.getSession(true);
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		HttpClient httpclient1 = new DefaultHttpClient();
		httpclient1.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/addkycImage.do");
        String UPLOAD_DIRECTORY ="/images";  
		//String filepath=null;
        ServletContext context = session.getServletContext();  
        String path = context.getRealPath(UPLOAD_DIRECTORY);  
        String filename = file.getOriginalFilename();
        System.out.println(path+" "+filename);       
        File newFile = new File("/resources/dbimages");
        File serverFile = new File(newFile.getAbsolutePath()+File.separator+filename);
		//File file1 = new File(path+filename); //new File("C:\\Users\\himel\\Downloads\\img_4\\98-ASHRAFIL.jpg");   
		MultipartEntity mpEntity = new MultipartEntity();
		ContentBody cbFile = new FileBody(serverFile);
		mpEntity.addPart("file", cbFile);
	
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("api_pass","kycimage");
        headerMap.put("mailid",oKycForm.getEmail());
        headerMap.put("timstamp",reportDate);
        headerMap.put("oprstamp",oKycForm.getEmail());
        for (Entry<String, String> entry : headerMap.entrySet()) {
        	httpPost1.addHeader(entry.getKey(), entry.getValue());
        	
        }
        httpPost1.setEntity(mpEntity);
		System.out.println("executing request " + httpPost1.getRequestLine());
		HttpResponse response1 = httpclient1.execute(httpPost1);
		HttpEntity resEntity = response1.getEntity();
		System.out.println(response1.getStatusLine());
		if (resEntity != null) {
			System.out.println(EntityUtils.toString(resEntity));
		}
		return "kyc1";
	}
	  @RequestMapping(value="savefile",method=RequestMethod.POST)  
	    public String saveimage( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
			HttpClient httpclient1 = new DefaultHttpClient();
			httpclient1.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		  HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/addkycImage.do");
		String UPLOADED_FOLDER = "D://test//";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		System.out.println("Type"+file.getContentType());

		if (file.isEmpty()) {
            System.out.println("new");
            return "redirect:image";
        }
		if (!file.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File(UPLOADED_FOLDER, file.getOriginalFilename())));
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();
	         System.out.println(UPLOADED_FOLDER+file.getOriginalFilename());
	         System.out.println(UPLOADED_FOLDER+file.getOriginalFilename());
	         File filetest = new File(UPLOADED_FOLDER, file.getOriginalFilename()); //new File("C:\\Users\\himel\\Downloads\\img_4\\98-ASHRAFIL.jpg"); 
	         System.out.println(UPLOADED_FOLDER+file.getOriginalFilename());
	         MultipartEntity mpEntity = new MultipartEntity();
	         ContentBody cbFile = new FileBody(filetest);
	 		 mpEntity.addPart("file", cbFile);
	         HashMap<String, String> headerMap = new HashMap<String, String>();
	         headerMap.put("api_pass","kycimage");
	         headerMap.put("mailid","neazahsan23@gmail.com");
	         headerMap.put("TimeStamp",reportDate);
	         headerMap.put("oprstamp","neazahsan11@gmail.com");
	         for (Entry<String, String> entry : headerMap.entrySet()) {
	         	httpPost1.addHeader(entry.getKey(), entry.getValue());
	         }
	         httpPost1.setEntity(mpEntity);
	 		System.out.println("executing request " + httpPost1.getRequestLine());
	 		HttpResponse response1 = httpclient1.execute(httpPost1);
	 		HttpEntity resEntity = response1.getEntity();
	 		System.out.println(response1.getStatusLine());
	 		if (resEntity != null) {
	 			System.out.println(EntityUtils.toString(resEntity));
	 		}
	      }
		else {
	    	  System.out.println("new2");
	      }
	    return "image";
	    }
	  @RequestMapping(value="/erapay/saveimage",method=RequestMethod.POST)
	    public String saveimagedrive( @RequestParam("file") MultipartFile file,  
	    		 @RequestParam("file1")MultipartFile file1,
	           HttpSession session,@ModelAttribute("oKycForm") KycForm oKycForm) throws Exception{  
		  String userID = (String) session.getAttribute("GSMAILID");
		String UPLOADED_FOLDER = "D://qrcode//";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		String cuscode = (String) session.getAttribute("CUSCODE");
		System.out.println("SSS"+file.getContentType());
		String test=file.getContentType();
		  if(!test.equalsIgnoreCase("image/jpeg")){
			  session.setAttribute("KYCUPDATEMESSAGE","Please Select Image FIle JPG/JPEG Format");
			  System.out.println("ABCD");
			  return "kychome";
		  }


		if (!file.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File(UPLOADED_FOLDER,userID+".jpg")));
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();
	         System.out.println(userID);
	         System.out.println(UPLOADED_FOLDER+file.getOriginalFilename());
	         CloseableHttpResponse closeableHttpResponse = null;
	 		 CloseableHttpClient httpclient = HttpClients.createDefault();
	 		 HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/addkycImage.do");
	 		// Map<String,Object> dateValue = new HashMap<String,Object>();
	 	
	 		List<NameValuePair> params = new ArrayList<>();
	 		params.add(new BasicNameValuePair("api_pass","kycimage"));
	 		params.add(new BasicNameValuePair("mailid",userID));
	 		params.add(new BasicNameValuePair("Efdate",reportDate));
	 		params.add(new BasicNameValuePair("actflg", "kyc"));
	 		params.add(new BasicNameValuePair("oprstamp",userID));
	 		params.add(new BasicNameValuePair("Timstamp", reportDate));
	 		params.add(new BasicNameValuePair("cuscod","WL50008"));
	 		// MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	 		// builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
	 		// Add image file to upload
	 		// builder.addBinaryBody("imgFile", imgFile,ContentType.DEFAULT_BINARY,
	 		// imgFile.getName());
	 		/*
	 		 * File file = new File(oKycForm.getImageFile().toString());
	 		 * MultipartEntity mpEntity = new MultipartEntity(); ContentBody cbFile
	 		 * = new FileBody(file); mpEntity.addPart("file", cbFile);
	 		 * 
	 		 * 
	 		 * httpPost.setEntity(mpEntity);
	 		 * 
	 		 */
	 		// DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
	 		// yyyy-MM-dd HH:mm:ss
	 		// Date date = new Date();
	 		// System.out.println("Daete ========= "+dateFormat.format(date));
	 		// params.add(new
	 		// BasicNameValuePair("timstamp",dateFormat.format(date)));
	 		try {
	 			httpPost.setEntity(new UrlEncodedFormEntity(params));
	 			closeableHttpResponse = httpclient.execute(httpPost);
	 			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	 			System.out.println("Response ===== >>>>> " + responseString);
	 			String[] parts = responseString.split(",");
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
			if (!file.getOriginalFilename().isEmpty()) {
		         BufferedOutputStream outputStream1 = new BufferedOutputStream(
		               new FileOutputStream(
		                     new File(UPLOADED_FOLDER,userID+"file"+".jpg")));
		         outputStream1.write(file.getBytes());
		         outputStream1.flush();
		         outputStream1.close();
		         System.out.println(userID);
		         System.out.println(UPLOADED_FOLDER+file1.getOriginalFilename());
		         CloseableHttpResponse closeableHttpResponse2 = null;
		 		 CloseableHttpClient httpclient1 = HttpClients.createDefault();
		 		 HttpPost httpPost1 = new HttpPost("http://10.11.201.169:8080/ERAPAY/addKycFileUpload.do");;
		 		// Map<String,Object> dateValue = new HashMap<String,Object>();
		 		 List<NameValuePair> params1 = new ArrayList<>();
		 		 params1.add(new BasicNameValuePair("api_pass","kycimage"));
		 		 params1.add(new BasicNameValuePair("mailid",userID));
		 		 params1.add(new BasicNameValuePair("Efdate",reportDate));
		 		 params1.add(new BasicNameValuePair("actflg","kyc"));
		 		 params1.add(new BasicNameValuePair("oprstamp",userID));
		 		 params1.add(new BasicNameValuePair("Timstamp",reportDate));
		 		//params1.add(new BasicNameValuePair("cuscod",cuscode));
		 		// MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		 		// builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		 		// Add image file to upload
		 		// builder.addBinaryBody("imgFile", imgFile,ContentType.DEFAULT_BINARY,
		 		// imgFile.getName());
		 		/*
		 		 * File file = new File(oKycForm.getImageFile().toString());
		 		 * MultipartEntity mpEntity = new MultipartEntity(); ContentBody cbFile
		 		 * = new FileBody(file); mpEntity.addPart("file", cbFile);
		 		 * 
		 		 * 
		 		 * httpPost.setEntity(mpEntity);
		 		 * 
		 		 */
		 		// DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
		 		// yyyy-MM-dd HH:mm:ss
		 		// Date date = new Date();
		 		// System.out.println("Daete ========= "+dateFormat.format(date));
		 		// params.add(new
		 		// BasicNameValuePair("timstamp",dateFormat.format(date)));
		 		try {
		 			httpPost1.setEntity(new UrlEncodedFormEntity(params1));
		 			closeableHttpResponse2 = httpclient1.execute(httpPost1);
		 			
		 			String responseString = EntityUtils.toString(closeableHttpResponse2.getEntity(), "UTF-8");
		 			System.out.println("Response ===== >>>>> " + responseString);
		 			String[] parts = responseString.split(",");
		 			session.setAttribute("KYCUPDATEMESSAGE", "Image and File Added Successfully");
		 			// String DataResponse = responseString.replace("[",
		 			// "").replace("]", "");
		 			// result += responseBody;

		 			// System.out.println("Response ===== >>>>>
		 			// "+closeableHttpResponse);

		 		} catch (Exception e) {
		 			e.printStackTrace();
		 		} finally {
		 			httpclient1.close();
		 		}
	 		}
		 
	    }
		return "kychome";
	  }
	  @RequestMapping(value = "/erapay/transctionenqury")
		public String transctionenqury(Model model, HttpServletRequest request, HttpServletResponse response,
				@ModelAttribute("oKycForm") KycForm oKycForm) throws ClientProtocolException, IOException {
			//String cuscode=cusCode;
			// session.setAttribute("INDIVIDUALCUSCODE", cuscode);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date today = Calendar.getInstance().getTime();
			String reportDate = df.format(today);
		  oKycForm.setFromDate(reportDate);
		  oKycForm.setToDate(reportDate);
			return "TransctionEnqury";
		}
		@RequestMapping(value = "/erapay/transctionenqurysearch")
		public String transctionenquryserch(Model model, HttpServletRequest request, HttpServletResponse response,
				@ModelAttribute("oKycForm") KycForm oKycForm) throws ClientProtocolException, IOException, ParseException {
			//String cuscode=cusCode;
			// session.setAttribute("INDIVIDUALCUSCODE", cuscode);
			 CloseableHttpResponse closeableHttpResponse = null;
				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserTransactionHistoryReportDetails.do");
				// Map<String,Object> dateValue = new HashMap<String,Object>();
				List<NameValuePair> params = new ArrayList<>();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	            Date date = formatter.parse(oKycForm.fromDate);
	            Date date1 = formatter.parse(oKycForm.toDate);
	        	HttpSession session = request.getSession(true);
	            String walletID = (String) session.getAttribute("LoginWalletId");
	            System.out.println("walletID"+walletID);
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            String reportDate = df.format(date);
	            String reportDate1 =df.format(date1);
				params.add(new BasicNameValuePair("api_pass","usertranhistorydetails"));
				params.add(new BasicNameValuePair("walletid",walletID));
				params.add(new BasicNameValuePair("fromDate",reportDate));
				params.add(new BasicNameValuePair("toDate",reportDate1));
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(params));
					closeableHttpResponse = httpclient.execute(httpPost);
					
					String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
					System.out.println("Response ===== >>>>> " + responseString);
					JSONArray topArray = null; 
					try {
					     // Getting your top array
					     //THIS IS NOT NEEDED ANYMORE 
					     //topArray = json.getJSONArray(jsonString);
					     //use this instead
					     topArray = new JSONArray(responseString);
					      // looping through All elements
					     ArrayList<KycForm> nodeList = new ArrayList<KycForm>(); 
					      for(int i = 0; i < topArray.length(); i++){
					      JSONObject c = topArray.getJSONObject(i);
					      //list holding row data
					      // Storing each json item in variable
					      String docnum = c.getString("docnum");
					      String doctyp = c.getString("doctyp");
					      String trndat=c.getString("trndat");
					    // String dateOfBirth=c.getString("cusdob").toString();
					      String walletid=c.getString("walletid");
					      String drcrcd=c.getString("drcrcd");
					      int trnamt=c.getInt("trnamt");
					      String narration=c.getString("narration");
					      //System.out.println("aa+"+narration);
					      KycForm oKycForm1 = new KycForm();
					      oKycForm1.setDocnum(docnum);
					      oKycForm1.setDoctype(doctyp);
					      oKycForm1.setTrandat(trndat);
					      oKycForm1.setTrnamt(trnamt);
					      oKycForm1.setWalletid(walletid);
					      //oKycForm1.setTrnamt(trnamt);
					      oKycForm1.setNarration(narration);
					      oKycForm1.setDrcrcd(drcrcd);
						  nodeList.add(oKycForm1);
					      oKycForm1= new KycForm();
					      oKycForm.setTranapprovalList(nodeList);
					      session.setAttribute("tranapprovalList",nodeList);
						  System.out.println("Node"+nodeList);
					    }
					} catch (JSONException e) {
					        e.printStackTrace();
					 }
					
				} finally {
					httpclient.close();
				}
			return "TransctionEnqury";
		}
		@RequestMapping(value = "/erapay/paymentvoucher")
		public String paymentvoucher(Model model, HttpServletRequest request, HttpServletResponse response,
				@ModelAttribute("oKycForm") KycForm oKycForm,@RequestParam String walletid,@RequestParam String docnum,@RequestParam String narration,@RequestParam String trnamt) throws ClientProtocolException, IOException {
			//String cuscode=cusCode;
			// session.setAttribute("INDIVIDUALCUSCODE", cuscode);
			System.out.println("aa"+walletid);
			oKycForm.setWalletid(walletid);
			oKycForm.setTrnamt(Integer.parseInt(trnamt));
			oKycForm.setNarration(narration);
			oKycForm.setDocnum(docnum);
			return "PaymentVoucher";
		}
		@RequestMapping(value = "/erapay/imagetestkyc")
		public String imagetestkyc(Model model, HttpServletRequest request, HttpServletResponse response,
				@ModelAttribute("oKycForm") KycForm oKycForm,@RequestParam String walletid,@RequestParam String docnum,@RequestParam String narration,@RequestParam String trnamt) throws ClientProtocolException, IOException {
			
			return "image";
		}
	@RequestMapping(value = "/erapay/businesskyc")
	public String businesskyc(HttpServletRequest request, HttpServletResponse response,
						 @ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("KYCUPDATEMESSAGE", " ");
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/kycnew";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		session.setAttribute("USERINFORESPONSEADDRESS", " ");
		session.setAttribute("USERINFORESPONSEINTRODUCER", " ");
		session.setAttribute("USERINFORESPONSE", " ");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
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
		return "BuisnessKyc";
	}
	@RequestMapping(value = "/erapay/businesskycbasicinfo")
	public String businesskycbasicinfo(Model model, HttpServletRequest request, HttpServletResponse response,
								   @ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String userID = (String) session.getAttribute("GSMAILID");
		String useremail = (String) session.getAttribute("GSMAILID");
		String username = (String) session.getAttribute("GSUSERNAME");
		String cuscode = (String) session.getAttribute("CUSCODE");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		String flag=" ";
		oKycForm.setName(username);
		oKycForm.setEmail(useremail);
		System.out.println("USER ID"+userID);
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apUrl="/erapay/kycinfoparameter";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", apUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		System.out.println("ResponseCus"+cuscode);

		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserInfoDetails.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass","userbasicinfo"));
		params.add(new BasicNameValuePair("userid",userID));
		String userType= (String) session.getAttribute("USERTYPE");
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			//	JSONObject responseString = (JSONObject) closeableHttpResponse.getEntity();

			//	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			//	System.out.println("Response ===== >>>>> " + responseString);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("responseString" + responseString);
			int stringLen = responseString.length();
			System.out.println("LENGTH" + stringLen);
			JSONObject json = new JSONObject(responseString);
			System.out.println(" ");
			String errorCode = json.getString("Response_Code");
			if (errorCode.equals("1")) {
				flag = "flag1";
				session.setAttribute("USERINFORESPONSE", flag);
			}
			else if (errorCode.equals("0")) {
				String email = json.getString("emailid");
				String name = json.getString("cusnam");
				String dateOfBirth = json.getString("cusdob");
				String fatherName = json.getString("fname");
				String motherName = json.getString("mname");
				String contactNO = json.getString("mobileno");
				String nationalId = json.getString("passportno");
				String passportNo = json.getString("nid");
				String gender = json.getString("gender");
				//System.out.println("Date"+json.getd);
				oKycForm.setContactNo(contactNO);
				//oKycForm.setDateOfBirth(dateOfBirth);
				oKycForm.setFatherName(fatherName);
				oKycForm.setMotherName(motherName);
				oKycForm.setName(name);
				oKycForm.setEmail(email);
				oKycForm.setNationalId(nationalId);
				oKycForm.setPassport(passportNo);
				oKycForm.setDateOfBirth(dateOfBirth);

				//JSONObject temp1 = new JSONObject(json_string);
				//JSONObject json = new JSONObject(closeableHttpResponse);

			/*String[] parts = responseString.split(",");
			 String emailid =request.getParameter("emailid"); */
				//	 System.out.println("EMAIL"+emailid);
				// String DataResponse = responseString.replace("[",
				// "").replace("]", "");
				// result += responseBody;

				// System.out.println("Response ===== >>>>>
				// "+closeableHttpResponse);

			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			httpclient.close();
		}
		return "KycBusinessBasicInfo";
	}

	@RequestMapping(value = "/erapay/businesskycaddressinfo")
	public String businesskycaddressinfo(Model model, HttpServletRequest request, HttpServletResponse response,
								 @ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String userID = (String) session.getAttribute("GSMAILID");
		String LoginWalletId = (String) session.getAttribute("LoginWalletId");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");

		System.out.println("wall" + LoginWalletId);
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String cuscode = (String) session.getAttribute("CUSCODE");

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/kycaddressinfo";
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
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserAddressDetails.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass", "useraddressinfo"));
		params.add(new BasicNameValuePair("emailid", userID));

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			System.out.println("responseString" + responseString);
			int stringLen = responseString.length();
			System.out.println("LENGTH" + stringLen);
			String flag=" ";
			if (responseString.equals("[]")) {
				flag = "flag";
				session.setAttribute("USERINFORESPONSEADDRESS", flag);
			}
			if (!responseString.equals("[]")) {


				System.out.println("LogWall ===== >>>>> " + LoginWalletId);
				String DataResponse = responseString.replace("[", "").replace("]", "");
				String DataResponse1 = DataResponse.replace("\"", "");
				System.out.println("DataResponse ===== >>>>> " + DataResponse);
				System.out.println("DataResponse ===== >>>>> " + DataResponse1);
				String[] parts = DataResponse1.split(",");
				String presentadr1 = parts[0];
				String presentadr2 = parts[1];
				String presentadr3 = parts[2];
				String presentcitycode = parts[3];
				String presentcountry = parts[4];
				String permamnentadr1 = parts[5];
				System.out.println(" permamnentadr1===== >>>>> " + permamnentadr1);
				String permamnentadr2 = parts[6];
				String permamnentadr3 = parts[7];
				String permamnentcitycode = parts[8];
				String permamnentcountry = parts[9];
				oKycForm.setPresentAddress(presentadr1);
				oKycForm.setPermanentAddress(permamnentadr1);
				oKycForm.setPermanentCity(permamnentcitycode);
				oKycForm.setPresentCity(presentcitycode);
			/*
			 String DataResponse = responseString.replace("[", "{").replace("]", "}");
				System.out.println("Response ===== >>>>> " + DataResponse);
			JSONObject json = new JSONObject(DataResponse);
			String presentAddress=json.getString("addrs1");
			String permanentAddress=json.getString("addrs2");
			JSONArray arr = new JSONArray(DataResponse);

			String a="";
			String b="";
			String c="";
			String d="";
			String e="";
			String f="";
			System.out.println("length"+arr.length());
			for(int i = 0; i < arr.length(); i++){
				JSONObject obj = arr.getJSONObject(i);
				a=obj.getString("emailid");
				b=obj.getString("addrs1");
				c=obj.getString("addrs2");
			}
			oKycForm.setPresentAddress(presentAddress);
			oKycForm.setPermanentAddress(permanentAddress);
			//String dateOfBirth=json.getString("cusdob");



			//JSONObject temp1 = new JSONObject(json_string);
			//JSONObject json = new JSONObject(closeableHttpResponse);

			/*String[] parts = responseString.split(",");
			 String emailid =request.getParameter("emailid"); */
				//	 System.out.println("EMAIL"+emailid);
				// String DataResponse = responseString.replace("[",
				// "").replace("]", "");
				// result += responseBody;

				// System.out.println("Response ===== >>>>>
				// "+closeableHttpResponse);

			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			httpclient.close();
		}
		return "BusinessAddressInfo";
	}
	@RequestMapping(value ="/erapay/kycbusinessintroducerinfo")
	public String kycbusinessintroducernfo(Model model, HttpServletRequest request, HttpServletResponse response,@ModelAttribute("oKycForm") KycForm oKycForm) throws IOException {
		HttpSession session = request.getSession(true);
		String userID = (String) session.getAttribute("GSMAILID");
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		CloseableHttpResponse closeableHttpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String cuscode = (String) session.getAttribute("CUSCODE");
		String flag = " ";
		System.out.println("Cuse"+cuscode);
		HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/getUserIntroducerDetails.do");
		// Map<String,Object> dateValue = new HashMap<String,Object>();
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("api_pass","userintroducerinfo"));
		params.add(new BasicNameValuePair("oprstamp",userID));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			closeableHttpResponse = httpclient.execute(httpPost);

			//	JSONObject responseString = (JSONObject) closeableHttpResponse.getEntity();
			//	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			//	System.out.println("Response ===== >>>>> " + responseString);
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			int stringLen = responseString.length();
			System.out.println("LENGTH" + responseString);
			if ( responseString.equals("")) {
				flag = "flag";
				System.out.println("LENGTH Flag" + flag);
				session.setAttribute("USERINFORESPONSEINTRODUCER", flag);
			}

			if ( !responseString.equals("[]")) {

				System.out.println("ResponseOrginal ===== >>>>> " + responseString);
				System.out.println("Response ===== >>>>> " + responseString);
				JSONObject json = new JSONObject(responseString);
				String introname = json.getString("introname");
				String introaddr = json.getString("introaddr");
				//String dateOfBirth=json.getString("cusdob");
				String ocupation = json.getString("ocupation");
				String mobileno = json.getString("mobileno");
				System.out.println("DEE"+introname+introaddr);
				oKycForm.setIntroducerMobileNo(mobileno);
				oKycForm.setIntroducerOccupation(ocupation);
				oKycForm.setIntroducerName(introname);
				oKycForm.setIntroducerAddress(introaddr);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			httpclient.close();
		}

		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apUrl="/erapay/kycintroducerinfo";
		HttpPost httpPostHistory = new HttpPost("http://10.11.201.169:8080/ERAPAY/userActivityHistory.do");
		session.setAttribute("KYCMessage", "");
		List<NameValuePair> paramsHistory = new ArrayList<NameValuePair>();
		paramsHistory.add(new BasicNameValuePair("api_pass", "history"));
		paramsHistory.add(new BasicNameValuePair("userid", mailId));
		paramsHistory.add(new BasicNameValuePair("sessionid", sessionId));
		paramsHistory.add(new BasicNameValuePair("actionname", apUrl));
		paramsHistory.add(new BasicNameValuePair("actionintime", "11111"));
		paramsHistory.add(new BasicNameValuePair("actionouttime",dateAndTime));
		paramsHistory.add(new BasicNameValuePair("timeinterval", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("terminalid", "usersignin"));
		paramsHistory.add(new BasicNameValuePair("oprstamp", mailId));
		paramsHistory.add(new BasicNameValuePair("ip_remote",iP));
		activityHistoryApiCall.getHistory(closeableHttpClientHistory, httpPostHistory, paramsHistory);
		return "KycIntroducerBuisnessInfo";
	}
	
}
