package com.example.demo.service;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class customerService {

    private int customerIDCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<Customer>();

    public Customer addCustomer(Customer customer) {
        customer.setCustomerID(customerIDCount);
        customerList.add(customer);
        customerList.add(customer);
        customerIDCount++;
        return customer;
    }

    //get the list of customer that we have already
    public List<Customer> getCustomers() {
        return customerList;
    }

    //retieve one specific customer
    //pass the customer ID and then from the list we can filter that particular customer ID
    //then we can send it as a response for the particular request
    public Customer getCustomer(int customerID) {
        return customerList
                .stream()
                .filter(c -> c.getCustomerID() == customerID)
                .findFirst()
                .get();
    }

    //update customer Id and customer information
    //going to find the customer from the list then update the info then whatever info is updates that info
    //we are going to be return in this method
    public Customer updateCustomer(int customerID, Customer customer) {
        customerList
                .stream()
                .forEach(c -> {
                    //if customer id is equal to the customer id you passed then I am going to update the
                    //info such as customer first and last name
                    if(c.getCustomerID() == customerID) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        //return the updated customer
        return customerList
                .stream()
                .filter(c -> c.getCustomerID() == customerID)
                .findFirst()
                .get();

    }

    //this method is going to delete the customer based on the ID that we passed
    public void deleteCustomer(int customerID) {
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerID() == customerID) {
                        customerList.remove(c);
                    }
                });
    }
}
