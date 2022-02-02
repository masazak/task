import Entities.MoneySlot;

public class MoneyGenerator {

    public static MoneySlot parseMoney(String input) {

        if ("$1".equals(input)) {
            return new MoneySlot(1, "NOTE");
        } else if ("50c".equals(input)) {
            return new MoneySlot(0.5f, "CENT");
        } else if ("$50".equals(input)) {
            return new MoneySlot(50, "NOTE");
        } else if ("10c".equals(input)) {
            return new MoneySlot(0.1f, "CENT");
        } else if ("20c".equals(input)) {
            return new MoneySlot(0.2f, "CENT");
        } else if ("$20".equals(input)) {
            return new MoneySlot(20, "NOTE");
        }
        return new MoneySlot(0f, "NOTE");
    }

}

