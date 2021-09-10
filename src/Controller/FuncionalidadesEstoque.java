package Controller;

import java.util.Scanner;

import Model.CorPeca;
import Model.ItemEstoque;
import Model.ListaItemEstoque;
import Model.TamanhoPeca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FuncionalidadesEstoque {

    Scanner scanner = new Scanner(System.in);
    private static ListaItemEstoque listaItemEstoque = new ListaItemEstoque();

    public void criarNovoItem() throws ParseException {
        String finalizarInclusao = "";

        try {
            do {
                System.out.println("|----------------------- Novo Item -----------------------|");

                ItemEstoque item = new ItemEstoque(entradaCodigoItem(), entradaData(), entradaLocalCompra(), entradaTipo(), entradaMarca(),
                entradaCaracteristicas(), entradaTamanhoProduto(true), entradaCorProduto(true), entradaValorEtiqueta(), entradaValorPago(), entradaPreco());

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
            numeroItemEscolhido = validarNumeroSelecionadoOpcao();
        } else {
            System.out.println("Não existe nenhum produto cadastrada na lista!");
        }
        return numeroItemEscolhido;
    }

    public void listarEstoqueDetalhado(int numeroItemEscolhido) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (numeroItemEscolhido >= 0) {
            System.out.println("|--------------------- Item Detalhado ----------------------|");

            System.out.println(String.format("%-60s",
                    "| 1 - Código do Item:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCodigoItem())
                    + "|");

            System.out.println(String.format("%-60s",
                    "| 2 - Data de Entrada:" + formatter.format(listaItemEstoque.getList().get(numeroItemEscolhido).getDataEntrada()))
                    + "|");
            System.out.println(String.format("%-60s",
                    "| 3 - Local da Compra:" + listaItemEstoque.getList().get(numeroItemEscolhido).getLocalCompra())
                    + "|");
            System.out.println(String.format("%-60s",
                    "| 4 - Tipo:" + listaItemEstoque.getList().get(numeroItemEscolhido).getTipoRoupa()) + "|");
            System.out.println(String.format("%-60s",
                    "| 5 - Marca:" + listaItemEstoque.getList().get(numeroItemEscolhido).getMarcaRoupa()) + "|");
            System.out
                    .println(String.format("%-60s",
                            "| 6 - Características:"
                                    + listaItemEstoque.getList().get(numeroItemEscolhido).getCaracteristicaRoupa())
                            + "|");
            System.out.println(String.format("%-60s",
                    "| 7 - Tamanho:" + listaItemEstoque.getList().get(numeroItemEscolhido).getTamanhoPeca()) + "|");
            System.out.println(String.format("%-60s",
                    "| 8 - Cor:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCorPeca()) + "|");
            System.out
                    .println(
                            String.format("%-60s",
                                    "| 9 - Valor de etiqueta na compra:R$"
                                            + listaItemEstoque.getList().get(numeroItemEscolhido).getValorEtiqueta())
                                    + "|");
            System.out
                    .println(
                            String.format("%-60s",
                                    "| 10 - Valor pago na compra:R$"
                                            + listaItemEstoque.getList().get(numeroItemEscolhido).getValorPago())
                                    + "|");

            System.out
                    .println(
                            String.format("%-60s",
                                    "| 11 - Valor para margem de 100%:R$"
                                            + listaItemEstoque.getList().get(numeroItemEscolhido).getValorMargem())
                                    + "|");

            System.out.println(String.format("%-60s",
                    "| 12 - Preço sugerido:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getPrecoSugerido())
                    + "|");
            System.out.println("|-----------------------------------------------------------|\n");
        }
    }

    public void excluirProduto(int numeroItemEscolhido) {
        listaItemEstoque.excludeListaEstoque(numeroItemEscolhido);
    }

    public void editarProtudo() {
        int indiceProduto = listarEstoque();
        String novoValor = "";
        listarEstoqueDetalhado(indiceProduto);
        int numeroItemEscolhido;
        System.out.println("Digite o Item que deseja alterar os dados");
        numeroItemEscolhido = scanner.nextInt();
        ArrayList<ItemEstoque> itens = listaItemEstoque.getList();

        switch (numeroItemEscolhido) {
            case 1:
                System.out.println("Digite o novo valor para o Código do Produto");
                itens.get(indiceProduto).setCodigoItem(scanner.nextInt());
                break;
            case 2:
                System.out.println("Digite o novo valor para a Data de Entrada");
                // itens.get(numeroItemEscolhido-1).setDataEntrada(dataEntrada);
                break;
            case 3:
                itens = listaItemEstoque.getList();
                System.out.println("Digite o novo valor para o Local da Compra");
                novoValor = scanner.next();
                itens.get(indiceProduto).setLocalCompra(novoValor);
                break;
            case 4:
                System.out.println("Digite o novo valor para o Tipo do Produto");
                itens.get(indiceProduto).setTipoRoupa(scanner.next());
                break;
            case 5:
                System.out.println("Digite o novo valor para a Marca do Produto");
                itens.get(indiceProduto).setMarcaRoupa(scanner.next());
                break;
            case 6:
                System.out.println("Digite o novo valor para as Características do Produto");
                itens.get(indiceProduto).setCaracteristicaRoupa(scanner.next());
                break;
            case 7:
                System.out.println("Digite o novo valor para o Tamanho do Produto");
                itens.get(indiceProduto).setTamanhoPeca(entradaTamanhoProduto(false));
                break;
            case 8:
                System.out.println("Digite o novo valor para a Cor do Produto");
                itens.get(indiceProduto).setCorPeca(entradaCorProduto(false));
                break;
            case 9:
                System.out.println("Digite o novo valor para o Valor de etiqueta do Produto");
                itens.get(indiceProduto).setValorEtiqueta(scanner.nextDouble());
                break;
            case 10:
                System.out.println("Digite o novo valor para o Valor pago na compra do Produto");
                itens.get(indiceProduto).setValorPago(scanner.nextDouble());
                break;
            case 12:
                System.out.println("Digite o novo valor para o Preço sugerido:R$");
                itens.get(indiceProduto).setPrecoSugerido(scanner.nextDouble());
                break;
            default:
                break;
        }
    }

    private TamanhoPeca entradaTamanhoProduto(boolean primeiroMenu) {
        // Tamanho
        if(primeiroMenu){
            System.out.println("Preencha o Tamanho:");
        }
        System.out.println("1 - P\n2 - M\n3 - G");
        String numeroTamanho = scanner.next();
        TamanhoPeca tamanhoPeca = null;
        switch (numeroTamanho) {
            case "1":
                tamanhoPeca = TamanhoPeca.PEQUENO;
                break;

            case "2":
                tamanhoPeca = TamanhoPeca.MEDIO;
                break;

            case "3":
                tamanhoPeca = TamanhoPeca.GRANDE;
                break;

            default:
                System.out.println("Tamanho inválido selecione uma opção válida!");
                entradaTamanhoProduto(false);
                break;
        }
        return tamanhoPeca;
    }

    private CorPeca entradaCorProduto(boolean primeiroMenu) {
        // Cor
        if(primeiroMenu){
            System.out.println("Preencha a Cor:");
        }
        System.out.println("1 - AZUL\n2 - BRANCA\n3 - PRETA\n4 - LARANJA\n5 - CINZA");
        String numeroCor = scanner.next();
        CorPeca corPeca = null;
        switch (numeroCor) {
            case "1":
                corPeca = CorPeca.AZUL;
                break;

            case "2":
                corPeca = CorPeca.BRANCA;
                break;

            case "3":
                corPeca = CorPeca.PRETA;
                break;

            case "4":
                corPeca = CorPeca.LARANJA;
                break;

            case "5":
                corPeca = CorPeca.CINZA;
                break;

            default:
                System.out.println("Cor inválida selecione uma opção válida!");
                entradaCorProduto(false);
                break;
        }
        return corPeca;
    }

    // Metodos de Entrada de Dados
    private int entradaCodigoItem() {
        // Código do Item
        try {
            System.out.println("Preencha o Código do Item:");
            return scanner.nextInt();

        } catch (Exception e) {
            scanner.nextLine(); // Limpa o Scanner
            System.out.println("Preencha o Código numérico válido!");
            entradaCodigoItem();
            return 0;
        }
    }

    private String entradaLocalCompra() {
        // Local da Compra
        System.out.println("Preencha o Local da Compra:");
        String localCompra = scanner.next();
        if(localCompra.equals("")){
            System.out.println("Campo não pode ser vazio!");
            entradaLocalCompra();
        }
        return localCompra;
    }

    private Date entradaData() throws ParseException{
        // Data de Entrada
        Date dataEntrada = new Date();
        return dataEntrada;
    }

    private String entradaTipo(){
         // Tipo
         System.out.println("Preencha o Tipo da Roupa:");
         String tipoRoupa = scanner.next();
         if(tipoRoupa.equals("")){
            System.out.println("Campo não pode ser vazio!");
            entradaTipo();
        }
        return tipoRoupa;
    }

    private String entradaMarca(){
         // Marca
         System.out.println("Preencha a Marca:");
         String marcaRoupa = scanner.next();
         if(marcaRoupa.equals("")){
            System.out.println("Campo não pode ser vazio!");
            entradaMarca();
        }
         return marcaRoupa;
    }

    private String entradaCaracteristicas(){
        // Caracteristicas
        System.out.println("Preencha a(s) Característica(s):");
        String caracteristicaRoupa = scanner.next();
        if(caracteristicaRoupa.equals("")){
            System.out.println("Campo não pode ser vazio!");
            entradaCaracteristicas();
        }
         return caracteristicaRoupa;
    }

    private double entradaValorEtiqueta() {
        // Valor de etiqueta na compra  
        try {
            System.out.println("Preencha o Valor de etiqueta na compra:");
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o Scanner
            System.out.println("Preencha um Valor de etiqueta válido!");
            entradaValorEtiqueta();
            return 0;
        }
    }

    private double entradaValorPago() {
         // Valor pago na compra
        try {
            System.out.println("Preencha o Valor pago na compra:");
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o Scanner
            System.out.println("Preencha um Valor pago na compra válido!");
            entradaValorPago();
            return 0;
        }
    }

    private double entradaPreco() {
        // Preço Sugerido
        try {
            System.out.println("Preencha o Valor do Preço Sugerido");
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o Scanner
            System.out.println("Preencha um Preço Sugerido válido!");
            entradaPreco();
            return 0;
        }
    }

    private int validarNumeroSelecionadoOpcao(){
        try {
            System.out.println("Digite o Item que deseja visualizar os detalhes");
            int numeroSelecionado = scanner.nextInt();
            if(listaItemEstoque.getList().size()>=numeroSelecionado){
                return numeroSelecionado - 1;
            }
            else{
                System.out.println("Preencha uma opção válida!");
                validarNumeroSelecionadoOpcao();
                return 0;
            }
            
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o Scanner
            System.out.println("Preencha uma opção válida!");
            validarNumeroSelecionadoOpcao();
            return 0;
        }
    }
}
