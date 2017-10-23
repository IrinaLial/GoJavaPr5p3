package workers;

public class HourPayment extends Worker {

    private double hourlyRate;
    private double workdays = 20.8;
    private double workHours = 8;

    public HourPayment ( String name , String surname,double hourlyRate ) {
        super ( name , surname );
        this.hourlyRate = hourlyRate;
    }
    public double getHourlyRate ( ) {
        return hourlyRate;
    }

    public void setHourlyRate ( double hourlyRate ) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcWage ( ) {
        return workdays * workHours * hourlyRate;
    }
}
