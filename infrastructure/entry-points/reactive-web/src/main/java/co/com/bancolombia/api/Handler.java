package co.com.bancolombia.api;

import co.com.bancolombia.model.sede.Sede;
import co.com.bancolombia.usecase.sede.SedeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class Handler {
    private final SedeUseCase useCase;

    public Mono<ServerResponse> getAllSedes(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(useCase.getAllSedes(), Sede.class);
    }

    public Mono<ServerResponse> getSedesById(ServerRequest serverRequest) {

        String id = serverRequest.pathVariable("id");
        return useCase.getSedeById(id).flatMap(currentSede -> ServerResponse
                        .ok()
                        .body(BodyInserters.fromValue(currentSede)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createSedes(ServerRequest serverRequest){
        Mono<Sede> sede = serverRequest.bodyToMono(Sede.class);

        return sede.flatMap(currentSede -> {
            return useCase.createSede(currentSede);
        }).flatMap(currentSede -> ServerResponse.created(URI
                        .create("/api/sede/v2".concat(currentSede.getId())))
                .body(BodyInserters.fromValue(currentSede)));

    }

   public Mono<ServerResponse> updateSedes(ServerRequest request){
        Mono<Sede> sede = request.bodyToMono(Sede.class);
        String id = request.pathVariable("id");

        return sede.flatMap(currentSede -> {
                    return useCase.updateSede(id, currentSede);
                }).flatMap(currentSede -> ServerResponse.created(URI
                                .create("/api/sede/v2".concat(currentSede.getId())))
                        .body(BodyInserters.fromValue(currentSede)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteSedes(ServerRequest request){
        String id = request.pathVariable("id");

        return useCase.deleteSede(id).then(ServerResponse.noContent().build())
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
