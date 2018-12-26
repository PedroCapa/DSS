/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Carro;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Collection<Carro> carros = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Carro car = this.get(str);
            carros.add(car);
        }
        return carros;
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
            stm.executeUpdate("Delete From Peca_Carro");
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
            String s = "Delete From Peca_Carro Where Carro_id='"+chave+"'";
            Statement st = this.conn.createStatement();
            int j = st.executeUpdate(s);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Carro Where id='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            return car;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Carro put(String key, Carro value) {
        try {
            String data = value.getData().toString();
            Date date = java.sql.Date.valueOf(data);
            String m = value.getModelo().getNome();
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Carro (id, Estado, Preco, Data, Modelo_Nome, Utilizador_Email) VALUES ";
            sql += "('"+key+"',"+value.getEstado()+",";
            sql += value.getCusto()+", '"+date+"', '"+m+"','"+value.getCliente()+"')";
            int i  = stm.executeUpdate(sql);
            this.putPecaCarro(key, value.getPecas(), value.getFalta());
            return new Carro(value);
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void putPecaCarro(String key, List<String> p, List<String> f){
        try {
            Statement stm = conn.createStatement();
            for(String str: p){
                String sql = "INSERT INTO Peca_Carro VALUES ('"+key+"', 1, '"+str+"')";
                int i = stm.executeUpdate(sql);
            }
            for(String s: f){
                String sql = "INSERT INTO Peca_Carro VALUES ('"+key+"', 0, '"+s+"')";
                int i = stm.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                car.setEstado(rs.getInt("Estado"));
                car.setCusto(rs.getFloat("Preco"));
                String modeloNome = rs.getString("Modelo_Nome");
                String clienteEmail = rs.getString("Utilizador_Email");
                Object o = rs.getObject("Data");
                String s = o.toString();
                LocalDate data = LocalDate.parse(s);
                car.setData(data);
                car.setCliente(clienteEmail);
                this.getPecaCarro((String)key, car);
                ModeloDAO m = new ModeloDAO();
                m.getModeloCarro((String)key, car, modeloNome);
            }
            return car;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void getPecaCarro(String key, Carro value){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Peca_Carro WHERE Carro_id='"+key+"'";
            ResultSet rs = stm.executeQuery(sql);
            List<String> pecas = new ArrayList<>();
            List<String> falta = new ArrayList<>();
            while(rs.next()){
                if(rs.getBoolean("Colocada")){pecas.add(rs.getString("Peca_Nome"));}
                else {falta.add(rs.getString("Peca_Nome"));}
            }
            value.setFalta(falta);
            value.setPecas(pecas);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
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
    
    public void update(Carro car){
        try {
            String id = car.getId();
            int estado = car.getEstado();
            String sql = "Update Carro Set Estado="+estado+" Where id='"+id+"'";
            Statement stm = conn.createStatement();
            int i = stm.executeUpdate(sql);
            for(String str: car.getPecas()){
                String s = "Update Peca_Carro Set Colocada=1 Where Carro_id='"+id+"' AND Peca_Nome='"+str+"'";
                int j = stm.executeUpdate(s);
            }
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
    
    public void updateAll(List<Carro> carros){
        for(Carro c: carros){
            this.update(c);
        }
    }
    
    public List<Carro> getCarrosEspera(){
        try {
            Statement stm = conn.createStatement();
            String sql = "Select * From Carro Where Estado = 0";
            ResultSet res = stm.executeQuery(sql);
            List<Carro> carros = new ArrayList<>();
            while(res.next()){
                String id = res.getString("Id");
                Carro car = get(id);
                carros.add(car);
            }
            return carros;
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
    
        public List<Carro> getCarrosProducao(){
        try {
            Statement stm = conn.createStatement();
            String sql = "Select * From Carro Where Estado = 1";
            ResultSet res = stm.executeQuery(sql);
            List<Carro> carros = new ArrayList<>();
            while(res.next()){
                String id = res.getString("Id");
                Carro car = get(id);
                carros.add(car);
            }
            return carros;
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
}
