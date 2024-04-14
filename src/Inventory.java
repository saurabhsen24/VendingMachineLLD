import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private final Map<String,Product> productMap;

    public Inventory() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product product){
        productMap.putIfAbsent(product.getCode(), product);
    }

    public void removeProduct(Product product){
        productMap.remove(product.getCode());
    }

    public Product getProduct(String code){
        return productMap.getOrDefault(code, null);
    }

    public List<Product> getAllProducts(){
        return productMap.values().stream().toList();
    }

    public void reduceProductQty(Product product) {
        product.setQty(product.getQty() - 1);
        if(product.getQty() == 0){
            removeProduct(product);
        }
    }
}
