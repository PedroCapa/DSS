/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

public class Utilizador {
    private String nome;
    private String email;
    private String password;

    public Utilizador(String nome, String password, String email) {
        this.nome = nome;
        this.password = password;
        this.email = email;
    }
    
    public Utilizador(){
        this.nome = "";
        this.password = "";
        this.email = "";
    }
    
    public Utilizador(Utilizador umUtilizador){
        this.nome = umUtilizador.getNome();
        this.password = umUtilizador.getPassword();
        this.email = umUtilizador.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public Utilizador clone(){
        return new Utilizador(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Utilizador other = (Utilizador) obj;
        return (this.nome.equals(other.getNome()) && this.password.equals(other.getPassword()) 
                && this.email.equals(other.getEmail()));
    }
    
    public boolean validaCredenciais(String email){
        boolean b;
        b = email.equals(this.password);
        return b;
    }
}