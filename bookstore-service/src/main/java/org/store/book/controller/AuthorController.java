package org.store.book.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Author;
import org.store.book.repository.AuthorRepository;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/author")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class AuthorController {

  @Resource
  private AuthorRepository authorRepository;

  @GetMapping
  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  @PostMapping
  public void createNewAuthor(@RequestBody Author author) {
    authorRepository.save(author);
  }

  @PutMapping
  public void updateAuthor(@RequestBody Author author) {
    authorRepository.save(author);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthorById(@PathVariable long id) {
    authorRepository.deleteById(id);
  }
}
