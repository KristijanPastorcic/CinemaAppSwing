/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author islan
 */
public class PersonTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES
            = {"id", "First Name", "Last Name", "Movie Role"};

    private List<Person> persons;

    public PersonTableModel(List<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return persons.get(rowIndex).getId();
            case 1:
                return persons.get(rowIndex).getFirstName();
            case 2:
                return persons.get(rowIndex).getLastName();
            case 3:
                return persons.get(rowIndex).getMovieRole().toString();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

}
