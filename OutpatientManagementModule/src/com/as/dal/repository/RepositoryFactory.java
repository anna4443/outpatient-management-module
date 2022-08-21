/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dal.repository;


public final class RepositoryFactory {
    
    public static IRepository getRepository() {
        return new SqlRepository();
    }
    
}
