import java.util.Scanner;

class Prob1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.nextLine();
        String text = scan.nextLine();
        char charact, convertChar;
        //int key = 0;
        for (int i = 0; i < text.length(); i++) {
            charact = text.charAt(i);
            int passCode = (int) charact;
            int key = passCode + x;
            if (key > 90) {
                passCode = key - 26;
                convertChar = (char) passCode;
            } else {
                passCode = key;
                convertChar = (char) passCode;
            }
            System.out.print(convertChar);
        }
    }
}

class Prob3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if (x % 2 == 0) {
            System.out.println("Yes, Clara Sensei");
        }
        else
            System.out.println("Nooo");
    }
}

