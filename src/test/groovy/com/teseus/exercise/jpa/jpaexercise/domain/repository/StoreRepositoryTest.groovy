package com.teseus.exercise.jpa.jpaexercise.domain.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class StoreRepositoryTest extends Specification {
    @Autowired
    StoreRepository storeRepository
    def test1() {
        expect:
        storeRepository != null
    }
}
