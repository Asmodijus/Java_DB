package lt.code.academy.data;

public class BillingAccount {
    private double ballance;

    public BillingAccount(double ballance) {
        this.ballance = ballance;
    }

    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance) {
        this.ballance = ballance;
    }

    @Override
    public String toString() {
        return "BillingAccount{" +
                "ballance=" + ballance +
                '}';
    }
}
