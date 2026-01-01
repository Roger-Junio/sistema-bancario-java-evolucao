package roger_banco_pacote;


public class App {

    public static void main(String[] args) throws Exception {

        Conta aconta1 = new Conta("123456789", "1234", "Roger Junio", 0);

        System.out.println(aconta1.getNome());

        aconta1.Deposito(1000);
        aconta1.Deposito(500);

        aconta1.Sacar(100);
        aconta1.Sacar(2000);



     //Sistema de banco, projeto inicial, Aprendendo e criando.
     // de Roger Junio 30/12/2025
    }
}
