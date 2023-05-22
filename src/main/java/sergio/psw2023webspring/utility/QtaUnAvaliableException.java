package sergio.psw2023webspring.utility;

public class QtaUnAvaliableException extends Exception{

    private long pid;

    public long getPid() {
        return pid;
    }

    public QtaUnAvaliableException(long pid) {
        super();
        this.pid = pid;
    }
}
