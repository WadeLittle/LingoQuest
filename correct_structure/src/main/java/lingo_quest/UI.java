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
        //lg.getUser().setCoinsEarned(40);
        //lg.logout();

    }

    public static void logout() {
        LanguageGame lg = new LanguageGame();
        lg.logout();
    }

    public static void createAccount() {

    }

    public static void main(String[] args) {
        boolean quit = false;
        while(!quit) {
            System.out.println("Select 1 to Login\nSelect 2 to Logout\nSelect 3 to Create Account\nSelect 9 to Quit\n");
            Scanner keyboard = new Scanner(System.in);
            int userChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch (userChoice) {
                case 1:
                    login();
                    break;
                case 2:
                    logout();
                    break;
                case 3:
                    createAccount();
                    break;
                case 9:
                    logout();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
