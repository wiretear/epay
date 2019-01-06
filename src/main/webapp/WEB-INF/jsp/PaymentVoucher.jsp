<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<style>
    #content {
        text-align: center;
        display: block;
        width: 100%;
        background: #fff;
        padding: 15px 15px;
        padding-bottom: 15px;
        -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 2px 0px;
        -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 2px 0px;
        box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 2px 0px;
    }

    dt, dd {
        margin: auto;
        width: 50%;
        padding: 5px;
        margin-left: 50px;
    }

    #Box {
        margin: auto;
        width: 50%;
        padding: 10px;
    }

    footer {
        text-align: center;
    }
</style>
<div  style="margin-top:120px;"class="col-md-6 col-md-offset-3">
<div class="panel-group">
    <div class="panel panel-primary">
      <div class="panel-heading text-center">Payment Voucher</div>
      <div class="panel-body">
      <h1 class="text-center">Transaction Details</h1>
         <hr/>
        <div class="col-md-12 col-md-offset-2">
    

                

        <div>
     
            <dl class="dl-horizontal">
            
                <dt>
                   Wallet ID : 
                </dt>
                <dd style="margin-left:25px;">
       ${oKycForm.walletid}
                </dd>

                <dt>
                   Transaction ID :
                </dt>
            <dd style="margin-left:25px;">
                ${oKycForm.docnum}
                </dd>

                <dt>
                 Narration :
                </dt>
                 <dd style="margin-left:25px;">
                   ${oKycForm.narration}
                </dd>

                <dt>
                  Amount :
                </dt>
                   
                 <dd style="margin-left:25px;">
                  ${oKycForm.trnamt}
                </dd>

                <dt>
                    Charge/Fee :
                </dt>

                <dd>
                    
                </dd>

                <dt>
                 Net Amount :
                </dt>

                <dd>
                   
                </dd>

            </dl>
        </div>
    </div>
      </div>
    </div>
</div>
</div>

</body>
</html>
