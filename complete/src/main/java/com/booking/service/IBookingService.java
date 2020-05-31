package com.booking.service;

import java.util.List;

import com.booking.entity.MeetingRoom;

public interface IBookingService {
	MeetingRoom findById(Long id);
	String bookRoom(Long roomid) throws Exception;
	//String cancelBooking()
	List<MeetingRoom> findAll();
	List<MeetingRoom> listAvailableMeetingRooms(String buildingName,int floorId) throws Exception; 
	Boolean cancelRoom(String refId);
	
	
	
}
