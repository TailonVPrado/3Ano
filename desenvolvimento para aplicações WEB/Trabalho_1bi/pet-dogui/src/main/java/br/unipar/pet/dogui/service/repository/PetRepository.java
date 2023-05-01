package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Pessoa;
import br.unipar.pet.dogui.model.Pet;
import br.unipar.pet.dogui.model.enums.GeneroEnum;
import br.unipar.pet.dogui.model.enums.PorteEnum;
import br.unipar.pet.dogui.service.PessoaService;
import br.unipar.pet.dogui.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PetRepository {

    private static final String INSERT
            = "INSERT INTO pet (nome, genero, peso, porte, status, id_dono) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String UPDATE
            = "UPDATE pet SET nome = ?, genero=?, peso= ?, porte=?, status=?, id_dono=? WHERE id= ? ;";
    private static final String DELETE
            = "UPDATE pet SET status = false WHERE id= ? ;";
    private static final String FIND_BY_ID
            = "SELECT id, nome, genero, peso, porte, status, id_dono FROM pet where id = ?;";
    private static final String FIND_ALL
            = "SELECT id, nome, genero, peso, porte, status, id_dono FROM pet";
    
    public Pet insert(Pet pet) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            //"INSERT INTO pet (nome 1, genero 2, peso 3, porte 4, status 5, id_dono 6) VALUES(?, ?, ?, ?, ?, ?);";
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getGenero().toString());
            ps.setDouble(3, pet.getPeso());
            ps.setString(4, pet.getPorte().toString());
            ps.setBoolean(5, pet.isStatus());
            ps.setInt(6, pet.getDono().getId());
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            
            pet.setId(rs.getInt("id"));

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pet;
        
    }
    
    public ArrayList<Pet> findAll() throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pet> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            //"SELECT id, nome, genero, peso, porte, status, id_dono FROM pet"
            while(rs.next()){
                
                Pet pet = new Pet();
                PessoaService pessoaService = new PessoaService();
                
                pet.setId(rs.getInt("id"));
                pet.setNome(rs.getString("nome"));
                pet.setPeso(rs.getDouble("peso"));
                pet.setStatus(rs.getBoolean("status"));
                
                pet.setGenero(GeneroEnum.valueOf(rs.getString("genero")));
                pet.setPorte(PorteEnum.valueOf(rs.getString("porte")));
                
                pet.setDono(pessoaService.findById(rs.getInt("id_dono")));
                
                
                listaResultado.add(pet);
            }

        }finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return listaResultado;

    }
    
    public ArrayList<Pet> findWithParameters(int idDono, String nomePet, String nomeDono) throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pet> listaResultado = new ArrayList<>();
        String whereDinamico = " where 1 = 1 ";        
        
        try {
            conn = new ConnectionFactory().getConnection();
            
            if(nomePet != null && !nomePet.isEmpty()){
                whereDinamico = whereDinamico + " and nome like '%"+nomePet+"%'";
            }
            if(nomeDono != null && !nomeDono.isEmpty()){
                whereDinamico = whereDinamico + " and id_dono in ( select id from pessoa where nome like '%"+nomeDono+"%' ) ";
            }
            if(idDono != 0){
                whereDinamico = whereDinamico + " and id_dono = " + idDono;
            }
            
            ps = conn.prepareStatement(FIND_ALL + whereDinamico);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
               
                Pet pet = new Pet();
                PessoaService pessoaService = new PessoaService();
                
                pet.setId(rs.getInt("id"));
                pet.setNome(rs.getString("nome"));
                pet.setPeso(rs.getDouble("peso"));
                pet.setStatus(rs.getBoolean("status"));
                
                pet.setGenero(GeneroEnum.valueOf(rs.getString("genero")));
                pet.setPorte(PorteEnum.valueOf(rs.getString("porte")));
                
                pet.setDono(pessoaService.findById(rs.getInt("id_dono")));
                
                listaResultado.add(pet);
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return listaResultado;

    }
    
    public void delete(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {
 
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

    }
    
    public Pet update(Pet pet) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();
            //"UPDATE pet SET nome = 1, genero=2, peso= 3, porte=4, status=5, id_dono=6 WHERE id= 7 ;
            ps = conn.prepareStatement(UPDATE);
            
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getGenero().toString());
            ps.setDouble(3, pet.getPeso());
            ps.setString(4, pet.getPorte().toString());
            ps.setBoolean(5, pet.isStatus());
            ps.setInt(6, pet.getDono().getId());
            ps.setInt(7, pet.getId());
            
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pet;
        
    }
    
    public Pet findById(int id) throws SQLException, Exception {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet resultado = new Pet();
        
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //"SELECT id, nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa FROM endereco where id = ?;"     
                PessoaService pessoaService = new PessoaService();
                
                resultado.setId(rs.getInt("id"));
                resultado.setNome(rs.getString("nome"));
                resultado.setPeso(rs.getDouble("peso"));
                resultado.setStatus(rs.getBoolean("status"));
                resultado.setGenero(GeneroEnum.valueOf(rs.getString("genero")));
                resultado.setPorte(PorteEnum.valueOf(rs.getString("porte")));
                
                resultado.setDono(pessoaService.findById(rs.getInt("id_dono")));   
                
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return resultado;

    }
}
