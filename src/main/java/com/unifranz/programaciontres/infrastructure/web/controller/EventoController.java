package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController {
    @Autowired
    private EventoService eventoService;
}