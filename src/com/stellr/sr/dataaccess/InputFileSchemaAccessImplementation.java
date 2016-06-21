/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.InputFileSchema;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* Input File Schema CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-28
 */
@Stateless
public class InputFileSchemaAccessImplementation implements InputFileSchemaAccess {
    
    private static SessionFactory sessionFactory;
    
    public InputFileSchemaAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(InputFileSchema newInputFileSchema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(InputFileSchema inputFileSchema) {
         Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(inputFileSchema);
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null,  new FacesMessage("Error saving schema, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public InputFileSchema findById(int inputFileSchemaId) {
        InputFileSchema retInputFileSchema = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retInputFileSchema = (InputFileSchema) session.get(InputFileSchema.class, inputFileSchemaId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retInputFileSchema;
    }

    @Override
    public List<InputFileSchema> getAll() {
         List<InputFileSchema> retList = null;
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			//get data
			txn = session.beginTransaction();
			retList = session.createCriteria(InputFileSchema.class).list();
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
