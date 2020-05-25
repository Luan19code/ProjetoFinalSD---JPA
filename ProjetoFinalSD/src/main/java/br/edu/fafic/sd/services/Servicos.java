/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.sd.services;

import br.edu.fafic.persistence.JpaPersistence;
import br.edu.fafic.sd.model.Autor;
import br.edu.fafic.sd.model.Livro;
import java.util.List;
import static org.eclipse.persistence.config.CacheUsageIndirectionPolicy.Exception;

/**
 *
 * @author luanl
 */
public class Servicos {

    private final JpaPersistence jpa = new JpaPersistence();

    public void saveLivro(Livro livro) {
        jpa.save(livro);

    }

    public Livro findById(long id) {
        return jpa.getEm().find(Livro.class, id);

    }

    public Autor findById_autor(long id) {
        return jpa.getEm().find(Autor.class, id);
    }

    public void deletar(Livro livro) {
        jpa.del(livro);
    }

    public Livro getTitulo(String titulo) {
        Livro livro = null;
        List<Livro> l = jpa.getEm().createQuery("select l from Livro l").getResultList();

        for (Livro bucar : l) {
            if (bucar.getTitulo().equals(titulo)) {
                livro = bucar;
            } else if (bucar.getAutor().getCpf().equals(titulo)) {
                livro = bucar;
            } else if (bucar.getIsbn().equals(titulo)) {
                livro = bucar;
            } else if (bucar.getAutor().getNome().equals(titulo)) {
                livro = bucar;
            }

        }
        if (livro == null) {
            System.out.println("Nada Encontrado");
        }

        return livro;
    }

}
