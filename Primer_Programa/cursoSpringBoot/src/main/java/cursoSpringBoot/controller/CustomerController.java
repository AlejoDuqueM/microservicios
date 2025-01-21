package cursoSpringBoot.controller;


import cursoSpringBoot.model.Customer;
import org.springframework.web.bind.annotation.*;

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

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getAllCustomers() {

        return customers;

    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCustomers(@PathVariable String username) {

        for (Customer c : customers) {

            if (c.getUsername().equalsIgnoreCase(username)) {

                return c;

            }

        }

        return null;
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer) {

        customers.add(customer);

        return customer;

    }

    /**
     * PUT /clientes actualiza completamente un cliente
     * @param customer
     * @return
     */
    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
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

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id) {

        for(Customer c : customers) {

            if(c.getId() == id) {

                customers.remove(c);

                return c;

            }

        }

        return null;

    }

    /**
     * PATCH /clientes/{id} actualiza parcialmente un cliente
     * Request body recibe parametros tipo JSON
     */

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public Customer patchCustomer(@RequestBody Customer customer) {

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

                return c;

            }

        }

        return null;

    }

}
