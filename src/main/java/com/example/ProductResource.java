package com.example;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductResource {
    private List<Product> produtos;
    // private Product produto;

    public ProductResource() {
        this.produtos = new ArrayList<>();
        this.produtos.add(new Product("cao", 50.00, 5));
        this.produtos.add(new Product("gato", 30.00, 7));
    }

    @RequestMapping(value = "/produtos/", method = RequestMethod.GET)
    public List<Product> buscarPrdutos(@RequestParam(required = false) final String raca) {
        if (raca == null) {
            return this.produtos;
        } else {
            final List<Product> prod = new ArrayList<>();
            for (final Product p : this.produtos) {
                if (raca.equals(p.getRaca()))
                    prod.add(p);
            }
            return prod;
        }
        // return "Gretings from Spring Boot";
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public Product buscarProduto(@PathVariable final Integer id) {
        // try {
            return this.produtos.get(id - 1);
        // }
        
    }
     
    @RequestMapping(value = "/produtos/{id}",method = RequestMethod.DELETE)
    public void removerProduto(@PathVariable Integer id) {
        this.produtos.remove(id - 1);
    }

    @RequestMapping(value = "/produtos/", method = RequestMethod.POST)
    public Product criarProduto(@RequestBody Product product) {
        String raca = product.getRaca();
        double valor = product.getValor();
        int quantidade = (int) product.getQuantidade();
        return new Product(raca, valor, quantidade);
    }

    @RequestMapping(value ="/produtos/{id}", method=RequestMethod.PUT)
    public void requestMethodName(@PathVariable Integer id,
    @RequestBody Product produtoParam) {
        Product produto = this.produtos.get(id - 1);
        produto.setQuantidade(produtoParam.getQuantidade());
        produto.setValor(produtoParam.getValor());
        produto.setRaca(produtoParam.getRaca());
    }
    

}
