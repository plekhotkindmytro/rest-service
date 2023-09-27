package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.models.Order;
import com.example.restservice.models.Product;

@RestController
public class ProductController {
    
    private static List<Product> products = new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            Product product = new Product(i+1, "IPhone " + (i + 6), 300000 + i*10000, "This is cool IPhone " + (i + 6), i*10);
            products.add(product);
        }
    }

    private static List<Order> orders = new ArrayList<>();

    // As a manager/client you should be able to list all available goods and their prices and quantities
    @GetMapping("/products")
	public List<Product> get() {
		return products;
	}

    // As a manager you should be able to add goods to db so clients will be able to buy them
    @PostMapping("/products")
	public Product add(
        @RequestParam(name="name", required=true) String name,
        @RequestParam(name="price", required=true) long price, 
        @RequestParam(name="description", required=false, defaultValue = "No information yet.") String description,
        @RequestParam(name="quantity", required=false, defaultValue = "1") int quantity) {
            int id = products.get(products.size() - 1).getId()+ 1;
            Product product = new Product(id, name, price, description, quantity);
         
		return product;    
	}

    // @GetMapping("/product/{id}")
    // public Product one(@PathVariable int id) {
    //     for (Product product : products) {
    //         if(product.getId() == id) {
    //             return product;
    //         }
    //     }
    //     return null;
    // }

    // As a client you should be able to place orders for goods (multiple allowed for example in you order you can buy iPhone 13 Pro 5 units, and iPhone 11 10 units)
    @PostMapping("/order")
	public Order buy(@PathVariable int id) {
        // for (Product product : products) {
        //     if(product.getId() == id) {
        //         product.setAvailable(false);
        //         return product;
        //     }
        // }
        return null; 
	}

    // As a client you should be able to pay for your order so provide endpoint that will mark clients order as paid
    @PostMapping("/order/{id}/pay")
	public Order pay(@PathVariable UUID id) {
        for (Order order : orders) {
            if(order.getId().equals(id)) {
                order.setPaid(true);
                return order;
            }
        }
        return null; 
	}

    // Your application should manage risks and automatically delete not paid orders after 10 minutes after creations
    

}
