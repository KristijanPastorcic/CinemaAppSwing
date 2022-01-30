/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.kpastorcic11.panels;

import hr.algebra.utilities.FileUtils;
import hr.algebra.utilities.IconUtils;
import hr.algebra.utilities.MessageUtils;
import hr.kpastorcic11.factories.RepositoryFactory;
import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.MovieTableModel;
import hr.kpastorcic11.models.Person;
import hr.kpastorcic11.models.PersonTransferable;
import hr.kpastorcic11.repositories.interfaces.MoviesRepository;
import hr.kpastorcic11.roles.enums.MovieRole;
import java.awt.Desktop;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY;

/**
 *
 * @author islan
 */
public class MoviePanel extends javax.swing.JPanel {

    MoviesRepository moviesRepository;

    private static final String ERROR = "Error";
    private static final String EMPTY_STRING = "";
    private final ImageIcon DEFAULT_IMAGE
            = new ImageIcon(getClass().getResource("/assets/no_image.jpeg"));

    private List<JTextField> validationFields;
    private List<JLabel> errorLabels;

    private List<Person> allActors;
    private Set<Person> acctorsSet;
    private final DefaultListModel<Person> actorsModel = new DefaultListModel<>();
    private final DefaultListModel<Person> allActorsModel = new DefaultListModel<>();

    private List<Person> allDirectors;
    private Set<Person> directorsSet;
    private final DefaultListModel<Person> directorsModel = new DefaultListModel<>();
    private final DefaultListModel<Person> alldirectorsModel = new DefaultListModel<>();

    private MovieTableModel movieTableModel;

    private Optional<Movie> movie = Optional.empty();

