package com.horvat.dal;

public class RepositoryFactory {
    private static IRepository repository;

    public static IRepository getRepository() {
        if(repository == null) {
            String xmlFilePath = FileManager.getFilePath("OMM_Settings.xml");

            try {
                repository = new DatabaseRepository(xmlFilePath);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return repository;
    }
}
