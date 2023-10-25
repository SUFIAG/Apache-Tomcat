/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 20-06-2022/06/2022
 *   Time: 11:29 PM
 *   File: Customer
 */

package com.example.apache_tomcat_demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String city;
}
