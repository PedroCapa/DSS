/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

public class Utilizador {
    private String nome;
    private String password;

    public Utilizador(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }
    
    public Utilizador(){
        this.nome = "";
        this.password = "";
    }
    
    public Utilizador(Utilizador umUtilizador){
        this.nome = umUtilizador.getNome();
        this.password = umUtilizador.getPassword();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Utilizador other = (Utilizador) obj;
        return (this.nome.equals(other.getNome()) && this.password.equals(other.getPassword()));
    }    
}
