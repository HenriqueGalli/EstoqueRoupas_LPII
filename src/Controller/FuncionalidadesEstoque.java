package Controller;

import java.util.Scanner;

import Model.CorPeca;
import Model.ItemEstoque;
import Model.ListaItemEstoque;
import Model.TamanhoPeca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FuncionalidadesEstoque {

    Scanner scanner = new Scanner(System.in);
    private static ListaItemEstoque listaItemEstoque = new ListaItemEstoque();

    public void criarNovoItem() throws ParseException {
        String finalizarInclusao = "";

        try {

            do {
                System.out.println("|----------------------- Novo Item -----------------------|");

                // Código do Item
                System.out.println("Preencha o Código do Item:");
                int codigoItem = scanner.nextInt();

                // Data de Entrada
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date dataEntrada = new Date();

                // Local da Compra
                System.out.println("Preencha o Local da Compra:");
                String localCompra = scanner.next();

                // Tipo
                System.out.println("Preencha o Tipo da Roupa:");
                String tipoRoupa = scanner.next();

                // Marca
                System.out.println("Preencha a Marca:");
                String marcaRoupa = scanner.next();

                // Caracteristicas
                System.out.println("Preencha a(s) Característica(s):");
                String caracteristicaRoupa = scanner.next();

                // Tamanho
                System.out.println("Preencha o Tamanho:");
                System.out.println("1 - P\n2 - M\n3 - G");
                int numeroTamanho = scanner.nextInt();
                TamanhoPeca tamanhoPeca = null;
                switch (numeroTamanho) {
                    case 1:
                        tamanhoPeca = TamanhoPeca.PEQUENO;
                        break;

                    case 2:
                        tamanhoPeca = TamanhoPeca.MEDIO;
                        break;

                    case 3:
                        tamanhoPeca = TamanhoPeca.GRANDE;
                        break;

                    default:
                        System.out.println("Tamanho inválido selecione uma opção válida!");
                        break;
                }

                // Cor
                System.out.println("Preencha o Tamanho:");
                System.out.println("1 - AZUL\n2 - BRANCA\n3 - PRETA\n4 - LARANJA\n5 - CINZA");
                int numeroCor = scanner.nextInt();
                CorPeca corPeca = null;
                switch (numeroCor) {
                    case 1:
                        corPeca = CorPeca.AZUL;
                        break;

                    case 2:
                        corPeca = CorPeca.BRANCA;
                        break;

                    case 3:
                        corPeca = CorPeca.PRETA;
                        break;

                    case 4:
                        corPeca = CorPeca.LARANJA;
                        break;

                    case 5:
                        corPeca = CorPeca.CINZA;
                        break;

                    default:
                        System.out.println("Cor inválida selecione uma opção válida!");
                        break;
                }

                // Valor de etiqueta na compra
                System.out.println("Preencha o Valor de etiqueta na compra:");
                double valorEtiqueta = scanner.nextDouble();

                // Valor pago na compra
                System.out.println("Preencha o Valor pago na compra:");
                double valorPago = scanner.nextDouble();

                // Preço Sugerido
                System.out.println("Preencha o Valor do Preço Sugerido");
                double precoSugerido = scanner.nextDouble();

                ItemEstoque item = new ItemEstoque(codigoItem, dataEntrada, localCompra, tipoRoupa, marcaRoupa,
                        caracteristicaRoupa, tamanhoPeca, corPeca, valorEtiqueta, valorPago, precoSugerido);

                listaItemEstoque.addListaEstoque(item);

                System.out.println("Deseja cadastrar outra peça de roupa? (sim/nao)");
                finalizarInclusao = scanner.next();
            } while (finalizarInclusao.equals("sim"));
        } catch (Exception e) {
            System.out.println("Erro Ao cadastrar um produto");
        }
    }

    public int listarEstoque() {
        System.out.println("|------------------- Estoque Cadastrado -------------------|");
        int numeroItemEscolhido = -1;
        int cont = 1;
        if (listaItemEstoque.getList().size() > 0) {
            for (ItemEstoque estoque : listaItemEstoque.getList()) {
                System.out.println(
                        cont + " - Código do Item:" + estoque.getCodigoItem() + " e Tipo:" + estoque.getTipoRoupa());
                cont++;
            }
            System.out.println("Digite o Item que deseja visualizar os detalhes");
            numeroItemEscolhido = scanner.nextInt() - 1;
        } else {
            System.out.println("Não existe nenhuma produto cadastrada na lista!");
        }
        return numeroItemEscolhido;
    }

    public void listarEstoqueDetalhado(int numeroItemEscolhido) {
        if( numeroItemEscolhido >= 0){
            System.out.println("|--------------------- Item Detalhado ----------------------|");

            System.out.println(String.format("%-60s",
                    "| - Código do Item:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCodigoItem()) + "|");

            System.out.println(String.format("%-60s",
                    "| - Data de Entrada:" + listaItemEstoque.getList().get(numeroItemEscolhido).getDataEntrada()) + "|");
            System.out.println(String.format("%-60s",
                    "| - Local da Compra:" + listaItemEstoque.getList().get(numeroItemEscolhido).getLocalCompra()) + "|");
            System.out.println(
                    String.format("%-60s", "| - Tipo:" + listaItemEstoque.getList().get(numeroItemEscolhido).getTipoRoupa())
                            + "|");
            System.out.println(String.format("%-60s",
                    "| - Marca:" + listaItemEstoque.getList().get(numeroItemEscolhido).getMarcaRoupa()) + "|");
            System.out.println(String.format("%-60s",
                    "| - Características:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCaracteristicaRoupa())
                    + "|");
            System.out.println(String.format("%-60s",
                    "| - Tamanho:" + listaItemEstoque.getList().get(numeroItemEscolhido).getTamanhoPeca()) + "|");
            System.out.println(
                    String.format("%-60s", "| - Cor:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCorPeca())
                            + "|");
            System.out
                    .println(
                            String.format("%-60s",
                                    "| - Valor de etiqueta na compra:R$"
                                            + listaItemEstoque.getList().get(numeroItemEscolhido).getValorEtiqueta())
                                    + "|");
            System.out.println(String.format("%-60s",
                    "| - Valor pago na compra:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getValorPago())
                    + "|");
            System.out.println(String.format("%-60s", "| - Valor para margem de 100%:R$"
                    + listaItemEstoque.getList().get(numeroItemEscolhido).getValorMargem()) + "|");
            System.out.println(String.format("%-60s",
                    "| - Preço sugerido:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getPrecoSugerido())
                    + "|");
            System.out.println("|-----------------------------------------------------------|\n");
        }
    }
    
    public void excluirProduto(int numeroItemEscolhido){
        listaItemEstoque.excludeListaEstoque(numeroItemEscolhido);
    }
}
