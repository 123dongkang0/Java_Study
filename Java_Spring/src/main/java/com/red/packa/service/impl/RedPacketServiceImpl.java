package com.red.packa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.red.packa.dao.RedPacketDao;
import com.red.packa.pojo.RedPacket;
import com.red.packa.service.RedPacketService;

@Service
public class RedPacketServiceImpl implements RedPacketService {
	
	@Autowired
	private RedPacketDao  redPacketDao = null;

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public RedPacket getRedPacket(Long id) {
		return redPacketDao.getRedPacket(id);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int decreaseRedPacket(Long id) {
		return redPacketDao.decreaseRedPacket(id);
	}

}