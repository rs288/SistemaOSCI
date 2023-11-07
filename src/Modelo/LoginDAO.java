/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan
 */
public class LoginDAO {
    private Conexion cn= new Conexion();
    private login l;
    ResultSet rs;
    private Connection con;
    
    public login insertar(String usuario, String contraseña){
        l = new login();
        PreparedStatement ps;
        String sql;
        try{
            con = cn.getConnection();
            sql = "SELECT * FROM login WHERE usuario = ? AND contraseña = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));
                l.setContraseña(rs.getString("contraseña"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        return l;
    }
    
}
