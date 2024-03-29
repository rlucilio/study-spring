package com.renan.cursomc;

import com.renan.cursomc.domain.*;
import com.renan.cursomc.domain.enums.TipoCliente;
import com.renan.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Autowired
    private IProdutoRepository produtoRepository;
    @Autowired
    private IEstadoRepository estadoRepository;
    @Autowired
    private ICidadeRepository cidadeRepository;
    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;
    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");

        Produto p1 = new Produto("Computador", 2000.0);
        Produto p2 = new Produto("Impressora", 800.0);
        Produto p3 = new Produto("Mouse", 80.0);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p3));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

//        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado("Minhas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade c1 = new Cidade("Ubelândia", est1);
        Cidade c2 = new Cidade("São Paulo", est2);
        Cidade c3 = new Cidade("Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

//        estadoRepository.saveAll(Arrays.asList(est1, est2));
//        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "42599424844", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("123456789", "123456789"));

        Endereco e1 = new Endereco("Rua Flores", "300", "Apto 303", "Jardim", "321654", c1, cli1);
        Endereco e2 = new Endereco("Avenida Matos", "105", "Sala 800", "Centro", "321654", c1, cli1);

//        clienteRepository.saveAll(Arrays.asList(cli1));
//        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    }
}
