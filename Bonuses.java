/*
    The below program calculates the amount of the bonus, that each employee should receive;
    The specifications as presented by the customer explicitly say they want a final result in the integer format, not a double;
    This is the reason why the truncation that happens in integer division is producing a "somewhat incorrect result" - this is intended;
    The reason why "double" is used for the variables is due to number of days for each employee, which can be greater than the total work days;
        --> example: For an Employee with 23 working days in a month having a total of 21 work days, the math is:
            -----> int variable = 23 / 21 = 0; // which breaks all consequent calculations;
            -----> double variable 23 / 21 = 1.0952380952380953; // which is than casted into an (int);
 */

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bonuses {

    public static void main(String[] args) {

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Scanner scan = new Scanner(System.in);

        String[] employees = {"AA", "VBI", "VV", "EP"};
        System.out.println("Please, enter the salary: \n");

        int totalSalary = 0;
        int bonusPercent = 0;
        int workDays = 0;
        int monthWorkDays = 21;
        double salaryInput1 = 0;
        double salaryInput2 = 0;
        double salaryInput3 = 0;
        double salaryInput4 = 0;
        double workDaysInput1 = 0;
        double workDaysInput2 = 0;
        double workDaysInput3 = 0;
        double workDaysInput4 = 0;

        try {
            for (String s : employees) {
                System.out.println("Enter the salary for the employee " + employees[0]);
                int e1 = scan.nextInt();
                System.out.println("Enter the salary for the employee " + employees[1]);
                int e2 = scan.nextInt();
                System.out.println("Enter the salary for the employee " + employees[2]);
                int e3 = scan.nextInt();
                System.out.println("Enter the salary for the employee " + employees[3]);
                int e4 = scan.nextInt();
                System.out.println("\n");
                totalSalary = e1 + e2 + e3 + e4;
                salaryInput1 = e1; salaryInput2 = e2; salaryInput3 = e3; salaryInput4 = e4;
                break;
            }
        }catch(Exception e) {
            System.out.println("Please, enter a number! \n");
        }

        try {
            for (String d : employees) {
                System.out.println("Enter the work days for the employee " + employees[0]);
                int d1 = scan.nextInt();
                System.out.println("Enter the work days for the employee " + employees[1]);
                int d2 = scan.nextInt();
                System.out.println("Enter the work days for the employee " + employees[2]);
                int d3 = scan.nextInt();
                System.out.println("Enter the work days for the employee " + employees[3]);
                int d4 = scan.nextInt();
                System.out.println("\n");
                workDays = d1 + d2 + d3 + d4;
                workDaysInput1 = d1; workDaysInput2 = d2; workDaysInput3 = d3; workDaysInput4 = d4;
                break;
            }
        }catch(Exception e) {
            System.out.println("Please, enter a number! \n");
        }

        try {
            System.out.println("Please, enter the bonus: ");
            int bonus = scan.nextInt();
            System.out.println("------------------");
            bonusPercent = bonus;
        }catch (Exception e) {
            System.out.println("Please, enter a number! \n");
        }
        
        System.out.println("The total amount of all salaries is: " + totalSalary + "lv");
        System.out.println("The bonus percentage is: " + bonusPercent + "%");
        System.out.println("The total number of work days is: " + workDays + " days \n");

        double bonusDays1 = workDaysInput1 / workDays;
        double bonusDays2 = workDaysInput2 / workDays;
        double bonusDays3 = workDaysInput3 / workDays;
        double bonusDays4 = workDaysInput4 / workDays;

        double employee1 = (salaryInput1 * bonusPercent) / 100 / (monthWorkDays / workDaysInput1);
        double employee2 = (salaryInput2 * bonusPercent) / 100 / (monthWorkDays / workDaysInput2);
        double employee3 = (salaryInput3 * bonusPercent) / 100 / (monthWorkDays / workDaysInput3);
        double employee4 = (salaryInput4 * bonusPercent) / 100 / (monthWorkDays / workDaysInput4);

        double totalEmployeeBonus = employee1 + employee2 + employee3 + employee4;
        double difference = ((totalSalary * bonusPercent) / 100) - (totalEmployeeBonus);
        double extraBonus1 = (difference * bonusDays1);
        double extraBonus2 = (difference * bonusDays2);
        double extraBonus3 = (difference * bonusDays3);
        double extraBonus4 = (difference * bonusDays4);

        int finalBonus1 = (int) (employee1 + extraBonus1);
        int finalBonus2 = (int) (employee2 + extraBonus2);
        int finalBonus3 = (int) (employee3 + extraBonus3);
        int finalBonus4 = (int) (employee4 + extraBonus4);

        System.out.println("The bonus of " + employees[0] + " is " + finalBonus1 + "lv");
        System.out.println("The bonus of " + employees[1] + " e " + finalBonus2 + "lv");
        System.out.println("The bonus of " + employees[2] + " e " + finalBonus3 + "lv");
        System.out.println("The bonus of " + employees[3] + " e " + finalBonus4 + "lv \n");
        System.out.println("The report is generated on: " + formatter.format(date));
    }
}
