package com.red.packa.dao;

import org.springframework.stereotype.Repository;

import com.red.packa.pojo.UserRedPacket;

@Repository
public interface UserRedPacketDao {

	/**
	 * �����������Ϣ.
	 * @param userRedPacket �����������Ϣ
	 * @return Ӱ���¼��.
	 */
	public int grapRedPacket(UserRedPacket  userRedPacket);
}
