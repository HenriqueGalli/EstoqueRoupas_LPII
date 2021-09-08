package View;
import java.util.Scanner;

public class IterfaceUsuario {

    Scanner scannerMenu = new Scanner(System.in);
    
    public void criarMenu(){
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
            criarMenu();
            break;

          case "2":
            criarMenu();
            break;

          case "3":
            criarMenu();
            break;

          case "4":
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
