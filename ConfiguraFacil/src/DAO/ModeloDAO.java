/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Modelo;
import Classes.Pacote;
import Classes.Carro;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.sql.*;
/**
 *
 * @author Luis
 */
public class ModeloDAO implements Map<String, Modelo>{
        
    private Connection conn;
    
    public ModeloDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
    
    @Override
    public Set<Map.Entry<String,Modelo>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Modelo>> entrySet() not implemented!");
    }
    
    @Override
    public Collection<Modelo> values(){
        Collection<Modelo> modelos = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Modelo m = this.get(str);
            modelos.add(m);
        }
        return modelos;
    }
    
    @Override
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select Nome From Modelo";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("Nome"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Modelo");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public void putAll(Map<? extends String,? extends Modelo> p) {
        throw new NullPointerException("Not implemented!");
    }
    
    @Override
    public Modelo remove(Object key) {
        try {
            String chave = (String)key;
            Modelo m = this.get(chave);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Modelo Where Nome='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            String s = "Delete From Pacote_Modelo Where Modelo_Nome='"+chave+"'";
            int j = stm.executeUpdate(s);
            return m;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Modelo put(String key, Modelo value) {
        Modelo m = new Modelo(value);
        this.remove(key);
        this.putModelo(key, value);
        this.putPacoteModelo(key, value);
        return m;
    }
    
    public void putModelo(String key, Modelo value){
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Modelo VALUES ('"+key+"',"+value.getCustoBase()+")";
            int i  = stm.executeUpdate(sql);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        
    public void putPacoteModelo(String key, Modelo value){
        try {
            Statement stm = conn.createStatement();
            for(Pacote p: value.getPacotes()){
                String str = p.getNome();
                String s = "Insert Pacote_Modelo Values ('"+key+"','"+str+"')";
                stm.executeUpdate(s);
            }
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
    
    @Override
    public Modelo get(Object key) {
        try {
            Modelo m = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Modelo WHERE Nome='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                m = new Modelo();
                m.setNome((String)key);
                m.setCustoBase(rs.getFloat("CustoBase"));
                PacoteDAO p = new PacoteDAO();
                p.getPacoteModelo(m);
            }
            return m;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Modelo WHERE Nome='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }
    
    @Override
    public boolean isEmpty(){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT Nome FROM Modelo";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Nome FROM Pacote");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void getModeloCarro(String key, Carro car, String nome){
        Modelo m = this.get(nome);
        car.setModelo(m);
    }
}
