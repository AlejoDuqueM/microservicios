package cursoSpringBoot.controller;


import cursoSpringBoot.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
