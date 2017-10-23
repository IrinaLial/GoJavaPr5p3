package workers;

public class ConstantPayment extends Worker{
    public ConstantPayment ( String name , String surname , double monthWage ) {
        super ( name , surname );
        this.monthWage = monthWage;
    }

    private double monthWage;
    public double getMonthWage ( ) {
        return monthWage;
    }

    public void setMonthWage ( double monthWage ) {
        this.monthWage = monthWage;
    }

    @Override
    public double calcWage ( ) {
        return monthWage;
    }
}
