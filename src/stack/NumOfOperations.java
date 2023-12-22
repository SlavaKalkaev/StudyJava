package stack;

public enum NumOfOperations {
    DELETE(1),
    ADD(2),
    EMPTY(3),
    SIZE(4),
    HEAD(5),
    VIEW(6);

    private int code;
    NumOfOperations (int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
