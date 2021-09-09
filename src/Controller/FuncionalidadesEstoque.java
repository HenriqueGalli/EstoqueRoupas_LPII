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


    public void criarNovoItem() throws ParseException{
        String finalizarInclusao = "";

        do{
            if(!finalizarInclusao.equals("nao")){

                System.out.println("|----------------------- Novo Item -----------------------|");

                //Código do Item
                System.out.println("Preencha o Código do Item:");
                int codigoItem = scanner.nextInt();
        
                //Data de Entrada
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Preencha a Data de Entrada (dd/MM/yyyy):");
                String dateString = scanner.next();
                Date dataEntrada = formatter.parse(dateString);

                //Local da Compra
                System.out.println("Preencha o Local da Compra:");
                String localCompra = scanner.nextLine();

                //Tipo
                System.out.println("Preencha o Tipo da Roupa:");
                String tipoRoupa = scanner.nextLine();

                //Marca
                System.out.println("Preencha a Marca:");
                String marcaRoupa = scanner.nextLine();

                //Caracteristicas
                System.out.println("Preencha a(s) Característica(s):");
                String caracteristicaRoupa = scanner.nextLine();
                
                //Tamanho
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

                //Cor
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

                //Valor de etiqueta na compra
                System.out.println("Preencha o Valor de etiqueta na compra:");
                double valorEtiqueta = scanner.nextDouble();

                //Valor pago na compra
                System.out.println("Preencha o Valor pago na compra:");
                double valorPago = scanner.nextDouble();

                //Preço Sugerido
                System.out.println("Preencha o Valor do Preço Sugerido");
                double precoSugerido = scanner.nextDouble();

                ItemEstoque item = new ItemEstoque( codigoItem,  dataEntrada,  localCompra,  tipoRoupa, marcaRoupa,  caracteristicaRoupa,
                  tamanhoPeca, corPeca,  valorEtiqueta,  valorPago, precoSugerido);

                listaItemEstoque.addListaEstoque(item);

                System.out.println("Deseja cadastrar outra peça de roupa? (sim/nao)");
                finalizarInclusao = scanner.nextLine();
            }
        } while(!finalizarInclusao.equals("nao"));
    }

    public void listarEstoque(){
        System.out.println("|------------------- Estoque Cadastrado -------------------|");
  
        int cont = 1;
        if(listaItemEstoque.getList().size()>0){
          for (ItemEstoque estoque : listaItemEstoque.getList()) {
            System.out.println(cont + " - Código do Item:" + estoque.getCodigoItem() + " e Tipo:" + estoque.getTipoRoupa());
            cont++;
          }
          System.out.println("Digite o Item que deseja visualizar os detalhes");
          int numeroItemEscolhido = scanner.nextInt();

          System.out.println("|--------------------- Item Detalhado ---------------------|");

          System.out.println(numeroItemEscolhido + " - Código do Item:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCodigoItem());
          System.out.println(numeroItemEscolhido + " - Data de Entrada:" + listaItemEstoque.getList().get(numeroItemEscolhido).getDataEntrada());
          System.out.println(numeroItemEscolhido + " - Local da Compra:" + listaItemEstoque.getList().get(numeroItemEscolhido).getLocalCompra());
          System.out.println(numeroItemEscolhido + " - Tipo:" + listaItemEstoque.getList().get(numeroItemEscolhido).getTipoRoupa());
          System.out.println(numeroItemEscolhido + " - Marca:" + listaItemEstoque.getList().get(numeroItemEscolhido).getMarcaRoupa());
          System.out.println(numeroItemEscolhido + " - Características:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCaracteristicaRoupa());
          System.out.println(numeroItemEscolhido + " - Tamanho:" + listaItemEstoque.getList().get(numeroItemEscolhido).getTamanhoPeca());
          System.out.println(numeroItemEscolhido + " - Cor:" + listaItemEstoque.getList().get(numeroItemEscolhido).getCorPeca());
          System.out.println(numeroItemEscolhido + " - Valor de etiqueta na compra:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getValorEtiqueta());
          System.out.println(numeroItemEscolhido + " - Valor pago na compra:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getValorPago());
          System.out.println(numeroItemEscolhido + " - Valor para margem de 100%:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getValorMargem());
          System.out.println(numeroItemEscolhido + " - Preço sugerido:R$" + listaItemEstoque.getList().get(numeroItemEscolhido).getPrecoSugerido());
        }
        else{
          System.out.println("Não existe nenhuma tarefa cadastrada na lista!");
        }
      }
}
