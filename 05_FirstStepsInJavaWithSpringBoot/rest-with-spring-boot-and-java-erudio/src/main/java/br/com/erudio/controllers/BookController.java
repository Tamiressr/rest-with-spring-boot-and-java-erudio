package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.model.Book;
import br.com.erudio.services.BookService;
import br.com.erudio.util.MediaType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/api/books")
public class BookController {
	@Autowired
	private BookService service;
	@PostMapping(produces = { br.com.erudio.util.MediaType.APPLICATION_JSON, br.com.erudio.util.MediaType.APPLICATION_XML,
			br.com.erudio.util.MediaType.APPLICATION_YML},
			consumes = { br.com.erudio.util.MediaType.APPLICATION_JSON, br.com.erudio.util.MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public BookVO save( @RequestBody BookVO bookVO){
		return service.save(bookVO);

	}
	public BookVO findById(@PathVariable(value="id") UUID id){
		BookVO bookVO= service.findById(id);
		return bookVO;

	}
	public BookVO update ( @RequestBody BookVO bookVO){
		return service.update(bookVO);
	}
}
