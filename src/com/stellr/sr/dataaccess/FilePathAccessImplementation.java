/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.FilePath;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* File Path CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-28
 */
@Stateless
public class FilePathAccessImplementation implements FilePathAccess {

    private static SessionFactory sessionFactory;

    public FilePathAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(FilePath newFilePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FilePath filePath) {
        Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(filePath);
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null,  new FacesMessage("Error saving file, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public FilePath findById(int filePathId) {
        FilePath retFilePath = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retFilePath = (FilePath) session.get(FilePath.class, filePathId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retFilePath;
    }

    @Override
    public List<FilePath> getAll() {
        List<FilePath> retList = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retList = session.createCriteria(FilePath.class).list();
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retList;
    }

}
