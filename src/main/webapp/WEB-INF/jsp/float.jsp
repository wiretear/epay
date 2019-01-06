<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/resources/core/css/jquery.floatinglabel.js" var="js1" />
<spring:url value="/resources/core/css/jquery.floatinglabel.min.js" var="js2" />
<spring:url value="/resources/core/css/jq.js" var="js3" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery floatingLabel: Floating Label Pattern Demos</title>
<script src="${js3}"></script>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/3.3.7/flatly/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<script>
/**
*
* Floating label 0.2.0 - Floating label based on placeholder attribute.
* Version 0.2.0
* @requires jQuery v1.7.0
* 
* http://www.opensource.org/licenses/mit-license.php
* The MIT License (MIT)
* 
* Copyright (c) 2017 Fabiano Araujo
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

(function ($){
 "use strict";
 
 $.fn.floatinglabel = function(custom){
   var options =   $.extend({
                       ignoreId        : [],
                       animationIn     : {top: '-5px', opacity: '1'},
                       animationOut    : {top: '0', opacity: '0'},
                       delayIn         : 300,
                       delayOut        : 300,
                       easingIn        : false,
                       easingOut       : false,
                       labelClass      : 'floating-label',
                       pinClass        : 'pin'
                   }, custom),
       input   =   $(this).find(':input');

   // Core method. 
   function createLabel(input, value, customclass){
       var labelElement = $('<label></label>'),
           forid        = $(input).attr('id'),
           html         = $(input).attr('placeholder');

       // If input type is submit, do not continue.
       if ($(input).attr('type') == 'submit')
           return false;

       // label attributes, html and class
       labelElement.attr('for', forid);
       labelElement.html(html);
       labelElement.addClass(options.labelClass);

       // Adding label before the input field
       input.before(labelElement);

       // Attaching events for animation
       input.on("focusin.floatinglabel", function(){
           input.trigger("floatinginstart");
           labelElement.stop().animate(options.animationIn, options.delayIn, options.easingIn);
           input.trigger("floatinginend");
       });

       input.on("focusout.floatinglabel", function(){
           input.trigger("floatingoutstart");
           // if input field is no empty, then 
           // pin the label to make sure that
           // the user knows which field is that
           if ($(this).val().length > 0)
               labelElement.addClass(options.pinClass);
           else
               labelElement.animate(options.animationOut, options.delayOut, options.easingOut);

           input.trigger("floatingoutend");
       });
   }

   // Attaching a label for every input.
   $(input).each(function(){
       if ($.inArray($(this).attr('id'), options.ignoreId) == -1)
           createLabel($(this));
   });

   return this;
 };
}(jQuery));

</script>
  <script src="<c:url value="/resources/core/css/jquery.floatinglabel.min.js"/>"></script>
<style>
body { background-color:#fafafa; font-family:'Roboto';}
.container { margin:150px auto;}
.floating-label{
	color: #1e94c8;
	font-size: 12px;
	position: relative;
	top: 0;
	font-weight: bold;
	z-index: 2;
	opacity: 0;
}

.pin{
	color: black;
}
</style>
</head>

<body>
<div id="jquery-script-menu">
<div class="jquery-script-center">
<ul>
<li><a href="http://www.jqueryscript.net/form/Floating-Placeholder-Label-jQuery-floatingLabel/">Download This Plugin</a></li>
<li><a href="http://www.jqueryscript.net/">Back To jQueryScript.Net</a></li>
</ul>

</div>
</div>
<div class="container">
<h1>jQuery floatingLabel: Floating Label Pattern Demos</h1>
<form id="form1" role="form">
	<div class="form-group">
		<input type="email" class="form-control" id="email" placeholder="Enter email">
	</div>
    <div class="form-group">
	    <input type="text" class="form-control" id="name" placeholder="Your Username">
	</div>
	<div class="form-group">
	    <input type="password" class="form-control" id="password" placeholder="Password">
	</div>
	<div class="form-group">
	    <input type="text" class="form-control" id="ignored" placeholder="I'll be ignored :(">
	</div>
	<div class="form-group">
	    <input type="submit" class="form-control btn btn-success" value="Fake submit">
	</div>
</form>
</div>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</body>
</html>
