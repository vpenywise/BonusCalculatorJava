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

        String[] employees = {"АА", "ВБИ", "ВВ", "ЕП"};
        System.out.println("Моля, въвеждайте само цели цифри за заплата! \n");

        int totalSalary = 0;
        int bonusPercent = 0;
        int workDays = 0;
        int monthWorkDays = 21;
        double a1 = 0; double a2 = 0; double a3 = 0; double a4 = 0;
        double b1 = 0; double b2 = 0; double b3 = 0; double b4 = 0;

        try {
            for (String s : employees) {
                System.out.println("Въведете заплата за служител " + employees[0]);
                int e1 = scan.nextInt();
                System.out.println("Въведете заплата за служител " + employees[1]);
                int e2 = scan.nextInt();
                System.out.println("Въведете заплата за служител " + employees[2]);
                int e3 = scan.nextInt();
                System.out.println("Въведете заплата за служител " + employees[3]);
                int e4 = scan.nextInt();
                System.out.println("\n");
                totalSalary = e1 + e2 + e3 + e4;
                a1 = e1; a2 = e2; a3 = e3; a4 = e4;
                break;
            }
        }catch(Exception e) {
            System.out.println("Моля, въведете само цели цифри! \n");
        }

        try {
            for (String d : employees) {
                System.out.println("Въведете брой работни дни за служител " + employees[0]);
                int d1 = scan.nextInt();
                System.out.println("Въведете брой работни дни за служител " + employees[1]);
                int d2 = scan.nextInt();
                System.out.println("Въведете брой работни дни за служител " + employees[2]);
                int d3 = scan.nextInt();
                System.out.println("Въведете брой работни дни за служител " + employees[3]);
                int d4 = scan.nextInt();
                System.out.println("\n");
                workDays = d1 + d2 + d3 + d4;
                b1 = d1; b2 = d2; b3 = d3; b4 = d4;
                break;
            }
        }catch(Exception e) {
            System.out.println("Моля, въведете само цели цифри! \n");
        }

        try {
            System.out.println("Моля, въведете процента на Бонуса като цяла цифра!");
            int bonus = scan.nextInt();
            System.out.println("------------------");
            bonusPercent = bonus;
        }catch (Exception e) {
            System.out.println("Моля, въведете само цели цифри! \n");
        }
        
        System.out.println("Общата сума на всички заплати е: " + totalSalary + "лв");
        System.out.println("Въведеният процент на бонус е: " + bonusPercent + "%");
        System.out.println("Общият брой работни дни е: " + workDays + " дни \n");

        double bonusDays1 = b1 / workDays;
        double bonusDays2 = b2 / workDays;
        double bonusDays3 = b3 / workDays;
        double bonusDays4 = b4 / workDays;

        double employee1 = (a1 * bonusPercent) / 100 / (monthWorkDays / b1);
        double employee2 = (a2 * bonusPercent) / 100 / (monthWorkDays / b2);
        double employee3 = (a3 * bonusPercent) / 100 / (monthWorkDays / b3);
        double employee4 = (a4 * bonusPercent) / 100 / (monthWorkDays / b4);

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

        System.out.println("Бонуса на " + employees[0] + " e " + finalBonus1 + "лв");
        System.out.println("Бонуса на " + employees[1] + " e " + finalBonus2 + "лв");
        System.out.println("Бонуса на " + employees[2] + " e " + finalBonus3 + "лв");
        System.out.println("Бонуса на " + employees[3] + " e " + finalBonus4 + "лв \n");
        System.out.println("Данните са генерирани на: " + formatter.format(date));
    }
}
