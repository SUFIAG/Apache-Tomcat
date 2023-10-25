package com.example.apache_tomcat_demo.dao;

import com.example.apache_tomcat_demo.entity.Customer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerDao {

    @Select("select * from customers")
    public List<Customer> getAllCustomers();

}
