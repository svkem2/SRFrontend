package com.stellr.sr.dataaccess;

import com.stellr.sr.domain.ReportSection;
import com.stellr.sr.hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* Report Section CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-28
 */
@Stateless
public class ReportSectionAccessImplementation implements ReportSectionAccess {
    
    private static SessionFactory sessionFactory;

    public ReportSectionAccessImplementation() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(ReportSection newReportSection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ReportSection reportSection) {
        Session session = sessionFactory.openSession();
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
                        session.saveOrUpdate(reportSection);
			txn.commit();
		}catch(HibernateException e){
			//handle exception
			if (txn!=null) txn.rollback();
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null,  new FacesMessage("Error saving report section, please contact Administrator: error message -> " + e));
		}finally{
			session.close();
		}
    }

    @Override
    public ReportSection findById(int reportSectionId) {
        ReportSection retReportSection = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retReportSection = (ReportSection) session.get(ReportSection.class, reportSectionId);
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
    public List<ReportSection> getAll() {
         List<ReportSection> retList = null;
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            //get data
            txn = session.beginTransaction();
            retList = session.createCriteria(ReportSection.class).list();
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
