package lingo_quest;

import java.util.Scanner;
public class UI {
    public static void login() {
        LanguageGame lg = new LanguageGame();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = keyboard.nextLine();
        System.out.println("Enter Password: ");
        String password = keyboard.nextLine();
        //Users users = Users.getInstance();
        lg.login(username,password);
        lg.getUser().setCoinsEarned(1000);
        lg.logout();

    }

    public static void main(String[] args) {
        login();

    }
}
