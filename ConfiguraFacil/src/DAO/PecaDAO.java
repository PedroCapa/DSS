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
            stm.executeUpdate("Delete From Peca_Peca");
            stm.executeUpdate("Delete From Peca_Carro");
            stm.executeUpdate("Delete From Peca_Pacote");
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
            String s1 = "Delete From Peca_Peca Where idPeca1='"+chave+"' OR idPeca2='"+chave+"'";
            int j = stm.executeUpdate(s1);
            String s2 = "DELETE FROM Peca_Carro Where Peca_Nome='"+chave+"'";
            int k = stm.executeUpdate(s2);
            String s3 = "DELETE FROM Peca_Pacote Where Peca_Nome='"+chave+"'";
            int l = stm.executeUpdate(s3);
            String s4 = "DELETE FROM Peca Where Nome='"+chave+"'";
            int i = stm.executeUpdate(s4);
            return peca;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Peca put(String key, Peca value) {
        Peca peca = this.putPeca(key, value);
        this.putPeca_Peca(value);
        return peca;
    }
    
    public void putPeca_Peca(Peca value){
        try {
            String id1 = value.getNome();
            Statement stm = conn.createStatement();
            for(String str: value.getIncompativeis()){
                String sql = "Insert Into Peca_Peca Values (0, '"+ id1 + "','" + str + "')";
                int i = stm.executeUpdate(sql);
            }
            for(String s: value.getObrigatorias()){
                String sql = "Insert Into Peca_Peca Values (1, '"+ id1 + "','" + s + "')";
                int i = stm.executeUpdate(sql);
            }
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
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
            String sql = "INSERT INTO Peca VALUES ("+value.getQuantidade()+",'"+key+"',";
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
            String str = "Select * From Peca_Peca Where idPeca1='"+(String)key+"' OR idPeca2='"+(String)key+"'";
            Statement st = this.conn.createStatement();
            ResultSet res = st.executeQuery(str);
            List<String> obrig = new ArrayList<>();
            List<String> proib = new ArrayList<>();
            while(res.next()){
                String idPeca2 = res.getString("idPeca2");
                String idPeca1 = res.getString("idPeca1");
                boolean type = res.getBoolean("Tipo");
                if(type == true && idPeca1.equals((String)key)){obrig.add(idPeca2);}
                else if(type == true && idPeca2.equals((String)key)){obrig.add(idPeca1);}
                else if(type == false && idPeca1.equals((String)key)){proib.add(idPeca2);}
                else {proib.add(idPeca1);}
            }
            if(p!=null){
                p.setObrigatorias(obrig);
                p.setIncompativeis(proib);
            }
            return p;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Peca WHERE Nome='"+(String)key+"'";
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
            String sql = "SELECT Nome FROM Peca";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
    
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Nome FROM Peca");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void update(Peca p){
        try {
            String s = p.getNome();
            int quantidade = p.getQuantidade();
            String sql = "Update Peca Set Quantidade="+quantidade+" Where Nome='"+s+"'";
            Statement stm = conn.createStatement();
            int i = stm.executeUpdate(sql);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
}
