package com.searchdemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.searchdemo.domain.Movie;

public interface MovieSearchRepository extends ElasticsearchRepository<Movie, String> {

    @Query("{\"bool\":{\"must\":{\"match\":{\"Title\":\"?0\"}}}}")
    Page<Movie> findAllByTitle(Pageable pageable, String title);
}
