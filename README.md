# Nuria_Backend
Teste - Estágio em Desenvolvimento
>Status: ✅Finalizado

## Objetivo
Desenvolver duas funções relacionadas com Matrizes.

## Recomendação

O código foi escrito para ser testado na prática, para melhor experiencia recomendo executar o JAR dentro de seu Prompt de preferência. </br>
Para isso <a href="#executavel">Clique aqui</a>.

## Resolução

❓ Os Códigos abaixo foram alterados e comentados para melhorar a leitura direta, para acessar o código fonte original <a href="https://github.com/giovanifogarolli/Nuria_Backend/blob/main/src/Exercicio_Matriz.java">clique aqui</a>. </br>
    Alterações feitas: remoção das quebras de linhas e adição dos comentários

### Primeira questão

⚠️ Acredito que o enunciado possuia ambiguidade em relação a proposta, logo apresento duas soluções, sendo a primeira delas a inversão dos elementos dentro de uma diagonal. E a segunda a inversão da Diagonal principal com a Diagonal secundaria sem alterar os valores.

<details>
  <summary>Código</summary>
  
  ```java
    public void resoluçãoA(String[][] matriz){ //Recebe a Matriz criada através do programa
        String[][] n_matriz = new String[tamanho][tamanho]; //Cria uma nova matriz para ser alterada em relação a matriz original
        String[] DP = new String[tamanho]; //Cria uma variavel para armazenar a Diagonal Principal
        String[] DS = new String[tamanho]; //Cria uma variavel para armazenar a Diagonal Secundaria

        System.out.println("Resolução:");

        for(int l=0;l<tamanho;l++){
            for(int col=0;col<tamanho;col++){
                if (l == col) { // Checa valores da diagonal principal
                    DP[l] = matriz[l][col];
                    n_matriz[tamanho-l-1][tamanho-l-1] = matriz[l][col];
                }
                if(l+col == tamanho - 1){ // Checa valores da diagonal secundaria
                    DS[l] = matriz[l][col];
                    n_matriz[tamanho-l-1][tamanho-col-1] = matriz[l][col];
                }
                if(l != col && l+col != tamanho - 1){ // Checa os valores normais
                    n_matriz[l][col] = matriz[l][col];
                }
            }
        }

        System.out.println("Matriz original:"); // printa a Matriz original
        for(String n[]:matriz){
            for(String v:n){
                System.out.printf("%3s|", v);
            }
            System.out.println();
        }

        System.out.println("Matriz com valores invertidos:"); // printa a Matriz com os elementos invertidos
        for(String n[]:n_matriz){
            for(String v:n){
                System.out.printf("%3s|", v);
            }
            System.out.println();
        }

        for(int l=0;l<tamanho;l++){
            for(int col=0;col<tamanho;col++){
                if (l == col) {
                    n_matriz[l][col] = DS[l]; // inverte a diagonal principal com a secundaria
                }else if(l+col == tamanho - 1){ 
                    n_matriz[l][col] = DP[l]; // inverte a diagonal secundaria com a principal
                }
            }
        }

        System.out.println("Matriz com Diagonais trocadas:"); // printa a matriz com as diagonais trocadas
        for(String n[]:n_matriz){
            for(String v:n){
                System.out.printf("%3s|", v);
            }
            System.out.println();
        }
    }
```
</details>

### Segunda questão

<details>
  <summary>Código</summary>
  
  ```java
      public void resoluçãoB(int tA, int tB){ //Função da resolução
        int n = tA/tB;
        System.out.println("A Submatriz B pode ser encontrada " + n + " Vezes dentro da Matriz A");
    }

    public void m_tamanho(){ //Função que recebe os parametros para passar para a função
        int tamanhoA;
        int tamanhoB;
        int lA;
        int lB;
        int colA;
        int colB;

        // Recebe os valores da Matriz A e da Submatriz B

        System.out.println("Insira o numero de linhas da Matriz A: ");
        lA = Integer.parseInt(menu.nextLine());
        System.out.println("Insira o numero de colunas da Matriz A: ");
        colA = Integer.parseInt(menu.nextLine());

        System.out.println("Insira o numero de linhas da Submatriz B: ");
        lB = Integer.parseInt(menu.nextLine());
        System.out.println("Insira o numero de colunas da Submatriz B: ");
        colB = Integer.parseInt(menu.nextLine());

        // Monta o tamanho das duas

        tamanhoA = lA*colA;
        tamanhoB = lB*colB;

        // Testa se a Submatriz B é maior que a Matriz A
        
        while (tamanhoB>tamanhoA) {
            System.out.println("Submatriz B não pode ser maior que a Matriz A ");
            System.out.println("Insira o numero de linhas da Submatriz B: ");
            lB = Integer.parseInt(menu.nextLine());
            System.out.println("Insira o numero de colunas da Submatriz B: ");
            colB = Integer.parseInt(menu.nextLine());
            tamanhoB = lB*colB;
        }

        resoluçãoB(tamanhoA,tamanhoB); // Chama a função
    }
  ```
</details>

## Executavel

1. Baixe o <a href="https://github.com/giovanifogarolli/Nuria_Backend/blob/main/Matrizes.jar">arquivo JAR</a>
2. No prompt de sua preferencia:
    1. Navegue para a pasta onde o JAR se encontre
    2. Entre com a command line:

       ```
       java -jar --enable-preview Matrizes.jar
       ```
3. Siga as intruções dentro do programa
