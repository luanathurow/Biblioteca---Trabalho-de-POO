public class Cliente {
    private String nome;
    private String matricula;
    private String telefone;

    public Cliente(String nome, String matricula, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
