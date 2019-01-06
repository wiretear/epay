package com.era.erapay.QRCODE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.simple.JSONObject;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.era.erapay.common.ActivityHistoryApiCall;
import com.era.erapay.common.IpFinder;
import com.google.zxing.*;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QRCODEController {
	private final Logger logger = LoggerFactory.getLogger(QRCODEController.class);
	IpFinder ipFinder =new IpFinder();
	ActivityHistoryApiCall activityHistoryApiCall=new ActivityHistoryApiCall();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss  aa");
	Date today = Calendar.getInstance().getTime();
	String dateAndTime = df.format(today);
	@RequestMapping(value = "/erapay/qrcode")
	public String LoadFund(Model model, HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, NotFoundException {
		HttpSession session = request.getSession(true);
		String iP=ipFinder.getIp(request);
		String sessionId= (String) session.getAttribute("SESSIONID");
		String mailId= (String) session.getAttribute("photoemailid");
		String userID = (String) session.getAttribute("GSMAILID");
		String userName=(String)  session.getAttribute("GSUSERNAME");
		String mobileNo = (String) session.getAttribute("USERMOBILENO");
		String balance=(String)  session.getAttribute("WALLETBALANCE");
		String walletId=(String)  session.getAttribute("LoginWalletId");
		String cuscode =(String) session.getAttribute("CUSCODE");
		String qrCodeData = "UserId : " + userID +"\n"+"Name : " + userName + "\n" +"WalletID : " + walletId + "\n"+ "Balance : " + balance + "\n" + " Mobile : " + mobileNo + "\n";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("UserId",userID);
		jsonObject.put("Name",userName);
		jsonObject.put("WalletID",walletId);
		jsonObject.put("Balance",balance);
		jsonObject.put("MobileNo",mobileNo);
		System.out.println("Print Value"+jsonObject);

		String filePath = "D:\\qrcode\\"+cuscode+".png";
		String charset = "UTF-8"; // or "ISO-8859-1"
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		createQRCode(jsonObject.toJSONString(), filePath, charset, hintMap, 400, 400);
		System.out.println("QR Code image created successfully!");
		System.out.println("Data read from QR Code: " + readQRCode(filePath, charset, hintMap));
		CloseableHttpClient closeableHttpClientHistory = HttpClients.createDefault();
		String apiUrl="/erapay/qrcode";
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
		return "show_qrcode";
	}

	public static void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight,
									int qrCodewidth) throws WriterException, IOException {
System.out.println("TEst");
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	}
	public static String readQRCode(String filePath, String charset, Map hintMap)
			throws FileNotFoundException, IOException, NotFoundException {
        System.out.println("TEst1");
		BinaryBitmap binaryBitmap = new BinaryBitmap(
				new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
		return qrCodeResult.getText();
	}

/*
    private static final String QR_CODE_IMAGE_PATH = "/Users/enamul/Desktop/MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}

    public static void main(String[] args) {
        try {

            JSONObject obj = new JSONObject();
            obj.put("name", "Enamul Haque");
            obj.put("age", new Integer(100));

            generateQRCodeImage(obj.toJSONString(), 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " );

            {
                System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            }
            } catch (IOException e) {
			e.printStackTrace();
		}
	}
*/

}
