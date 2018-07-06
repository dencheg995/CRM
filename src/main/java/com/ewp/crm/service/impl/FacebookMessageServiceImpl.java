package com.ewp.crm.service.impl;

import com.ewp.crm.models.FacebookMessage;
import com.ewp.crm.repository.interfaces.FacebookMessageDAO;
import com.ewp.crm.service.interfaces.FacebookMessageServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacebookMessageServiceImpl implements FacebookMessageServie {

	private final FacebookMessageDAO facebookMessageDao;

	@Autowired
	public FacebookMessageServiceImpl(FacebookMessageDAO facebookMessageDao) {
		this.facebookMessageDao = facebookMessageDao;
	}

	@Override
	public FacebookMessage addFacebookMessage(FacebookMessage facebookMessage) {
		return facebookMessageDao.saveAndFlush(facebookMessage);
	}

	@Override
	public List<FacebookMessage> getAllFacebookMessages() {
		return facebookMessageDao.findAll();
	}

	@Override
	public FacebookMessage getFacebookMessage(Long id) {
		return facebookMessageDao.getOne(id);
	}

	@Override
	public void deleteFacebookMessage(FacebookMessage facebookMessage) {
		facebookMessageDao.delete(facebookMessage);
	}

	@Override
	public void deleteFacebookMessage(Long id) {
		facebookMessageDao.delete(id);
	}

	@Override
	public void updateFacebookMessage(FacebookMessage facebookMessage) {
		facebookMessageDao.saveAndFlush(facebookMessage);
	}
}
