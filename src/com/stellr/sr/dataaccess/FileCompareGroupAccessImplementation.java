/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.FileCompareGroup;
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
public class FileCompareGroupAccessImplementation implements FileCompareGroupAccess {
    private static SessionFactory sessionFactory;

    public FileCompareGroupAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(FileCompareGroup newGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FileCompareGroup group) {
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
                        context.addMessage(null,  new FacesMessage("Error saving file group, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public FileCompareGroup findById(int groupId) {
        FileCompareGroup retFilePath = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retFilePath = (FileCompareGroup) session.get(FileCompareGroup.class, groupId);
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
    public List<FileCompareGroup> getAll() {
        List<FileCompareGroup> retList = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retList = session.createCriteria(FileCompareGroup.class).list();
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
