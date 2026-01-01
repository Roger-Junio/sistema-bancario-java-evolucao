package roger_banco_pacote;


public class Conta {

    private String conta;
    private String agencia;
    private String nome;
    private double saldo;



    public Conta(String conta, String agencia, String nome, double saldo) {
        this.conta = conta;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void setNome(String nome) {this.nome = nome;}
    public String getNome() {return nome;}

    public void Deposito(double valor) {
        saldo = saldo + valor;
        System.out.println("DEPOSITO - realizado com sucesso! +R$" + valor);
        System.out.println("saldo atual de R$" + saldo);
    }

    public void Sacar(double valor) {
         if (saldo > valor) {
             System.out.println("SAQUE - realizado com sucesso! -R$" + valor);
         }
         System.out.println("SAQUE NEGADO - saldo insuficiente");

    }


}



