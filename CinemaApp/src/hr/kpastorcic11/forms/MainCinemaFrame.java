/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hr.kpastorcic11.forms;


import hr.algebra.utilities.JAXBUtils;
import hr.algebra.utilities.MessageUtils;
import hr.kpastorcic11.factories.RepositoryFactory;
import hr.kpastorcic11.forms.auth.LoginForm;
import hr.kpastorcic11.roles.User;
import hr.kpastorcic11.forms.interfaces.Loginable;
import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.MoviesArchive;
import hr.kpastorcic11.panels.AdminPanel;
import hr.kpastorcic11.panels.MoviePanel;
import hr.kpastorcic11.panels.MovieRolesPanel;
import hr.kpastorcic11.repositories.interfaces.RoleManager;
import hr.kpastorcic11.repositories.interfaces.UsersRepository;
import hr.kpastorcic11.roles.enums.Role;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author islan
 */
public class MainCinemaFrame extends javax.swing.JFrame implements Loginable {

    private int idUser;
    private UsersRepository repository;
    private RoleManager roleManager;
    public final String MOVIES_XML = "movies.xml";
    
    public MainCinemaFrame() {
        initComponents();
        
        // delete after
        //Login(Optional.of(new User(2, "", ""))); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpContent = new javax.swing.JTabbedPane();
        menu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        miXMLDownload = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinestar kina s 5 zvjezdica *");

        menuFile.setMnemonic('F');
        menuFile.setText("File");

        miXMLDownload.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miXMLDownload.setText("Save to XML");
        miXMLDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miXMLDownloadActionPerformed(evt);
            }
        });
        menuFile.add(miXMLDownload);

        menu.add(menuFile);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miXMLDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miXMLDownloadActionPerformed
        try {
            // alt + F then enter or accelerate ctrl + X to expor in movies in XML with JAXB
            List<Movie> movies = RepositoryFactory.getMoviesRepository().getMovies();
            JAXBUtils.save(new MoviesArchive(movies), MOVIES_XML);
            MessageUtils.showInformationMessage("Info", "Saved to xml");
        } catch (Exception ex) {
            MessageUtils.showInformationMessage("Info", "Faild to save in xml file");
            Logger.getLogger(MainCinemaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miXMLDownloadActionPerformed



    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainCinemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainCinemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainCinemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainCinemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {           
                MainCinemaFrame mainFrame = new MainCinemaFrame();
                LoginForm form = new LoginForm(mainFrame);
                form.setVisible(true);
            }
        });
    }

    @Override
    public void Login(Optional<User> user) {
        if (user.isPresent()) {
            idUser = user.get().getId();
            this.setVisible(true);
            init();
        }
        else
            dispose();
    }

    private void init() {
        repository = RepositoryFactory.getUsersRepository();
        roleManager = (RoleManager) repository;
        configurePanels();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem miXMLDownload;
    private javax.swing.JTabbedPane tpContent;
    // End of variables declaration//GEN-END:variables

    private void configurePanels() {
        try {
            if (roleManager.isUserInRole(idUser, Role.ADMIN)) {
                tpContent.add("Admin", new AdminPanel());
            }
            tpContent.add("Movies", new MoviePanel());
            tpContent.add("Movie Roles", new MovieRolesPanel());
        } catch (Exception ex) {
            Logger.getLogger(MainCinemaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
