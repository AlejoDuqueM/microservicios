package cursoSpringBoot.controller;


import cursoSpringBoot.model.Customer;
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

            new Customer(1, "John Doe", "johndoe", "123456"),

            new Customer(2, "Jane Doe", "janedoe", "123456"),

            new Customer(3, "Mary Jane", "maryjane", "123456"),

            new Customer(4, "Peter Parker", "peterparker", "123456")

    ));

    /**
     * La clase response entity permite devolver un objeto con un status code
     * es una clase wrapper que envuelve un objeto y un status code
     * En este ejemplo el objeto es List<Customer> y el status code es 200
     * Sin responseEntity el metodo seria solo public List<Customer> getAllCustomers()
     */

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        //return customers;
        return ResponseEntity.ok(customers);

    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    /**
     * sin responseEntity el metodo seria public Customer getCustomers(@PathVariable String username)
     * Deberia ir ResponseEntity<Customer> pero arrojaria
     * un error en el return responseEntity.status,
     * pues el texto de body no es un objeto Customer
     * en este caso el parametro es username
     */
    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomers(@PathVariable String username) {

        for (Customer c : customers) {

            if (c.getUsername().equalsIgnoreCase(username)) {

                return ResponseEntity.ok(c);
                //return c;

            }

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El recurso o cliente no fue encontrado: " + username);
        //return null;
    }

    //@RequestMapping(method = RequestMethod.POST)
    //public customer postCustomer(@RequestBody Customer customer)
    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {

        customers.add(customer);

        //return ResponseEntity.status(HttpStatus.CREATED).body("El cliente fue creado correctamente: " + customer.getUsername());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

    /**
     * PUT /clientes actualiza completamente un cliente
     * @param customer
     * @return
     */
    //@RequestMapping(method = RequestMethod.PUT)
    //public Customer putCustomer(@RequestBody Customer customer)
    @PutMapping
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer) {

        for(Customer c : customers) {

            if(c.getId() == customer.getId()) {

                c.setName(customer.getName());

                c.setUsername(customer.getUsername());

                c.setPassword(customer.getPassword());

                //return c;
                //return ResponseEntity.ok("El cliente fue actualizado correctamente: " + customer.getId());
                return ResponseEntity.noContent().build();

            }

        }


        //return null;
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no fue encontrado: " + customer.getId());
        return ResponseEntity.notFound().build();
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //public Customer deleteCustomer(@PathVariable int id)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {

        for(Customer c : customers) {

            if(c.getId() == id) {

                customers.remove(c);

                //return c;
                /*return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("El cliente fue eliminado correctamente: " + id);*/

                return ResponseEntity.noContent().build();

            }

        }

        //return null;
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no fue encontrado: " + id);
        return ResponseEntity.notFound().build();

    }

    /**
     * PATCH /clientes/{id} actualiza parcialmente un cliente
     * Request body recibe parametros tipo JSON
     */

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer) {

        for(Customer c : customers) {

            if(c.getId() == customer.getId()) {

                if(customer.getName() != null) {

                    c.setName(customer.getName());

                }

                if(customer.getUsername() != null) {

                    c.setUsername(customer.getUsername());

                }

                if(customer.getPassword() != null) {

                    c.setPassword(customer.getPassword());

                }

                return ResponseEntity.ok("El cliente fue actualizado correctamente: " + customer.getName());

            }

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no fue encontrado con el ID: " + customer.getId());

    }

}
