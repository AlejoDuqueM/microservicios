package cursoSpringBoot.controller;


import cursoSpringBoot.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer(1, "John Doe", "johndoe", "123456"),

            new Customer(2, "Jane Doe", "janedoe", "123456"),

            new Customer(3, "Mary Jane", "maryjane", "123456"),

            new Customer(4, "Peter Parker", "peterparker", "123456")

    ));

    @GetMapping("/clientes")
    public List<Customer> getAllCustomers() {

        return customers;

    }

    @GetMapping("/clientes/{username}")
    public Customer getCustomers(@PathVariable String username) {

        for(Customer c : customers) {

            if(c.getUsername().equalsIgnoreCase(username)) {

                return c;

            }

        }

        return null;
    }

    @PostMapping("/clientes")
    public Customer postCustomer(@RequestBody Customer customer) {

        customers.add(customer);

        return customer;

    }

    @PutMapping("/clientes")
    public Customer putCustomer(@RequestBody Customer customer) {

        for(Customer c : customers) {

            if(c.getId() == customer.getId()) {

                c.setName(customer.getName());

                c.setUsername(customer.getUsername());

                c.setPassword(customer.getPassword());

                return c;

            }

        }

        return null;

    }

    @DeleteMapping("/clientes/{id}")
    public Customer deleteCustomer(@PathVariable int id) {

        for(Customer c : customers) {

            if(c.getId() == id) {

                customers.remove(c);

                return c;

            }

        }

        return null;

    }

}
