import java.time.LocalDate;

public class Locacao extends Livros {
    public LocalDate dataLocacao;
    public String cpfCliente;
    public LocalDate dataDevolucao;
    public boolean status = true;

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }
    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Data da locação: " + getDataLocacao() + "\nCPF: " + getCpfCliente() 
        + "\nData de devolução: " + getDataDevolucao() + "\nStatus: " + getStatus() + "\nCódigo: " + getCodLivro() + "\nTitulo: " + getTitulo() + "\nAutor: " + 
        getAutor() + "\nNúmero de páginas: "+getNumPaginas()+".");
    }
}
