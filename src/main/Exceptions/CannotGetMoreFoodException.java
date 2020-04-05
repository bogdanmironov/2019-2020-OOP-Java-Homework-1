package main.Exceptions;

public class CannotGetMoreFoodException extends Exception{
    public CannotGetMoreFoodException(String errorMessage) {
        super(errorMessage);
    }
}
