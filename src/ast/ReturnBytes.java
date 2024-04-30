package ast;

public class ReturnBytes {

    private int bytesReturn, bytesLocals, bytesArgs;

    public ReturnBytes(int bytesReturn, int bytesLocals, int bytesArgs){
        this.bytesReturn = bytesReturn;
        this.bytesLocals = bytesLocals;
        this.bytesArgs = bytesArgs;
    }

    public int getBytesReturn() {
        return bytesReturn;
    }

    public int getBytesLocals() {
        return bytesLocals;
    }

    public int getBytesArgs() {
        return bytesArgs;
    }
}
