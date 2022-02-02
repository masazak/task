import Entities.Item;

public abstract class VendingMachine<T> {

    public  abstract void fillInventory();

    public abstract void showItems();

    public abstract boolean validateEnteredItemCode(String enteredItemCode);

    public abstract boolean dropItem(Item item);
}
