package com.pedido.services;

import com.pedido.domain.Categoria;
import com.pedido.domain.Cliente;
import com.pedido.repositories.ClienteRepository;
import com.pedido.services.exeption.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) {
		Cliente cliente = clienteRepository.findOne(id);
		if (cliente == null) {
			throw new ObjectNotFoundExeption("Objeto não encontrato id:" + id);
		}
		return cliente;
	}
}
