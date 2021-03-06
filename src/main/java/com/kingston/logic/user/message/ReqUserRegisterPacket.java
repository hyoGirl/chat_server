package com.kingston.logic.user.message;

import com.kingston.logic.GlobalConst;
import com.kingston.net.message.AbstractPacket;
import com.kingston.net.message.PacketType;

import io.netty.buffer.ByteBuf;

public class ReqUserRegisterPacket extends AbstractPacket {
	
	/** 性别{@link GlobalConst#sex_of_boy} */
	private byte sex;
	
	private String nickName;
	
	private String password;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public byte getSex() {
		return sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	@Override
	public void writePacketBody(ByteBuf buf) {
		buf.writeByte(sex);
		writeUTF8(buf, nickName);
		writeUTF8(buf, password);
	}

	@Override
	public void readPacketBody(ByteBuf buf) {
		this.sex = buf.readByte();
		this.nickName = readUTF8(buf);
		this.password = readUTF8(buf);
		
	}

	@Override
	public PacketType getPacketType() {
		return PacketType.ReqUserRegister;
	}

	@Override
	public void execPacket() {
		// TODO Auto-generated method stub
		
	}

}