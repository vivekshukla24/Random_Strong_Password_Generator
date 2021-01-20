package Radom_Strong_password_generator;

// Author @ vivekshukla24 + https://www.linkedin.com/in/versesshukla/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class PasswordGen {
    public static void main(String args[]) {
        System.out.println("Enter the desired max length of your Password [8 - 16]");
        Scanner s= new Scanner(System.in);
        int maxlen= s.nextInt();
        String password = generatePassword(8, maxlen);
        System.out.print("Your Password is :-  " + password);
    }

    static String generatePassword(int min_length, int max_length) {
        Random random = new Random();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*(){}?";

        String allChars = upper + lower + numbers + specialChars;

        List<Character> letters = new ArrayList<Character>();
        for (char c : allChars.toCharArray()) letters.add(c);

        // Inbuilt method to randomly shuffle a elements of a list

        Collections.shuffle(letters);
        StringBuilder password = new StringBuilder();

        //This section prints the password equal to desired max length input by user.

        for (int i = max_length; i > 0; --i) {
            password.append(letters.get(random.nextInt(letters.size())));
        }

        // This section can ensure that the size of the password is  random.

//        for (int i = random.nextInt(max_length - min_length) + min_length; i > 0; --i) {
//            password.append(letters.get(random.nextInt(letters.size())));
//        }

        return password.toString();
    }
}
