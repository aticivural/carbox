package com.carbox.query;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.carbox.model.Advertise;
import com.carbox.model.Auction;
import com.carbox.model.GridFeeder;
import com.carbox.model.Photo;
import com.carbox.model.PhotoFeeder;
import com.carbox.model.User;
import com.carbox.util.HibernateUtil;


public class Queries {
	
	
	public static boolean isAuction (int advertiseId){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();
			
			Query query = session.createSQLQuery("SELECT * FROM ADVERTISE a where a.ADVERTISEID= :advertiseId and a.STARTINGPRICE IS not NULL");
			query.setInteger("advertiseId", advertiseId);
			List resultList =  query.list();
			if(resultList.isEmpty() == false){
				return true;
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return false;
	}
	
	
	public static Double getMaxPriceForAuctionByAdvertiseId (int advertiseId){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();
			
			Query query = session.createQuery("select a.auctionPrice from Auction a where advertiseId= :advertiseId order by a.auctionPrice desc ");
			query.setInteger("advertiseId", advertiseId);
			List resultList =  query.list();
			Double maxPrice = null;
			if(resultList.isEmpty())
				return maxPrice;
			else{
				return maxPrice = (Double) resultList.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	public static Double getStartingPriceByAdvertiseId (int advertiseId){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();
			
			Query query = session.createQuery("select a.startingPrice from Advertise a where advertiseId= :advertiseId ");
			query.setInteger("advertiseId", advertiseId);
			List resultList =  query.list();
			Double startingPrice = (Double) resultList.get(0);
			return startingPrice;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	public static Date getFinishingDateByAdvertiseId (int advertiseId){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();
			
			Query query = session.createQuery("select a.finishingDate from Advertise a where advertiseId= :advertiseId ");
			query.setInteger("advertiseId", advertiseId);
			List resultList =  query.list();
			Date finishingDate = (Date) resultList.get(0);
			return finishingDate;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	
	public static Date getStartingDateDateByAdvertiseId (int advertiseId){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();
			
			Query query = session.createQuery("select a.startingDate from Advertise a where advertiseId= :advertiseId ");
			query.setInteger("advertiseId", advertiseId);
			List resultList =  query.list();
			Date startingDate = (Date) resultList.get(0);
			return startingDate;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	
	
	
	
	
	
	public static ArrayList<Auction> getAllAuctionsByAdvertiseId (int advertiseId){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();
			
			Query query = session.createQuery("from Auction a where advertiseId= :advertiseId order by a.auctionPrice desc");
			query.setInteger("advertiseId", advertiseId);
			ArrayList<Auction> auctionList = (ArrayList<Auction>) query.list();
			return auctionList;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	
	
	public static void addAuction (Auction auction){
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

				session.save(auction);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
	}
	
		
	
	
	public static ArrayList<PhotoFeeder> getAdvertisingPhotoListWithAdvertiseId(int advertiseId){
		
		ArrayList<PhotoFeeder> pfList = new ArrayList<PhotoFeeder>();
		
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createSQLQuery("select p.PHOTOID, p.PHOTO from Photo p where advertiseId= :advertiseId ");
			query.setInteger("advertiseId", advertiseId);
			List photoList = query.list();
			for(int i = 0; i<photoList.size(); i++){
				Object[] obj = (Object[]) photoList.get(i);
				BigDecimal photoId =   (BigDecimal) obj[0];
				Blob blob = (Blob) obj[1];
				pfList.add(new PhotoFeeder(photoId.intValue(),blob));
			}
			return pfList;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	public static User getUserByUserId(int userId) {
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createQuery("from User where userId= :userId ");
			query.setInteger("userId", userId);
			List<User> userList = query.list();
			return userList.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	public static Advertise getAdvertiseByAdvertiseId(int advertiseId) {
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createQuery("from Advertise where advertiseId= :advertiseId ");
			query.setInteger("advertiseId", advertiseId);
			List<Advertise> advertiseList = query.list();
			return advertiseList.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		return null;
	}
	
	public static Integer queryLogin(String mail, String password) {
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createQuery("from User U where U.mail = :mail and U.password= :pass ");
			query.setString("mail", mail);
			query.setString("pass", password);
			List<User> userList = query.list();

			if (!userList.isEmpty()) {
				return userList.get(0).getUserId();
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}

		return 0;
	}

	public static ArrayList<GridFeeder> getGridList() {
		ArrayList<GridFeeder> gfList = new ArrayList<GridFeeder>();
		Session session = null;
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createSQLQuery(
					"select a.ADVERTISEID , a.ADVERTISINGHEADER ,p.photo from Advertise a , (Select ADVERTISEID ,photo ,photoid from PHOTO  order by photoid) p,(select min(photoid) as photoid from PHOTO group by ADVERTISEID) c where a.ADVERTISEID = p.ADVERTISEID and p.photoid = c.photoid and a.ISCOMPLETE=1");
			
			List gridFeederList = query.list();
			for(int i = 0;i < gridFeederList.size();i++){
				Object[] obj = (Object[]) gridFeederList.get(i);
				BigDecimal advertiseId =   (BigDecimal) obj[0];
				String advertiseHeader = (String) obj[1];
				Blob blob = (Blob) obj[2];
				GridFeeder gf = new GridFeeder(advertiseId.intValue(),advertiseHeader,blob);
				gfList.add(gf);
			}
			return gfList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
	}
	
	
	public static ArrayList<GridFeeder> getGridListForSearchResults(String vehicleType, String brand, String model, String motor, String hardwarePackage, String searchQuery) {
		ArrayList<GridFeeder> gfList2 = new ArrayList<GridFeeder>();
		Session session = null;
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createSQLQuery(searchQuery);
			
			query.setString("vehicleType", vehicleType);
			query.setString("brand", brand);
			query.setString("model", model);
			query.setString("motor", motor);
			query.setString("hardwarePackage", hardwarePackage);
			
			List gridFeederList = query.list();
			for(int i = 0;i < gridFeederList.size();i++){
				Object[] obj = (Object[]) gridFeederList.get(i);
				BigDecimal advertiseId =   (BigDecimal) obj[0];
				String advertiseHeader = (String) obj[1];
				Blob blob = (Blob) obj[2];
				String modell = (String) obj[3];
				String year = (String) obj[4];
				String km = (String) obj[5];
				String price = (String) obj[6];
				String color = (String) obj[7];
				Date date = (Date) obj[8];
				GridFeeder gf = new GridFeeder(advertiseId.intValue(),advertiseHeader,blob, modell, year, km, price, color, date.toString());
				gfList2.add(gf);
				//System.out.println(advertiseId.intValue());
			}
			return gfList2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
	}
	
	
	
	
	
	public static User queryUser(String mail, String password) {
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createQuery("from User U where U.mail = :mail and U.password= :pass ");
			query.setString("mail", mail);
			query.setString("pass", password);
			List<User> userList = query.list();

			if (!userList.isEmpty()) {
				return userList.get(0);
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}

		return null;
	}
	
	public static boolean queryMail(String mail) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createQuery("from User u where u.mail='" + mail + "'");
			List<User> queryList = query.list();
			if (!queryList.isEmpty())
				return true;
			session.getTransaction().commit();

			return false;

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void setIsComplete(int userId, int advertiseId) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			Query query = session.createQuery("update Advertise set isComplete = 1 where userId = :userId and advertiseId = :advertiseId");
			query.setInteger("userId", userId);
			query.setInteger("advertiseId", advertiseId);
			query.executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getBrands(String vehicleType) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if (session.getTransaction().isActive() != true)
				session.getTransaction().begin();

			Query query = session .createQuery("select A.brand from Advertise A   where A.vehicleType= :vehicleType and A.isComplete=1");
			query.setParameter("vehicleType",vehicleType );
			List<String> queryList = query.list();

			if (!queryList.isEmpty())
				return queryList;

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getModels(String vehicleType, String brand) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if (session.getTransaction().isActive() != true)
				session.getTransaction().begin();

			Query query = session
					.createQuery("select A.model from Advertise A  where A.vehicleType= :vehicleType and "
							+ "A.brand= :brand and A.isComplete=1");
			query.setParameter("vehicleType", vehicleType);
			query.setParameter("brand", brand);
			List<String> queryList = query.list();

			if (!queryList.isEmpty())
				return queryList;

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getMotors(String vehicleType, String brand, String model) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if (session.getTransaction().isActive() != true)
				session.getTransaction().begin();

			Query query = session
					.createQuery("select A.motor from Advertise A  where A.vehicleType= :vehicleType and "
							+ "A.brand= :brand and " + "A.model= :model and A.isComplete=1");
			query.setParameter("vehicleType", vehicleType);
			query.setParameter("brand", brand);
			query.setParameter("model", model);
			List<String> queryList = query.list();

			if (!queryList.isEmpty())
				return queryList;

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getHardwarePackage(String vehicleType, String brand, String model, String motor) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if (session.getTransaction().isActive() != true)
				session.getTransaction().begin();

			Query query = session.createQuery(
					"select A.hardwarePackage from Advertise A  where " + "A.vehicleType= :vehicleType and "
							+ "A.brand= :brand and " + "A.model= :model and " + "A.motor= :motor and A.isComplete=1");

			query.setParameter("vehicleType",vehicleType);
			query.setParameter("brand", brand);
			query.setParameter("model", model);
			query.setParameter("motor", motor);
			List<String> queryList = query.list();

			if (!queryList.isEmpty())
				return queryList;

			session.getTransaction().commit();

			// return null;

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
