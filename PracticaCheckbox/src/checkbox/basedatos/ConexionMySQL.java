/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox.basedatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillem
 */
public final class ConexionMySQL {

    public String bd = "usuaris";
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + bd;
    private final Connection conectar;

    public ConexionMySQL() {
        conectar = conectar();
    }

    private Connection conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.login, this.password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }

    public ResultSet consultar(String vSQL) {
        Connection cn = conectar;

        //vSQL = "SELECT nif, nom,llinatge1,llinatge2 from usuaris";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(vSQL);

            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    
    public void actualizar(String sql) {
        try {
            Statement createStatement = conectar.createStatement();
            createStatement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
