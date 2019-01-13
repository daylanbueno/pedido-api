package com.pedido.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.domain.Categoria;
import com.pedido.repositories.CategoriaRepository;
import com.pedido.services.exeption.ObjectNotFoundExeption;;;
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Categoria  categoria = categoriaRepository.findOne(id); 
		if(categoria == null) {
			throw  new ObjectNotFoundExeption("Objeto não encontrato id:"+id);
		}
		return  categoria;
	}
}
