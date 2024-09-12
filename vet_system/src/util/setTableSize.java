package util;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class setTableSize {
	
	
	/*
	public static void autoAdjustColumnWidths(JTable table, int maxWidth) {
	for(int column = 0; column< table.getColumnCount(); column++) {
	int width = 10;
	for(int row=0; row<table.getRowCount();row++)
	{
			TableCellRenderer renderer= table.getCellRenderer(row, column);
			Component comp = table.prepareRenderer(renderer, row, column);
			width = Math.max(comp.getPreferredSize().width+1, width);
			}
	if(width > maxWidth) {
		width = maxWidth;
	}
	table.getColumnModel().getColumn(column).setPreferredWidth(width);
	}
	}*/
	
	
	public static void adjustColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            adjustColumnWidth(table, column);
        }
    }
	private static void adjustColumnWidth(JTable table, int column) {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        int preferredWidth = tableColumn.getMinWidth();
        int maxWidth = tableColumn.getMaxWidth();

        // 計算標題的寬度
        TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
        Component headerComponent = headerRenderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, column);
        int headerWidth = headerComponent.getPreferredSize().width;
        preferredWidth = Math.max(preferredWidth, headerWidth);

        // 計算每個單元格的寬度
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
            Component component = table.prepareRenderer(cellRenderer, row, column);
            int cellWidth = component.getPreferredSize().width;
            preferredWidth = Math.max(preferredWidth, cellWidth);

            // 如果寬度超過最大寬度，就設置為最大寬度
            if (preferredWidth >= maxWidth) {
                preferredWidth = maxWidth;
                break;
            }
        }

        // 設置列的寬度
        tableColumn.setPreferredWidth(preferredWidth);
    }


	public static void setTableFont(JTable table)
	{
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("微軟正黑體", Font.BOLD,20));
		table.setRowHeight(30);
	}
}
