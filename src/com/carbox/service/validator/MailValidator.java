package com.carbox.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.carbox.query.Queries;
import com.carbox.service.impl.UserServiceImpl;

@FacesValidator("mailValidator")
public class MailValidator implements Validator {

	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private final static Pattern EMAIL_COMPILED_PATTERN = Pattern.compile(EMAIL_PATTERN);

	UserServiceImpl userService = new UserServiceImpl();

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		// No value is not ok
		if (value == null || "".equals((String) value)) {
			FacesMessage msg = new FacesMessage("No email value!", "Email Validation Error");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

		// The email matcher
		Matcher matcher = EMAIL_COMPILED_PATTERN.matcher((String) value);

		if (!matcher.matches()) { // Email doesn't match
			FacesMessage msg = new FacesMessage("Invalid email value!", "Email Validation Error");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

		
		
		String mail = value.toString();

		UIInput uiInputConfirmMail = (UIInput) component.getAttributes().get("confirmMail");
		String confirmMail = uiInputConfirmMail.getSubmittedValue().toString();

		// Let required="true" do its job.
		if (mail == null || mail.isEmpty() || confirmMail == null || confirmMail.isEmpty()) {
			return;
		}

		if (!mail.equals(confirmMail)) {
			uiInputConfirmMail.setValid(false);
			throw new ValidatorException(new FacesMessage("Mail must match confirm mail."));
		}
		
		
	/*	if(userService.checkUserByMail(mail) == true){
			FacesMessage msg = new FacesMessage("Conflict email !", "Email already registered");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			
		}*/
		
		if(Queries.queryMail(mail) == true){
			FacesMessage msg = new FacesMessage("Conflict email !", "Email already registered");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			
		}
			
	}
}
