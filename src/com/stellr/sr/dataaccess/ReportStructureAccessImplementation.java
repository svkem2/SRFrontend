/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.ReportStructure;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* Report Structure CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-28
 */
@Stateless
public class ReportStructureAccessImplementation implements ReportStructureAccess {
    
    private static SessionFactory sessionFactory;

    public ReportStructureAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(ReportStructure newReportStructure) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ReportStructure ReportStructure) {
        Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(ReportStructure);
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null,  new FacesMessage("Error saving report structure, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public ReportStructure findById(int ReportStructureId) {
        ReportStructure retReportStructure = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retReportStructure = (ReportStructure) session.get(ReportStructure.class, ReportStructureId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retReportStructure;
    }

    @Override
    public List<ReportStructure> getAll() {
        List<ReportStructure> retList = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retList = session.createCriteria(ReportStructure.class).list();
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
