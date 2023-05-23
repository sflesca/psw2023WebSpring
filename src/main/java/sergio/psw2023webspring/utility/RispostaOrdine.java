package sergio.psw2023webspring.utility;

public class RispostaOrdine {
    private boolean status;

    private long pid;

    private int errortype;

    public RispostaOrdine() {
        status = true;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getErrortype() {
        return errortype;
    }

    public void setErrortype(int errortype) {
        this.errortype = errortype;
    }

    public RispostaOrdine(long pid, OrderErrorTypes errortype) {
        this.status = false;
        this.pid = pid;
        this.errortype = (errortype==OrderErrorTypes.QTA)?0:1;
    }
}
