package com.holddie.niu.code.gan0415;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/15 9:11
 */
public class ThreadLocalTest {
    private static final ThreadLocal threadSession = new ThreadLocal();

//    public static Session getSession() throws InfrastructureException {
//        Session s = (Session) threadSession.get();
//        try {
//            if (s == null) {
//                s = getSessionFactory().openSession();
//                threadSession.set(s);
//            }
//        } catch (HibernateException ex) {
//            throw new InfrastructureException(ex);
//        }
//        return s;
//    }
}
