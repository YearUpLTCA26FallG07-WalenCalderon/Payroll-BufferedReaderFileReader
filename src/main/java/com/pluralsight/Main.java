package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/*
* EXERCISE 1
Continue working on the payroll-calculator program.
Rather than displaying your payroll report to the screen, write it to a .csv file in the
following format.
id|name|gross pay
111|Cameron Tay|3277.65
222|James Tee|2150.00
Prompt the user for the name of a file to read and process, then prompt them for the
name of the payroll file to create.
Enter the name of the file to process: employees.csv
Enter the name of the payroll file to create: payroll-sept-2023.csv
When your program finishes running, open the new file to view the results.
BONUS: If the user chooses specifies a .json extension write the data as JSON instead
of csv.
For example:
Enter the name of the file to process: employees.csv
Enter the name of the payroll file to create: payroll-sept-2023.json
payroll-sept-2023.json
[
{ "id": 111, "name" : "Cameron Tay", "grossPay" : 3277.65 },
{ "id": 222, "name" : "James Tee", "grossPay" : 2150.00 }
]
1. Ensure all your changes are committed and pushed to GitHub
2. Let your Instructor know you’ve completed this exercise
* */




public class Main {
    public static void main(String[] args) {
            try {
                //asking for prompt
                String readingFileName = Console.promptForString("What is the name of your file to read?(Include his extension ex: .csv,.txt, .md) ");
                String payRollFileName = Console.promptForString("What is the name of your payroll file?(Include his extension ex: .csv,.txt, .md) ");

                //Creating objects
                FileReader file = new FileReader("src/main/resources/" + readingFileName);
                FileWriter writer = new FileWriter("src/main/resources/" + payRollFileName);
                BufferedReader reader = new BufferedReader(file);
                Scanner sc = new Scanner(System.in);





                String line;//Line to read
                reader.readLine();

                //Meanwhile there is no null value keep reading
                while ((line = reader.readLine()) != null) {

                    String[] tokens = line.split("[|]");//Making
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double hoursWorked = Double.parseDouble(tokens[2]);
                    double payRate = Double.parseDouble(tokens[3]);

                    Employee employee = new Employee(id, name, hoursWorked, payRate);

                    //Writing on JSON formatt
                    writer.write("\n");
                    writer.write(String.format(" {\\\"id\\\": %d, \\\"name\\\": \\\"%s\\\", \\\"grossPay\\\": %.2f} ",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay()));


                    //Old version of printing files---------------------------------------------------------------------|
                    /*System.out.printf("%d | %s | $%.2f%n",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay());*/
                    //--------------------------------------------------------------------------------------------------|
                }
                writer.close();
                reader.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

    }

}