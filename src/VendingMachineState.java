public interface VendingMachineState {

    void insertCoin(double amount);

    Product selectProduct(String code);

    void dispense(Product product);
}
