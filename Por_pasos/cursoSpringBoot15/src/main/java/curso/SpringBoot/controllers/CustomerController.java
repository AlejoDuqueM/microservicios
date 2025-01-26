package curso.SpringBoot.controllers;

import curso.SpringBoot.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Juan", "juanito", "1234"),
            new Customer(2, "Pedro", "pedrito", "1234"),
            new Customer(3, "Maria", "maria", "1234"),
            new Customer(4, "Jose", "jose", "1234")
    ));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.ok(customers);

    }

    //@RequestMapping(value = "/{username_}", method = RequestMethod.GET)
    @GetMapping("/{username_}")
    public ResponseEntity<?> getCustomerById(@PathVariable String username_) {

        for(Customer c : customers) {

            if(c.getUsername().equalsIgnoreCase(username_)) {

                return ResponseEntity.ok(c);

            }

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el usuario: " + username_);

    }


    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customervar){

        customers.add(customervar);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customervar.getUsername())
                .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customervar);

    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customerput){

        for (Customer c: customers){

           if(c.getId() == customerput.getId()){

               c.setName(customerput.getName());
               c.setUsername(customerput.getUsername());
               c.setPassword(customerput.getPassword());

               //Genera codigo 204, que es indicado para el PUT
               return ResponseEntity.noContent().build();

           }

        }

        return ResponseEntity.notFound().build();

    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delCliente(@PathVariable int id){

        for (Customer c: customers) {

            if(c.getId() == id){

                customers.remove(c);

                return ResponseEntity.noContent().build();

            }

        }

        return ResponseEntity.notFound().build();

    }

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customerpath){

        for(Customer c: customers){

            if(c.getId() == customerpath.getId()){

                if(customerpath.getName() != null){

                    c.setName(customerpath.getName());

                }
                if(customerpath.getUsername() != null){

                    c.setUsername(customerpath.getUsername());

                }
                if(customerpath.getPassword() != null){

                    c.setPassword(customerpath.getPassword());

                }

                return ResponseEntity.ok("Cliente modificado exitosamente: " + customerpath.getId());

            }


        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el id: " + customerpath.getId());

    }














}
