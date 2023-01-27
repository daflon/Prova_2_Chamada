public class Livros {    
    public int codLivro, numPaginas;
    public String titulo, autor;
        
    //#region Getters e setters
    public int getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro = codLivro;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }       
    //#endregion
    
    //Não utilizado AINDA...
    public void procuraElemento(){
        for (int i=0; i==getCodLivro();  i++)
               System.out.println("Já existe");
    }
    
    @Override
    public String toString() {
        return String.format("Código: " + getCodLivro() + "\nTitulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nNúmero de páginas: " + getNumPaginas());

    }

    
}
