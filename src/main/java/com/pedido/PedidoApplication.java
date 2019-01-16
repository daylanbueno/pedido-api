package com.pedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedido.domain.Categoria;
import com.pedido.domain.Cidade;
import com.pedido.domain.Cliente;
import com.pedido.domain.Endereco;
import com.pedido.domain.Estado;
import com.pedido.domain.Produto;
import com.pedido.domain.enums.TipoCliente;
import com.pedido.repositories.CategoriaRepository;
import com.pedido.repositories.CidadeRepository;
import com.pedido.repositories.ClienteRepository;
import com.pedido.repositories.EnderecoRepository;
import com.pedido.repositories.EstadoRepository;
import com.pedido.repositories.ProdutoRespository;

@SpringBootApplication
public class PedidoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRespository;

	@Autowired
	private ProdutoRespository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
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
		
		
		Estado df = new Estado(null, "Distrito Federal");
		Estado sp = new Estado(null, "São Paulo");
		
		Cidade sobradinho = new Cidade(null,"Sobradinho",df);
		Cidade aguasclaras = new Cidade(null,"Aguas Claras",df);
		Cidade campinas  = new Cidade(null, "Campinas",sp);
		df.getCidades().addAll(Arrays.asList(sobradinho,aguasclaras));
		sp.getCidades().add(campinas);
		
	
		Cliente c1 = new Cliente(null, "Dailan", "dailansantos@gmail.com", "0450134143", TipoCliente.PESSOAFISICA);
		c1.getTelefones().addAll(Arrays.asList("61991602632","332233555"));
		
		Endereco e1 = new Endereco(null, "rua 1", "01a", "teste", "sobrad", "teste", sobradinho, c1);
		Endereco e2 = new Endereco(null, "Aguas 1", "12", "Predinho", "esquina", "nao sei", aguasclaras, c1);
		
		c1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		categoriaRespository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		estadoRepository.save(Arrays.asList(df,sp));
		cidadeRepository.save(Arrays.asList(sobradinho,aguasclaras,campinas));
		clienteRepository.save(c1);
		enderecoRepository.save(Arrays.asList(e1,e2));
	}
	

}

