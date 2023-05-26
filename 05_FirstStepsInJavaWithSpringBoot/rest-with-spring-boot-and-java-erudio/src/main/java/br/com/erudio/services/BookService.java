package br.com.erudio.services;

import br.com.erudio.controllers.BookController;

import br.com.erudio.data.vo.v1.BookVO;

import br.com.erudio.exceptions.RequiredObjectIsnullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Book;

import br.com.erudio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	private Logger logger = Logger.getLogger(BookService.class.getName());

	public BookVO save(BookVO bookVO) {

		if (bookVO == null) {
			throw new RequiredObjectIsnullException();
		}
		logger.info("Creating one book!!!");
		var entity = DozerMapper.parseObject(bookVO, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getId())).withSelfRel());

		return vo;

	}

	public BookVO findById(UUID id) {
		logger.info("Finding one book");
		var entity =repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		BookVO bookvo=DozerMapper.parseObject(entity,BookVO.class);
		bookvo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return  bookvo;
	}

	public BookVO update(BookVO bookVO){
		logger.info("updating one book");
		var entity =repository.findById(bookVO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setAutor(bookVO.getAutor());
		entity.setGenero(bookVO.getGenero());
		entity.setId(bookVO.getId());
		entity.setDataLancamento(bookVO.getDataLancamento());
		entity.setQuantidadeDePaginas(bookVO.getQuantidadeDePaginas());
		entity.setNome(bookVO.getNome());

		BookVO vo= DozerMapper.parseObject(repository.save(entity),BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getId())).withSelfRel());

		return vo;
	}
}
