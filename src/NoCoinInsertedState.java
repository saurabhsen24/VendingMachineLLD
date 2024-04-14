public class NoCoinInsertedState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public NoCoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("User inserting " + amount + " in vending machine");
        vendingMachine.setAmount(amount);
        vendingMachine.setVendingMachineState(new CoinInsertedState(vendingMachine));
    }

    @Override
    public Product selectProduct(String code) {
        throw new IllegalStateException("Product can't be selected in NoCoinInsertedState");
    }

    @Override
    public void dispense(Product product) {
        throw new IllegalStateException("Dispense not possible in " + this.getClass().getName());
    }
}
