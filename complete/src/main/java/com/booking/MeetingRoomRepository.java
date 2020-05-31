package com.booking;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.entity.MeetingRoom;

@Repository
public interface MeetingRoomRepository extends CrudRepository<MeetingRoom, Long> {
	
	@Query("SELECT r FROM MeetingRoom r WHERE r.floorNumber = :floorNumber and r.buildingName= :buildingName")
	List<MeetingRoom> findAllAvailableMeetingRooms(@Param("floorNumber") int floorNumber,@Param("buildingName") String buildingName);
	
	@Query("SELECT r FROM MeetingRoom r WHERE r.referenceId = :referenceId")
	MeetingRoom findByReferenceId(@Param("referenceId") String refId);
	

}



