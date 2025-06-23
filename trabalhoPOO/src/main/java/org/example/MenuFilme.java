package org.example;

import java.util.*;

public class MenuFilme {
    public void exibirMenuFilmes(Scanner scanner, SessoesService sessoesService) {
        List<Sessao> todasSessoes = sessoesService.getSessao();

        // Cria uma lista de títulos únicos de filmes
        Set<String> titulosUnicos = new HashSet<>();
        for (Sessao s : todasSessoes) {
            titulosUnicos.add(s.getTitulo());
        }

        int escolha;
        String resposta;

        do {
            System.out.println("\n------------------------FILMES EM EXIBIÇÃO-------------------------");
            int indice = 1;
            for (String titulo : titulosUnicos) {
                System.out.println(indice + " - " + titulo);
                indice++;
            }
            System.out.println("0 - Voltar");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 0 && escolha <= titulosUnicos.size()) {
                String filmeSelecionado = getFilmeSelecionado(titulosUnicos, escolha);

                System.out.println("\n--- INFORMAÇÕES DO FILME ---");
                exibirInfo(filmeSelecionado, todasSessoes);

                System.out.print("Deseja ver as sessões disponíveis para esse filme? (s/n): ");
                resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("s")) {
                    exibirSessoesPorFilme(scanner, filmeSelecionado, todasSessoes);
                }

            } else if (escolha != 0) {
                System.out.println("Opção inválida!");
            }

        } while (escolha != 0);
    }

    private String getFilmeSelecionado(Set<String> titulosUnicos, int escolha) {
        int indice = 1;
        for (String titulo : titulosUnicos) {
            if (indice == escolha) {
                return titulo;
            }
            indice++;
        }
        return null;
    }

    private void exibirInfo(String titulo, List<Sessao> todasSessoes) {
        for (Sessao s : todasSessoes) {
            if (s.getTitulo().equals(titulo)) {
                s.exibirInfo();
                break;
            }
        }
    }

    private void exibirSessoesPorFilme(Scanner scanner, String titulo, List<Sessao> todasSessoes, Ingresso ingresso) {
        System.out.println("\n----- SESSÕES DISPONÍVEIS PARA: " + titulo.toUpperCase() + " -----");
        Scanner s = new Scanner(System.in);
        Sessao sessao = new Sessao();
        Pagamento pagamento = new Pagamento();

        int indice = 1;
        int opcao;

        boolean encontrou = false;
        List<Sessao> sessoesFiltradas = new ArrayList<>();

        for (Sessao s : todasSessoes) {
            if (s.getTitulo().equals(titulo)) {
                System.out.println("(" + indice + ") - Horário: " + s.getHorario() + " | Sala: " + s.getSala() + " | Preço: R$" + s.getPreco());
                sessoesFiltradas.add(s);
                encontrou = true;
                indice++;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma sessão disponível para este filme.");
            return;
        }


        // Pergunta qual sessão o usuário quer selecionar
        System.out.print("(0) - Sair ");
        System.out.println("Qual sessão deseja? ");
        opcao = s.nextInt();
        scanner.nextLine();

        if (opcao > 0 && opcao < indice) {
            Sessao sessaoEscolhida = sessoesFiltradas.get(opcao - 1);
            int opc;
            System.out.println("Quantos ingressos deseja?");
            opc = s.nextInt();

            ingresso.setQtdIngresso(opc);
            ingresso.ingresso(sessao, pagamento, ingresso);


        } else if (opcao != 0) {
            System.out.println("Opção inválida!");
        }
    }
}