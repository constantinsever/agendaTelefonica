package agenda;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;

public class client_model extends AbstractTableModel implements Serializable{

    List abonati = new ArrayList();
    boolean modified = false;

    public int getSize() {
        return abonati.size();
    }

    public void addClient(String n, String p, long c, long nr){
       abonati.add(new abonat(n,p,c,nr));
        }

    public Object getElementAt(int pos) {
        return abonati.get(pos);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
       return false; /// !!! NOT SERIALIZABLE ???
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0)
            return "Nume";
       if (column == 1)
            return "Prenume";
       if (column == 2)
            return "CNP";
       if (column == 3)
            return "Numar";
        return "";
    }

    public int getRowCount() {
        return abonati.size();
    }

    public int getColumnCount() {
        return 4;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        abonat a = (abonat)abonati.get(rowIndex);
        if (columnIndex == 0)
            a.setNume(aValue.toString());
        if (columnIndex == 1)
            a.setPrenume(aValue.toString());
        if (columnIndex == 2)
            a.setCNP(Long.parseLong(aValue.toString()));
       if (columnIndex == 3)
            a.setNrtel(Long.parseLong(aValue.toString()));

    }

    public Object getValueAt(int rowIndex, int columnIndex) {

      abonat a = (abonat)abonati.get(rowIndex);

        switch(columnIndex){
            case 0: return a.getNume();
            case 1: return a.getPrenume();
            case 2: return a.getCNP();
            case 3: return a.getNrtel(); 
        }
        return null;
    }

   

   
}
