/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.bl;

import com.as.dal.repository.IRepository;
import com.as.dal.repository.RepositoryFactory;


public class HandlerBase {
    final IRepository repository;
    public HandlerBase() {
        repository = RepositoryFactory.getRepository();
    }
}
