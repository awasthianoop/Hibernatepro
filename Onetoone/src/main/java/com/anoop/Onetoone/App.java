package com.anoop.Onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
        Transaction t=session.beginTransaction(); */  
    	SessionFactory factory
        = new Configuration()
              .configure("hibernate.cfg.xml")
              .addAnnotatedClass(Student.class)
              .addAnnotatedClass(Address.class)
              .buildSessionFactory();
    
    		Session session=factory.openSession();  
    		Transaction t=session.beginTransaction();
    		
    	Student s1=new Student();    
        s1.setName("Anoop kumar");    
        s1.setEmail("anoop@gmail.com");    
            s1.setId(1);
        Address add=new Address();    
        add.setAddressline("New extension colony");    
        add.setCity("Palwal");    
        add.setState("Hr");    
        add.setId(1);
        add.setPincode("121102");    
            
        s1.setAddress(add);    
        add.setStudent(s1);    
        session.save(s1);
		 
        // Commit the transaction
        session.getTransaction().commit();
 
        
        
            
        session.close();    
        System.out.println("success");    
    }    
   }

