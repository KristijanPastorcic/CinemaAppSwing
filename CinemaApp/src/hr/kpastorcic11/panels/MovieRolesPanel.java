/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.kpastorcic11.panels;

import hr.algebra.utilities.IconUtils;
import hr.algebra.utilities.MessageUtils;
import hr.kpastorcic11.factories.RepositoryFactory;
import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.Person;
import hr.kpastorcic11.models.PersonTableModel;
import hr.kpastorcic11.repositories.interfaces.PersonsRepository;
import hr.kpastorcic11.roles.enums.MovieRole;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author islan
 */
public class MovieRolesPanel extends javax.swing.JPanel {

    private static final String ERROR = "Error";
    private static final String EMPTY_STRING = "";
    private final ImageIcon DEFAULT_IMAGE
            = new ImageIcon(getClass().getResource("/assets/no_image.jpeg"));

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private PersonTableModel personTableModel;
    private PersonsRepository personsRepository;
    private List<Movie> movies;

    private Optional<Person> person = Optional.empty();

    public MovieRolesPanel() {
        initComponents();
        init();
    }

    private void init() {
        personsRepository = RepositoryFactory.getPersonsRepository();
        initValidation();
        try {
            personTableModel = new PersonTableModel(personsRepository.getPersons());
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't load persons to table");
            Logger.getLogger(MovieRolesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        setupComboBoxMoveRoles();
        setupPersonsTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        lbMovieRoleError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        lbLastNameError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMovieRoles = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPersons = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        tfSerch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsMovies = new javax.swing.JList<>();
        lbPoster = new javax.swing.JLabel();
        lbFirstNameError = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("First name:");

        lbMovieRoleError.setForeground(java.awt.Color.red);

        jLabel3.setText("Last name:");

        lbLastNameError.setForeground(java.awt.Color.red);

        jLabel5.setText("Movie role:");

        cbMovieRoles.setName(""); // NOI18N

        tbPersons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPersons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPersonsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPersons);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setEnabled(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setBackground(java.awt.Color.red);
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tfSerch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSerchKeyReleased(evt);
            }
        });

        jLabel4.setText("Serch Person by first name:");