    public MoviePanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();
        lbPoster = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbTitleError = new javax.swing.JLabel();
        tfPubDateTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbPubDateTimeError = new javax.swing.JLabel();
        tfDuration = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbDurationError = new javax.swing.JLabel();
        tfGenre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbGenreError = new javax.swing.JLabel();
        tfInTheatars = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbInTheatersError = new javax.swing.JLabel();
        tfPicturePath = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsAllActors = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lsActors = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbLink = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsAllDirectors = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        lsDirectors = new javax.swing.JList<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnChoose = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovies);

        lbPoster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.jpeg"))); // NOI18N

        jLabel1.setText("Title");

        lbTitleError.setForeground(java.awt.Color.red);

        tfPubDateTime.setText("yyyy-MM-ddThh:mm:ss");
        tfPubDateTime.setName("pubDateTime"); // NOI18N

        jLabel3.setText("Published date");

        lbPubDateTimeError.setForeground(java.awt.Color.red);

        tfDuration.setName("duration"); // NOI18N

        jLabel5.setText("Duration");

        lbDurationError.setForeground(java.awt.Color.red);

        tfGenre.setName(""); // NOI18N

        jLabel7.setText("Genre");

        lbGenreError.setForeground(java.awt.Color.red);

        tfInTheatars.setName("inDate"); // NOI18N

        jLabel9.setText("In Theatres");

        lbInTheatersError.setForeground(java.awt.Color.red);

        tfPicturePath.setEditable(false);
        tfPicturePath.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setText("Picture path:");

        jScrollPane2.setMaximumSize(new java.awt.Dimension(278, 113));

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        jLabel13.setText("Description:");

        jScrollPane3.setViewportView(lsAllActors);

        lsActors.setToolTipText("Select and press delete to delete actor");
        lsActors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lsActorsKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(lsActors);

        jLabel14.setText("Actors:");

        jLabel15.setText("All actors:");

        jLabel16.setText("Link:");

        lbLink.setForeground(java.awt.Color.blue);
        lbLink.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLinkMouseEntered(evt);
            }
        });

        jScrollPane5.setViewportView(lsAllDirectors);

        lsDirectors.setToolTipText("Select and press delete to delete director");
        lsDirectors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lsDirectorsKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(lsDirectors);

        jLabel17.setText("Directors:");

        jLabel18.setText("All directors:");

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

        btnClearForm.setText("Clear Form");
        btnClearForm.setEnabled(false);
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        btnDelete.setBackground(java.awt.Color.red);
        btnDelete.setForeground(java.awt.Color.white);
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbDurationError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbGenreError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfInTheatars, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbInTheatersError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfPubDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbPubDateTimeError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel15)
                                        .addGap(93, 93, 93))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnClearForm, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(95, 95, 95))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(21, 21, 21))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnChoose)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addComponent(lbPoster))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLink, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(lbLink, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearForm)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbTitleError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfTitle, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbPubDateTimeError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfPubDateTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbDurationError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfDuration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbGenreError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfGenre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbInTheatersError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfInTheatars, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfPicturePath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnChoose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addComponent(lbPoster, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (!formValid()) {
            return;
        }
        try {
            Movie m = new Movie();
            m.setTitle(tfTitle.getText().trim());
            m.setPublishedDateTime(LocalDateTime
                    .parse(tfPubDateTime.getText().trim(), Movie.DATE_TIME_FORMATTER));
            m.setDuration(Integer.parseInt(tfDuration.getText().trim()));
            m.setGenre(tfGenre.getText().trim());
            m.setInTheaters(LocalDate
                    .parse(tfInTheatars.getText().trim(), Movie.DATE_FORMAT));
            m.setPosterPicturePath(tfPicturePath.getText());
            m.setDescription(taDescription.getText().trim());

            m.setActors(new ArrayList<>(acctorsSet));
            m.setDirectors(new ArrayList<>(directorsSet));

            moviesRepository.createMovie(m);
            movieTableModel.setMovies(moviesRepository.getMovies());
            clearForm();
            MessageUtils.showInformationMessage("Info", "New movie created!");
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't create movie");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!formValid()) {
            return;
        }
        try {
            Movie m = movie.get();
            m.setTitle(tfTitle.getText().trim());
            m.setPublishedDateTime(LocalDateTime
                    .parse(tfPubDateTime.getText().trim(), Movie.DATE_TIME_FORMATTER));
            m.setDuration(Integer.parseInt(tfDuration.getText().trim()));
            m.setGenre(tfGenre.getText().trim());
            m.setInTheaters(LocalDate
                    .parse(tfInTheatars.getText().trim(), Movie.DATE_FORMAT));
            m.setPosterPicturePath(tfPicturePath.getText());
            m.setDescription(taDescription.getText().trim());

            m.setActors(new ArrayList<>(acctorsSet));
            m.setDirectors(new ArrayList<>(directorsSet));

            moviesRepository.updateMovie(movie.get());
            movieTableModel.setMovies(moviesRepository.getMovies());
            clearForm();
            MessageUtils.showInformationMessage("Info", "Movie updated!");
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't update movie");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (MessageUtils.showConfirmDialog("Delete", "Confirm delete of "
                    + movie.get().getTitle()) == JOptionPane.YES_OPTION) {
                moviesRepository.deleteMovie(movie.get());
                movieTableModel.setMovies(moviesRepository.getMovies());
                clearForm();
            }
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't delete movie");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        errorLabels.forEach(l -> l.setText(""));
        try {
            int selectedRowIndex = tbMovies.getSelectedRow();
            int rowIndex = tbMovies.convertRowIndexToModel(selectedRowIndex);
            int id = (int) movieTableModel.getValueAt(rowIndex, 0);
            Optional<Movie> movie = moviesRepository.getMovie(id);
            if (movie.isPresent()) {
                this.movie = movie;
                acctorsSet = new TreeSet<>(movie.get().getActors());
                directorsSet = new TreeSet<>(movie.get().getDirectors());
                fillForm(this.movie.get());
                loadActorsListModel();
                loadDirectorsListModel();
            }

        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't get movie and fill form");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        enableButtons();
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void lbLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinkMouseEntered
        if (tbMovies.isRowSelected(tbMovies.getSelectedRow()))
            lbLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        else
            lbLink.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lbLinkMouseEntered

    private void lbLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinkMouseClicked
        if (movie.isPresent()) {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(movie.get().getLink()));
                } catch (Exception e) {
                    MessageUtils.showErrorMessage("Error", "Can't open link");
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_lbLinkMouseClicked

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        Optional<File> file = FileUtils.uploadFile("image", "jpg", "jpeg", "png");
        if (file.isPresent() == false) {
            return;
        }
        try {
            Icon icon = IconUtils.getIcon(file.get(), lbPoster.getWidth(), lbPoster.getHeight());
            lbPoster.setIcon(icon);
            tfPicturePath.setText(file.get().getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage(ERROR, "Unable to upload picture");
        }
    }//GEN-LAST:event_btnChooseActionPerformed

    private void lsActorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lsActorsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            Person selectedValue = lsActors.getSelectedValue();
            if (selectedValue != null) {
                acctorsSet.remove(selectedValue);
                loadActorsListModel();
            }
        }
    }//GEN-LAST:event_lsActorsKeyReleased

    private void lsDirectorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lsDirectorsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            Person selectedValue = lsDirectors.getSelectedValue();
            if (selectedValue != null) {
                directorsSet.remove(selectedValue);
                loadDirectorsListModel();
            }
        }
    }//GEN-LAST:event_lsDirectorsKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    //<editor-fold defaultstate="collapsed" desc="generated fields">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbDurationError;
    private javax.swing.JLabel lbGenreError;
    private javax.swing.JLabel lbInTheatersError;
    private javax.swing.JLabel lbLink;
    private javax.swing.JLabel lbPoster;
    private javax.swing.JLabel lbPubDateTimeError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JList<Person> lsActors;
    private javax.swing.JList<Person> lsAllActors;
    private javax.swing.JList<Person> lsAllDirectors;
    private javax.swing.JList<Person> lsDirectors;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfDuration;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfInTheatars;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfPubDateTime;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

