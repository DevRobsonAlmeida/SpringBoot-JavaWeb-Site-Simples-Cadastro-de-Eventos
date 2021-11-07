package com.eventoapp.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import net.bytebuddy.implementation.bind.annotation.Empty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author robson-pc
 */
@Entity
public class Convidado implements Serializable{
    
    private static final long serialVerionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rg;
    private String nomeConvidado;

    @ManyToOne
    @JoinColumn(name="id_evento")
    private Evento evento;
    
    public Convidado() {
    }

    public Convidado(String rg, String nomeConvidado) {
        this.rg = rg;
        this.nomeConvidado = nomeConvidado;
    }
    
    public boolean campoVazio(){
        boolean vazio = false;
        if (rg == "" || rg.isEmpty()) {
            vazio = true;
        }
        if (nomeConvidado == "" || nomeConvidado.isEmpty()) {
            vazio = true;
        }
        return vazio;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.rg);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convidado other = (Convidado) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
