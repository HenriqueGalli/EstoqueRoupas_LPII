public enum CorPeca {
    AZUL("azul"),
    BRANCA("branca"),
    PRETA("preta"),
    LARANJA("laranja"),
    CINZA("cinza");

    private String corPeca;

    CorPeca(String corPeca){
        this.corPeca = corPeca;
    }

    public String getCorPeca(){
        return this.corPeca;
    }
}
