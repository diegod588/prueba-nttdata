package com.clientes.prueba.dao;

import com.clientes.prueba.entity.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface IClientesDao extends CrudRepository<Clientes,Long> {

    @Transactional(readOnly = true)
    public Clientes findByNumeroDocumentoAndTipoDocumento(String numeroDocumento,String tipoDocumento);
}
