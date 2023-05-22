package sergio.psw2023webspring.utility;

public class RispostaOrdine {
    private boolean status;

    private long pid;

    private OrderErrorTypes errortype;

    public RispostaOrdine() {
        status = true;
    }

    public RispostaOrdine(long pid, OrderErrorTypes errortype) {
        this.status = false;
        this.pid = pid;
        this.errortype = errortype;
    }
}
