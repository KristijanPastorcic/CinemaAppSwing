/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.models;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author islan
 */
public class PersonTransferable implements Transferable {

    public static final DataFlavor PERSON_FLAVOR = new DataFlavor(Person.class, "Person");
    private static final DataFlavor[] SUPORTED_FLAVORS = {PERSON_FLAVOR};

    private final Person person;

    public PersonTransferable(Person person) {
        this.person = person;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(PERSON_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return person;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
