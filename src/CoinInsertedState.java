import java.util.Objects;

public class CoinInsertedState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println(amount + " inserted to the vending machine");
        vendingMachine.setAmount(vendingMachine.getAmount() + amount);
    }

    @Override
    public Product selectProduct(String code) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProduct(code);
        if(Objects.isNull(product)){
            throw new RuntimeException("Product not available");
        }

        if(vendingMachine.getAmount() < product.getPrice()){
            throw new RuntimeException("Insufficient Amount");
        }

        System.out.println("Product selected " + product.getName());
        inventory.reduceProductQty(product);
        vendingMachine.setVendingMachineState(new DispenseState(vendingMachine));
        return product;
    }

    @Override
    public void dispense(Product product) {
        throw new IllegalStateException("Dispense can't be done in CoinInsertedState");
    }
}
