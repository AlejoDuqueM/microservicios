package curso.SpringBoot.service;


import curso.SpringBoot.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsServiceImpl {

    List<Product> productos = new ArrayList<>(Arrays.asList(

            new Product(1, "Laptop", 799.99, 10),
            new Product(2,"Smartphone",499.99,25),
            new Product(3, "Tablet", 299.99, 15),
            new Product(4, "Smartwatch", 199.99, 30)

            ));


    public List<Product> getAllProductos() {

        return productos;

    }





}
