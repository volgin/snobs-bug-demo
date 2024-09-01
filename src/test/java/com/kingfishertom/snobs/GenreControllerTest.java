package com.kingfishertom.snobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.kingfishertom.snobs.model.Genre;

import io.micronaut.http.HttpRequest;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
public class GenreControllerTest extends SnobsTests {

	@BeforeAll
	public void beforeAll() {
		init();
	}

	@AfterAll
	public void afterAll() {
		stop();
	}

	// This test fails
	@Test
	void testFindAll() {

		Genre[] genres = client.toBlocking().retrieve(HttpRequest.GET("/api/genres/"), Genre[].class);

		assertNotNull(genres);

	}

	// This test works
	@Test
	void testFindById() {

		Long genreId = 1L;

		Genre genre = client.toBlocking().retrieve(HttpRequest.GET("/api/genres/" + genreId), Genre.class);

		assertNotNull(genre);
		assertEquals(genreId, genre.getId());

	}

}
