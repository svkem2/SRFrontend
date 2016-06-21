/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.ConcatenateFileGroup;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author stu
 */
@Stateless
public class ConcatenateFileGroupAccessImplementation implements ConcatenateFileGroupAccess{
    
    private static SessionFactory sessionFactory;
    
    public ConcatenateFileGroupAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(ConcatenateFileGroup newGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ConcatenateFileGroup group) {
        Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(group);
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
    public ConcatenateFileGroup findById(int groupId) {
         ConcatenateFileGroup retConcatenateFileGroup = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retConcatenateFileGroup = (ConcatenateFileGroup) session.get(ConcatenateFileGroup.class, groupId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retConcatenateFileGroup;
    }

    @Override
    public List<ConcatenateFileGroup> getAll() {
        List<ConcatenateFileGroup> retList = null;
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			//get data
			txn = session.beginTransaction();
			retList = session.createCriteria(ConcatenateFileGroup.class).list();
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
