package com.demwis.tests.gilan.services

import com.demwis.tests.gilan.dao.ProductRepository
import spock.lang.Specification

class ProductServiceImplTest extends Specification {
    def "Should add product appropriately"() {
        given:
        def id = "id"
        def idGenerationService = Mock(IdGenerationService) {
            1 * generateId() >> id
        }
        def productRepository = Mock(ProductRepository)
        def service = new ProductServiceImpl(productRepository, idGenerationService)

        when:
        service.addProduct()
    }

    def "UpdateProduct"() {
    }

    def "DeleteProductById"() {
    }

    def "FindProduct"() {
    }

    def "FindAllLeftovers"() {
    }
}
