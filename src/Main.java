import workers.Worker;
import workers.HourPayment;
import workers.ConstantPayment;
import workers.FreeLancer;

public class Main {
    public static void main(String[] args) {

        Worker[] workers = new Worker[5];
        workers[0] = new ConstantPayment ("Alice", "Anderson", 3800);
        workers[1] = new ConstantPayment ("Bob", "Barnet", 4200);
        workers[2] = new HourPayment ("Charles", "Carlsen", 14.7);workers[3] = new FreeLancer("Dave", "Dilan", 3800, 4.5);
        workers[4] = new HourPayment ("Eva", "Ermon", 12.7);
        for (Worker worker : workers) {
            System.out.println("Monthly wage for " + worker.getSurName() + " "  + ": " + worker.calcWage());
        }

        Company company = new Company(workers);
        System.out.println("Overall wage expenses: " + company.countMonthlyWages());
        System.out.println("Workers info:");
        company.printWorkersInfo();

        company.writeFile();
        System.out.println();

        company.setWorkers(company.readFile("src/files/workers.txt"));

        System.out.println("Overall wage expenses: " + company.countMonthlyWages());
        System.out.println("Workers info:");
        company.printWorkersInfo();
    }


}
