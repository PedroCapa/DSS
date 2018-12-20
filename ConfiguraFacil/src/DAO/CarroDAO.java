/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Carro;
import Classes.Peca;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.*;

/**
 *
 * @author Luis
 */
public class CarroDAO implements Map<String, Carro>{
    
    private Connection conn;
    
    public CarroDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
    @Override
    public Set<Map.Entry<String,Carro>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Carro>> entrySet() not implemented!");
    }
    
    @Override
    public Collection<Carro> values(){
        try{
            Statement st = this.conn.createStatement();
            String str = "Select * From Carro";
            ResultSet res = st.executeQuery(str);
            Map<String, Carro> carros = new HashMap<>();
            while(res.next()){
                String id = res.getString("id");
                int estado = Integer.parseInt(res.getString("Estado"));
                float custo = Float.valueOf(res.getString("Custo"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                String date = res.getString("Data");
                LocalDate data = LocalDate.parse(date, formatter);
                List<Peca> pecas = new ArrayList<>();
                List<Peca> pecasFalta = new ArrayList<>();
                // Fazer retrieve do modelo
                //Carro car = new Carro(id, estado, pecas, pecasFalta, custo, data);
                //carros.put(id, car);
            }
            String sql = "Select * From Peca_Carro";
            ResultSet rs = st.executeQuery(sql);
            /*
            Fazer retrieve da peça
            */
            return carros.values();
        }
        catch(NumberFormatException | SQLException exc){
            throw new NullPointerException(exc.getMessage());
        }
    }
    
    @Override
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select id From Carro";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("id"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Carro");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public void putAll(Map<? extends String,? extends Carro> t) {
        throw new NullPointerException("Not implemented!");
    }
    
    @Override
    public Carro remove(Object key) {
        try {
            String chave = (String)key;
            Carro car = this.get(chave);
            Statement stm = conn.createStatement();
            String sql = "DELETE '"+chave+"' FROM Carros";
            int i  = stm.executeUpdate(sql);
            return car;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    // Verificar primeiro statement qual o nome da chave primaria
    @Override
    public Carro put(String key, Carro value) {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Carro WHERE id='"+key+"'");
            // apagar carros de tabelas intermedias
            String sql = "INSERT INTO Carro VALUES ('"+key+"','"+value.getEstado()+"',";
            sql += value.getCusto()+", '"+value.getData().format(DateTimeFormatter.ofPattern("yyyy/MM/d"))+"')";
            int i  = stm.executeUpdate(sql);
            return new Carro(value);
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Carro get(Object key) {
        try {
            Carro car = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Carro WHERE id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                car = new Carro();
                car.setId(rs.getString("id"));
                car.setEstado(Integer.parseInt(rs.getString("Estado")));
                car.setCusto(Float.valueOf("Custo"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                String date = rs.getString("Data");
                LocalDate data = LocalDate.parse(date, formatter);
                car.setData(data);
            }
            //Inserir id das pecas atraves da tabela intermedia
            return car;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Carro WHERE id='"+(String)key+"'";
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
            String sql = "SELECT id FROM Carro";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Carro");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
}
