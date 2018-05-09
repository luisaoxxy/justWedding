package es.justWeddings.beans;

import java.io.IOException;

import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
@RequestScoped
public class LoginBean{
	
	private String userEmail; 
	
    public String doLogin() throws IOException, ServletException {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        userEmail = context.getUserPrincipal().getName();
        facesContext.responseComplete();
        return null;
    }

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}