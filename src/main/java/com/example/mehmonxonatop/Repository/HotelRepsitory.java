package com.example.mehmonxonatop.Repository;

import com.example.mehmonxonatop.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepsitory extends JpaRepository<Hotel,Integer> {
}
