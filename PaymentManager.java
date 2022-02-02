import Entities.MoneySlot;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class PaymentManager {

    // this will hold all the coins and how many coin we have from each one include notes .
    private Map<String, Integer> coins = new HashMap<String, Integer>();
    private List<Float> cardsPayments = new ArrayList<Float>();

    public boolean executePayment(Keypad keypad, float itemPrice) {

        System.out.println("-------------------------------------------------------");
        System.out.println("Do you wanna to pay Cash or card, for Cash press 1 , for card press 2");
        String paymentOption =  keypad.readLine();

        if (!paymentOption.equals("1") && !paymentOption.equals("2")) {
            System.out.println("Invalid Option");
            return false;
        }


        if (paymentOption.equals("1")) {
            float remaining = payCash(keypad, itemPrice);
            if (remaining > 0) {
                return returnTheExtraCharge(remaining);
            }
        }

        if (paymentOption.equals("2")) {
            payWithCard(keypad, itemPrice);
            return true;
        }

        return false;
    }


    // This function to ask the user for the card and withdraw the money from it, we cant simulate it.
    public boolean payWithCard(Keypad keypad, float itemPrice) {
        System.out.println("you choose payment with creditCard , please scan the card ");
        String card = keypad.readLine();

        this.cardsPayments.add(itemPrice);
        // we will call withdraw the money from the card
        System.out.println("Successful Payments ");
        return true;
    }

    // This function to ask the user to insert the cash .
    public float payCash(Keypad keypad, float snackPrice) {
        System.out.println("you selected to pay with cash , our machine accepts only 1C , 2C , 5C , 1$ , 20$ ,50$");

        System.out.println("please start enter coins or Notes , when you finish please press Enter");

        //create map to store money entered by user
        return pullCustomerCash(keypad, snackPrice);

    }

    private float pullCustomerCash(Keypad keypad, float snackPrice) {
        float sum = 0;

        snackPrice = snackPrice * 100;

        // machine will accept coins from user until we get enter
        ArrayList<MoneySlot> customerMoneySlots = new ArrayList<MoneySlot>();

        while (true) {
            String enteredMoney = keypad.readLine();
            MoneySlot moneySlot = MoneyGenerator.parseMoney(enteredMoney);
            customerMoneySlots.add(moneySlot);
            sum = sum + moneySlot.getValue();
            if (enteredMoney.equals("")) {

                if (sum < snackPrice) {
                    System.out.println("Your money is less than the price");
                    refundCustomer(customerMoneySlots);
                    return 0;
                }
                addTheMoneyToMachine(customerMoneySlots);
               return sum - snackPrice;
            }
            return 0;
        }
    }

    private boolean returnTheExtraCharge(float v) {
        return true;
    }

    private void addTheMoneyToMachine(ArrayList<MoneySlot> customerMoneySlots) {
        for (MoneySlot moneySlot: customerMoneySlots) {
            if (this.coins.get(moneySlot.getCode()) > 0) {
                this.coins.put(moneySlot.getCode(),this.coins.get(moneySlot.getCode() +1));
            } else {
                this.coins.put(moneySlot.getCode(), 1);
            }
        }
    }

    private void refundCustomer(ArrayList<MoneySlot> customerMoneySlots) {
        for (MoneySlot moneySlot : customerMoneySlots) {
            System.out.println("Refund ");
        }
    }

}
