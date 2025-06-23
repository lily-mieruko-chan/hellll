package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu(){
        Scanner s = new Scanner(System.in);
        int op;
        SessoesService sessoesService = new SessoesService();
        MenuFilme menuFilme = new MenuFilme();
        ExibirContaUsuario exibir = new ExibirContaUsuario();
        CadastrarUsuario cadastro = new CadastrarUsuario();
        AtualizacaoCadastro atualizar = new AtualizacaoCadastro();
        Scanner scanner= new Scanner(System.in);
        Usuario usuario = null;

        do{
            System.out.println("------------------------MENU----------------------");
            System.out.println("(1) - Filme em exibição");
            System.out.println("(2) - Pagamento");
            System.out.println("(3) - Cadastrar Usuario");
            System.out.println("(4) - Atualizar cadastro");
            System.out.println("(5) - Conta do usuario");
            System.out.println("(0) - Sair");
            op = s.nextInt();

            switch (op){
                case 1: menuFilme.exibirMenuFilmes(s, sessoesService); break;
                case 2: break;
                case 3:
                    usuario = cadastro.cadastroUsuario();


                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case 4:
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado ainda.");
                    } else {
                        atualizar.atualizarCadastro(usuario,scanner);
                    }
                    break;
                case 5:
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado ainda.");
                    } else {
                        exibir.exibirConta(usuario);
                    }
                    break;
                case 0:
                    System.out.println("Até logo ...");
                break;
                default:
                    System.out.println("Opção inválida!!");

            }

        }while( op != 0);

        s.close();
    }

}
