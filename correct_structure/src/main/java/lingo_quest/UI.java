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
        if(lg.getUser() != null)
            lg.getUser().setCoinsEarned(40);
        //lg.logout();

    }

    public static void logout() {
        //LanguageGame lg = new LanguageGame();
        lg.logout();
    }

    public static void createAccount() {
        String username;
        String password;
        boolean repeat = false;
        do{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter username you would like to use");
            username = keyboard.nextLine();
            System.out.println("Enter password you would like to use");
            password = keyboard.nextLine();
            // Checking password and username length here to avoid crash
            if(username.length() <= 8 || password.length() <= 8 || password.contains(" ")) {
                repeat = true;
                System.out.println("Invalid username or password");
            }
            else
                repeat = false;
        } while(repeat);
        lg.createUser(username, password);
    }

    public static void main(String[] args) throws Exception {
        lg = new LanguageGame();
        System.out.println(lg.getAllLanguages().get(0).toString());
        boolean quit = false;
        //for(User u : Users.getInstance().getUsers()) {
        //    System.out.println("TESTTTTTT" +u.getUUID());
        //}
        Scanner keyboard = new Scanner(System.in);
        while(!quit) {
            System.out.println("Select 1 to Login\nSelect 2 to Logout\nSelect 3 to Create Account\nSelect 9 to Quit\n");
            int userChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch (userChoice) {
                case 1:
                    if(lg.hasCurrentUser() == false)
                        login();
                    //System.out.println("Hello " +lg.getUser().getUsername());
                    break;
                case 2:
                    if(lg.hasCurrentUser() == true)
                        logout();
                    break;
                case 3:
                    if(lg.hasCurrentUser()) {
                        System.out.println("Cannot create account when logged in.");
                        break;
                    }
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
