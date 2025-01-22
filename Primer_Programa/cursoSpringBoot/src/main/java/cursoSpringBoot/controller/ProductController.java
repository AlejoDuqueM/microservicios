package cursoSpringBoot.controller;

import cursoSpringBoot.model.Product;
import cursoSpringBoot.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    //Instancia de clase
    //polimorfismo dinamico es cuando se crea una instancia de una interfaz y se le asigna una clase que implementa esa interfaz
    //IProductsService productsService = new ProductsServiceImpl();

    //Inyeccion de dependencias por campo
    @Autowired                                  //esto es inyeccion de dependencias
    private IProductsService productsService;   //esto es composicion

    @GetMapping
    public ResponseEntity<?> getAllProducts() {

        List<Product> products = productsService.getAllProducts();

        return ResponseEntity.ok(products);

    }



}
