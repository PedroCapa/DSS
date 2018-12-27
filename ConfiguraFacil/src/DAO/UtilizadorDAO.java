/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Utilizador;
import Classes.Funcionario;
import Classes.Cliente;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.sql.*;


public class UtilizadorDAO implements Map<String, Utilizador>{
    
    private Connection conn;
    
        /**
     * Método DAO que permite aceder à informação relacionada com os utilizadores na base de dados
     * 
     * @author Eu
     */
    public UtilizadorDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
        /**
     * Método que cria um set de utilizadores
     * 
     * @author Eu
     */
    @Override
    public Set<Map.Entry<String,Utilizador>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Utilizador>> entrySet() not implemented!");
    }
        /**
     * Método que cria uma coleção de utilizadores
     * 
     * @return coleção criada
     * 
     * @author Eu
     */
    @Override
    public Collection<Utilizador> values(){
        Collection<Utilizador> utilizadores = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Utilizador u = this.get(str);
            utilizadores.add(u);
        }
        return utilizadores;
    }
        /**
     * Método que cria um set com os ids dos utilizadores
     * 
     * @return set dos ids
     * 
     * @author Eu
     */
    @Override
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select Email From Utilizador";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("Email"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que apaga caraterísticas de utilizadores
     * 
     * @author Eu
     */
    @Override
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("Delete From Peca_Carro");
            stm.executeUpdate("Delete From Carro");
            stm.executeUpdate("DELETE FROM Utilizador");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método não implementado
     * 
     * @author Eu
     */
    @Override
    public void putAll(Map<? extends String,? extends Utilizador> p) {
        throw new NullPointerException("Not implemented!");
    }
        /**
     * Método que insere caraterísticas num utilizador
     * 
     * @param key chave que dá acesso ao utilizador
     * 
     * @param value utilizador cujas caraterísticas serão alteradas
     * 
     * @return utilizador com novas caraterísticas
     * 
     * @author Eu
     */
    @Override
    public Utilizador remove(Object key) {
        try {
            String chave = (String)key;
            Utilizador u = this.get(chave);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Utilizador Where Email='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            return u;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que insere caraterísticas num utilizador
     * 
     * @param key chave que dá acesso ao utilizador
     * 
     * @param value utilizador cujas caraterísticas serão alteradas
     * 
     * @return utilizador com novas caraterísticas
     * 
     * @author Eu
     */
    @Override
    public Utilizador put(String key, Utilizador value) {
        try {
            int tipo;
            Utilizador u;
            if(value instanceof Funcionario){
                tipo = 0;
                Funcionario user = (Funcionario)value;
                u = new Funcionario(user);
            }
            else{
                tipo = 1;
                Cliente user = (Cliente)value;
                u = new Cliente(user);
            }
            String sql = "INSERT INTO Utilizador VALUES ('"+value.getPassword()+"','"+key+"',";
            sql += +tipo+",'"+value.getNome()+"')";
            Statement st = this.conn.createStatement();
            int i  = st.executeUpdate(sql);
            return u;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que permite obter as caraterísticas do utilizador
     * 
     * @param key chave que dá acesso ao utilizador
     * 
     * @author Eu
     */
    @Override
    public Utilizador get(Object key) {
        try {
            Utilizador u = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Utilizador WHERE Email='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                int tipo = rs.getInt("Tipo");
                switch(tipo){
                    case 0: u = new Funcionario();
                    break;
                    case 1: u = new Cliente();
                }
                u.setNome(rs.getString("Nome"));
                u.setEmail((String)key);
                u.setPassword(rs.getString("Password"));
            }
            String str = "Select id From Carro Where Utilizador_Email='"+(String)key+"'";
            Statement st = this.conn.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                String idCarro = res.getString("id");
                Cliente c = (Cliente)u;
                c.addCarro(idCarro);
            }
            return u;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que verifica se a chave está correta
     * 
     * @param key chave a ser verificada
     * 
     * @return boolean que diz se a chave está correta ou não
     * 
     * @author Eu
     */
    @Override
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Utilizador WHERE Email='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que verifica se um dado objeto existe
     * 
     * @param value objeto a ser verificado
     * 
     * @author Eu
     */
    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }
        /**
     * Método que verifica se uma string está vazia
     * 
     * @return boolean que diz se a string está vazia ou não
     * 
     * @author Eu
     */
    @Override
    public boolean isEmpty(){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT Email FROM Utilizador";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que verifica o tamanho de uma statement
     * 
     * @return tamanho da statement
     * 
     * @author Eu
     */
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Email FROM Utilizador");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    /*
    Talvez n seja necessario este metodo
    */
    public void setCarroUser(String key, Cliente c){
        try {
            String email = c.getEmail();
            Statement stm = conn.createStatement();
            int i = stm.executeUpdate("Update Carro Set Utilizador_Email='"+key+"' Where id='"+email+"'");
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que verifica se um dado cliente existe
     * 
     * @param key chave do cliente a ser verificado
     * 
     * @return boolean que diz se o cliente existe ou não
     * 
     * @author Eu
     */
    public boolean containsCliente(String key) {
       try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Utilizador WHERE Email='"+(String)key+"' And Tipo=1";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
}
