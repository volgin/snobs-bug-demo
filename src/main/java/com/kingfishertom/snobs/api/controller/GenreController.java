package com.kingfishertom.snobs.api.controller;

import java.util.List;

import com.kingfishertom.snobs.api.service.GenreService;
import com.kingfishertom.snobs.model.Genre;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@Controller("/api/genres")
@ExecuteOn(TaskExecutors.IO)
public class GenreController {

	@Inject
	GenreService genreService;

	// GET

	@Get
	public Mono<HttpResponse<List<Genre>>> findAll() {
		return Mono.just(HttpResponse.ok(genreService.findAll()));
	}

	@Get(uri = "/{id}")
	public Mono<HttpResponse<Genre>> findById(@PathVariable Long id) {
		return Mono.just(HttpResponse.ok(genreService.findById(id)));
	}

}
