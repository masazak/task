import Entities.Item;
import Entities.Snack;

import java.util.HashMap;
import java.util.Map;


public class SnackVendingMachine extends VendingMachine {

    // the key Represent code of the item and the value is the available count
    private Map<String, Integer> snackInventory = new HashMap<String, Integer>();
    private Map<String, Snack> snacks = new HashMap<String, Snack>();

    private PaymentManager paymentManager = new PaymentManager();


    public void fillInventory() {
        this.snacks.put("MARS", new Snack("MARS", "Mars", 3));
        this.snacks.put("KITKAT", new Snack("KITKAT", "Kit Kat", 4));
        this.snacks.put("LAYZ", new Snack("LAYZ", "Layz", 2));
        this.snacks.put("BOUNTY", new Snack("BOUNTY", "Bounty", 3.5f));
        this.snacks.put("ORBIT", new Snack("ORBIT", "Orbit", 2.5f));

        this.snackInventory.put("MARS", 5);
        this.snackInventory.put("KITKAT", 5);
        this.snackInventory.put("LAYZ", 5);
        this.snackInventory.put("BOUNTY", 5);
        this.snackInventory.put("ORBIT", 5);

    }

    public void showItems() {
        System.out.println(" please select code of the snack");
        System.out.println("--------------------------------------------------------------------------");

        String snacksCode = "code :\t\t\t ";
        String snacksName = "name :\t\t\t ";
        String snacksPrice = "price :\t\t\t ";
        for (Map.Entry<String, Snack> entry : snacks.entrySet()) {
            // Check if its available
            if (snackInventory.get(entry.getKey()) != 0) {
                snacksCode += entry.getKey() + "\t\t\t ";
                snacksName += entry.getValue().getName() + "\t\t";
                snacksPrice += entry.getValue().getPrice() + "\t\t ";

                System.out.println(snacksCode + "\n" + snacksName + "\n" + snacksPrice);
                System.out.println("--------------------------------------------------------------------------");
                snacksCode = "code :\t\t\t ";
                snacksName = "name :\t\t\t ";
                snacksPrice = "price :\t\t\t ";
            }
        }
    }

    public Snack getSnackByCode(String enteredSnackCode) {
        return this.snacks.get(enteredSnackCode);
    }

    public boolean validateEnteredItemCode(String enteredSnackCode) {
        if (enteredSnackCode == null) {
            return false;
        }

        try {
            return snackInventory.get(enteredSnackCode) != 0;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


    public boolean dropItem(Item snack) {
        Integer snackQuantity = this.snackInventory.get(snack.getCode());

        snackQuantity = snackQuantity - 1;

        this.snackInventory.put(snack.getCode(), snackQuantity);

        System.out.println("Drop the snack");

        return true;
    }

    public Map<String, Integer> getSnackInventory() {
        return snackInventory;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public Map<String, Snack> getSnacks() {
        return snacks;
    }

    public void setSnackInventory(Map<String, Integer> snackInventory) {
        this.snackInventory = snackInventory;
    }
}
