package View;
import java.text.ParseException;
import java.util.Scanner;

import Controller.FuncionalidadesEstoque;

public class IterfaceUsuario {

    Scanner scannerMenu = new Scanner(System.in);
    FuncionalidadesEstoque metodosEstoque = new FuncionalidadesEstoque();

    public void criarMenu() throws ParseException{
        System.out.println("|------------------- Menu de Ferramentas -------------------|");
        System.out.println("|                  1 - Adicionar Tarefas                    |");
        System.out.println("|                  2 - Listar todas as Tarefas              |");
        System.out.println("|                  3 - Excluir Tarefa                       |");
        System.out.println("|                  4 - Editar Tarefa                        |");
        System.out.println("|                  5 - Sair                                 |");
        System.out.println("|-----------------------------------------------------------|");

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
            System.exit(0);
            criarMenu();
          break;
            
          default:
            System.out.println("Opção inválida\nSelecione novamente");
            criarMenu();
        }
    }
       
}
