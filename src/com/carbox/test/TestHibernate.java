package com.carbox.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.carbox.dao.impl.UserDAOImpl;
import com.carbox.model.Advertise;
import com.carbox.model.Advertises;
import com.carbox.model.Auction;
import com.carbox.model.GridFeeder;
import com.carbox.model.User;
import com.carbox.model.Users;
import com.carbox.query.LoginQuery;
import com.carbox.query.Queries;
import com.carbox.service.UserService;
import com.carbox.service.impl.AdvertiseServiceImpl;
import com.carbox.service.impl.UserServiceImpl;
import com.carbox.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {

		
	}
}
		
		
		
		
		
//		Date newAuctionDate = new Date();
//		Date finishingDate = Queries.getFinishingDateByAdvertiseId(218);
//		System.out.println(newAuctionDate.getTime()-finishingDate.getTime());
//		System.out.println(finishingDate.getTime()-newAuctionDate.getTime());





//Advertise a = new Advertise(11, "car", "a", "a", "a", "a", "a", "a", "a", "a", "a", "aa", "a", "a", "a", "a", new Date(), new Date(), 1.1);
//
//try {
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	Session session = sessionFactory.getCurrentSession();
//	if (session.getTransaction().isActive() == false)
//		session.getTransaction().begin();
//
//	session.save(a);
//	
//	session.getTransaction().commit();
//} catch (Exception e) {
//	e.printStackTrace();
//}



/*
 * String JDBC_DRIVER = "com.mysql.jdbc.Driver"; String DB_URL =
 * "jdbc:mysql://localhost/datatable";
 * 
 * String USER = "admin"; String PASS = "admin";
 * 
 * Connection con = null; try { Class.forName("com.mysql.jdbc.Driver"); con =
 * DriverManager.getConnection(DB_URL, USER, PASS);
 * 
 * PreparedStatement ps = con.prepareStatement("select * from customer");
 * ArrayList<CustomerBean> al = new ArrayList<CustomerBean>(); ResultSet rs =        
 * ps.executeQuery(); boolean found = false; while (rs.next()) { CustomerBean e
 * = new CustomerBean(); e.setFirstname(rs.getString("firstname"));
 * e.setLastname(rs.getString("lastname"));
 * e.setAddress(rs.getString("address")); e.setEmail(rs.getString("email"));
 * System.out.println(rs.getString("firstname")); al.add(e); found = true; }
 * rs.close(); if (found) { } else { } } catch(Exception e) {
 * System.out.println("Error In getCustomer() -->" + e.getMessage()); }
 */

/*
 * Advertises newAdvertise = new
 * Advertises(2,"Car","bmw","420","2.0","full","02166509315",
 * "05369648188","2014","Diesel","Automatic","15000","white","kelepir",
 * "sifir hatasiz","70000"); newAdvertise.setStartingDate(new Date());
 * newAdvertise.setFinishingDate(new Date());
 * newAdvertise.setStartingPrice(100000);
 */

/*
 * try {
 * 
 * SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session
 * session = sessionFactory.getCurrentSession();
 * if(session.getTransaction().isActive() == false )
 * session.getTransaction().begin();
 * 
 * Query query = session.createQuery("from Users u where u.mail='va@gmail.com'"
 * ); List queryList = query.list(); if (!queryList.isEmpty())
 * System.out.println("ok"); session.getTransaction().commit();
 * 
 * 
 * } catch (HibernateException e) { e.printStackTrace(); }
 */

/*
 * int userId=1; int advertiseId; Advertise advertise = new Advertise();
 * 
 * Session session2 = null; SessionFactory sessionFactory2 = null;
 * 
 * try { sessionFactory2 = HibernateUtil.getSessionFactory(); session2 =
 * sessionFactory2.getCurrentSession(); session2.getTransaction().begin();
 * 
 * Query query2 = session2.createQuery(
 * "from Advertise  where userId = :userId  order by advertiseId desc");
 * query2.setInteger("userId", userId); List<Advertise> advertiseList =
 * query2.list(); advertise = (Advertise) advertiseList.get(0); advertiseId =
 * advertise.getAdvertiseId(); //System.out.println(advertiseId);
 * 
 * } catch (Exception e) { e.printStackTrace(); } finally { session2.flush();
 * session2.getTransaction().commit();
 * 
 * }
 */

/*
 * Session session = null; SessionFactory sessionFactory = null;
 */

/*
 * byte[] b = {'v','u','r','a','l'}; byte[] c = {'u','f','u','k'};
 * 
 * 
 * Advertise2 adv = new Advertise2("car","audi"); Photo2 photo = new Photo2();
 * photo.setPhoto(b); Photo2 photo2 = new Photo2(); photo2.setPhoto(c);
 * adv.getPhoto().add(photo); adv.getPhoto().add(photo2);
 */

