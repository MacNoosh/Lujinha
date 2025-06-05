package Lujinha.model;

public class Cliente {
    private String nome;
    private String sexo;
    private String cpf;
    private boolean varejo;
    private boolean atacado;
    private boolean bloqueiaBoleto;
    private boolean inadimplente;
    private boolean inativo;

    public Cliente(String nome, String sexo, String cpf,
                   boolean varejo, boolean atacado, boolean bloqueiaBoleto,
                   boolean inadimplente, boolean inativo) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.varejo = varejo;
        this.atacado = atacado;
        this.bloqueiaBoleto = bloqueiaBoleto;
        this.inadimplente = inadimplente;
        this.inativo = inativo;
    }

    public String getNome() { return nome; }
    public String getSexo() { return sexo; }
    public String getCpf() { return cpf; }

    public boolean isVarejo() { return varejo; }
    public boolean isAtacado() { return atacado; }
    public boolean isBloqueiaBoleto() { return bloqueiaBoleto; }
    public boolean isInadimplente() { return inadimplente; }
    public boolean isInativo() { return inativo; }
}
