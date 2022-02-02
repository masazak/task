package Exceptions;


public class InValidItemCode extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InValidItemCode(String id) {
        super("the item is not valid");
    }

}
