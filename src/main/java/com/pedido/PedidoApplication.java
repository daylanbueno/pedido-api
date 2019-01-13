package com.pedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedido.domain.Categoria;
import com.pedido.repositories.CategoriaRepository;

@SpringBootApplication
public class PedidoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRespository;

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		categoriaRespository.save(Arrays.asList(cat1,cat2));
	}

}

