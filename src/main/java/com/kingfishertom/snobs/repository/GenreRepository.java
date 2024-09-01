package com.kingfishertom.snobs.repository;

import java.util.List;
import java.util.Optional;

import com.kingfishertom.snobs.model.Genre;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface GenreRepository extends CrudRepository<Genre, Long> {

	@Override
	@NonNull
	@Join(value = "genre", type = Join.Type.LEFT_FETCH)
	List<Genre> findAll();

	@Override
	@NonNull
//	@Join(value = "genre", type = Join.Type.LEFT_FETCH)
	Optional<Genre> findById(Long id);

}