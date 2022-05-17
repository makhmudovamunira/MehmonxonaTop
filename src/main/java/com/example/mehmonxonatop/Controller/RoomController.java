package com.example.mehmonxonatop.Controller;

import com.example.mehmonxonatop.DTO.RoomDto;
import com.example.mehmonxonatop.Model.Hotel;
import com.example.mehmonxonatop.Model.Room;
import com.example.mehmonxonatop.Repository.HotelRepsitory;
import com.example.mehmonxonatop.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    HotelRepsitory hotelRepsitory;
    @Autowired
    RoomRepository roomRepository;
    @PostMapping(value = "/add")
    public String add(@RequestBody RoomDto roomDto){
        Optional<Hotel> optionalHotel=hotelRepsitory.findById(roomDto.getHotel_Id());
       //boolean holat=roomRepository.existsByRoomNameAndHotelId(roomDto.getRoomNumber(), roomDto.getHotel_Id());
        if (!(optionalHotel.isPresent())){
            return "Bunday malumot mavjud emas";
        }
//        if(holat){
//            return "Bu malumot mavjud";
//        }
        Room room=new Room();
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setQavat(roomDto.getQavat());
        room.setHotel(optionalHotel.get());
        roomRepository.save(room);
        return "Malumot qo'shildi";
    }
    @GetMapping(value = "/read")
    public List<Room> read(RoomDto roomDto){
        List<Room> list=roomRepository.findAll();
        return list;
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Room> optional=roomRepository.findById(id);
        if (optional.isPresent()){
            roomRepository.deleteById(id);
            return "Malumot o'chirildi";
        }
        return "Bunday malumot mavjud emas";
    }
    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable Integer id,@RequestBody RoomDto roomDto){
        Optional<Room> optional=roomRepository.findById(id);

        if (optional.isPresent()){
            Room room=new Room();
            room.setRoomNumber(roomDto.getRoomNumber());
            room.setQavat(roomDto.getQavat());
            Hotel hotel=hotelRepsitory.getById(id);
            room.setHotel(hotel);
            roomRepository.save(room);
            return "Tahrirlandi";
        }
        return "Bunday malumot mavjud emas";
    }

}
