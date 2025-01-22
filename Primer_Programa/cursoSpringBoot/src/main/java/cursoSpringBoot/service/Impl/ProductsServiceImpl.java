package cursoSpringBoot.service.Impl;

import cursoSpringBoot.model.Product;
import cursoSpringBoot.service.IProductsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
@Service//("listResourceService")  //esto se usa para identificar el servicio a inyectar con @Qualifier
@ConditionalOnProperty(name = "service.products", havingValue = "list")
public class ProductsServiceImpl implements IProductsService {

    public ProductsServiceImpl(){
        System.out.println("Instancia de la clase ProductsServiceImpl");
    }

    List<Product> products = new ArrayList<>(Arrays.asList(

                new Product(1, "Laptop", 1000.0, 10),
                new Product(2, "Mouse", 20.0, 100),
                new Product(3, "Keyboard", 50.0, 50),
                new Product(4, "Monitor", 200.0, 20)

    ));


    @Override
    public List<Product> getAllProducts() {

        return products;

    }



}
