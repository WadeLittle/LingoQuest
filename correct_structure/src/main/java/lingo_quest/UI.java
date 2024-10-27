package lingo_quest;

import java.util.Scanner;
import java.util.UUID;

public class UI {
    private static LanguageGame lg;

    public static void login() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = keyboard.nextLine();
        System.out.println("Enter Password: ");
        String password = keyboard.nextLine();
        lg.login(username, password);
        if (lg.getUser() != null)
            lg.getUser().setCoinsEarned(40);

    }

    public static void logout() {
        lg.logout();
    }

    public static void createAccount() {
        String username;
        String password;
        boolean repeat = false;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter username you would like to use");
            username = keyboard.nextLine();
            System.out.println("Enter password you would like to use");
            password = keyboard.nextLine();
            // Checking password and username length here to avoid crash
            if (username.length() <= 8 || password.length() <= 8 || password.contains(" ")) {
                repeat = true;
                System.out.println("Invalid username or password");
            } else
                repeat = false;
        } while (repeat);
        lg.createUser(username, password);
        lg.startLanguage(Languages.SPANISH);
        lg.getUser().getUserDictionary().getWordByString("Galleta").setPoints(100);
    }

    public static void main(String[] args) throws Exception {
        lg = new LanguageGame();
        Scanner keyboard = new Scanner(System.in);

        lg.createUser("JimJimJimJimJimmy", "jimiscool23");
        lg.logout();

        lg.login("JimJimJimJimJimmy", "jimiscool23");

        lg.pickALanguageByUUID(UUID.fromString("b2657c2b-56ef-45b1-a794-97eda7a32bd4"));
        lg.pickASection(UUID.fromString("bb8832c1-3f9c-4796-84e2-d8a41ff22d14"));
        lg.pickALesson(UUID.fromString("a5d8b523-68e9-46c0-ba96-63a244127868"));
<<<<<<< HEAD
        lg.getProgressScreen();
        for(int i =0; i< 5;i++) {
=======
        for (int i = 0; i < 5; i++) {
>>>>>>> db21abb0812c7f447acaaa10f9ad40d3ff824548
            lg.getAQuestion();
            lg.answerQuestion(keyboard);
        }

        lg.getProgressScreen();

        lg.pickALesson(UUID.fromString("c2e6b17a-5f04-4f9d-8cb7-bddedc6c1782"));
        for (int i = 0; i < 5; i++) {
            lg.getAQuestion();
            lg.answerQuestion(keyboard);
        }
        lg.getProgressScreen();
        lg.logout();
        lg.login("JimJimJimJimJimmy", "jimiscool23");
        lg.getAQuestion();
        lg.answerQuestion(keyboard);
<<<<<<< HEAD
        System.out.println("Let's practice your words with low understanding.\n");
        lg.practiceLowUnderstanding();
        for(int i=0; i < 4;i++) {
            lg.getAQuestion();
            lg.answerQuestion(keyboard);
        }
        lg.makeStudySheet();
        

        



        //System.out.println(lg.getAllLanguages().get(0).toString());
        boolean quit = false;
        //for(User u : Users.getInstance().getUsers()) {
        //    System.out.println("TESTTTTTT" +u.getUUID());
        //}



        // while(!quit) {
        //     System.out.println("Select 1 to Login\nSelect 2 to Logout\nSelect 3 to Create Account\nSelect 9 to Quit\n");
        //     int userChoice = keyboard.nextInt();
        //     keyboard.nextLine();
        //     switch (userChoice) {
        //         case 1:
        //             if(lg.hasCurrentUser() == false)
        //                 login();
        //             //System.out.println("Hello " +lg.getUser().getUsername());
        //             break;
        //         case 2:
        //             if(lg.hasCurrentUser() == true)
        //                 logout();
        //             break;
        //         case 3:
        //             if(lg.hasCurrentUser()) {
        //                 System.out.println("Cannot create account when logged in.");
        //                 break;
        //             }
        //             createAccount();
        //             break;
        //         case 9:
        //             logout();
        //             quit = true;
        //             break;
        //         default:
        //             break;
        
            keyboard.close();
            System.exit(0);
=======

        keyboard.close();
        System.exit(0);
>>>>>>> db21abb0812c7f447acaaa10f9ad40d3ff824548
    }
}
