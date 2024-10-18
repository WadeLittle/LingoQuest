package lingo_quest;

import java.util.Scanner;
public class UI {
    private static LanguageGame lg;
    public static void login() {
        //LanguageGame lg = new LanguageGame();
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
        //LanguageGame lg = new LanguageGame();
        lg.logout();
    }

    public static void createAccount() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter username you would like to use");
        String username = keyboard.nextLine();
        System.out.println("Enter password you would like to use");
        String password = keyboard.nextLine();
        lg.createUser(username, password);
    }

    public static void main(String[] args) {
        lg = new LanguageGame();
        boolean quit = false;
        Scanner keyboard = new Scanner(System.in);
        while(!quit) {
            System.out.println("Select 1 to Login\nSelect 2 to Logout\nSelect 3 to Create Account\nSelect 9 to Quit\n");
            int userChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch (userChoice) {
                case 1:
                    if(lg.hasCurrentUser() == false)
                        login();
                    break;
                case 2:
                    if(lg.hasCurrentUser() == true)
                        logout();
                    break;
                case 3:
                    createAccount();
                    break;
                case 9:
                    logout();
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        keyboard.close();
        System.exit(0);
    }
}
