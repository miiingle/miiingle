package com.poc

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject
import javax.persistence.EntityManager

@MicronautTest
class BookControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    RxHttpClient client

    @Inject
    EntityManager em

    void "test retrieval of books"() {
        given:
        em.persist(Book.builder().name("test").build())
        em.getTransaction().commit()
        String body = client.toBlocking().retrieve("/book")

        expect:
        body == """[{"id":1,"name":"test"}]"""
    }
}
