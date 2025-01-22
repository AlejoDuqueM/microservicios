package cursoSpringBoot.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringBoot.model.Product;
import cursoSpringBoot.service.IProductsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//Primary es una anotacion que se usa para indicar
//que esta es la implementacion por defecto de la interfaz
//Esta clase lee desde el archivo products.json
@Primary
@Service//("jsonResourceService")  //esto se usa para identificar el servicio a inyectar con @Qualifier
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductsServiceJSONImpl implements IProductsService {


    //Jackson usa un constructor vacio para crear una instancia de la clase
    @Override
    public List<Product> getAllProducts() {

        List<Product> products;

        try {

            //Leer archivo JSON
            //Convertir JSON a List<Product>

            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});

            //Retornar List<Product>
            return products;

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
}
