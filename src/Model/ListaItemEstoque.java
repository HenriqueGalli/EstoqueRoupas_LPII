package Model;
import java.util.ArrayList;

public class ListaItemEstoque {

    private static final ArrayList<ItemEstoque> itens = new ArrayList<ItemEstoque>();

    public ArrayList<ItemEstoque> getList(){
        return itens;
    }

    public int getListSize(){
        return itens.size();
    }

    public void addTarefa(ItemEstoque item){
        itens.add(item);
    }

    public void excludeTarefa(ItemEstoque item){
        itens.remove(item);
    }
}
