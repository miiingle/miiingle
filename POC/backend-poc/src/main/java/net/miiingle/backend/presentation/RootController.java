package net.miiingle.backend.presentation;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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

    @Operation(
            operationId = "echo",
            summary = "echo the request",
            responses = {
                    @ApiResponse(
                            description = "same as the body",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = Pong.class)))
            })
    @Post("/echo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pong echo(
            @RequestBody(
                    description = "the pong",
                    content = @Content(
                            schema = @Schema(implementation = Pong.class))) Pong pong) {
        return pong;
    }

}