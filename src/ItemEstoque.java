import java.util.Date;

public class ItemEstoque {
    private int codigoItem;
    private Date dataEntrada;
    private String localCompra;
    private String tipoRoupa;
    private String marcaRoupa;
    private String caracteristicaRoupa;
    private TamanhoPeca tamanhoPeca;
    private CorPeca corPeca;
    private double valorEtiqueta;
    private double valorPago;
    private double valorMargem;
    private double precoSugerido;

    public int getCodigoItem() {
        return this.codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public Date getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getLocalCompra() {
        return this.localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public String getTipoRoupa() {
        return this.tipoRoupa;
    }

    public void setTipoRoupa(String tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }

    public String getMarcaRoupa() {
        return this.marcaRoupa;
    }

    public void setMarcaRoupa(String marcaRoupa) {
        this.marcaRoupa = marcaRoupa;
    }

    public String getCaracteristicaRoupa() {
        return this.caracteristicaRoupa;
    }

    public void setCaracteristicaRoupa(String caracteristicaRoupa) {
        this.caracteristicaRoupa = caracteristicaRoupa;
    }

    public TamanhoPeca getTamanhoPeca() {
        return this.tamanhoPeca;
    }

    public void setTamanhoPeca(TamanhoPeca tamanhoPeca) {
        this.tamanhoPeca = tamanhoPeca;
    }

    public CorPeca getCorPeca() {
        return this.corPeca;
    }

    public void setCorPeca(CorPeca corPeca) {
        this.corPeca = corPeca;
    }

    public double getValorEtiqueta() {
        return this.valorEtiqueta;
    }

    public void setValorEtiqueta(double valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorMargem() {
        return this.valorMargem;
    }

    public void setValorMargem(double valorMargem) {
        this.valorMargem = valorMargem;
    }

    public double getPrecoSugerido() {
        return this.precoSugerido;
    }

    public void setPrecoSugerido(double precoSugerido) {
        this.precoSugerido = precoSugerido;
    }

}
