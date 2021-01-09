package com.poc

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

import javax.inject.Inject

@Testcontainers
@MicronautTest
class DataTestSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    void 'test it works'() {
        expect:
        application.running
    }

}
