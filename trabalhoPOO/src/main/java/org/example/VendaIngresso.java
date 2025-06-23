package org.example;

import java.util.Scanner;

public class VendaIngresso {
    public void ingresso(Sessao sessao, Pagamento pagamento, Ingresso ingresso){
        Scanner s = new Scanner(System.in);
        int op1;

        double total;
        total = ingresso.getQtdIngresso()*sessao.getPreco();
        pagamento.setValorTotal(total);
        ingresso.setValorPagamento(total*0.10);
        System.out.println("Valor total: " + ingresso.getValorPagamento());

        do {

            System.out.println("Selecione a forma de pagamento");
            System.out.println("(1) - Cartão de crédito");
            System.out.println("(2) - Cartão de débito");
            System.out.println("(3) - Dinheiro");
            System.out.println("(4) - Pix");
            System.out.println("(0) - Cancelar compra");
            op1 = s.nextInt();

            switch(op1){
                case 1:
                    pagamento.setForma(FormaPagamento.cartaoCredito);
                    System.out.println("Valor total: " + ingresso.getValorPagamento());
                    System.out.println("Forma de pagamento: " + pagamento.getForma());
                    break;
                case 2:
                    pagamento.setForma(FormaPagamento.cartaoDebito);
                    System.out.println("Valor total: " + ingresso.getValorPagamento());
                    System.out.println("Forma de pagamento: " + pagamento.getForma());
                    break;
                case 3:
                    pagamento.setForma(FormaPagamento.dinheiro);
                    System.out.println("Valor total: " + ingresso.getValorPagamento());
                    System.out.println("Forma de pagamento: " + pagamento.getForma());
                    break;
                case 4:
                    pagamento.setForma(FormaPagamento.pix);
                    System.out.println("Valor total: " + ingresso.getValorPagamento());
                    System.out.println("Forma de pagamento: " + pagamento.getForma());
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal ...");
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        }while(op1 != 0);

    }
}
