package com.softtek.academia.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.repository.MovieRepository;


@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) this.movieRepository.findAll();
		LOGGER.info("## User List Obtained: {}", movies);
		return movies;
	}

	@Override
	public Movie getMovieById(Integer id) {
		Movie movie = this.movieRepository.findById(id).orElse(null);
		LOGGER.info("## User Obtained: {}", movie);
		return movie;
	}


	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}


	@Override
    public Movie patchMovie(Integer id, Movie requestBody) {
        // TODO Auto-generated method stub
        Movie movie = this.getMovieById(id);
        movie.setTitle(requestBody.getTitle() != null ? requestBody.getTitle() : movie.getTitle());
        movie.setGenre_id(requestBody.getGenre_id() != null ? requestBody.getGenre_id() : movie.getGenre_id());
        movie.setYear(requestBody.getYear() != null ? requestBody.getYear() : movie.getYear());
        movie.setDirector_id(
                requestBody.getDirector_id() != null ? requestBody.getDirector_id() : movie.getDirector_id());
        movie.setRating(requestBody.getRating() != null ? requestBody.getRating() : movie.getRating());
        return movieRepository.save(movie);
    }

	@Override
	public Movie getMovieByName(String description) {
		return this.getMovieByName(description);
	}

	@Override
	public void deleteMovieById(Integer id) {
		this.movieRepository.deleteById(id);
		
	}

}
