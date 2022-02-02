import java.util.Scanner;

public class Keypad {
    private Scanner scanner;

    public Keypad() {
        this.scanner = new Scanner(System.in);
    }
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
