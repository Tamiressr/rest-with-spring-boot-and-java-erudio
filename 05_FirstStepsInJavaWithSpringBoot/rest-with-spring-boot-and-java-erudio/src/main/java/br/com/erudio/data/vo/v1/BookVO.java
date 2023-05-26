package br.com.erudio.data.vo.v1;


import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class BookVO extends RepresentationModel<PersonVO> implements Serializable {
	private static final long serialversionUID = 1L;
	private UUID id;
	private String nome;
	private LocalDate dataLancamento;
	private String autor;
	private String quantidadeDePaginas;
	private String Genero;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(String quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}
}
