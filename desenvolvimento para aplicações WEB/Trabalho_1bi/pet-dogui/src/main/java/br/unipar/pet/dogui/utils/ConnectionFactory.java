package br.unipar.pet.dogui.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
    
    public static final String RESOURCE_NAME = "java:/PostgresDS";
    
    public DataSource getDataSource() throws NamingException {
        
        Context c = new InitialContext();
        
        return (DataSource) c.lookup(RESOURCE_NAME);

    }
    
    public Connection getConnection() {
        
        try {
        
            return getDataSource().getConnection();
        
        } catch(SQLException | NamingException ex) {

            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

            return null;

        }

    }
    
}
