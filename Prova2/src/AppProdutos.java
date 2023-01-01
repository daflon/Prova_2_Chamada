import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AppProdutos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        Scanner in = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produtos");
            System.out.println("3 - Listar produtos cadastrados");
            System.out.println("4 - Vendas por periodo");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior
           //1 Primeira verificação: Verificar se existe um produto com o codigo igual ao fornecido pelo usuario(Fazer uma busca). 
                   
            if (opcao == 1) {
                if (opcao == 1) {
                    Produto p = new Produto();
                    System.out.println("Digite o codigo do produto");
                    try{
                        p.setCodigoproduto(in.nextInt());    
                        in.nextLine();
                    }catch(InputMismatchException e ){
                        System.out.println("O codigo devem ser apenas numeros.");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }

                  //2 Segunda verificação: Verificar se o codigo digitado é inteiro (Tratar a excessão com try/cat)
                     boolean produto_existente = false;    
                       
                    for (Produto produto : produtos) {
                        if(p.getCodigoproduto() == produto.getCodigoproduto()){
                          System.out.println("Produto já cadastrado.");
                          produto_existente=true;    
                       }
                          
                    }   
                    if(produto_existente){
                        voltarMenu(in);
                        continue;
                    }             
                    System.out.println("Nome do produto: ");
                    p.setNome(in.nextLine());
                   
                    try{
                        System.out.println("Quantidade em estoque: ");
                        p.setQtdestoque(in.nextInt());
                    }catch(InputMismatchException e){
                        System.out.println("Digite apenas numeros neste campo.");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }

                    if(p.getQtdestoque()<=0){
                        System.out.println("A quantidade em estoque deve ser maior que 0.");
                        voltarMenu(in);
                        in.nextLine();
                        continue;
                    }
                    // 1 Primeira verificação: garantir que a quantidade seja maior ou igual a 0
                    // 2 Segunda verificação: igual a verificação de cima
                   try{
                      System.out.println("Preço do produto: ");
                        p.setPreco(in.nextInt());
                    }catch(InputMismatchException e){
                        System.out.println("Digite um valor valido.");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                   }
                    if(p.getPreco()<=0){
                        System.out.println("O preço deve ser maior que 0.");
                        voltarMenu(in);
                        continue;
                    }
                    // 1 Primeira verificação: garantir que a preço seja maior a 0
                    // 2 Segunda verificação: igual a verificação de cima
                    produtos.add(p);
                    voltarMenu(in);
                    continue;
                }

                
                
            } else if (opcao == 2) {
                
                if (produtos.size() == 0){
                    System.out.println("Não existem produtos a serem buscados.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("Digite o codigo do produto desejado: ");
                int escolha = in.nextInt();
                in.nextLine();

                for (Produto produto : produtos) {
                    if(escolha == produto.getCodigoproduto()){
                        System.out.println("Produto encontrado");
                        System.out.println(produto);
                        voltarMenu(in);
                    }
                    else{
                        System.out.println("Nenhum produto encontrado.");
                    }
                }
                //Retornar "Nenhum produto encontrado" caso a escolha seja nenhum codigo dos produtos cadastrados
                voltarMenu(in);
            
            } else if (opcao == 3) {
                //Se a lista estiver vazia não há o que procurar.

                if (produtos.size() == 0){
                    System.out.println("Não existem produtos a serem listados.");
                    voltarMenu(in);
                    continue;
                }
                //Ordenar pelo nome: usando o metodo sort separado ou na stream
                //Adequar a listagem ao anunciado da prova(Pode ser da quantidade em estoque ou do preço do produto)
        
                produtos.forEach(System.out::println);
               
                voltarMenu(in);

            } else if (opcao == 4) {
                
            }
            else if (opcao == 5){
                //Primeira verificar se existem produtos na lista de produtos
                //Pedir codigo do produto ao usuario  
                //Segunda verificar se o codigo fornecido pelo usuario está contido na lista de produtos
                
                Venda v = new Venda();
                Produto p = new Produto();
                System.out.println("Digite o codigo do produto que deseja vender:   ");
                int codigo = in.nextInt();
                in.nextLine();
                Produto produto_buscado = busca(produtos, codigo);
                if(produto_buscado!=null){
                    System.out.println("Produto encontrado");
                    v.setProdutovendido(produto_buscado);
                }else{
                    System.out.println("Produto não encontrado");
                    voltarMenu(in);
                    continue;
                }
                
                //Pedir a quantidade a ser vendida
                //Verificar se a quantidade é maior que 0
                int compra_produto=0;
                try{
                    System.out.println("Digite a quantidade a ser comprada: ");
                    compra_produto = in.nextInt();
                    in.nextLine();

                }catch(InputMismatchException e){
                    System.out.println("Digite uma quantidade valida!");
                    voltarMenu(in);
                    in.nextLine();
                    
                }

                //verificar se a quantidade a ser vendida é menor que a quantidade em estoque do produto
                if(compra_produto>p.getQtdestoque()){
                    System.out.println("Realizando compra.");
                }else{
                    System.out.println("Quantidade em estoque não disponivel.");
                    voltarMenu(in);
                    continue;
                }
                
                
                //Fazer a baixa do estoque  

                try{
                    System.out.println("Digite data: ");
                    String datav = in.nextLine();
                    v.setDatavenda(LocalDate.parse(datav));
                    vendas.add(v);
                    v.setQuantidadevendida(compra_produto);
                }catch(InputMismatchException e){
                    System.out.println("Digite uma data valida.");
                    voltarMenu(in);
                    continue;
                }

            
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();    
        else
            System.out.print("\033[H\033[2J");
            
        System.out.flush();
    }
    public static Produto busca(List<Produto> produtos,int codigo){
        for (Produto produto : produtos) {
            if(codigo == produto.getCodigoproduto()){
             return produto; 
           }
        } 
        return null;
    }
}