/*
 * Advertise2 a = new Advertise2(); try { sessionFactory =
 * HibernateUtil.getSessionFactory(); session =
 * sessionFactory.getCurrentSession(); session.getTransaction().begin();
 * 
 * Query query = session.createQuery("select a.advertiseId from Advertise2 a");
 * List<Integer> results = query.list(); System.out.println(results.get(0));
 * 
 * } catch (Exception e) { e.printStackTrace(); } finally { session.flush();
 * session.getTransaction().commit(); }
 */

/*
 * Advertise newAdvertise = new
 * Advertise(2,"Car","bmw","420","2.0","full","02166509315",
 * "05369648188","2014","Diesel","Automatic","15000","white","kelepir",
 * "sifir hatasiz","70000");
 */

/*
 * Session session = null; SessionFactory sessionFactory = null;
 * 
 * try { sessionFactory = HibernateUtil.getSessionFactory(); session =
 * sessionFactory.getCurrentSession(); session.getTransaction().begin();
 * 
 * Query query = session.createSQLQuery(
 * "select u.user_mail,a.advertiseId  from Users_Carbox u inner join Advertise a on u.user_id = a.userId"
 * ); List<String> result = query.list(); System.out.println(result);
 * 
 * } catch (Exception e) { e.printStackTrace(); } finally { session.flush();
 * session.getTransaction().commit(); }
 */

/* Queries.setIsComplete(1, 250); */

/*
 * List<String> resultBrands = Queries.getBrands("Car"); String brand =
 * resultBrands.get(0); System.out.println(brand);
 */

/*
 * List<String> resultsModel = Queries.getModels("Car", "Hyundai"); String model
 * = resultsModel.get(0); System.out.println(model);
 */

/*
 * List<String> resultsMotor = Queries.getMotors("Car", "Hyundai","i30"); String
 * motor = resultsMotor.get(0); System.out.println(motor);
 */

/*
 * List<String> resultsHardwarePackage = Queries.getHardwarePackage("Car",
 * "Hyundai", "i20", "1.6"); if (resultsHardwarePackage != null) { String
 * hardwarePackage = resultsHardwarePackage.get(0);
 * System.out.println(hardwarePackage); } else{ return ; }
 */

// List<Advertise> resultQuery = Queries.getVehicles("Car");
/*
 * List<String> resultBrands = Queries.getBrands("Car"); String brand =
 * resultBrands.get(0); System.out.println(brand);
 * 
 * List<String> resultModel = Queries.getModels("car", "hyundai"); String model
 * = resultModel.get(0); System.out.println(model);
 * 
 * List<String> resultMotor = Queries.getMotors("car", brand, model); String
 * motor = resultMotor.get(0); System.out.println(motor);
 * 
 * List<String> resultHardwarePackage = Queries.getHardwarePackage("car", brand,
 * model, motor); String hardwarePackage = resultHardwarePackage.get(0);
 * System.out.println(hardwarePackage);
 */

/*
 * List<String> resultModel = Queries.getModels("car", "hyundai"); String model
 * = resultModel.get(0); System.out.println(model);
 */

/*
 * Advertise newAdvertise = new Advertise("Car","Hyundai","i30","1.6","Elite");
 * 
 * AdvertiseServiceImpl advertiseService = new AdvertiseServiceImpl();
 * advertiseService.addAdvertise(newAdvertise);
 */

/*
 * User newUser = new User("test2", "test", "test", "test");
 * 
 * UserServiceImpl userService = new UserServiceImpl();
 * userService.addUser(newUser);
 * 
 * 
 * System.out.println(LoginQuery.queryLogin("mymail","mypass"));
 * System.out.println(LoginQuery.queryLogin("mymail","mypass"));
 * 
 * 
 * UserDAOImpl userDao = new UserDAOImpl(); User user1 = new User("ahmet",
 * "mehmet", "mail3@gmail.com", "pass4"); userDao.addUser(user1);
 * 
 * SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session
 * session = sessionFactory.getCurrentSession();
 * session.getTransaction().begin();
 * 
 * Query query = session.createSQLQuery(
 * "select user_name from users_carbox where user_id = 1"); List<User> user =
 * query.list(); System.out.println(user);
 * 
 * query = session.createSQLQuery(
 * "select user_name from users_carbox where user_id = 2"); List<User> user2 =
 * query.list(); System.out.println(user2);
 * 
 * query = session.createSQLQuery("select * from users_carbox"
 * ).addEntity(User.class); List<User> userList = query.list(); for(User users :
 * userList){ System.out.println(users.getUserId()+" "+ users.getName()+" "
 * +users.getSurname()); } session.flush(); session.getTransaction().commit();
 * sessionFactory.close();
 */
