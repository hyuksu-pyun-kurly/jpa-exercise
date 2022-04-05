package com.teseus.exercise.jpa.jpaexercise.domain.repository

import com.teseus.exercise.jpa.jpaexercise.domain.entity.Employee
import com.teseus.exercise.jpa.jpaexercise.domain.entity.Product
import com.teseus.exercise.jpa.jpaexercise.domain.entity.Store
import com.teseus.exercise.jpa.jpaexercise.domain.service.StoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest
class StoreRepositoryTest extends Specification {
    @Autowired
    StoreRepository storeRepository

    @Autowired
    StoreService storeService

    @Transactional
    def 'should save stores'() {
        given:
        Store store1 = new Store("서점", "서울시 강남구");
        store1.addProduct(new Product("책1_1", 10000L));
        store1.addProduct(new Product("책1_2", 20000L));
        store1.addEmployee(new Employee("직원1", LocalDate.now()));
        store1.addEmployee(new Employee("직원2", LocalDate.now()));
        storeRepository.save(store1);

        Store store2 = new Store("서점2", "서울시 강남구");
        store2.addProduct(new Product("책2_1", 10000L));
        store2.addProduct(new Product("책2_2", 20000L));
        store2.addEmployee(new Employee("직원2_1", LocalDate.now()));
        store2.addEmployee(new Employee("직원2_2", LocalDate.now()));
        storeRepository.save(store2);

        when:
        long size = storeService.find();

        then:
        size == 60000L
    }
}
