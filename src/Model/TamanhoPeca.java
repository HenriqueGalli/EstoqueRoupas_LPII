package Model;
public enum TamanhoPeca {
    PEQUENO("P"),
    MEDIO("M"),
    GRANDE("G");

    private String tamanho;

    TamanhoPeca(String tamanho){
        this.tamanho = tamanho;
    }

    public String getTamanhoPeca(){
        return this.tamanho;
    }
}
