import Entities.Snack;

public class Main {

    public static void main(String[] args) {

        try {

            // init snackVendingMachine
            SnackVendingMachine snackVendingMachine = new SnackVendingMachine();

            // Fill the inventory of the machine
            snackVendingMachine.fillInventory();

            // init keypad
            Keypad keypad = new Keypad();

            // display list of snacks on the screen

            snackVendingMachine.showItems();


            while (true) {
                System.out.println("Could you please enter the code of snack you want");

                String enteredSnackCode = keypad.readLine();

                boolean isValidItemCode  = snackVendingMachine.validateEnteredItemCode(enteredSnackCode);

                if (! isValidItemCode) {
                    System.out.println("Wrong Snack Code");
                    continue;

                }

                Snack selectedSnack = snackVendingMachine.getSnackByCode(enteredSnackCode);

                System.out.println("you selected " + selectedSnack.getName() + "and its price : " + selectedSnack.getPrice());

                // execute Payment
                boolean paymentStatus = snackVendingMachine.getPaymentManager().executePayment(keypad, selectedSnack.getPrice());

                if (! paymentStatus) {
                    System.out.println("Failed Payment");
                    continue;
                }

                boolean droppingStatus = snackVendingMachine.dropItem(selectedSnack);

                if (! droppingStatus) {
                    System.out.println("We have internal issue , please try again");
                    continue;
                }
                System.out.println("Thanks for buying from us");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
