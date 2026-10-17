import java.util.Scanner;

class Kata {
    static String greet(String name, String owner) {
        Scanner sc = new Scanner(System.in);

        name = sc.nextLine();

        owner = sc.nextLine();

        if (name.equals(owner)) {
            return "Hello boss";
        } else {
            return "Hello guest";
        }
    }
}