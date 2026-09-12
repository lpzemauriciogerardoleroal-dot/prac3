package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.service.EventoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventoServiceImpl implements EventoService {

    @Override
    public Map<String, Object> validarAcceso(int edad, boolean pago) {
        Map<String, Object> respuesta = new HashMap<>();

        if (edad >= 18 && pago) {
            respuesta.put("mensaje", "Acceso permitido");
            respuesta.put("estado", true);
        } else {
            respuesta.put("mensaje", "Acceso denegado");
            respuesta.put("estado", false);
        }

        return respuesta;
    }
}