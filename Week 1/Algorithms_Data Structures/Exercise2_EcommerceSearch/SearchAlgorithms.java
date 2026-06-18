import java.util.Arrays;

public class SearchAlgorithms {
    
    // Linear Search
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Smartphone", "Electronics"),
            new Product("P001", "Laptop", "Electronics"),
            new Product("P004", "Desk Chair", "Furniture"),
            new Product("P002", "Coffee Maker", "Appliances")
        };

        // Linear Search Test
        System.out.println("Linear Search for P001:");
        Product result1 = linearSearch(products, "P001");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Binary Search Test (Requires sorted array)
        Arrays.sort(products);
        System.out.println("\nSorted Array for Binary Search:");
        for(Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nBinary Search for P004:");
        Product result2 = binarySearch(products, "P004");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
