package ru.ssau.tk.abrosimovamargo.sandbox.ui;

import ru.ssau.tk.abrosimovamargo.sandbox.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.List;

public class TabulatedFunctionWindow extends JDialog {
    List<Double> xValues = new ArrayList<>();
    List<Double> yValues = new ArrayList<>();
    AbstractTableModel tableModel = new TableModel(xValues, yValues);
    JTable table = new JTable(tableModel);
    private JLabel label = new JLabel("Введите количество точек функции:");
    private JTextField countField = new JTextField();
    private JButton inputButton = new JButton("Ок");
    private JButton createButton = new JButton("Создать табулированную функцию");
    TabulatedFunctionFactory factory;
    TabulatedFunction function;

    public static void main(TabulatedFunctionFactory factory, Consumer<? super TabulatedFunction> callback) {
        TabulatedFunctionWindow app = new TabulatedFunctionWindow(factory, callback);
        app.setVisible(true);
    }

    public TabulatedFunctionWindow(TabulatedFunctionFactory factory, Consumer<? super TabulatedFunction> callback) {
        setTitle("Массив");
        setModal(true);
        this.setBounds(300, 300, 500, 500);
        this.factory = factory;
        addButtonListeners(callback);
        compose();
        inputButton.setEnabled(false);
        createButton.setEnabled(false);
        inputButton.setFocusPainted(false);
        createButton.setFocusPainted(false);
        inputButton.setBackground(Color.cyan);
        createButton.setBackground(Color.cyan);
    }

    void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        designTable(table, tableScrollPane);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addComponent(countField)
                        .addComponent(inputButton))
                .addComponent(tableScrollPane)
                .addComponent(createButton)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label)
                        .addComponent(countField)
                        .addComponent(inputButton))
                .addComponent(tableScrollPane)
                .addComponent(createButton)
        );
    }

    public void addButtonListeners(Consumer<? super TabulatedFunction> callback) {
        addListenerForInputButton();
        addListenerForCreateButton(callback);
        addListenerForCountButton();
    }

    public void clearTable(int n) {
        for (int i = 0; i < n; i++) {
            xValues.remove(n - i - 1);
            yValues.remove(n - i - 1);
            tableModel.fireTableDataChanged();
        }
    }

    public void addListenerForInputButton() {
        inputButton.addActionListener(event -> {
            try {
                createButton.setEnabled(false);
                int count = Integer.parseInt(countField.getText());
                clearTable(tableModel.getRowCount());
                for (int i = 0; i < count; i++) {
                    xValues.add(0.);
                    yValues.add(0.);
                    tableModel.fireTableDataChanged();
                }
                if (tableModel.getRowCount() > 1) {
                    createButton.setEnabled(true);
                }
            } catch (Exception e) {
                new ErrorsWindow(this, e);
            }
        });
    }

    public void addListenerForCreateButton(Consumer<? super TabulatedFunction> callback) {
        createButton.addActionListener(event -> {
            try {
                double[] x = new double[xValues.size()];
                double[] y = new double[xValues.size()];
                x[0] = xValues.get(0);
                y[0] = yValues.get(0);
                for (int i = 1; i < xValues.size(); i++) {
                    if (xValues.get(i - 1) > xValues.get(i)) {
                        throw new ArrayIsNotSortedException();
                    }
                    x[i] = xValues.get(i);
                    y[i] = yValues.get(i);
                }
                function = factory.create(x, y);
                callback.accept(function);
                this.dispose();
            } catch (Exception e) {
                new ErrorsWindow(this, e);
            }
        });
    }

    public void addListenerForCountButton() {
        countField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChanged();
            }

            private void onChanged() {
                inputButton.setEnabled(!countField.getText().isEmpty());
            }
        });
    }

    public void designTable(JTable designedTable, JScrollPane designedPane) {
        UIManager.put("ScrollPane.thumb", new ColorUIResource(Color.BLACK));
        designedPane.setUI(new BasicScrollPaneUI());
        UIManager.put("ScrollBar.thumb", new ColorUIResource( Color.white));
        designedPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        designedPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
        designedPane.getViewport().setBackground(Color.white);  //фон панели
        designedTable.setBackground(Color.white); //фон полей таблицы
        designedTable.getTableHeader().setBackground(Color.white);
        designedTable.getTableHeader().setForeground(Color.BLACK);
        designedTable.setSelectionBackground(new Color(220, 194, 184));
        designedTable.getTableHeader().setFont(new Font("VVV", Font.BOLD, 14));
        designedPane.setBackground(new Color(235, 205, 193));
        designedPane.setForeground(Color.BLACK);
        designedPane.setViewportView(designedTable);
    }
}