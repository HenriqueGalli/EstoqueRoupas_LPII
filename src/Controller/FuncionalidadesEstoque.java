package Controller;
import java.util.Scanner;

import Model.TamanhoPeca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FuncionalidadesEstoque {

    Scanner scanner = new Scanner(System.in);


    private void criarNovoItem(){
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
                TamanhoPeca tamanhoSelecionadoPeca;
                switch (numeroTamanho) {
                    case 1:
                        tamanhoSelecionadoPeca = TamanhoPeca.PEQUENO;
                        break;

                    case 2:
                        tamanhoSelecionadoPeca = TamanhoPeca.MEDIO;
                        break;

                    case 3:
                        tamanhoSelecionadoPeca = TamanhoPeca.GRANDE;
                        break;

                    default:
                        System.out.println(" :");
                        break;
                }

                

                Tarefa tarefa = new Tarefa(descricaoTarefa, false);

              listaTarefas.addTarefa(tarefa);
            }
          }while(!finalizarInclusao.equals("nao"));

      }
  
}
