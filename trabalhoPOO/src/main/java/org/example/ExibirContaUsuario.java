package org.example;

import java.util.Scanner;

public class ExibirContaUsuario {
    public void exibirConta(Usuario usuario){
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu();
        String op3;

        System.out.println("-----------------------------CONTA USUARIO-------------------------");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("E-mail: " + usuario.getEmail());
        System.out.println("Senha: *************");
        System.out.println("Voce visualizar a senha? s-sim/n-nao");
        op3 = s.nextLine();
        if(op3.equalsIgnoreCase("s")) {
            System.out.println("Senha: " + usuario.getSenha());
        }
    }
}
