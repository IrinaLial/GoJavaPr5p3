package workers;

public class FreeLancer extends HourPayment {
    private double workHours;

    public FreeLancer ( String name , String surname , double hourlyRate, double workHours) {
        super ( name , surname , hourlyRate );
        this.workHours = workHours;
    }

    public double getWorkHours ( ) {
        return workHours;
    }
}
