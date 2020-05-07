package com.himalaya.aqua.aqua.core.exception;

public class HimalayaAquaException extends Exception {
    int errorCode;
    int errorObjectID;
    private static final long serialVersionUID = 1L;

    public HimalayaAquaException() {
        super();
    }
    public HimalayaAquaException(String message) {
        super(message);
    }
    public HimalayaAquaException(String message, int id) {
        super(message + " ID="+id);
    }
    public HimalayaAquaException(String message, int id, String string){
        super(message + " ID="+id + string);
    }

    public HimalayaAquaException(String message, String id) {
        super(message + " - "+id);
    }
    public HimalayaAquaException(Exception e) {
        super(e);
    }
    public HimalayaAquaException(String message, Exception e) {
        super(message, e);
    }
    public HimalayaAquaException(int errorCode, Exception e) {
        super(e);
    }
    public HimalayaAquaException(int errCode, String message,  Exception e) {
        super(message, e);

        errorCode = errCode;
    }
    public HimalayaAquaException(int errCode, String message) {
        super(message);

        errorCode = errCode;
    }
}
