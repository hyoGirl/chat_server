package com.kingston.logic.chat.message;

import com.kingston.base.SpringContext;
import com.kingston.net.message.AbstractPacket;
import com.kingston.net.message.PacketType;

import io.netty.buffer.ByteBuf;

public class ReqChatPacket extends AbstractPacket {
	
	private long toUserId;
	
	private String content;
	
	public long getToUserId() {
		return toUserId;
	}

	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void writePacketBody(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readPacketBody(ByteBuf buf) {
		this.toUserId = buf.readLong();
		this.content = readUTF8(buf);
		
	}

	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execPacket() {
		SpringContext.getChatService().chat(0, 0, "");
		
	}
	

}
