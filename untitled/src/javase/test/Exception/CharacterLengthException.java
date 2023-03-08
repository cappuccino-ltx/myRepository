package javase.test.Exception;
//自定义异常类

public class CharacterLengthException extends Exception {


    public CharacterLengthException(){}

    public CharacterLengthException(String s) {
        super(s);
    }
}
