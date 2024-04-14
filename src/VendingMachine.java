import java.util.List;

public class VendingMachine {

    private double amount;
    private final Inventory inventory;
    private VendingMachineState vendingMachineState;

    public VendingMachine(Inventory inventory){
        this.inventory = inventory;
        vendingMachineState = new NoCoinInsertedState(this);
    }

    public void showAllProducts(){
        List<Product> products = inventory.getAllProducts();
        for(Product product: products){
            System.out.println(product.getCode() + " " + product.getName() + " " + product.getPrice());
        }
    }

    public void insertCoin(double amt){
        vendingMachineState.insertCoin(amt);
    }

    public Product selectProduct(String code){
        return vendingMachineState.selectProduct(code);
    }

    public void dispense(Product product){
        vendingMachineState.dispense(product);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
