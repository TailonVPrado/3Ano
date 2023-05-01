package br.com.unipar.hibernateteste.model.dao;

import br.com.unipar.hibernateteste.model.usuario.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{
      
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
}
