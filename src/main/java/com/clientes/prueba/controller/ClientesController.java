package com.clientes.prueba.controller;

import com.clientes.prueba.entity.Clientes;
import com.clientes.prueba.services.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClientesController {

    @Autowired
    private IClienteServices services;

    @GetMapping(path ="/consultar-cliente", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> consultarCliente(
                @RequestParam(required = true, name = "numeroDocumento") String numeroDocumento,
                @RequestParam(required = true, name = "tipoDocumento") String tipoDocumento) {

        Clientes cliente = null;
        Map<String, Object> response = new HashMap<>();
        try{
            cliente= services.findByNumeroDocumentoAndTipoDocumento(numeroDocumento,tipoDocumento);
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cliente == null) {
            response.put("mensaje", "El cliente con número documento: ".concat(numeroDocumento.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Clientes>(cliente, HttpStatus.OK);
    }
}
