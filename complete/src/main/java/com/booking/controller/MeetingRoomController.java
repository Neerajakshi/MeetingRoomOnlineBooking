package com.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.MeetingRoom;
import com.booking.service.IBookingService;

import io.micrometer.core.ipc.http.HttpSender.Response;



@RestController
public class MeetingRoomController {
	
	@Autowired
    private IBookingService bookingService;
	@RequestMapping("/")
	public String index() {
		return "Meeting room controller";
	}
	
	
	@RequestMapping("/booking/room/{roomid}")  
	private ResponseEntity bookRoom(@PathVariable("roomid") Long roomid)   
	{  
		try{
		String referenceId = bookingService.bookRoom(roomid);
		return new ResponseEntity<>("Successfully booked with reference Id "+referenceId, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Meeting room with id "+roomid+" already booked", HttpStatus.UNAUTHORIZED);// change the status accrodingly
		}
	}  
	
	@PostMapping("/cancel/room/{roomid}")  
	private ResponseEntity cancelRoom(@PathVariable("roomid") String refid)   
	{  
		
			boolean result = bookingService.cancelRoom(refid);
			if(true)
			return new ResponseEntity<>("Successfully cancelled room booking with reference Id "+refid, HttpStatus.OK);
			else
				return new ResponseEntity<>("Internal server error"+refid, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}  
	
	
	@RequestMapping("/rooms")
	public List<MeetingRoom> getRoomList(){
				
		return (List<MeetingRoom>) bookingService.findAll();
		
	}
	@RequestMapping("/rooms/{buildingname}/{floorid}")
	public List<MeetingRoom> getAvailableRoomByBuildingNameAndFloor(@PathVariable("buildingname") String buildingName, @PathVariable("floorid") int floorId){
				
		try {
			return (List<MeetingRoom>) bookingService.listAvailableMeetingRooms(buildingName, floorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
