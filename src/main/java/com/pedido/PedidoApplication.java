package com.pedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedido.domain.Categoria;
import com.pedido.domain.Produto;
import com.pedido.repositories.CategoriaRepository;
import com.pedido.repositories.ProdutoRespository;

@SpringBootApplication
public class PedidoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRespository;

	@Autowired
	private ProdutoRespository produtoRepository;


	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		Categoria cat1 = new Categoria(null, "Informática");
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		Categoria cat2 = new Categoria(null, "Escritório");
		cat2.getProdutos().add(p2);
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat2);
		
		categoriaRespository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
	}

}

