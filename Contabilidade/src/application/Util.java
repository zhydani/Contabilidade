package application;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.sha256Hex("asldkjfa;lskdjf;laksjdflaksjdflkjas;dlkfja;lskdjf;alksjdf;lkasjdf;lkasjd;flkjasd;lkfjas;dlkjfa;sldkjf;laksdjf;lkasjd;flkjasd;lkjf;lasdkjf;laksjdf;lkjasd;lkfjas;dlkj"));
	}
	
	public static String hashSHA256(String valor) {
		return DigestUtils.sha256Hex(valor);
	}

	public static void addMessageInfo(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

	public static void addMessageWarn(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
	}

	public static void addMessageError(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}
}