package com.brq.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brq.cursomc.domain.CategoriaDomain;
import com.brq.cursomc.domain.ProdutoDomain;
import com.brq.cursomc.repositories.CategoriaRepository;
import com.brq.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CategoriaDomain categoriaDomain1 = new CategoriaDomain(null, "Informática");
		CategoriaDomain categoriaDomain2 = new CategoriaDomain(null, "Escritório");
		
		ProdutoDomain produtoDomain1 = new ProdutoDomain(null, "Computador", 2000.00);
		ProdutoDomain produtoDomain2 = new ProdutoDomain(null, "Impressora", 800.00);
		ProdutoDomain produtoDomain3 = new ProdutoDomain(null, "Mouse", 80.00);
		
		categoriaDomain1.getProdutos().addAll(Arrays.asList(produtoDomain1, produtoDomain2, produtoDomain3));
		categoriaDomain2.getProdutos().addAll(Arrays.asList(produtoDomain2));
		
		produtoDomain1.getCategorias().addAll(Arrays.asList(categoriaDomain1));
		produtoDomain2.getCategorias().addAll(Arrays.asList(categoriaDomain1, categoriaDomain2));
		produtoDomain3.getCategorias().addAll(Arrays.asList(categoriaDomain1));
		
		categoriaRepository.saveAll(Arrays.asList(categoriaDomain1, categoriaDomain2));
		produtoRepository.saveAll(Arrays.asList(produtoDomain1, produtoDomain2, produtoDomain3));
	}

}
