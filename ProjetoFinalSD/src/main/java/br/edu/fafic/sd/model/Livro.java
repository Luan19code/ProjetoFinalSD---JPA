/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.sd.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author luanl
 */
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    
    private String isbn;
 
    private String quantidade_paginas;

    @OneToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getQuantidade_paginas() {
        return quantidade_paginas;
    }

    public void setQuantidade_paginas(String quantidade_paginas) {
        this.quantidade_paginas = quantidade_paginas;
    }

    public Autor getAutor() {
        if (autor == null) {
            autor = new Autor();
        }
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", quantidade_paginas=" + quantidade_paginas + ", autor=" + autor + '}';
    }
    
    

}
