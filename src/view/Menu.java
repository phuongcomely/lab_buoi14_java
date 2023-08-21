package view;

import entities.User;
import service.Login;
import service.Register;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public  int index(Scanner scanner){
        int choose =0;
        try{
            System.out.println("Nhập lựa chọn");
            choose = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Lỗi dữ liệu "+e.getMessage());
        }
        return choose;
    }
    public void displayMenu(){
        Login login = new Login();
        Register register = new Register();
        Map<String, User> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CHÀO MỪNG BẠN ĐẾN VỚI HỆ THỐNG ===");
        System.out.println("1-- Đăng nhập ");
        System.out.println("2-- Đăng kí");
        switch (index(scanner)){
            case 1:
                login.loginSystem(scanner);
                break;
            case 2:
                register.registerUser(scanner,users, login );
                break;
            default:
                System.out.println("lựa chọn không hợp lệ!");
                break;
        }
    }
}
