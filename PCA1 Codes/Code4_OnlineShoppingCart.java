import java.util.Scanner;
class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCartApp app = new ShoppingCartApp();
        app.customerMenu();
    }
    private Product[] storeProducts = {
        new Product(101, "Milk", 45.0),
        new Product(102, "Bread", 30.0),
        new Product(103, "Rice", 60.0),
        new Product(104, "Sugar", 40.0),
        new Product(105, "Oil", 150.0)
    };
    void customerMenu() {
        Cart cart = new Cart(10);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nCustomer Menu: -");
            System.out.println("1. Add Product To Cart");
            System.out.println("2. Remove Product From Cart");
            System.out.println("3. Display Shopping Cart");
            System.out.println("4. Display All Store Products");
            System.out.println("5. Checkout Cart");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    listStoreProducts();
                    cart.addProdToCart(storeProducts);
                    break;
                case 2:
                    cart.displayCart();
                    cart.removeProdFromCart(storeProducts);
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    listStoreProducts();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Exiting customer menu...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
    void listStoreProducts() {
        System.out.println("\nAvailable Products: -");
        for (Product p : storeProducts) {
            if (p != null) {
                System.out.println("ID: " + p.getProductId() + " | Name: " + p.getProductName() + " | Price: " + p.getProductPrice());
            }
        }
    }
}
class Product {
    private int productId;
    private String productName;
    private double productPrice;
    Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    int getProductId() {
        return productId;
    }
    String getProductName() {
        return productName;
    }
    double getProductPrice() {
        return productPrice;
    }
}
class Cart {
    private Product[] products;
    private int count;
    Cart(int size) {
        products = new Product[size];
        count = 0;
    }
    void addProdToCart(Product[] storeProducts) {
        if (count >= products.length) {
            System.out.println("Cart is full! Cannot add more products.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product ID to add to cart: ");
        int productId = sc.nextInt();
        Product storeProduct = findProductById(storeProducts, productId);
        if (storeProduct != null) {
            products[count] = storeProduct;
            count++;
            System.out.println(storeProduct.getProductName() + " added to cart!");
        } else {
            System.out.println("Product not found in store.");
        }
        displayShopAndCart(storeProducts);
    }
    void removeProdFromCart(Product[] storeProducts) {
        if (count == 0) {
            System.out.println("Cart is empty.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        displayCart();
        System.out.print("Enter product ID to remove from cart: ");
        int productId = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (products[i] != null && products[i].getProductId() == productId) {
                String removedName = products[i].getProductName();
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[count - 1] = null;
                count--;
                System.out.println(removedName + " removed from cart.");
                displayShopAndCart(storeProducts);
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }
    void displayCart() {
        if (count == 0) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\nShopping Cart: -");
        double total = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + products[i].getProductId() + " | Name: " + products[i].getProductName() + " | Price: " + products[i].getProductPrice());
            total += products[i].getProductPrice();
        }
        System.out.println("Total Price: " + total);
    }
    void checkout() {
        if (count == 0) {
            System.out.println("Cart is empty. Cannot checkout.");
        } else {
            displayCart();
            System.out.println("Checkout complete. Thank you for shopping!");
            count = 0;
        }
    }
    Product findProductById(Product[] storeProducts, int productId) {
        for (Product p : storeProducts) {
            if (p != null && p.getProductId() == productId) {
                return p;
            }
        }
        return null;
    }
    void displayShopAndCart(Product[] storeProducts) {
        System.out.println("\nStore Products: -");
        for (Product p : storeProducts) {
            if (p != null) {
                System.out.println("ID: " + p.getProductId() + " | Name: " + p.getProductName() + " | Price: " + p.getProductPrice());
            }
        }
        displayCart();
    }
}
/*Output: -
Customer Menu: -
1. Add Product To Cart
2. Remove Product From Cart
3. Display Shopping Cart
4. Display All Store Products
5. Checkout Cart
0. Exit
Choice: 1

Available Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0
Enter product ID to add to cart: 101
Milk added to cart!

Store Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
Total Price: 45.0

Customer Menu: -
1. Add Product To Cart
2. Remove Product From Cart
3. Display Shopping Cart
4. Display All Store Products
5. Checkout Cart
0. Exit
Choice: 1

Available Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0
Enter product ID to add to cart: 102
Bread added to cart!

Store Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
Total Price: 75.0

Customer Menu: -
1. Add Product To Cart
2. Remove Product From Cart
3. Display Shopping Cart
4. Display All Store Products
5. Checkout Cart
0. Exit
Choice: 1

Available Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0
Enter product ID to add to cart: 104
Sugar added to cart!

Store Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 104 | Name: Sugar | Price: 40.0
Total Price: 115.0

Customer Menu: -
1. Add Product To Cart
2. Remove Product From Cart
3. Display Shopping Cart
4. Display All Store Products
5. Checkout Cart
0. Exit
Choice: 2

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 104 | Name: Sugar | Price: 40.0
Total Price: 115.0

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 104 | Name: Sugar | Price: 40.0
Total Price: 115.0
Enter product ID to remove from cart: 104
Sugar removed from cart.

Store Products: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
ID: 103 | Name: Rice | Price: 60.0
ID: 104 | Name: Sugar | Price: 40.0
ID: 105 | Name: Oil | Price: 150.0

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
Total Price: 75.0

Customer Menu: -
1. Add Product To Cart
2. Remove Product From Cart
3. Display Shopping Cart
4. Display All Store Products
5. Checkout Cart
0. Exit
Choice: 5

Shopping Cart: -
ID: 101 | Name: Milk | Price: 45.0
ID: 102 | Name: Bread | Price: 30.0
Total Price: 75.0
Checkout complete. Thank you for shopping!

Customer Menu: -
1. Add Product To Cart
2. Remove Product From Cart
3. Display Shopping Cart
4. Display All Store Products
5. Checkout Cart
0. Exit
Choice: 0
Exiting customer menu...
 */