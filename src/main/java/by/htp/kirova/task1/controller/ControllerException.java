package by.htp.kirova.task1.controller;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 6597631899989266436L;

    public ControllerException() {
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }

    public ControllerException(Exception e) {
        super(e);
    }
}
