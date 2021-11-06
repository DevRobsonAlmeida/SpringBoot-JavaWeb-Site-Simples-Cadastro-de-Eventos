/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eventoapp.repository;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author robson-pc
 */
public interface ConvidadoRepository extends CrudRepository<Convidado, Object>{
    Convidado findById(long id);
    
    Iterable<Convidado> findByEvento(Evento evento);
}
