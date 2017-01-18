package com.carbox.service.impl;

import com.carbox.dao.impl.AdvertiseDAOImpl;
import com.carbox.model.Advertise;
import com.carbox.service.AdvertiseService;

public class AdvertiseServiceImpl implements AdvertiseService {

	AdvertiseDAOImpl advertiseDao = new AdvertiseDAOImpl();
	
	@Override
	public void addAdvertise(Advertise advertise) {

		advertiseDao.addAdvertise(advertise);
		
	}

}
