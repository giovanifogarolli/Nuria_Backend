import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner menu = new Scanner(System.in);
        int op;
        Exercicio_Matriz res = new Exercicio_Matriz();

        do {
            System.out.print("\033c");
            System.out.println("MENU MATRIZ - NUTRIA");
            System.out.println("1 - EXERCICIO INVERSÃO DE DIAGONAL");
            System.out.println("2 - EXERCICIO TAMANHO DE MATRIZ");
            System.out.println(("0 - SAIR"));
            op = menu.nextInt();
            if (op == 0) {
                System.out.println("Fim da execução.");
                break;
            }else{
                switch (op) {
                    case 1:
                        res.m_diagonal();
                        break;
                    case 2:
                        res.m_tamanho();
                        break;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }
            }
        } while (op != 0);
        menu.close();
    }
}
