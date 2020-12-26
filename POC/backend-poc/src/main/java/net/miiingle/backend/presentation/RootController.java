package net.miiingle.backend.presentation;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

import javax.annotation.Nullable;

@Controller
public class RootController {

    @Introspected
    static class Pong {
        private Long id;
        private String param;

        public Pong(Long id, String param) {
            this.id = id;
            this.param = param;
        }

        public Long getId() {
            return id;
        }

        public String getParam() {
            return param;
        }
    }

    @Get("/ping{?ping}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong ping(@Nullable String ping) {
        return new Pong(System.currentTimeMillis(), ping);
    }

    @Post("/echo")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong ping(Pong pong) {
        return pong;
    }

}