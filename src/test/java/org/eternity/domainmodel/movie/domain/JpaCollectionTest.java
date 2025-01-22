package org.eternity.domainmodel.movie.domain;

import jakarta.persistence.EntityManager;
import org.eternity.domainmodel.generic.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest(showSql = false)
public class JpaCollectionTest {
	@Autowired
	private EntityManager em;

	@Test
	public void persist() {
		Movie movie = new Movie("한산", 120, Money.wons(10000));
		movie.addPrice(Money.wons(2000));

	    em.persist(movie);
		em.flush();
		em.clear();

		Movie loadedMovie = em.find(Movie.class, movie.getId());
		loadedMovie.addPrice(Money.wons(1000));

		em.flush();
	}

	@Test
	public void remove() {
		Movie movie = new Movie("한산", 120, Money.wons(10000));
		movie.addPrice(Money.wons(1000));
		movie.addPrice(Money.wons(2000));

		em.persist(movie);
		em.flush();
		em.clear();

		Movie loadedMovie = em.find(Movie.class, movie.getId());
		loadedMovie.getPrices().clear();

		em.flush();
	}
}