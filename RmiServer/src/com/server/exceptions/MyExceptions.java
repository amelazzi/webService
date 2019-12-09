package com.server.exceptions;

@SuppressWarnings("serial")
public class MyExceptions extends Exception {

	boolean notDeleted;
    boolean notCreated;
    boolean notUpdated;

    public MyExceptions(String msg){
        super(msg);
    }

    public boolean isNotDeleted() {
        return(notDeleted);
    }

    public boolean isNotCreated() {
        return(notCreated);
    }
    
    public static void throwNotDeleted() throws MyExceptions {
    	MyExceptions exceptions = new MyExceptions("Ooooops! cannot be deleted!");
    	exceptions.notDeleted =true;
    	throw exceptions;
	}
    
    public static void throwNotCreated() throws MyExceptions {
    	MyExceptions exceptions = new MyExceptions("Ooooops! cannot be created!");
    	exceptions.notCreated =true;
    	throw exceptions;
	}
    
    public static void throwNotUpdated() throws MyExceptions {
    	MyExceptions exceptions = new MyExceptions("Ooooops! cannot be updated!");
    	exceptions.notUpdated=true;
    	throw exceptions;
	}
}
