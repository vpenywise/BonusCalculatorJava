import java.util.Scanner;

public class Bonuses2 {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("AA"),
                new Employee("VBI"),
                new Employee("VV"),
                new Employee("EP")
        };

        int totalSalary = 0;
        int totalSumWorkDays = 0;
        int workDaysMonth = 21;
        double bonusWorkDays;
        int[] daysEntered = new int[employees.length];
        Scanner scan = new Scanner(System.in);

        for (Employee employee : employees) {
            System.out.println("Enter the salary for the employee " + employee.getName());
            employee.setSalary(scan.nextInt());
            totalSalary += employee.getSalary();

            System.out.println("Enter the work days for the employee " + employee.getName());
            employee.setWorkDaysInput(scan.nextInt());
            totalSumWorkDays += employee.getWorkDaysInput();
        }

        System.out.println("Please, enter the bonus percentage: ");
        bonusWorkDays = scan.nextInt();

        for(int i = 0; i < daysEntered.length; i++) {
            daysEntered[i] = scan.nextInt();
            System.out.println(daysEntered[0]);
            System.out.println(daysEntered[1]);
            System.out.println(daysEntered[2]);
            System.out.println(daysEntered[3]);
        }

        //е от тука надолу си ебало майката
        for(Employee employee : employees) {
            employee.getBonusDays(totalSumWorkDays, workDaysMonth);
            bonusWorkDays = employee.getBonusDays(totalSumWorkDays, workDaysMonth);
            System.out.println(bonusWorkDays);
        }

    }

    private static class Employee {
        String name;
        int salary;
        double workDaysInput;

        static double getBonusDays(double workDaysInput, int workDays) {
            return (workDaysInput / workDays);
        }

        double baseBonus(double baseBonus) {
            return this.workDaysInput / baseBonus;
        }

        void setWorkDaysInput(double workDaysInput) {
            this.workDaysInput = workDaysInput;
        }

        public double getWorkDaysInput() {
            return workDaysInput;
        }

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }

    }
}

