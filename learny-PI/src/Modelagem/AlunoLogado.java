
package Modelagem;

public class AlunoLogado {
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String dataNasc;

    public AlunoLogado() {
        this("","","","","");
    }

    public AlunoLogado(String nome,String usuario, String senha, String email, String dataNasc) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.dataNasc = dataNasc;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
