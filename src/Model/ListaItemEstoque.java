package Model;
import java.util.ArrayList;
import java.util.Date;

public class ListaItemEstoque {

    private static final ArrayList<ItemEstoque> itens = new ArrayList<ItemEstoque>();

    public ArrayList<ItemEstoque> getList(){
        return itens;
    }

    public int getListSize(){
        return itens.size();
    }

    public void addListaEstoque(ItemEstoque item){
        itens.add(item);
    }

    public void excludeListaEstoque(int item){
        itens.remove(item);
    }

    public void alterarValorCodigo(int item, int codigo){
        itens.get(item).setCodigoItem(codigo);
    }

    public void alterarValorData(int item, Date dataEntrada){
        itens.get(item).setDataEntrada(dataEntrada);
    }
    
    public void alterarValorLocal(int item, String localCompra){
        itens.get(item).setLocalCompra(localCompra);
    }

    public void alterarValorTipo(int item, String tipoRoupa){
        itens.get(item).setTipoRoupa(tipoRoupa);
    }

    public void alterarValorMarca(int item, String marcaRoupa){
        itens.get(item).setMarcaRoupa(marcaRoupa);
    }

    public void alterarValorCaracteristicas(int item, String caracteristicaRoupa){
        itens.get(item).setCaracteristicaRoupa(caracteristicaRoupa);
    }

    public void alterarValorTamanho(int item, Date data){
        itens.get(item).setDataEntrada(data);
    }

    public void alterarValorCor(int item, Date data){
        itens.get(item).setDataEntrada(data);
    }
    public void alterarValorEtiqueta(int item, Date data){
        itens.get(item).setDataEntrada(data);
    }
    public void alterarValorPagoCompra(int item, Date data){
        itens.get(item).setDataEntrada(data);
    }
    public void alterarValorMargem(int item, Date data){
        itens.get(item).setDataEntrada(data);
    }
    public void alterarValorPrecoSugerido(int item, Date data){
        itens.get(item).setDataEntrada(data);
    }

}
