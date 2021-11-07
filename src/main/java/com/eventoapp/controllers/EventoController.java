/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eventoapp.controllers;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.repository.EventoRepository;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author robson-pc
 */
@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form() {
        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento, RedirectAttributes atributes) {
        if (evento.campoVazio()) {
            atributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        }
        er.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping(value = "/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();

        mv.addObject("eventos", eventos);

        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String convidado(@Validated Convidado convidado, @PathVariable("codigo") long codigo, RedirectAttributes atributes) {
        try {
            if (convidado.campoVazio() || evento.campoVazio()) {
                atributes.addFlashAttribute("mensagem", "Verifique os campos!");
                return "redirect:/{codigo}";
            }
            Evento evento = er.findByCodigo(codigo);
            convidado.setEvento(evento);
            cr.save(convidado);
            atributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
        } catch (SQLGrammarException e) {
            e.getMessage();
            e.getStackTrace();
        }
        return "redirect:/{codigo}";
    }

}
