package com.era.erapay.Security;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ForgetPasswordController {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
    Date today = Calendar.getInstance().getTime();
    String dateAndTime = df.format(today);
    @RequestMapping(value = "/erapay/forgetpassword")
    public String Login(Model model, HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("FORGETPASSWORDMESSAGE", " ");

        return "ForgetPassword";
    }
    @RequestMapping(value = "/erapay/resetpassword")
    public String Resetpassword(Model model, HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("oForgetPasswordForm") ForgetPasswordForm oForgetPasswordForm) throws Exception {
        HttpSession session = request.getSession(true);
        session.setAttribute("TemporaryMessage", " ");
        String api_pass = "";
        String emailid = "";
        String password = "";
        String outCode = "";
        String errorCode = "";
        String errorMessage = "";
        String outMessage = "";
        System.out.println("GET"+oForgetPasswordForm.getEmail());
        session.setAttribute("MAILIDPASSRECOVERY",oForgetPasswordForm.getEmail());
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/temporaryPasswordSenttoMail.do");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass", "temppass"));
        params.add(new BasicNameValuePair("user_id", oForgetPasswordForm.getEmail()));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);
            errorCode = json.getString("Response_Code");
            errorMessage = json.getString("Response_Status");
            System.out.println("EEROOR"+errorCode);
            System.out.println("test jason" + errorCode + "again" + errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
       if (errorCode.equals("0")) {
            //session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());
            session.setAttribute("TemporaryMessage", errorMessage);
            return "ForgetPasswordReset";
        } else {
            //session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());
            System.out.println("test jason" + errorCode + "again" + errorMessage);
            session.setAttribute("FORGETPASSWORDMESSAGE", errorMessage);

            return "ForgetPassword";
        }
       // return "ForgetPasswordReset";
    }
    @RequestMapping(value = "/erapay/executeresetpassword")
    public String ExecuteResetpassword(Model model, HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("oForgetPasswordForm") ForgetPasswordForm oForgetPasswordForm) throws Exception {

        HttpSession session = request.getSession(true);
        session.setAttribute("TemporaryMessage", " ");
        String api_pass = "";
        String emailid = "";
        String password = "";
        String outCode = "";
        String errorCode = "";
        String errorMessage = "";
        String outMessage = "";
        emailid= (String) session.getAttribute("MAILIDPASSRECOVERY");
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.11.201.169:8080/ERAPAY/confirmForgetPasswordChange.do");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("api_pass", "changepass"));
        params.add(new BasicNameValuePair("userid", emailid));
        params.add(new BasicNameValuePair("temppass", oForgetPasswordForm.getTemporaryPassword()));
        params.add(new BasicNameValuePair("confirmpass", oForgetPasswordForm.getConfirmNewPassword()));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            closeableHttpResponse = httpclient.execute(httpPost);
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

            System.out.println("Response ===== >>>>> " + responseString);
            JSONObject json = new JSONObject(responseString);
            errorCode = json.getString("Response_Code");
            errorMessage = json.getString("Response_Status");
            System.out.println("test jason" + errorCode + "again" + errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        if (errorCode.equals("0")) {
            //session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());
            session.setAttribute("TemporaryMessage", errorMessage);
            return "ForgetPasswordReset";
        } else {
            //session.setAttribute("sErrorMessage", oMenuGenarationBO.getErrorMessage());
            System.out.println("test jason" + errorCode + "again" + errorMessage);
            session.setAttribute("TemporaryMessage", errorMessage);
            return "ForgetPassword";
        }
        // return "ForgetPasswordReset";
    }

    }

