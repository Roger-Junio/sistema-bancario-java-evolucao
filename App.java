package roger_banco_pacote;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Conta aconta1 = new Conta(
                "123456789", // conta
                "1234",      // agencia
                "Roger Junio", // nome
                "Roger",     // apelido
                0.0,         // saldo
                "12",        // usuario
                "12"         // senha
        );

        String usuariologin = aconta1.getCpf();
        String usuariosenha = aconta1.getSenha();

        //LOGIN
        System.out.println("==========================================");
        System.out.println("       BANK ROGE'S - ACESSO SEGURO ");
        System.out.println("==========================================\n");

        System.out.print("Usuário: ");
        String usuariodigitado = scanner.nextLine();

        System.out.print("Senha: ");
        String senhadigitada = scanner.nextLine();

        while (!usuariodigitado.equals(usuariologin)
                || !senhadigitada.equals(usuariosenha)) {

            System.out.println("\nUsuário ou senha inválidos.");
            System.out.println("Por favor, tente novamente.\n");

            System.out.print("Usuário: ");
            usuariodigitado = scanner.nextLine();

            System.out.print("Senha: ");
            senhadigitada = scanner.nextLine();
        }

        System.out.println("============================================");
        System.out.println("       LOGIN REALIZADO COM SUCESSO ");
        System.out.println("============================================");
        System.out.println("Nome : " + aconta1.getNome());
        System.out.println("Conta : " + aconta1.getConta());
        System.out.println("Agência : " + aconta1.getAgencia());

        int opcao = 0;

        while (true) {

            System.out.println("============================================");
            System.out.println("             MENU PRINCIPAL ");
            System.out.println("============================================");
            System.out.println("[1] Consultar Saldo");
            System.out.println("[2] Extrato Bancário");
            System.out.println("[3] Realizar Depósito");
            System.out.println("[4] Realizar Saque");
            System.out.println("============================================");
            System.out.println("[S] Sair");
            System.out.print("Opção: ");

            String inputSelecao = scanner.next();

            if (inputSelecao.equalsIgnoreCase("S")) {
                break;
            } else if (
                    inputSelecao.equals("1") ||
                            inputSelecao.equals("2") ||
                            inputSelecao.equals("3") ||
                            inputSelecao.equals("4")
            ) {
                opcao = Integer.parseInt(inputSelecao);
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            //SALDO
            if (opcao == 1) {

                System.out.println("\n---------- SALDO ----------");
                System.out.println("Saldo disponível: R$ " + aconta1.getSaldo());

                System.out.println("\n[M] Menu [S] Sair");
                System.out.print("Opção: ");
                String inputOS = scanner.next();

                while (!inputOS.equalsIgnoreCase("S") &&
                        !inputOS.equalsIgnoreCase("M")) {
                    System.out.println("Opção invalida, tente novamente!");
                    inputOS = scanner.next();
                }

                if (inputOS.equalsIgnoreCase("S")) break;
                continue;
            }

            //EXTRATO
            if (opcao == 2) {

                aconta1.mostrarExtrato();

                System.out.println("\n[M] Menu [S] Sair ");
                System.out.print("Opção: ");
                String inputOS = scanner.next();

                while (!inputOS.equalsIgnoreCase("S") &&
                        !inputOS.equalsIgnoreCase("M")) {
                    System.out.println("Opção invalida, tente novamente!");
                    inputOS = scanner.next();
                }

                if (inputOS.equalsIgnoreCase("S")) break;
                continue;
            }

            //DEPÓSITO
            if (opcao == 3) {

                System.out.println("\n---------- DEPÓSITO ----------");
                System.out.print("\nInforme o valor do deposito");
                System.out.println("\n[M] Menu [S] Sair");
                System.out.println("\nR$ ");
                String inputDEPOSITO = scanner.next().trim();

                if (inputDEPOSITO.equalsIgnoreCase("M")) continue;
                if (inputDEPOSITO.equalsIgnoreCase("S")) break;

                double valor;

                try {
                    valor = Double.parseDouble(inputDEPOSITO);
                } catch (NumberFormatException e) {
                    System.out.println("\nValor inválido!");
                    continue;
                }

                while (valor <= 0) {

                    System.out.println("\nValor inválido!");
                    System.out.print("Informe o valor: \nR$ ");
                    String novoValor = scanner.next().trim();

                    if (novoValor.equalsIgnoreCase("M")) {
                        valor = -1;
                        break;
                    }

                    if (novoValor.equalsIgnoreCase("S")) {
                        valor = -2;
                        break;
                    }

                    try {
                        valor = Double.parseDouble(novoValor);
                    } catch (NumberFormatException e) {
                        valor = -1;
                    }

                    System.out.println("\n[M] Menu [S] Sair");
                }

                if (valor == -1) continue;
                if (valor == -2) break;

                System.out.println("\n--------------------------------");
                System.out.println("Confirmar deposito de R$" + valor + "?");
                System.out.println("--------------------------------");
                System.out.println("\n[C] Confirmar [M] Menu [S] Sair");
                String inputCMK = scanner.next().trim();

                if (inputCMK.equalsIgnoreCase("M")) continue;
                if (inputCMK.equalsIgnoreCase("S")) break;

                if (inputCMK.equalsIgnoreCase("C")) {
                    aconta1.deposito(valor);
                    continue;
                }
            }

            //SAQUE
            if (opcao == 4) {

                System.out.println("\n---------- SAQUE ----------");
                System.out.println("\n[M] Menu [S] Sair");
                System.out.print("Informe o valor: R$ ");

                String inputSAQUE = scanner.next().trim();

                if (inputSAQUE.equalsIgnoreCase("M")) continue;
                if (inputSAQUE.equalsIgnoreCase("S")) break;

                double valor;

                try {
                    valor = Double.parseDouble(inputSAQUE);
                } catch (NumberFormatException e) {
                    System.out.println("Valor insuficiente!");
                    continue;
                }

                while (valor <= 0) {

                    System.out.println("Valor insuficiente!");
                    System.out.println("\n[M] Menu [S] Sair");
                    System.out.print("Informe o valor: R$ ");

                    inputSAQUE = scanner.next().trim();

                    if (inputSAQUE.equalsIgnoreCase("M")) {
                        valor = -1;
                        break;
                    }

                    if (inputSAQUE.equalsIgnoreCase("S")) {
                        valor = -2;
                        break;
                    }

                    try {
                        valor = Double.parseDouble(inputSAQUE);
                    } catch (NumberFormatException e) {
                        valor = -1;
                    }
                }

                if (valor == -1) continue;
                if (valor == -2) break;

                if (valor > aconta1.getSaldo()) {

                    System.out.println("Saldo insuficiente!");
                    System.out.println("\n[M] Menu [S] Sair [D] Deposito");
                    System.out.print("Opção: ");
                    inputSAQUE = scanner.next().trim();

                    while (!inputSAQUE.equalsIgnoreCase("M")
                            && !inputSAQUE.equalsIgnoreCase("S")
                            && !inputSAQUE.equalsIgnoreCase("D")) {
                        System.out.println("Opção invalida, tente novamente!");
                        inputSAQUE = scanner.next().trim();
                    }

                    if (inputSAQUE.equalsIgnoreCase("M")) continue;
                    if (inputSAQUE.equalsIgnoreCase("S")) break;

                    if (inputSAQUE.equalsIgnoreCase("D")) {

                        System.out.println("\n---------- DEPÓSITO ----------");
                        System.out.print("Informe o valor: R$ ");
                        double valorDeposito = scanner.nextDouble();

                        while (valorDeposito <= 0) {
                            System.out.println("Valor inválido!");
                            System.out.print("Informe o valor: R$ ");
                            valorDeposito = scanner.nextDouble();
                        }

                        aconta1.deposito(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                        continue;
                    }

                } else {

                    //CONFIRMAÇÃO DE SAQUE
                    System.out.println("\n--------------------------------");
                    System.out.println("Confirmar saque de R$" + valor + "?");
                    System.out.println("--------------------------------");
                    System.out.println("\n[C] Confirmar [M] Menu [S] Sair");
                    String inputCONF = scanner.next().trim();

                    while (!inputCONF.equalsIgnoreCase("C")
                            && !inputCONF.equalsIgnoreCase("M")
                            && !inputCONF.equalsIgnoreCase("S")) {
                        System.out.println("Opção invalida, tente novamente!");
                        inputCONF = scanner.next().trim();
                    }

                    if (inputCONF.equalsIgnoreCase("M")) continue;
                    if (inputCONF.equalsIgnoreCase("S")) break;

                    if (inputCONF.equalsIgnoreCase("C")) {
                        aconta1.sacar(valor);
                    }

                    System.out.println("\n[M] Menu [S] Sair");
                    System.out.print("Opção: ");
                    inputSAQUE = scanner.next().trim();

                    while (!inputSAQUE.equalsIgnoreCase("M")
                            && !inputSAQUE.equalsIgnoreCase("S")) {
                        System.out.println("Opção invalida, tente novamente!");
                        inputSAQUE = scanner.next().trim();
                    }

                    if (inputSAQUE.equalsIgnoreCase("S")) break;
                }
            }
        }

        scanner.close();
    }
}






