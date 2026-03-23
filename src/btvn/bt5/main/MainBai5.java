package btvn.bt5.main;

import btvn.bt5.dao.PatientDAO;
import btvn.bt5.model.Patient;

import java.util.Scanner;

import java.util.*;
import java.util.*;

public class MainBai5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Thêm bệnh nhân");
            System.out.println("3. Cập nhật bệnh nhân");
            System.out.println("4. Xuất viện & tính phí");
            System.out.println("5. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Patient p : dao.getAll()) {
                        System.out.println(
                                p.getId() + " | " +
                                        p.getName() + " | " +
                                        p.getAge() + " | " +
                                        p.getDepartment() + " | " +
                                        p.getDays()
                        );
                    }
                    break;

                case 2:
                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Khoa: ");
                    String dep = sc.nextLine();

                    System.out.print("Số ngày: ");
                    int days = sc.nextInt();

                    dao.insert(new Patient(name, age, dep, days));
                    System.out.println("Thêm thành công!");
                    break;

                case 3:
                    System.out.print("ID cần sửa: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tên mới: ");
                    String n = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int a = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Khoa: ");
                    String d = sc.nextLine();

                    System.out.print("Số ngày: ");
                    int day = sc.nextInt();

                    dao.update(new Patient(id, n, a, d, day));
                    System.out.println("Cập nhật thành công!");
                    break;

                case 4:
                    System.out.print("Nhập ID: ");
                    int pid = sc.nextInt();

                    double fee = dao.calculateFee(pid);
                    System.out.println("Viện phí: " + fee);
                    break;

                case 5:
                    return;
            }
        }
    }
}