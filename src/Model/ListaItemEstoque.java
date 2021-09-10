package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListaItemEstoque {

    private static final ArrayList<ItemEstoque> itens = new ArrayList<ItemEstoque>();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public ArrayList<ItemEstoque> getList() {
        return itens;
    }

    public int getListSize() {
        return itens.size();
    }

    public void addListaEstoque(ItemEstoque item) {
        itens.add(item);
    }

    public void excludeListaEstoque(int item) {
        itens.remove(item);
    }

    public void salvarArquivo() throws IOException {
        FileWriter arq = new FileWriter("src//Arquivo.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for (int i = 0; i < getListSize(); i++) {
            gravarArq.printf(itens.get(i).getCodigoItem() + ";");
            gravarArq.printf(formato.format(itens.get(i).getDataEntrada()) + ";");
            gravarArq.printf(itens.get(i).getLocalCompra() + ";");
            gravarArq.printf(itens.get(i).getTipoRoupa() + ";");
            gravarArq.printf(itens.get(i).getMarcaRoupa() + ";");
            gravarArq.printf(itens.get(i).getCaracteristicaRoupa() + ";");
            gravarArq.printf(itens.get(i).getTamanhoPeca() + ";");
            gravarArq.printf(itens.get(i).getCorPeca() + ";");
            gravarArq.printf(itens.get(i).getValorEtiqueta() + ";");
            gravarArq.printf(itens.get(i).getValorPago() + ";");
            gravarArq.printf(itens.get(i).getPrecoSugerido() + "\n");
        }
        arq.close();
    }

    public void lerArquivo() throws IOException, NumberFormatException, ParseException {
        try {
            FileReader arq = new FileReader("src//Arquivo.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            if (linha != null) {
                while (linha != null) {
                    String[] produto = linha.split(";");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    TamanhoPeca tamanhoPeca = lerTamanho(produto[6]);
                    CorPeca corPeca = lerCor(produto[7]);
                    ItemEstoque item = new ItemEstoque(Integer.parseInt(produto[0]), formato.parse(produto[1]),
                            produto[2], produto[3], produto[4], produto[5], tamanhoPeca, corPeca,
                            Double.parseDouble(produto[8]), Double.parseDouble(produto[9]),
                            Double.parseDouble(produto[10]));
                    addListaEstoque(item);
                    linha = lerArq.readLine();
                }
            }
        } catch (Exception e) {
            
        }

    }

    private TamanhoPeca lerTamanho(String tamanho) {
        TamanhoPeca tamanhoPeca = null;
        switch (tamanho) {
            case "PEQUENO":
                tamanhoPeca = TamanhoPeca.PEQUENO;
                break;

            case "MEDIO":
                tamanhoPeca = TamanhoPeca.MEDIO;
                break;

            case "GRANDE":
                tamanhoPeca = TamanhoPeca.GRANDE;
                break;

            default:
                break;
        }
        return tamanhoPeca;
    }

    private CorPeca lerCor(String tamanho) {
        CorPeca corPeca = null;
        switch (tamanho) {
            case "AZUL":
                corPeca = CorPeca.AZUL;
                break;

            case "BRANCA":
                corPeca = CorPeca.BRANCA;
                break;

            case "PRETA":
                corPeca = CorPeca.PRETA;
                break;

            case "LARANJA":
                corPeca = CorPeca.LARANJA;
                break;

            case "CINZA":
                corPeca = CorPeca.CINZA;
                break;

            default:
                break;
        }
        return corPeca;
    }
}
