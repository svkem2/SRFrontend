/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.InputFile;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* Input File CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
public class InputFileAccessImplementation implements InputFileAccess {

    private static SessionFactory sessionFactory;

    public InputFileAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(InputFile newInputFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(InputFile inputFile) {
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(inputFile);
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
    public InputFile findById(int inputFileId) {
        InputFile retInputFile = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retInputFile = (InputFile) session.get(InputFile.class, inputFileId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retInputFile;
    }

    @Override
    public List<InputFile> getAll() {
        List<InputFile> retList = null;
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			//get data
			txn = session.beginTransaction();
			retList = session.createCriteria(InputFile.class).list();
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
		}finally{
			session.close();
		}
		return retList;
    }

}
