package com.selenium.exception;

public class SeleniumException extends Exception {
private static final long serialVersionUID = 1L;
    
	public SeleniumException(String message)
	{
		super (message);
	}

    public SeleniumException(Exception e) 
    {
        super(e);
    }

    public SeleniumException(String message, Exception e) 
    {
        super(message, e);
    }
}
