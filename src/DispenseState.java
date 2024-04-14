public class DispenseState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException();
    }

    @Override
    public Product selectProduct(String code) {
        throw new IllegalStateException();
    }

    @Override
    public void dispense(Product product) {
        System.out.println(product.getName() + " dispensed successfully");
        vendingMachine.setVendingMachineState(new NoCoinInsertedState(vendingMachine));
    }
}
