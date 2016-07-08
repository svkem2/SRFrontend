/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.SRMailGroup;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* SR Mail Groups CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-07-07
 */
@Stateless
public class SRMailGroupAccessImplementation implements SRMailGroupAccess {
    private static SessionFactory sessionFactory;

    public SRMailGroupAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(SRMailGroup newSRmailGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(SRMailGroup srMailGroup) {
        Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(srMailGroup);
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null,  new FacesMessage("Error saving sr file group, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public SRMailGroup findById(int srMailGroupId) {
        SRMailGroup ret = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            ret= (SRMailGroup) session.get(SRMailGroup.class, srMailGroupId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return ret;
    }

    @Override
    public List<SRMailGroup> getAll() {
        List<SRMailGroup> retList = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retList = session.createCriteria(SRMailGroup.class).list();
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
