package com.kingfishertom.snobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.kingfishertom.snobs.model.Genre;
import com.kingfishertom.snobs.repository.GenreRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
public class GenreControllerTest extends SnobsTests {

	@Inject
	GenreRepository genreRepository;

	// This test fails
	@Test
	void testFindAll() {

		List<Genre> genres = genreRepository.findAll();

		assertNotNull(genres);

	}

	// This test works
	@Test
	void testFindById() {

		Long genreId = 1L;

		Genre genre = genreRepository.findById(genreId).orElseThrow();

		assertNotNull(genre);
		assertEquals(genreId, genre.getId());

	}

}
