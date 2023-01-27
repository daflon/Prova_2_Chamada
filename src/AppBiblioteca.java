import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AppBiblioteca {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        Scanner in = new Scanner(System.in);
        ArrayList<Livros> livros = new ArrayList<>();
        ArrayList<Locacao> locacao = new ArrayList<>();
        Locacao lo = new Locacao();

        do {
            System.out.println("\nBem vindo ao sistema de Biblioteca\n");
            System.out.println("Selecione a opção desejada\n");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Consultar livros");
            System.out.println("3 - Listar todos os livros");
            System.out.println("4 - Realizar locação");
            System.out.println("5 - Realizar devolução");
            System.out.println("6 - Relatório de livros com devolução em aberto");
            System.out.println("7 - Relatório de livros alugados por período");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior
           //1 Primeira verificação: Verificar se existe um produto com o codigo igual ao fornecido pelo usuario(Fazer uma busca). 
            
           //#region Opção 1 - Cadastrar livro
            if (opcao == 1) {
                if (opcao == 1) {
                    Livros l = new Livros();
                    System.out.println("Informe o código do livro");
                    try{
                        l.setCodLivro(in.nextInt());    
                        in.nextLine();
                    }catch(InputMismatchException e ){
                        System.out.println("O codigo deve conter apenas numeros.");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }

                  //Verifica se livro já existe.
                     boolean produto_existente = false;    
                       
                    for (Livros produto : livros) {
                        if(l.getCodLivro() == produto.getCodLivro()){
                          System.out.println("Livro já cadastrado.");
                          produto_existente=true;    
                       }
                          
                    }   
                    if(produto_existente){
                        voltarMenu(in);
                        continue;
                    }             

                    // Título
                    System.out.println("Informe título do livro: ");
                    l.setTitulo(in.nextLine());

                    // Autor
                    System.out.println("Informe autor do livro: ");
                    l.setAutor(in.nextLine());
                                                          
                    //Quantidade de página
                    try{
                        System.out.println("Informe o número de páginas: ");
                        l.setNumPaginas(in.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Para páginas, apenas números.");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }

                    if (l.getNumPaginas() < 1) {
                        System.out.println("O número de páginas deve ser maior que 0.");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }
                                        
                    livros.add(l);
                    voltarMenu(in);
                    continue;
                }
            //#endregion
            
            //#region Opção 2 - Consultar livro
            } else if (opcao == 2) {
                
                if (livros.size() == 0){
                    System.out.println("Não existem livros cadastrados.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("Informa o código do livro: ");
                int escolha = in.nextInt();
                in.nextLine();

                for (Livros livro : livros) {
                    if(escolha == livro.getCodLivro()){
                        System.out.println("Livro encontrado");
                        System.out.println(livro);
                        voltarMenu(in);
                    }
                    else{
                        System.out.println("Nenhum livro encontrado com o código informado.");
                    }
                }
                //Retornar "Nenhum produto encontrado" caso a escolha seja nenhum codigo dos produtos cadastrados
                //voltarMenu(in);
            //#endregion

            //#region Opção 3 - Listar todos livros
            } else if (opcao == 3) {
                //Se a lista estiver vazia não há o que procurar.

                if (livros.size() == 0){
                    System.out.println("Não existem livros a serem listados.");
                    voltarMenu(in);
                    continue;
                }
                //Ordenar pelo nome: usando o metodo sort separado ou na stream
                //Adequar a listagem ao anunciado da prova(Pode ser da quantidade em estoque ou do preço do produto)
        
                livros.forEach(System.out::println);
                System.out.println("\n************Locações************\n");
                locacao.forEach(System.out::println);
               
                voltarMenu(in);          
            } 
             //#endregion
            
            //#region Opção 4 - Realizar locação
            
            else if (opcao == 4) {                              
                System.out.println("Informe a data da locação: ");
                //lo.setDataLocacao(in.LocalDate);
                System.out.println("Informe a data de devolução: ");
                //lo.setDataDevolucao(in.LocalDate);
                System.out.println("Informe CPF do locatário: ");
                lo.setCpfCliente(in.nextLine());                
                System.out.println("Informe o código do livro que deseja locar: ");
                int loc = in.nextInt();
                
                for (Livros livro : livros) {
                    if(loc == livro.getCodLivro()){                        
                        System.out.printf("O "+livro+", é o titulo desejado?");
                        System.out.println("\n1 - SIM\n2 - NÃO");
                        int escolha = in.nextInt();
                        if (escolha == 1) {
                            lo.setStatus(false);
                            locacao.add(lo);
                        }
                        else {
                            System.out.println("Voltando ao menu.");
                        }
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }
                    else{
                        System.out.println("Nenhum livro encontrado com o código informado.");
                    }
                }
            
            }
            //#endregion

            //#region Opção 5 - Realizar devolução
            else if (opcao == 5) {                              
                System.out.println("Informe o código do livro que deseja devolver: ");
                int loc = in.nextInt();
                
                for (Livros livro : livros) {
                    if(loc == livro.getCodLivro()){                        
                        System.out.printf("O "+livro+", é o titulo desejado?");
                        System.out.println("\n1 - SIM\n2 - NÃO");
                        int escolha = in.nextInt();
                        if (escolha == 1) {
                            lo.setStatus(true);
                            locacao.add(lo);
                        }
                        else {
                            System.out.println("Voltando ao menu.");
                        }
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }
                    else{
                        System.out.println("Nenhum livro encontrado com o código informado.");
                    }
                }
            
            }
            //#endregion
            
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
    public static Livros busca(List<Livros> produtos,int codigo){
        for (Livros produto : produtos) {
            if(codigo == produto.getCodLivro()){
             return produto; 
           }
        } 
        return null;
    }
}