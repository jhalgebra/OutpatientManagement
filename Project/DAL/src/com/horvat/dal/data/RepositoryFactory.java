package com.horvat.dal.data;

import javax.swing.filechooser.FileSystemView;
import java.text.MessageFormat;

public class RepositoryFactory {
    private static IRepository repository;

    public static IRepository getRepository() throws Exception {
        if(repository == null) {
            String desktop = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            String xmlFilePath = MessageFormat.format("{0}\\{1}", desktop, "con_str.xml");

            repository = new DatabaseRepository(xmlFilePath);
        }

        return repository;
    }
}
