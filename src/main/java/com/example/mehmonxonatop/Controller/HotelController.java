package com.example.mehmonxonatop.Controller;

import com.example.mehmonxonatop.DTO.HotelDto;
import com.example.mehmonxonatop.Model.Hotel;
import com.example.mehmonxonatop.Repository.HotelRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mehmonxona")
public class HotelController {
    @Autowired
    HotelRepsitory hotelRepsitory;
    @PostMapping(value = "/qoshish")
    public String add_Hotel(@RequestBody HotelDto hotelDto){
        Hotel hotel=new Hotel();
        hotel.setName(hotelDto.getName());
        hotelRepsitory.save(hotel);
        return "Malumot joylandi";
    }

    @GetMapping(value = "/oqish")
    public List<Hotel> oqish(){
        List<Hotel> list=hotelRepsitory.findAll();
        return list;
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Hotel> optional=hotelRepsitory.findById(id);
        if (optional.isPresent()){
            hotelRepsitory.deleteById(id);
            return "Malumot o'chirildi";
        }
        return "Malumot topilmadi";
    }

    @PutMapping(value = "create/{id}")
    public String create(@PathVariable Integer id,@RequestBody HotelDto hotelDto){
        Optional<Hotel> optional=hotelRepsitory.findById(id);
        if (optional.isPresent()){
            Hotel hotel=optional.get();
            hotel.setName(hotelDto.getName());
            hotelRepsitory.save(hotel);
            return "Malumotlar yangilandi";
        }
        return "Bunday ma'lumot topilamadi";
    }
}
