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
        int workDays = 0;
        int workDaysMonth = 21;
        Scanner scan = new Scanner(System.in);

        for(Employee employee : employees){
            System.out.println("Enter the salary for the employee " + employee.getName());
            employee.setSalary(scan.nextInt());
            totalSalary += employee.getSalary();

            System.out.println("Enter the work days for the employee " + employee.getName());
            employee.setWorkDaysInput(scan.nextInt());
            workDays += employee.getWorkDaysInput();
        }

        for(Employee employee : employees) {
            double bonusDays = employee.getBonusDays(workDays);
            System.out.println(bonusDays);

            System.out.println("Enter bonus percent: ");
            employee.setBonusPercent(scan.nextInt());
            employee.bonusPercent += employee.getBonusPercent(scan.nextInt());
            break;
        }
    }

    private static class Employee {
        String name;
        int salary;
        double workDaysInput;
        int bonusPercent;

        public void setBonusPercent(int bonusPercent) {
            this.bonusPercent = bonusPercent;
        }

        int getBonusPercent(int bonusPercent) {
            return this.bonusPercent = bonusPercent;
        }

        double getBonusDays(double workDays) {
            return this.workDaysInput / workDays;
        }

        double baseBonus(double baseBonus) {
            return this.workDaysInput / baseBonus;
        }

        public Employee() {

        }

        public void setWorkDaysInput(double workDaysInput) {
            this.workDaysInput = workDaysInput;
        }

        public double getWorkDaysInput() {
            return workDaysInput;
        }

        public Employee(String name) {
            this.name = name;
        }

        public void setName(String name) {
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
