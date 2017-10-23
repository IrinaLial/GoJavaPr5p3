import workers.Worker;
import workers.HourPayment;
import workers.ConstantPayment;
import workers.FreeLancer;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Company {

    private Worker[] workers;

    public Company(Worker[] workers) {
        this.workers = workers;
    }
    public void setWorkers ( Worker[] workers ) {
        this.workers = workers;
    }
    public double countMonthlyWages() {
        double wage = 0;
        for ( Worker worker : workers ) {
            wage += worker.calcWage ( );
        }
        return wage;
    }
    public void printWorkersInfo() {
        for (Worker worker : workers) {
            System.out.println(worker.getWorkerInfo());
        }
    }
public void writeFile(){
    try {
        FileWriter writer = new FileWriter ("src/files/workers.txt");
        writer.write ( workers.length +"\n" );
        for ( Worker worker :workers){

            if(worker instanceof FreeLancer){
                writer.write("WorkerFreelancer\n");
                writer.write(worker.getName () + "\n");
                writer.write(worker.getSurName () + "\n");
                writer.write(((FreeLancer) worker).getHourlyRate () + "\n");
                writer.write(((FreeLancer) worker).getWorkHours () + "\n");
            }
            if(worker instanceof HourPayment){
                writer.write("HourPayment\n");
                writer.write(worker.getName  () + "\n");
                writer.write(worker.getSurName  () + "\n");
                writer.write(((HourPayment) worker).getHourlyRate () + "\n");
            }
            if(worker instanceof ConstantPayment){
                writer.write("ConstantPayment\n");
                writer.write(worker.getName  () + "\n");
                writer.write(worker.getSurName  () + "\n");
                writer.write(((ConstantPayment) worker).getMonthWage () + "\n");
            }
            writer.flush();
        }
    } catch (IOException e) {
        e.printStackTrace ( );
    }}

    public Worker[] readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String sizeString = br.readLine();
            int size = Integer.parseInt(sizeString);
            Worker[] workers = new Worker[size];

            for (int i = 0; i < workers.length; i++) {
                String readType = br.readLine ( );
                if ( readType.equals ( "Freelancer" ) ) {
                    workers[ i ] = new FreeLancer ( br.readLine ( ) , br.readLine ( ) , Double.parseDouble ( br.readLine ( ) ) ,
                            Double.parseDouble ( br.readLine ( ) ) );

                } else if ( readType.equals ( "Hour Payment" ) ) {
                    workers[ i ] = new HourPayment ( br.readLine ( ) , br.readLine ( ) , Double.parseDouble ( br.readLine ( ) ) );

                } else if ( readType.equals ( "Constant Payment" ) ) {
                    workers[ i ] = new ConstantPayment ( br.readLine ( ) , br.readLine ( ) , Double.parseDouble ( br.readLine ( ) ) );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }}