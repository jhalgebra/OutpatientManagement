package com.horvat.dal.data;

public class RepositoryFactory {
    private IRepository repository;

    public IRepository getRepository(){
        if(repository == null)
            repository = new DatabaseRepository();

        return repository;
    }
}
