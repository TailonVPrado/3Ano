package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Endereco;
import br.unipar.pet.dogui.service.PessoaService;
import br.unipar.pet.dogui.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoRepository {

    private static final String INSERT
            = "INSERT INTO endereco (nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa) VALUES(?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE
            = "UPDATE endereco SET nome_rua = ?, complemento=?, bairro= ?, numero_casa=?, numero_cep=?, st_ativo=?, id_pessoa=? WHERE id= ? ;";
    private static final String DELETE
            = "UPDATE endereco SET st_ativo = false WHERE id= ? ;";
    private static final String FIND_BY_ID
            = "SELECT id, nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa FROM endereco where id = ?;";
    private static final String FIND_ALL
            = "SELECT id, nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa FROM endereco";
    
    public Endereco insert(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            //"INSERT INTO endereco (nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa) VALUES(?, ?, ?, ?, ?, ?, ?);"
            ps.setString(1, endereco.getNomeRua());
            ps.setString(2, endereco.getComplemento());
            ps.setString(3, endereco.getDsBairro());
            ps.setInt(4, endereco.getNrCasa());
            ps.setString(5, endereco.getNrCep());
            ps.setBoolean(6, endereco.isStAtivo());
            ps.setInt(7, endereco.getPessoa().getId());
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            
            endereco.setId(rs.getInt("id"));

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return endereco;
        
    }
    
    public ArrayList<Endereco> findAll() throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Endereco> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            //id, nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa
            while(rs.next()){
                
                Endereco endereco = new Endereco();
                PessoaService pessoaService = new PessoaService();
                
                endereco.setId(rs.getInt("id"));
                endereco.setNomeRua(rs.getString("nome_rua"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setDsBairro(rs.getString("bairro"));
                endereco.setNrCasa(rs.getInt("numero_casa"));
                endereco.setNrCep(rs.getString("numero_cep"));
                endereco.setStAtivo(rs.getBoolean("st_ativo"));
                endereco.setPessoa(pessoaService.findById(rs.getInt("id_pessoa")));
                
                listaResultado.add(endereco);
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
    
    public ArrayList<Endereco> findWithParameters(int idPessoa) throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Endereco> listaResultado = new ArrayList<>();
        
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL + " where id_pessoa = " + idPessoa);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
               
                Endereco endereco = new Endereco();
                PessoaService pessoaService = new PessoaService();
                
                endereco.setId(rs.getInt("id"));
                endereco.setNomeRua(rs.getString("nome_rua"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setDsBairro(rs.getString("bairro"));
                endereco.setNrCasa(rs.getInt("numero_casa"));
                endereco.setNrCep(rs.getString("numero_cep"));
                endereco.setStAtivo(rs.getBoolean("st_ativo"));
                endereco.setPessoa(pessoaService.findById(rs.getInt("id_pessoa")));
                
                listaResultado.add(endereco);
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
    
    public Endereco update(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();
            //UPDATE endereco SET nome_rua = 1, complemento=2, bairro= 3, numero_casa=4, numero_cep=5, st_ativo=6, id_pessoa=7 WHERE id= 8
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, endereco.getNomeRua());
            ps.setString(2, endereco.getComplemento());
            ps.setString(3, endereco.getDsBairro());
            ps.setInt(4, endereco.getNrCasa());
            ps.setString(5, endereco.getNrCep());
            ps.setBoolean(6, endereco.isStAtivo());
            ps.setInt(7, endereco.getPessoa().getId());
            ps.setInt(8, endereco.getId());
            
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return endereco;
        
    }
    
    public Endereco findById(int id) throws SQLException, Exception {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Endereco resultado = new Endereco();
        
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //"SELECT id, nome_rua, complemento, bairro, numero_casa, numero_cep, st_ativo, id_pessoa FROM endereco where id = ?;"     
                PessoaService pessoaService = new PessoaService();
                
                resultado.setId(rs.getInt("id"));
                resultado.setNomeRua(rs.getString("nome_rua"));
                resultado.setComplemento(rs.getString("complemento"));
                resultado.setDsBairro(rs.getString("bairro"));
                resultado.setNrCasa(rs.getInt("numero_casa"));
                resultado.setNrCep(rs.getString("numero_cep"));
                resultado.setStAtivo(rs.getBoolean("st_ativo"));
                resultado.setPessoa(pessoaService.findById(rs.getInt("id_pessoa")));
                
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
