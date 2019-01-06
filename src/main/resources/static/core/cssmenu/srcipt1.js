
	$(function() {
		var dialog, form,

		// From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
		emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/, name = $("#name"), email = $("#email"), password = $("#password"), allFields = $(
				[]).add(name).add(email).add(password), tips = $(".validateTips");

		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}

		function checkLength(o, n, min, max) {
			if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error");
				updateTips("Length of " + n + " must be between " + min
						+ " and " + max + ".");
				return false;
			} else {
				return true;
			}
		}

		function getMenuMasterStatus() {
			window.location = "/ecommercemanagment/MenuGeneration";
		}

		function checkRegexp(o, regexp, n) {
			if (!(regexp.test(o.val()))) {
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			} else {
				return true;
			}
		}

		function addUser() {
			var valid = true;
			allFields.removeClass("ui-state-error");

			valid = valid && checkLength(name, "username", 3, 16);
			valid = valid && checkLength(email, "email", 6, 80);
			valid = valid && checkLength(password, "password", 5, 16);

			valid = valid
					&& checkRegexp(
							name,
							/^[a-z]([0-9a-z_\s])+$/i,
							"Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
			valid = valid
					&& checkRegexp(email, emailRegex, "eg. ui@jquery.com");
			valid = valid
					&& checkRegexp(password, /^([0-9a-zA-Z])+$/,
							"Password field only allow : a-z 0-9");

			if (valid) {
				$("#users tbody").append(
						"<tr>" + "<td>" + name.val() + "</td>" + "<td>"
								+ email.val() + "</td>" + "<td>"
								+ password.val() + "</td>" + "</tr>");
				dialog.dialog("close");
			}

			return valid;
		}

		dialog = $("#dialog-form").dialog({

			autoOpen : false,
			height : 400,
			width : 850,
			modal : true,

			close : function() {
				form[0].reset();
				allFields.removeClass("ui-state-error");
			}
		});

		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			addUser();
		});

		$("#create-user").click(function() {
			$("#dialog-form").dialog("open");
		});
	});
	function showPopup() {
		//code to show your dialog
		return false
	}
	$(document).ready(
			function() {
				$("input").not($(":button")).keypress(
						function(evt) {
							if (evt.keyCode == 13) {
								iname = $(this).val();
								if (iname !== 'Submit') {
									var fields = $(this).parents(
											'form:eq(0),body').find(
											'button,input,textarea,select');
									var index = fields.index(this);
									if (index > -1
											&& (index + 1) < fields.length) {
										fields.eq(index + 2).focus();
										if (index == 6) {
											index = -1;
											fields.eq(index + 2).focus();
										}

									}
									return false;
								}
							}
						});
			});



	$(document).ready(

	/* This is the function that will get executed after the DOM is fully loaded */
	function() {

		$("#datepicker").datepicker({
			dateFormat : 'dd/mm/yy',//this option for formatting a Date
			changeMonth : true, //this option for allowing user to select month
			changeYear : true, //this option for allowing user to select from year range
			yearRange : "-50:+50"
		});
		$("#datepicker1").datepicker({
			dateFormat : 'dd/mm/yy',//this option for formatting a Date
			changeMonth : true, //this option for allowing user to select month
			changeYear : true, //this option for allowing user to select from year range
			yearRange : "-50:+50"
		});
	});
	$(document).ready(function() {
		$('#datatable').dataTable();

		$("[data-toggle=tooltip]").tooltip();

	});
	function getGenrateIdvalue() {
		window.location = "/ecommercemanagment/menugenerationsuccsess1";
		//	submit();
	}
	function openwindow() {
		winURL = "search";
		winName = "BalanceCheckByBranchDetails";
		winHeight = 380;
		winWidth = 600;
		winHeight = 380;
		winWidth = 600;
		winTop = ((screen.availHeight / 2) - (winHeight / 2));
		winLeft = ((screen.availWidth / 2) - (winWidth / 2));
		winOpen = "";

		if (winOpen) {
			if (winOpen.closed) {
				winOpen = window
						.open(
								winURL,
								winName,
								"top="
										+ winTop
										+ ",left="
										+ winLeft
										+ ",width="
										+ winWidth
										+ ",height="
										+ winHeight
										+ ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
			} else {
				winOpen.close();
				winOpen = window
						.open(
								winURL,
								winName,
								"top="
										+ winTop
										+ ",left="
										+ winLeft
										+ ",width="
										+ winWidth
										+ ",height="
										+ winHeight
										+ ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
			}
		} else {
			winOpen = window
					.open(
							winURL,
							winName,
							"top="
									+ winTop
									+ ",left="
									+ winLeft
									+ ",width="
									+ winWidth
									+ ",height="
									+ winHeight
									+ ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
		}
		winOpen.focus();
	}
