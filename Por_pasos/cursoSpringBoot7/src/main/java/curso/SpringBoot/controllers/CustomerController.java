package curso.SpringBoot.controllers;

import curso.SpringBoot.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Juan", "juanito", "1234"),
            new Customer(2, "Pedro", "pedrito", "1234"),
            new Customer(3, "Maria", "maria", "1234"),
            new Customer(4, "Jose", "jose", "1234")
    ));

    @GetMapping("/clientes")
    public List<Customer> getAllCustomers() {

        return customers;

    }

    @GetMapping("/clientes/{username_}")
    public Customer getCustomerById(@PathVariable String username_) {

        for(Customer c : customers) {

            if(c.getUsername().equalsIgnoreCase(username_)) {

                return c;

            }

        }

        return null;

    }


    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customervar){

        customers.add(customervar);

        return customervar;

    }

    @PutMapping("/clientes")
    public Customer putCliente(@RequestBody Customer custumerput){

        for (Customer c: customers){

           if(c.getId() == custumerput.getId()){

               c.setName(custumerput.getName());
               c.setUsername(custumerput.getUsername());
               c.setPassword(custumerput.getPassword());

               return c;
           }

        }

        return null;

    }

    @DeleteMapping("clientes/{id}")
    public Customer delCliente(@PathVariable int id){

        for (Customer c: customers) {

            if(c.getId() == id){

                customers.remove(c);

                return c;

            }

        }

        return null;

    }

    @PatchMapping("/clientes")
    public Customer patchCliente(@RequestBody Customer customerpath){

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

                return c;

            }


        }

        return null;

    }














}
