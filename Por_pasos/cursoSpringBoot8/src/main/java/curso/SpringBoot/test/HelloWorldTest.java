package curso.SpringBoot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorldTest {

    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloWorld() {

        System.out.println("Solicitud ejecutada...");

        return "Probando que funciona la aplicación";
        
    }

}
