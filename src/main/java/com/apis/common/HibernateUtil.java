/**  
* @author hongchun.li  
* @date 2013-4-21 下午02:46:55
* @version V1.0  
*/ 
package com.apis.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * @author hongchun.li
 *
 */
public class HibernateUtil {
	 
    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration configuration = new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
 
    static {
        try {
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /***
     * 获得session
     * 
     * @return
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
 
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }
 
        return session;
    }
 
    public static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("无法 在 baseDao 中 创建 SessionFactory ");
            e.printStackTrace();
        }
    }
}
