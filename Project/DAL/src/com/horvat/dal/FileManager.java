package com.horvat.dal;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final File storageFile = FileSystemView.getFileSystemView().getHomeDirectory();
    private static final Path storagePath = Paths.get(storageFile.toURI());

    public static String getFilePath(String fileName){
        return storagePath.resolve(fileName).toString();
    }
}
