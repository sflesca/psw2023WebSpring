package sergio.psw2023webspring.utility;

public class ItemDetails {
    private long pid;
    private int qta;

    private double price;

    public ItemDetails() {}

    public ItemDetails(long pid, int qta, double price) {
        this.pid = pid;
        this.qta = qta;
        this.price = price;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "pid=" + pid +
                ", qta=" + qta +
                ", price=" + price +
                '}';
    }
}
