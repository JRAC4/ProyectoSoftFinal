package utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Colorear_Tablas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col1) {

        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col1);

        if (row % 2 != 0) {
            setBackground(Color.decode("#F5F5F5"));
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.white);
            setForeground(Color.BLACK);
        }
        if (Selected == true) {
            setBackground(Color.decode("#E3F2FD"));
            setForeground(Color.BLACK);
        }
        return this;

    }

}
