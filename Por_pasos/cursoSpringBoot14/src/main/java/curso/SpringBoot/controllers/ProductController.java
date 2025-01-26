package curso.SpringBoot.controllers;

import curso.SpringBoot.model.Product;
import curso.SpringBoot.service.IProductService;
import curso.SpringBoot.service.impl.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    /**
     * Aqui se usa el polimorfismo dinamico
     */
    IProductService productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getAllProducts(){

        List<Product> products = productsService.getAllProductos();

        return ResponseEntity.ok(products);

    }

}
