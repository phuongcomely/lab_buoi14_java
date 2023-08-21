package service;

import entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private Map<String, User> users = new HashMap<>();
    public void loginSystem(Scanner scanner){
        System.out.println("Mời bạn nhập userName: ");
        String userName = scanner.nextLine();
        if (!users.containsKey(userName)) {
            System.out.println("Sai tên đăng nhập: ");
            loginSystem(scanner);

        }
        User user = users.get(userName);
        System.out.println("Mời bạn nhập password: ");
        String password = scanner.nextLine();
        if (!user.getPassword().equals(password)) {
            System.out.println("Sai mật khẩu! Đăng nhập lại ");
            loginSystem(scanner);
        }else {
            System.out.println("Đăng nhập thành công");
        }

    }
}
