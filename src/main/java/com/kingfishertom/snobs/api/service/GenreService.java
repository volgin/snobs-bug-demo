package com.kingfishertom.snobs.api.service;

import java.util.List;

import com.kingfishertom.snobs.model.Genre;
import com.kingfishertom.snobs.repository.GenreRepository;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@CacheConfig("genres")
public class GenreService {

	@Inject
	GenreRepository genreRepository;

	@Cacheable
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	public Genre findById(Long id) {
		return genreRepository.findById(id).orElseThrow();
	}

}