package curso.SpringBoot.controllers;

import curso.SpringBoot.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/clientes/{username}")
    public Customer getCustomerById(@PathVariable String username) {

        for(Customer c : customers) {

            if(c.getUsername().equalsIgnoreCase(username)) {

                return c;

            }

        }

        return null;

    }









}
