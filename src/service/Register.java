package service;

import entities.User;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Register {
    public  void  registerUser(Scanner scanner, Map<String, User> users, Login login) {
        System.out.println("=======ĐIỀN THÔNG TIN NGƯỜI DÙNG======");
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Tên người dùng đã tồn tại!");
            registerUser(scanner, users, login);
        }
        String password;
        do {
            System.out.println("Nhập password: ");
            password = scanner.nextLine();
            if (!isValidPassword(password)){
                System.out.println("Mật khẩu không hợp lệ! Mời nhập lại");
            }
        } while (isValidPassword(password));
        User newUser = new User(username, password);
        users.put(username, newUser);
        System.out.println("Đăng ký thành công!");
        login.loginSystem(scanner);
    }
    public static boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.,\\-_;])[a-zA-Z.,\\-_;]{7,15}$";
        return Pattern.matches(passwordPattern, password);
    }

}
