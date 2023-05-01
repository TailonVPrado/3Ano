package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Servico;
import br.unipar.pet.dogui.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ServicoRepository {

    private static final String INSERT
            = "INSERT INTO servico (descricao, valor, status) VALUES(?, ?, ?);";
    private static final String UPDATE
            = "UPDATE servico SET descricao= ?, valor=?, status= ? " +
              "WHERE id= ? ;";
    private static final String DELETE
            = "UPDATE servico SET status= false WHERE id= ? ;";
    private static final String FIND_BY_ID
            = "SELECT id, descricao, valor, status FROM servico where id = ?;";
    private static final String FIND_ALL
            = "SELECT id, descricao, valor, status FROM servico";

    
    public Servico insert(Servico servico) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, servico.getDescricao());
            ps.setDouble(2, servico.getValor());
            ps.setBoolean(3, servico.isStatus());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            servico.setId(rs.getInt("id"));

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return servico;
        
    }
    
    public ArrayList<Servico> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Servico> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Servico servico = new Servico();
                servico.setDescricao(rs.getString("descricao"));
                servico.setId(rs.getInt("id"));
                servico.setValor(rs.getDouble("valor"));
                servico.setStatus(rs.getBoolean("status"));
                
                listaResultado.add(servico);
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
    
    public ArrayList<Servico> findWithParameters(String descricao) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Servico> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL + 
                    " where descricao like '%"+descricao+"%'");
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Servico servico = new Servico();
                servico.setDescricao(rs.getString("descricao"));
                servico.setId(rs.getInt("id"));
                servico.setValor(rs.getDouble("valor"));
                servico.setStatus(rs.getBoolean("status"));
                
                listaResultado.add(servico);
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
    
    public Servico update(Servico servico) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, servico.getDescricao());
            ps.setDouble(2, servico.getValor());
            ps.setBoolean(3, servico.isStatus());
            ps.setInt(4, servico.getId());
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return servico;
        
    }
    
    public Servico findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Servico resultado = new Servico();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                resultado.setDescricao(rs.getString("descricao"));
                resultado.setId(rs.getInt("id"));
                resultado.setStatus(rs.getBoolean("status"));
                resultado.setValor(rs.getDouble("valor"));
                
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
