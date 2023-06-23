package br.com.unipar.hibernateteste.model.dao;

import br.com.unipar.hibernateteste.model.usuario.Pet;

public class PetDAO extends GenericDAO<Pet> {

    public PetDAO() {
        super(Pet.class);
    }
}