//</editor-fold>
    private void init() {
        moviesRepository = RepositoryFactory.getMoviesRepository();
        validationFields = Arrays.asList(tfTitle, tfPubDateTime, tfDuration, tfGenre, tfInTheatars);
        errorLabels = Arrays.asList(lbTitleError, lbPubDateTimeError, lbDurationError, lbGenreError, lbInTheatersError);
        try {
            movieTableModel = new MovieTableModel(moviesRepository.getMovies());
            allActors = moviesRepository.getMovieRolePersonssss(MovieRole.ACTOR);
            allDirectors = moviesRepository.getMovieRolePersonssss(MovieRole.DIRECTOR);
            setupMovieTable();
        } catch (Exception ex) {
            MessageUtils.showErrorMessage(ERROR, "Can't get movies");
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        intiDragNDrop();
        loadAllActorsListModel();
        loadAllDirectorsListModel();
        setupNewMovie();
    }

    private void enableButtons() {
        if (tbMovies.isRowSelected(tbMovies.getSelectedRow())) {
            btnClearForm.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnCreate.setEnabled(false);
        } else {
            btnClearForm.setEnabled(false);
            btnDelete.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnCreate.setEnabled(true);
        }
    }

    private void setupMovieTable() {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        tbMovies.setModel(movieTableModel);
    }

    private boolean formValid() {
        boolean formValid = true;
        boolean fieldValid;
        for (int i = 0; i < validationFields.size(); i++) {
            if ("pubDateTime".equals(validationFields.get(i).getName())) {
                try {
                    LocalDateTime.parse(validationFields.get(i).getText().trim(),
                            Movie.DATE_TIME_FORMATTER);
                    errorLabels.get(i).setText("");
                } catch (Exception e) {
                    errorLabels.get(i).setText("X");
                    formValid = false;
                }
                continue;
            }
            if ("duration".equals(validationFields.get(i).getName())) {
                try {
                    Integer.parseInt(validationFields.get(i).getText().trim());
                    errorLabels.get(i).setText("");
                } catch (Exception e) {
                    errorLabels.get(i).setText("X");
                    formValid = false;
                }
                continue;
            }
            if ("inDate".equals(validationFields.get(i).getName())) {
                try {
                    LocalDate.parse(validationFields.get(i).getText().trim(),
                            Movie.DATE_FORMAT);
                    errorLabels.get(i).setText("");
                } catch (Exception e) {
                    errorLabels.get(i).setText("X");
                    formValid = false;
                }
                continue;
            }

            formValid &= fieldValid = !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(fieldValid ? "" : "X");
        }
        if (formValid == false) {
            MessageUtils.showInformationMessage("Info", "Fix marked fields with red X");
        }
        return formValid;
    }

    private void fillForm(Movie movie) {
        tfTitle.setText(movie.getTitle());
        tfPubDateTime.setText(movie.getPublishedDateTime().toString());
        taDescription.setText(movie.getDescription());
        tfDuration.setText(String.valueOf(movie.getDuration()));
        tfGenre.setText(movie.getGenre());
        lbLink.setText(movie.getLink());
        tfInTheatars.setText(movie.getInTheaters().format(Movie.DATE_FORMAT));
        tfPicturePath.setText(movie.getPosterPicturePath());
        String posterPicturePath = movie.getPosterPicturePath();
        if (posterPicturePath.equals(EMPTY_STRING)) {
            lbPoster.setIcon(DEFAULT_IMAGE);
        } else {
            setPoster(new File(movie.getPosterPicturePath()));
        }

        loadActorsListModel();
        loadDirectorsListModel();
    }

    private void clearForm() {
        setupNewMovie();
        tbMovies.clearSelection();
        lbLinkMouseEntered(null);
        validationFields.forEach(field -> field.setText(EMPTY_STRING));
        errorLabels.forEach(l -> l.setText(""));
        taDescription.setText(EMPTY_STRING);
        lbLink.setText(EMPTY_STRING);
        tfPicturePath.setText(EMPTY_STRING);
        lbPoster.setIcon(DEFAULT_IMAGE);

        lsAllActors.clearSelection();
        lsAllDirectors.clearSelection();

        loadActorsListModel();
        loadDirectorsListModel();
        enableButtons();

    }

    public void setupNewMovie() {
        movie = Optional.of(new Movie());
        acctorsSet = new TreeSet<>();
        directorsSet = new TreeSet<>();
    }

    private void setPoster(File file) {
        try {
            Icon icon = IconUtils.getIcon(file, lbPoster.getWidth(), lbPoster.getHeight());
            lbPoster.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            lbPoster.setIcon(DEFAULT_IMAGE);
            MessageUtils.showErrorMessage(ERROR, "Can't upload image.");
        }
    }

    //<editor-fold defaultstate="collapsed" desc="drag and drop">
    private void loadAllDirectorsListModel() {
        alldirectorsModel.clear();
        allDirectors.forEach(alldirectorsModel::addElement);
        lsAllDirectors.setModel(alldirectorsModel);
    }

    private void loadDirectorsListModel() {
        directorsModel.clear();
        if (movie.isPresent()) {
            directorsSet.forEach(directorsModel::addElement);
            lsDirectors.setModel(directorsModel);
        }
    }

    private void loadAllActorsListModel() {
        allActorsModel.clear();
        allActors.forEach(allActorsModel::addElement);
        lsAllActors.setModel(allActorsModel);
    }

    private void loadActorsListModel() {
        actorsModel.clear();
        if (movie.isPresent()) {
            acctorsSet.forEach(actorsModel::addElement);
            lsActors.setModel(actorsModel);
        }
    }

    private void intiDragNDrop() {
        lsAllActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllActors.setDragEnabled(true);
        lsAllActors.setTransferHandler(new ActorsExportHandler());

        lsActors.setDropMode(DropMode.ON);
        lsActors.setTransferHandler(new ActorsImportHandler());

        lsAllDirectors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllDirectors.setDragEnabled(true);
        lsAllDirectors.setTransferHandler(new DirectorsExportHandler());

        lsDirectors.setDropMode(DropMode.ON);
        lsDirectors.setTransferHandler(new DirectorsImportHandler());
    }

    private class ActorsExportHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new PersonTransferable(lsAllActors.getSelectedValue());
        }

    }

    private class ActorsImportHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(PersonTransferable.PERSON_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {

            Transferable transferable = support.getTransferable();
            try {
                Person data = (Person) transferable.getTransferData(PersonTransferable.PERSON_FLAVOR);
                if (acctorsSet.add(data)) { // set adds if autor is unique and returns true
                    loadActorsListModel();
                    return true;
                }
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        }

    }

    private class DirectorsExportHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new PersonTransferable(lsAllDirectors.getSelectedValue());
        }

    }

    private class DirectorsImportHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(PersonTransferable.PERSON_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {

            Transferable transferable = support.getTransferable();
            try {
                Person data = (Person) transferable.getTransferData(PersonTransferable.PERSON_FLAVOR);
                if (directorsSet.add(data)) { // set adds if autor is unique and returns true
                    loadDirectorsListModel();
                    return true;
                }
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        }

    }
    //</editor-fold>
}
