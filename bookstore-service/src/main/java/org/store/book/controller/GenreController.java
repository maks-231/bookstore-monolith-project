package org.store.book.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Genre;
import org.store.book.repository.GenreRepository;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/genre")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class GenreController {

  @Resource
  private GenreRepository genreRepository;

  @GetMapping
  public List<Genre> getAllGenres() {
    return genreRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
  }

  @PostMapping
  public void createNewGenre(@RequestBody Genre genre) {
    genreRepository.save(genre);
  }

  @PutMapping
  public void updateGenre(@RequestBody Genre genre) {
    genreRepository.save(genre);
  }

  @DeleteMapping("/{id}")
  public void deleteGenreById(@PathVariable long id) {
    genreRepository.deleteById(id);
  }

}
