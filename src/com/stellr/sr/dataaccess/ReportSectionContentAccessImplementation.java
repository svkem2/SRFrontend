/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.ReportSectionContent;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* Report Section Content CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-28
 */
@Stateless
public class ReportSectionContentAccessImplementation implements ReportSectionContentAccess {
    
    private static SessionFactory sessionFactory;

    public ReportSectionContentAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(ReportSectionContent newReportSectionContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ReportSectionContent reportSectionContent) {
        Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(reportSectionContent);
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null,  new FacesMessage("Error saving report section content, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public ReportSectionContent findById(int reportSectionContentId) {
        ReportSectionContent retReportSection = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retReportSection = (ReportSectionContent) session.get(ReportSectionContent.class, reportSectionContentId);
            txn.commit();
        } catch (HibernateException e) {
            //handle exception
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
        return retReportSection;
    }

    @Override
    public List<ReportSectionContent> getAll() {
        List<ReportSectionContent> retList = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retList = session.createCriteria(ReportSectionContent.class).list();
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
