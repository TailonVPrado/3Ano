package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Pessoa;
import br.unipar.pet.dogui.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PessoaRepository {
    private static final String INSERT
            = "INSERT INTO pessoa (nome, telefone, email, st_ativo) VALUES(?, ?, ?, ?);";
    private static final String UPDATE
            = "UPDATE pessoa SET nome= ?, telefone=?, email= ?, st_ativo=? WHERE id= ? ;";
    private static final String DELETE
            = "UPDATE pessoa SET st_ativo = false WHERE id= ? ;";
    private static final String FIND_BY_ID
            = "SELECT id, nome, telefone, email, st_ativo FROM pessoa where id = ?;";
    private static final String FIND_ALL
            = "SELECT id, nome, telefone, email, st_ativo FROM pessoa";

    
    public Pessoa insert(Pessoa pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getNrTelefone());
            ps.setString(3, pessoa.getEmail());
            ps.setBoolean(4, pessoa.isAtivo());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            pessoa.setId(rs.getInt("id"));

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pessoa;
        
    }
    
    public ArrayList<Pessoa> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pessoa> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            //id, nome, telefone, email, cep, st_ativo
            while(rs.next()){
                
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNrTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setAtivo(rs.getBoolean("st_ativo"));
                
                listaResultado.add(pessoa);
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
    
    public ArrayList<Pessoa> findWithParameters(String nome) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pessoa> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL + 
                    " where nome like '%"+nome+"%'");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Pessoa pessoa = new Pessoa();
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNrTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setAtivo(rs.getBoolean("st_ativo"));
                
                listaResultado.add(pessoa);
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
            //UPDATE pessoa SET st_status = false WHERE id= ? 
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
    
    public Pessoa update(Pessoa pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();
            //= UPDATE pessoa SET nome= 1, telefone=2, email= 3, cep=4, st_ativo=5 WHERE id= 6
            ps = conn.prepareStatement(UPDATE);
            
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getNrTelefone());
            ps.setString(3, pessoa.getEmail());
            ps.setBoolean(4, pessoa.isAtivo());
            ps.setInt(5, pessoa.getId());
                    
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pessoa;
        
    }
    
    public Pessoa findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa resultado = new Pessoa();
        
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //SELECT id, nome, telefone, email, cep, st_ativo FROM pessoa where id = ?;             
                resultado.setId(rs.getInt("id"));
                resultado.setNome(rs.getString("nome"));
                resultado.setNrTelefone(rs.getString("telefone"));
                resultado.setEmail(rs.getString("email"));
                resultado.setAtivo(rs.getBoolean("st_ativo"));
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
