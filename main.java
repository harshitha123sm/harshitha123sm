package com.jobportal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Candidate candidate = new Candidate();
        Company company = new Company();
        Admin admin = new Admin();

        while(true) {
            System.out.println("1. Candidate Register");
            System.out.println("2. View Jobs");
            System.out.println("3. Admin View Candidates");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Email:");
                    String email = sc.nextLine();
                    System.out.println("Enter Password:");
                    String password = sc.nextLine();
                    candidate.register(name,email,password);
                    break;

                case 2:
                    candidate.viewJobs();
                    break;

                case 3:
                    admin.viewAllCandidates();
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
