package cursoSpringBoot.controller;

import cursoSpringBoot.configurations.ExternalizedConfiguration;
import cursoSpringBoot.model.Product;
import cursoSpringBoot.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
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
    @Autowired
    @Lazy
    //@Qualifier("listResourceService")           //esto se usa para identificar el servicio a inyectar con @Qualifier
    private IProductsService productsService;   //esto es composicion

    @Autowired
    private ExternalizedConfiguration externalizedConfiguration;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {

        System.out.println(externalizedConfiguration.toString());

        List<Product> products = productsService.getAllProducts();

        return ResponseEntity.ok(products);

    }



}
