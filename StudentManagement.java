import java.io.*;
import java.util.Scanner;

public class StudentManagement {
    public LinkList head;
    public static class LinkList{
        int age;
        String name;
        float gpa;
        final int id;
        LinkList next;
        public LinkList(int age, String name, float gpa, int id){
            this.age = age;
            this.id = id;
            this.gpa = gpa;
            this.name = name;
            this.next = null;
        }
    }
    public void add(int age, String name, float gpa, int id){
        if(gpa>4 || gpa<0 || age>35 || age<0) {
            System.out.println("Value Rejected");
            return;
        }
        LinkList newNode = new LinkList(age, name, gpa, id);
        if (head == null)
            head = newNode;
        else {
            LinkList current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void DisplayAll(){
        if (head == null) {
            System.out.println("NO records to display!");
            return;
        }
        LinkList current = head;
        while (current!=null){
            System.out.println("Student ID :"+current.id);
            System.out.println("Student Name :" +current.name);
            System.out.println("Student Age :"+current.age);
            System.out.println("Student GPA :"+current.gpa);
            current = current.next;
        }
    }
    public void disDetail(int id) {
        LinkList current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }
        if (current != null) {
            System.out.println("Student ID :"+current.id);
            System.out.println("Student Name :" +current.name);
            System.out.println("Student Age :"+current.age);
            System.out.println("Student GPA :"+current.gpa);
        }
        else System.out.println("No such id found");
    }
    public void delete(int id) {
        LinkList current = head;
        LinkList previous = null;

        // Special case for deleting the first node (head)
        if (current != null && current.id == id) {
            head = current.next;
        } else {
            while (current != null && current.id != id) {
                previous = current;
                current = current.next;
            }

            if (current != null) {
                previous.next = current.next;
            } else {
                System.out.println("No such id found");
            }
        }
    }

    public void Update(int id, String newName){
        System.out.println("Updating name for id: " + id);
        LinkList current = head;
        while (current != null && current.id != id) {
            System.out.println("Current ID: " + current.id);
            current = current.next;
        }
        if(current != null)
            current.name = newName;
        else {
            System.out.println("NO such id found");
        }
    }
    public void Update(int id, int newAge){
        LinkList current = head;
        while (current != null && current.id!=id){
            current = current.next;
        }
        if(current != null)
            current.age = newAge;
        else {
            System.out.println("NO such id found");
        }
    }
    public void Update(int id, float newGpa){
        LinkList current = head;
        while (current != null && current.id!=id){
            current = current.next;
        }
        if(current != null)
            current.gpa = newGpa;
        else {
            System.out.println("NO such id found");
        }
    }



    public static void main(String[] args) throws IOException {
        DashBoard board = new DashBoard();
        System.out.println("Welcome to Student Management System!");
        System.out.println("1. Add a new student");
        System.out.println("2. Update student information");
        System.out.println("3. Delete a student record");
        System.out.println("4. Get student information");
        System.out.println("5. Display all student records");
        System.out.println("6. Exit");
        Scanner scanner  = new Scanner(System.in);
        int num = scanner.nextInt();
        board.displayOption(num);
    }
}
