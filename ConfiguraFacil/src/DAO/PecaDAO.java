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
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

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
        try{
            Statement st = this.conn.createStatement();
            String str = "Select * From Peca";
            ResultSet res = st.executeQuery(str);
            Map<String, Peca> pecas = new HashMap<>();
            while(res.next()){
                String id = res.getString("id");
                String nome = res.getString("nome");
                int quantidade = res.getInt("Quantidade");
                float custo = res.getFloat("Custo");
                int tipo = res.getInt("Tipo");
                List<String> obrigatorias = new ArrayList<>();
                List<String> proibidas = new ArrayList<>();
                Peca p = null;
                switch(tipo){
                    case 1: p = new Motor(quantidade, nome, custo, obrigatorias, proibidas);
                    break;
                    case 2: p = new Cor(quantidade, nome, custo, obrigatorias, proibidas);
                    break;
                    case 3: p = new Jantes(quantidade, nome, custo, obrigatorias, proibidas);
                    break;
                    case 4: p = new Estofos(quantidade, nome, custo, obrigatorias, proibidas);
                    break;
                    case 5: p = new Extras(quantidade, nome, custo, obrigatorias, proibidas);
                }
                pecas.put(id, p);
                //carros.put(id, car);
            }
            String sql = "Select * From Peca_Peca";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String peca1 = rs.getString("idPeca1");
                String peca2 = rs.getString("idPeca2");
                int tipo = rs.getInt("Tipo");
                Peca peca = pecas.get(peca1);
                if(tipo == 1){
                    //peca.addObrigatorio(peca2);
                }
                else{
                    //peca.addProibido(peca2);
                }
            }
            return pecas.values();
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
            String str = "Select id From Peca";
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
            String sql = "DELETE '"+chave+"' FROM Carros";
            int i  = stm.executeUpdate(sql);
            return peca;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Peca put(String key, Peca value) {
        try {
            int tipo;
            Peca peca;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Peca WHERE id='"+key+"'");
            if(value instanceof Motor){
                tipo = 1;
                peca = new Motor(value);
            }
            else if(value instanceof Cor){
                tipo = 2;
                peca = new Cor(value);
            }
            else if(value instanceof Jantes){
                tipo = 3;
                peca = new Jantes(value);
            }
            else if(value instanceof Estofos){
                tipo = 4;
                peca = new Estofos(value);
            }
            else{
                tipo = 5;
                peca = new Extras(value);
            }
            // apagar carros de tabelas intermedias
            String sql = "INSERT INTO Peca VALUES ('"+key+"',"+value.getQuantidade()+",";
            sql += +tipo+","+value.getPreco()+")";
            int i  = stm.executeUpdate(sql);
            return peca;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Peca get(Object key) {
        try {
            Peca p = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Peca WHERE id='"+(String)key+"'";
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
                    //p.addObrigatorio();
                }
                if(type == 2){
                    //p.addProibida();
                }
            }
            return p;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
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
}
