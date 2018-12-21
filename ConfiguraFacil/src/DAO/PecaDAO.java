/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Peca;
import Classes.Cor;
import Classes.Estofos;
import Classes.Motor;
import Classes.Jantes;
import Classes.Extras;
import Exceptions.PecaJaExisteException;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class PecaDAO implements Map<String, Peca>{
    
    private Connection conn;
    
    public PecaDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
    
    @Override
    public Set<Map.Entry<String,Peca>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Peca>> entrySet() not implemented!");
    }

    @Override
    public Collection<Peca> values(){
        Collection<Peca> pecas = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Peca peca = this.get(str);
            pecas.add(peca);
        }
        return pecas;
    }
    
    @Override
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select Nome From Peca";
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
            stm.executeUpdate("DELETE FROM Peca");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public void putAll(Map<? extends String,? extends Peca> p) {
        throw new NullPointerException("Not implemented!");
    }
    @Override
    public Peca remove(Object key) {
        try {
            String chave = (String)key;
            Peca peca = this.get(chave);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Peca Where Nome='"+chave+"'";
            int i = stm.executeUpdate(sql);
            String str = "Delete From Peca_Peca Where idPeca1='"+chave+"' OR idPeca2='"+chave+"'";
            int j = stm.executeUpdate(str);
            return peca;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Peca put(String key, Peca value) {
        try {
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Peca Where Nome='"+key+"'";
            int i = stm.executeUpdate(sql);
            String str = "Delete From Peca_Peca Where idPeca1='"+key+"'";
            int j = stm.executeUpdate(str);
            Peca peca = this.putPeca(key, value);
            this.putPeca_Peca(value);
            return peca;
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
    
    public void putPeca_Peca(Peca value){
        try {
            String id1 = value.getNome();
            Statement stm = conn.createStatement();
            for(String str: value.getIncompativeis()){
                String sql = "Insert Into Peca_Peca Values (0, '"+ id1 + "','" + str + "'";
                int i = stm.executeUpdate(sql);
            }
            for(String s: value.getObrigatorias()){
                String sql = "Insert Into Peca_Peca Values (1, '"+ id1 + "','" + s + "'";
                int i = stm.executeUpdate(sql);
            }
        } catch (SQLException ex) {}
    }
    
    public Peca putPeca(String key, Peca value){
        try {
            Peca p;
            int tipo;
            Statement stm = conn.createStatement();
            if(value instanceof Motor){tipo = 1; p = new Motor(value);}
            else if(value instanceof Cor){tipo = 2; p = new Cor(value);}
            else if(value instanceof Jantes){tipo = 3; p = new Jantes(value);}
            else if(value instanceof Estofos){tipo = 4; p = new Estofos(value);}
            else{tipo = 5; p = new Extras(value);}
            String sql = "INSERT INTO Peca VALUES ('"+key+"',"+value.getQuantidade()+",";
            sql += +tipo+","+value.getPreco()+")";
            int i  = stm.executeUpdate(sql);
            return p;
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
    
    @Override
    public Peca get(Object key) {
        try {
            Peca p = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Peca WHERE Nome='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                int tipo = rs.getInt("Tipo");
                switch(tipo){
                    case 1: p = new Motor();
                    break;
                    case 2: p = new Cor();
                    break;
                    case 3: p = new Jantes();
                    break;
                    case 4: p = new Estofos();
                    break;
                    case 5: p = new Extras();
                }
                p.setNome(rs.getString("Nome"));
                p.setQuantidade(rs.getInt("Quantidade"));
                p.setPreco(rs.getFloat("Custo"));
            }
            String str = "Select * From Peca Where idPeca1='"+(String)key+"'";
            ResultSet res = stm.executeQuery(str);
            while(rs.next()){
                String idPeca = res.getString("idPeca2");
                int type = res.getInt("Tipo");
                if(type == 1){
                    p.addObrigatoria(idPeca);
                }
                if(type == 0){
                    p.addProibida(idPeca);
                }
            }
            return p;
        }
        catch (NumberFormatException | SQLException | PecaJaExisteException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Peca WHERE id='"+(String)key+"'";
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
            String sql = "SELECT id FROM Peca";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Peca");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void insereProibidas(Peca p){
        try{
            String nome = p.getNome();
            Statement st = conn.createStatement();
            String sql = "Select idPeca1 From Peca_Peca Where idPeca1 = '" + nome + "' AND Tipo = 0";
            ResultSet res = st.executeQuery(sql);
            List<String> pecas = new ArrayList<>();
            while(res.next()){
                String id2 = res.getString("idPeca2");
                pecas.add(id2);
            }
            p.setIncompativeis(pecas);
        } catch (SQLException ex) {}
    }
    
    public void insereObrigatorias(Peca p){
        
        try{
            String nome = p.getNome();
            Statement st = conn.createStatement();
            String sql = "Select idPeca2 From Peca_Peca Where idPeca1 = '" + nome + "' AND Tipo = 1";
            ResultSet res = st.executeQuery(sql);
            List<String> pecas = new ArrayList<>();
            while(res.next()){
                String id2 = res.getString("idPeca2");
                pecas.add(id2);
            }
            p.setIncompativeis(pecas);
        } catch (SQLException ex) {}
    }
}
