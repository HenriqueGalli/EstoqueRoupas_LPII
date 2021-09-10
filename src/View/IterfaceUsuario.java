package View;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import Model.ListaItemEstoque;

import Controller.FuncionalidadesEstoque;

public class IterfaceUsuario {

  Scanner scannerMenu = new Scanner(System.in);
  FuncionalidadesEstoque metodosEstoque = new FuncionalidadesEstoque();
  ListaItemEstoque listaItemEstoque = new ListaItemEstoque();
  int cont = 0;

  public void criarMenu() throws ParseException, IOException {
    System.out.println("|------------------- Menu de Ferramentas -------------------|");
    System.out.println("|                  1 - Adicionar Tarefas                    |");
    System.out.println("|                  2 - Listar todas as Tarefas              |");
    System.out.println("|                  3 - Excluir Tarefa                       |");
    System.out.println("|                  4 - Editar Tarefa                        |");
    System.out.println("|                  5 - Sair                                 |");
    System.out.println("|-----------------------------------------------------------|");
  
    if(cont == 0){
      listaItemEstoque.lerArquivo();
      cont++;
    }

    String opcao = scannerMenu.nextLine();

    switch (opcao) {
      case "1":
        metodosEstoque.criarNovoItem();
        criarMenu();
        break;

      case "2":
        metodosEstoque.listarEstoqueDetalhado(metodosEstoque.listarEstoque());
        criarMenu();
        break;

      case "3":
        metodosEstoque.excluirProduto(metodosEstoque.listarEstoque());
        criarMenu();
        break;

      case "4":
        metodosEstoque.editarProtudo();
        criarMenu();
        break;

      case "5":
        listaItemEstoque.salvarArquivo();
        System.exit(0);
        criarMenu();
        break;

      default:
        System.out.println("Opção inválida\nSelecione novamente");
        criarMenu();
    }
  }

}
