package com.example.mehmonxonatop.Repository;

import com.example.mehmonxonatop.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoomRepository extends JpaRepository<Room,Integer> {
  //  public boolean existsByRoomNameAndHotelId(Integer roomNumber,Integer hotel_Id);
}
