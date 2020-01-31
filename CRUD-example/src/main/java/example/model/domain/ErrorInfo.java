package example.model.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorInfo{
	private int status;
	private String error;
	private String message; 
	private String path;
	
	//This class is used to show a custom response
	public ErrorInfo(HttpStatus status, HttpServletRequest req, Exception ex) {
		this.status  = status.value();
		this.path    = req.getServletPath();
		this.error   = status.getReasonPhrase();
		this.message = ex.getLocalizedMessage();
	}

}
