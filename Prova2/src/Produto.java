public class Produto {
    public int codigoproduto, qtdestoque, preco;
    public String nome;
    int a[];
    
    public int getCodigoproduto() {
        return codigoproduto;
    }
    public void setCodigoproduto(int codigoproduto) {
        this.codigoproduto = codigoproduto;
    }
    public int getQtdestoque() {
        return qtdestoque;
    }
    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }
    public int getPreco() {
        return preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public void procuraElemento(){
        for (int i=0; i==getCodigoproduto();  i++)
               System.out.println("Já existe");
    }
    

    @Override
    public String toString() {
        return String.format("Nome: "+getNome()+"\nQuantidade em estoque: "+getCodigoproduto()+".");
    }
    
}
