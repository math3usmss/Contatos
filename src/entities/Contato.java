package entities;

import java.util.Objects;

public class Contato {

    private String nome;
    private String telefone;
    private String email;

    public Contato(){}

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return getNome() + "-" + getTelefone() + "-" + getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contato contato)) return false;
        return Objects.equals(nome, contato.nome) && Objects.equals(email, contato.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email);
    }
}