        lsMovies.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lsMoviesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lsMovies);

        lbPoster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.jpeg"))); // NOI18N

        lbFirstNameError.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbFirstNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbMovieRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbMovieRoleError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLastNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(lbPoster))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMovieRoleError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfFirstName)
                            .addComponent(lbFirstNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbLastNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfLastName))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnClear))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMovieRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfSerch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lbPoster)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (!formValid()) {
            return;
        }
        try {
            Person p = new Person();
            p.setFirstName(tfFirstName.getText().trim());
            p.setLastName(tfLastName.getText().trim());
            p.setMovieRole((MovieRole) cbMovieRoles.getSelectedItem());

            personsRepository.createPerson(p);
            reloadPersonTable();
            clearForm();
            MessageUtils.showInformationMessage("Info", "New person created");
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't create movie");
            Logger.getLogger(MovieRolesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (formValid() == false) {
            return;
        }
        try {
            Person p = person.get();
            p.setFirstName(tfFirstName.getText().trim());
            p.setLastName(tfLastName.getText().trim());
            p.setMovieRole((MovieRole) cbMovieRoles.getSelectedItem());

            personsRepository.updatePerson(p);
            reloadPersonTable();
            clearForm();
            MessageUtils.showInformationMessage("Info", "Person updated");
        } catch (Exception ex) {
            MessageUtils.showInformationMessage("Info", "Person can't be updated");
            Logger.getLogger(MovieRolesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (MessageUtils.showConfirmDialog("Delete", "Confirm delete of "
                    + person.get().toString()) == JOptionPane.YES_OPTION) {
                personsRepository.deletePerson(person.get().getId());
                reloadPersonTable();
                clearForm();
            }
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't delete movie");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tbPersonsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonsMouseClicked
        errorLabels.forEach(l -> l.setText(""));
        lbMovieRoleError.setText("");
        try {
            int selectedRowIndex = tbPersons.getSelectedRow();
            int rowIndex = tbPersons.convertRowIndexToModel(selectedRowIndex);
            int id = (int) personTableModel.getValueAt(rowIndex, 0);
            Optional<Person> person = personsRepository.getPerson(id);
            if (person.isPresent()) {
                this.person = person;
                fillForm(this.person.get());
            }

        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't get movie and fill form");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        enableButtons();
    }//GEN-LAST:event_tbPersonsMouseClicked

    private void tfSerchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSerchKeyReleased
        try {
            System.out.println(evt.getKeyCode());
            reloadPersonTable();
        } catch (Exception ex) {
            Logger.getLogger(MovieRolesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfSerchKeyReleased

    private void lsMoviesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lsMoviesValueChanged
        Movie movie = lsMovies.getSelectedValue();
        if (movie != null) {
            try {
                Icon icon;
                icon = IconUtils.getIcon(new File(movie.getPosterPicturePath()),
                        lbPoster.getWidth(), lbPoster.getHeight());
                lbPoster.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(MovieRolesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lsMoviesValueChanged

//<editor-fold defaultstate="collapsed" desc="generated fields">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<MovieRole> cbMovieRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbFirstNameError;
    private javax.swing.JLabel lbLastNameError;
    private javax.swing.JLabel lbMovieRoleError;
    private javax.swing.JLabel lbPoster;
    private javax.swing.JList<Movie> lsMovies;
    private javax.swing.JTable tbPersons;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfSerch;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    public void reloadPersonTable() throws Exception {
        personTableModel.setPersons(
                personsRepository.getPersons().stream()
                        .filter(this::testPerson)
                        .collect(Collectors.toList())
        );
    }

    private boolean testPerson(Person person) {
        boolean test = true;
        if (!tfSerch.getText().trim().toLowerCase().isEmpty()) {
            test &= person.getFirstName()
                    .toLowerCase()
                    .startsWith(tfSerch.getText().toLowerCase());
        }
        return test;
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfFirstName, tfLastName);
        errorLabels = Arrays.asList(lbFirstNameError, lbLastNameError);
    }

    private void setupPersonsTable() {
        tbPersons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbPersons.setAutoCreateRowSorter(true);
        tbPersons.setRowHeight(25);
        tbPersons.setModel(personTableModel);
    }

    private void setupComboBoxMoveRoles() {
        DefaultComboBoxModel<MovieRole> gradesComboBoxModel = new DefaultComboBoxModel<>();
        Arrays.asList(MovieRole.values()).forEach(gradesComboBoxModel::addElement);
        cbMovieRoles.setModel(gradesComboBoxModel);
        cbMovieRoles.setSelectedItem(null);
    }

    public void LoadMoviesListModel() {
        try {
            DefaultListModel<Movie> moviesListModel = new DefaultListModel<>();
            List<Movie> movies = personsRepository.getMovies(person.get().getId());
            movies.forEach(moviesListModel::addElement);
            lsMovies.setModel(moviesListModel);
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't load movies");
            Logger.getLogger(MovieRolesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enableButtons() {
        if (tbPersons.isRowSelected(tbPersons.getSelectedRow())) {
            btnClear.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnCreate.setEnabled(false);
        } else {
            btnClear.setEnabled(false);
            btnDelete.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnCreate.setEnabled(true);
        }
    }

    private void fillForm(Person person) {
        tfFirstName.setText(person.getFirstName());
        tfLastName.setText(person.getLastName());
        cbMovieRoles.setSelectedItem(person.getMovieRole());
        LoadMoviesListModel();
    }

    private void clearForm() {
        tfFirstName.setText(EMPTY_STRING);
        tfLastName.setText(EMPTY_STRING);
        cbMovieRoles.setSelectedItem(null);
        tbPersons.clearSelection();
        lsMovies.setModel(new DefaultListModel<>());
        enableButtons();
        tfSerch.setText(EMPTY_STRING);
    }

    private boolean formValid() {
        boolean formValid = true;
        boolean fieldValid;
        for (int i = 0; i < validationFields.size(); i++) {
            formValid &= fieldValid = !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(fieldValid ? "" : "X");
        }
        if (cbMovieRoles.getSelectedItem() == null) {
            formValid = false;
            lbMovieRoleError.setText("X");
        } else {
            lbMovieRoleError.setText("");
        }
        if (formValid == false) {
            MessageUtils.showInformationMessage("Info", "Fix marked fields with red X");
        }

        return formValid;
    }
}
