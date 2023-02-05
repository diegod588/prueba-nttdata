package com.clientes.prueba.services;

import com.clientes.prueba.dao.IClientesDao;
import com.clientes.prueba.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IClienteServiceImpl implements IClienteServices {

    @Autowired
    private IClientesDao clientesDao;

    @Override
    public Clientes findByNumeroDocumentoAndTipoDocumento(String numeroDocumento, String tipoDocumento) {
        return clientesDao.findByNumeroDocumentoAndTipoDocumento(numeroDocumento,tipoDocumento);
    }



}
