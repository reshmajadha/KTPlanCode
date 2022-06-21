package student.demo.pro.parcticePro.ExceptionHandling;

public class ExceptionResponse {
    private  String statuscode;
    private String errorMessage;
    private String requestedURI;
   private String errormsg;

    public void setRequestedURI(String requestedURI) {
        this.requestedURI = requestedURI;
    }


    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }


}
