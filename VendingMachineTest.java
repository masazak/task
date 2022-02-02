import Entities.Snack;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VendingMachineTest {
    @Test
    public void testValidatingExistItem() {
        SnackVendingMachine snackVendingMachine = new SnackVendingMachine();

            // Fill the inventory of the machine
        snackVendingMachine.fillInventory();

        boolean isValidItemCode  = snackVendingMachine.validateEnteredSnackCode("MARS");

        assertTrue(isValidItemCode);

    }

    @Test
    public void testValidatingNonExistItem() {
        SnackVendingMachine snackVendingMachine = new SnackVendingMachine();

        // Fill the inventory of the machine
        snackVendingMachine.fillInventory();

        boolean isValidItemCode  = snackVendingMachine.validateEnteredSnackCode("JENIN");

        assertFalse(isValidItemCode);

    }

    @Test
    public void testBuyingAvailableItem() {
        SnackVendingMachine snackVendingMachine = new SnackVendingMachine();

        // Fill the inventory of the machine
        snackVendingMachine.fillInventory();

        Snack selectedSnack = snackVendingMachine.getSnackByCode("MARS");

        boolean droppingStatus = snackVendingMachine.dropSnack(selectedSnack);

        assertTrue(droppingStatus);

    }

    @Test
    public void testBuyingNonAvailableItem() {
        SnackVendingMachine snackVendingMachine = new SnackVendingMachine();

        // Fill the inventory of the machine
        snackVendingMachine.fillInventory();

        Snack selectedSnack = snackVendingMachine.getSnackByCode("MARS");

        snackVendingMachine.dropSnack(selectedSnack);
        snackVendingMachine.dropSnack(selectedSnack);
        snackVendingMachine.dropSnack(selectedSnack);
        snackVendingMachine.dropSnack(selectedSnack);
        snackVendingMachine.dropSnack(selectedSnack);
        boolean droppingStatus= snackVendingMachine.dropSnack(selectedSnack);
        assertFalse(droppingStatus);

    }
}
