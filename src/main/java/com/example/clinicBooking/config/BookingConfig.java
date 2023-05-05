//package com.example.clinicBooking.config;
//
//import com.example.clinicBooking.repository.BookingRepository;
//import com.example.clinicBooking.service.BookingService;
//import com.example.clinicBooking.service.BookingServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.persistence.EntityManagerFactory;
//import java.beans.PropertyVetoException;
//
//@Configuration
//public class BookingConfig{
//    @Bean
//    public EntityManagerFactory entityManagerFactory() throws PropertyVetoException {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factory;
//        factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setPackagesToScan("com.example.clinicBooking.model");
//        return factory;
//    }
//}
//
//
