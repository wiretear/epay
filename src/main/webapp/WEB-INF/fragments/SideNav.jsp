   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url value="/images" var="dbimages"/>
   <spring:url value="/Test" var="dbimagestest"/>
   <spring:url value="/qrcode" var="qrcode"/>
    <%String photoemailid = (String) session.getAttribute("photoemailid");%>
    <head>
<style>
    .ui-navbar .ui-btn-text {
        font-size: 10px;
    }
</style>


    </head>
  <nav id="sidebar">            
 <div class="sidebar-header" >
                 <img  id="image" style="margin-left:42px;"  src="${qrcode}/<%=photoemailid%>.jpg" class="img-circle" alt="Random Name" width="130" height="130">
                  <h4 style="color:white;" class="text-center"><%out.print(session.getAttribute("GSUSERNAME"));%></h4>
                    <h6 style="color:white;" class="text-center">Wallet ID: <%out.print(session.getAttribute("LoginWalletId"));%></h6>
                   </div>
               <ul class="list-unstyled ">
                      
                    <li>
                    <a href="/erapay/testhome" data-toggle="collapse" data-target="#submenu-1">Home</a>
                </li> 
                      <li>
                        <a href="/erapay/walletopen">Wallet Open</a>
                    </li>

                    <li>
                        <a href="/erapay/kycnew">KYC</a>
                    </li>


                      <li>
                        <a href="/erapay/addbankhome">Add Bank Account</a>
                    </li>
                   <li>
                       <a href="/erapay/requestmoney">Request Money</a>
                   </li>


                   <li><a href="/erapay/talktime">TalkTime</a></li>
                    <li>
                        <a href="/erapay/setpincode">Set PIN</a>
                    </li>
                      <li>
                        <a href="/erapay/changepassword">Change Password</a>
                    </li>
                        <li>
                        <a href="/erapay/wallettomerchanpayment">Wallet to Merchant Payment</a>
                    </li>
                        <li>
                        <a href="/erapay/transctionenqury">Transaction History</a>
                    </li>
                   <li><a href="/erapay/login">LogOut</a></li>
                </ul>
            </nav>