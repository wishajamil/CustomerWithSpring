package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    /*  POST METHOD - create a customer (create a customer and added to the list using postman)

        inject this customerService to Resource class by using Autowired annotation.
        To use @Autowired make sure that your customerService class is annotated with @Component
        with this annotation you can use this particular customer service anywhere in the resource class
    */
    @Autowired
    private customerService customerService;

    @PostMapping
    // to get the Customer object from the user use @RequestBody
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    /*
        GET METHOD
     */
    // retrieve all the customers
    // in order to publish this API, use annotation @GetMapping
    @GetMapping
    public List<Customer> getCustomers () {
        return customerService.getCustomers();
    }

    // retrieve the specific customer by passing customerID
    // in order to receive customerID from the request and store into customerID variable, use the annotation @PathVariable (same name you mention in the @GetMapping and @PathVariable)
    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    /*
        PUT METHOD - update the API
     */
    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    /*
        DELETE METHOD
     */
    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer (@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
