package com.booking.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.booking.MeetingRoomRepository;
import com.booking.entity.MeetingRoom;
import com.booking.exception.BookingException;
@Service
public class BookingService implements IBookingService{

	@Autowired
    private MeetingRoomRepository repository;
	@Override
	public MeetingRoom findById(Long id) {
		Optional<MeetingRoom> or = repository.findById(id);
		if(or!=null){
			return or.get();
		}
		return null;
				
				
	}
	@Override
	public String bookRoom(Long roomid) throws Exception{
		MeetingRoom room = findById(roomid);
		if(room!=null && room.getStatus().equals("FREE")){
			UUID idOne = UUID.randomUUID();
			room.setStatus("OCCUPIED");
			room.setReferenceId(idOne.toString());
			repository.save(room);
			return room.getReferenceId();
		}
		throw new BookingException();
	}
	@Override
	public List<MeetingRoom> findAll() {
		return (List<MeetingRoom>) repository.findAll();
	}
	@Override
	public List<MeetingRoom> listAvailableMeetingRooms(String buildingName, int floorId) throws Exception {
		// TODO Auto-generated method stub
		List<MeetingRoom> listRooms = (List<MeetingRoom>) repository.findAllAvailableMeetingRooms(floorId, buildingName);
		return listRooms;
	}
	@Override
	public Boolean cancelRoom(String refId) {
		MeetingRoom room = repository.findByReferenceId(refId);
		if(room!=null){
			room.setStatus("FREE");
			room.setReferenceId("");
			repository.save(room);
			return true;
		}
		return false;
	}
}
	

	
