package com.clientes.prueba.services;

import com.clientes.prueba.entity.Clientes;

public interface IClienteServices {
    public Clientes findByNumeroDocumentoAndTipoDocumento(String numeroDocumento,String tipoDocumento);
}
