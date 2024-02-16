import java.security.SecureRandom;
import java.util.Scanner;

public class Exercicio_Matriz {

    int tamanho = 0;
    Scanner menu = new Scanner(System.in);

    public void resoluçãoA(String[][] matriz){
        String[][] n_matriz = new String[tamanho][tamanho];
        String[] DP = new String[tamanho];
        String[] DS = new String[tamanho];
        System.out.println("Resolução:");
        System.out.println();
        for(int l=0;l<tamanho;l++){
            for(int col=0;col<tamanho;col++){
                if (l == col) {
                    DP[l] = matriz[l][col];
                    n_matriz[tamanho-l-1][tamanho-l-1] = matriz[l][col];
                }
                if(l+col == tamanho - 1){
                    DS[l] = matriz[l][col];
                    n_matriz[tamanho-l-1][tamanho-col-1] = matriz[l][col];
                }
                if(l != col && l+col != tamanho - 1){
                    n_matriz[l][col] = matriz[l][col];
                }
            }
        }

        System.out.println("Matriz original:");
        System.out.println();
        for(String n[]:matriz){
            for(String v:n){
                System.out.printf("%3s|", v);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matriz com valores invertidos:");
        System.out.println();
        for(String n[]:n_matriz){
            for(String v:n){
                System.out.printf("%3s|", v);
            }
            System.out.println();
        }
        for(int l=0;l<tamanho;l++){
            for(int col=0;col<tamanho;col++){
                if (l == col) {
                    n_matriz[l][col] = DS[l];
                }else if(l+col == tamanho - 1){ 
                    n_matriz[l][col] = DP[l];
                }
            }
        }
        System.out.println();
        System.out.println("Matriz com Diagonais trocadas:");
        System.out.println();
        for(String n[]:n_matriz){
            for(String v:n){
                System.out.printf("%3s|", v);
            }
            System.out.println();
        }
        System.out.println("Pressione ENTER para continuar");
        menu.nextLine();
    }

    public void resoluçãoB(int tA, int tB){
        System.out.print("\033c");
        int n = tA/tB;
        System.out.println("A Submatriz B pode ser encontrada " + n + " Vezes dentro da Matriz A");
        System.out.println("Pressione ENTER para continuar");
        menu.nextLine();
    }

    public void m_diagonal(){
        System.out.println("Insira o tamanho da Matriz: ");
        tamanho = Integer.parseInt(menu.nextLine());
        int op;
        String[][] matriz = new String[tamanho][tamanho];
        for(int l = 0; l<tamanho; l++){
            for(int col=0; col<tamanho; col++){
                matriz[l][col] = "X";
            }
        }
        System.out.println("Deseja inserir os valores manualmente?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        op = Integer.parseInt(menu.nextLine());
        switch (op) {
            case 1:
            int aux = 0;
            int auxl = 0;
            int auxcol = 0;
                while (aux != tamanho*tamanho) {
                    System.out.print("\033c");
                    System.out.println("Matriz atual: ");
                    for(int l = 0; l<tamanho; l++){
                        for(int col=0; col<tamanho; col++){
                            if (l == auxl && col == auxcol) {
                                matriz[l][col] = "?";
                            }
                            System.out.printf("%s |", matriz[l][col]);
                        }
                        System.out.println();
                    }
                    System.err.println("Linha:" + auxl + " Coluna:" + auxcol);
                    System.out.println("Insira o valor desejado: ");
                    int nv = Integer.parseInt(menu.nextLine());
                    matriz[auxl][auxcol] = Integer.toString(nv);
                    if (auxcol+1<tamanho) {
                        auxcol++;
                    }else{
                        auxl++;
                        auxcol = 0;
                    }
                    
                    aux++;
                }
                System.out.print("\033c");
                System.out.println("Matriz final: ");
                for(String n[]:matriz){
                    for(String v:n){
                        System.out.printf("%s|", v);
                    }
                    System.out.println();
                }
                System.out.println("Deseja continuar com esta matriz?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                op = Integer.parseInt(menu.nextLine());
                switch (op) {
                    case 1:
                        System.out.print("\033c");
                        resoluçãoA(matriz);
                        break;
                    case 2:
                        System.out.println("Retornando ao menu inicial...");
                        break;
                    default:
                        System.out.println("Insira um valor valido");
                        break;
                }
                break;
            case 2:
                System.out.print("\033c");
                for(int l = 0; l<tamanho; l++){
                    for(int col=0; col<tamanho; col++){
                        int value = new SecureRandom().nextInt(100);
                        matriz[l][col] = Integer.toString(value);
                    }
                }
                resoluçãoA(matriz);
                break;
            default:
                System.out.println("Insira um valor valido.");
                break;
        }
    }

    public void m_tamanho(){
        int tamanhoA;
        int tamanhoB;
        int lA;
        int lB;
        int colA;
        int colB;
        System.out.print("\033c");
        System.out.println("Insira o numero de linhas da Matriz A: ");
        lA = Integer.parseInt(menu.nextLine());
        System.out.println("Insira o numero de colunas da Matriz A: ");
        colA = Integer.parseInt(menu.nextLine());
        System.out.println("Insira o numero de linhas da Submatriz B: ");
        lB = Integer.parseInt(menu.nextLine());
        System.out.println("Insira o numero de colunas da Submatriz B: ");
        colB = Integer.parseInt(menu.nextLine());
        tamanhoA = lA*colA;
        tamanhoB = lB*colB;
        while (tamanhoB>tamanhoA) {
            System.out.println("Submatriz B não pode ser maior que a Matriz A ");
            System.out.println("Insira o numero de linhas da Submatriz B: ");
            lB = Integer.parseInt(menu.nextLine());
            System.out.println("Insira o numero de colunas da Submatriz B: ");
            colB = Integer.parseInt(menu.nextLine());
            tamanhoB = lB*colB;
        }
        resoluçãoB(tamanhoA,tamanhoB);
    }
}
