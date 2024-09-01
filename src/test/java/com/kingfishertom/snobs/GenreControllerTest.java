package com.kingfishertom.snobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.kingfishertom.snobs.api.service.GenreService;
import com.kingfishertom.snobs.model.Genre;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
public class GenreControllerTest extends SnobsTests {

	@Inject
	GenreService genreService;

	// This test fails
	@Test
	void testFindAll() {

		List<Genre> genres = genreService.findAll();

		assertNotNull(genres);

	}

	// This test works
	@Test
	void testFindById() {

		Long genreId = 1L;

		Genre genre = genreService.findById(genreId);

		assertNotNull(genre);
		assertEquals(genreId, genre.getId());

	}

}
