/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 20-06-2022/06/2022
 *   Time: 11:36 PM
 *   File: DaoFactory
 */

package com.example.apache_tomcat_demo.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static CustomerDao getCustomerDao() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        return session.getMapper(CustomerDao.class);
    }
}
