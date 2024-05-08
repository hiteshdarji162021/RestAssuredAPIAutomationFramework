package bacancy.qa.gorest.frameworkexception;

public class ApiFrameworkException extends RuntimeException {
    public ApiFrameworkException(String mesg) {
        super(mesg);
    }
}