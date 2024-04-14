public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("101", "Pepsi", 200, 10));
        inventory.addProduct(new Product("102", "Cocacola", 200, 10));
        inventory.addProduct(new Product("103", "Juice", 200, 10));
        VendingMachine vendingMachine = new VendingMachine(inventory);

        vendingMachine.insertCoin(200);
        Product product = vendingMachine.selectProduct("101");
        vendingMachine.dispense(product);
    }
}