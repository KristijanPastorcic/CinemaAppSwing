/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utilities;

import hr.algebra.factories.URLConnectionFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author islan
 */
public class FileUtils {

    private static final String UPLOAD = "Upload";
    private static final String SAVE = "Save";
    private static final String TEXT_DOCUMENTS = "Text documents (*.txt)";
    private static final String TXT = "txt";

    private FileUtils() {
    }

    public static Optional<File> uploadFile(String description, String... extensions) {
        JFileChooser choser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        choser.setApproveButtonText(UPLOAD);
        choser.setApproveButtonToolTipText(UPLOAD);
        choser.setDialogTitle(UPLOAD);
        choser.setFileFilter(new FileNameExtensionFilter(description, extensions));
        choser.setAcceptAllFileFilterUsed(false);
        if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = choser.getSelectedFile();
            String ext = file.getName().substring(file.getName().indexOf(".") + 1).toLowerCase();
            return Arrays.asList(extensions).contains(ext) ? Optional.of(file) : Optional.empty();
        }
        return Optional.empty();
    }

    public static Optional<File> saveTextInFile(String text, Optional<File> fileOptional) throws IOException {
        if (fileOptional.isPresent() == false) {
            JFileChooser choser = new JFileChooser(
                    FileSystemView.getFileSystemView().getHomeDirectory());
            choser.setApproveButtonText(SAVE);
            choser.setApproveButtonToolTipText(SAVE);
            choser.setDialogTitle(SAVE);
            choser.setFileFilter(new FileNameExtensionFilter(TEXT_DOCUMENTS, TXT));
            choser.setAcceptAllFileFilterUsed(false);
            if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = choser.getSelectedFile();
                if (file.toString().endsWith(TXT) == false) {
                    file = new File(file.toString().concat(".").concat(TXT));
                }
                Files.write(file.toPath(), text.getBytes());
                fileOptional = Optional.of(file);
            }
        } else {
            // file exists
            Files.write(fileOptional.get().toPath(), text.getBytes());
        }

        return fileOptional;
    }

    public static Optional<String> loadTextFromFile() throws IOException {
        JFileChooser chooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.toString().endsWith(TXT);
            }

            @Override
            public String getDescription() {
                return TEXT_DOCUMENTS;
            }
        });
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return Optional.of(new String(
                    Files.readAllBytes(chooser.getSelectedFile().toPath())));
        }

        return Optional.empty();
    }

    public static void copyFromURL(String url, String destination) throws IOException {
        createDIRIfNotExists(destination);
        HttpURLConnection connection
                = URLConnectionFactory.createHttpURLConnection(url);
        try (InputStream inStream = connection.getInputStream()) {
            Files.copy(inStream, Paths.get(destination));
        }
    }

    public static void copy(String source, String destination) throws IOException {
        createDIRIfNotExists(destination);
        Files.copy(Paths.get(source), Paths.get(destination));
    }

    public static void createDIRIfNotExists(String destination) throws IOException {
        String dir = destination.substring(0, destination.lastIndexOf(File.separator));
        if (!Files.exists(Paths.get(dir))) {
            Files.createDirectories(Paths.get(dir));
        }
    }

    public static boolean hasExtension(String fileName, String... extensions) {
        if (extensions.length == 0) {

            return fileName.contains(".")
                    && fileName.substring(fileName.lastIndexOf(".") + 1)
                            .length() < 5;
        }
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1)
                .toLowerCase();
        for (String extension : extensions) {
            if (extension.equals(ext)) {
                return true;
            }
        }
        return false;
    }
}
