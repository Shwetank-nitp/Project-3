import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class DashBoard extends StudentManagement {
    public void displayOption(int num) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        if (num == 6) {
            System.out.println("**** Exit Done ****");
            return;
        }
        switch (num){
            case 1: {
                System.out.print("Enter the student ID : ");
                int id = scanner.nextInt();
                System.out.print("Enter the student Name : ");
                String name = reader.readLine();
                System.out.println("Enter the student GPA : ");
                float gpa = scanner.nextFloat();
                System.out.print("Enter the student Age : ");
                int age = scanner.nextInt();
                add(age, name, gpa, id);
                System.out.println("*Details filled successfully*");
                System.out.println();
                System.out.println("Enter Your next choice: ");
                num = scanner.nextInt();
                displayOption(num);
            }
                break;
            case 2: {
                System.out.print("Enter student id : ");
                int id = scanner.nextInt();
                System.out.print("Chose What you want to update\n");
                System.out.print(" 1. student Name : \n");
                System.out.print(" 2. student Age : \n");
                System.out.print(" 3. student Gpa : \n");
                byte x = scanner.nextByte();

                if (x == 1) {
                    String newName = reader.readLine();
                    Update(id, newName);
                } else if (x == 2) {
                    int newAge = scanner.nextInt();
                    Update(id, newAge);
                } else if (x == 3) {
                    float newGpa = scanner.nextFloat();
                    Update(id, newGpa);
                } else System.out.println("Not a valid input");
                System.out.println("*Details Updated successfully*");
                System.out.println();
                System.out.println("Enter Your next choice: ");
                num = scanner.nextInt();
                displayOption(num);
            }
                break;
            case 3: {
                System.out.print("Enter student id");
                int id = scanner.nextInt();
                delete(id);
                System.out.println("*Details Deleted successfully*");
                System.out.println();
                System.out.println("Enter Your next choice: ");
                num = scanner.nextInt();
                displayOption(num);
            }
                break;
            case 4: {
                System.out.print("Enter student id");
                int id = scanner.nextInt();
                disDetail(id);
                System.out.println("*Details Deleted successfully*");
                System.out.println();
                System.out.println("Enter Your next choice: ");
                num = scanner.nextInt();
                displayOption(num);
            }
                break;
            case 5: {
                DisplayAll();
                System.out.println();
                System.out.println("Enter Your next choice: ");
                num = scanner.nextInt();
                displayOption(num);
            }
                break;
            default : {
                System.out.println("Please inter a valid number 1 to 6 (included)");
                num = scanner.nextInt();
                displayOption(num);
            }
        }

    }
}