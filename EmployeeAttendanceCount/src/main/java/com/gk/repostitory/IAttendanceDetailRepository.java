package com.gk.repostitory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gk.entity.Attendance;

public interface IAttendanceDetailRepository extends CrudRepository<Attendance, Integer> {

	/*@Query("SELECT count FROM AttendanceDetail WHERE aId=:id")
	public  int fetchAttendanceCount(int id);*/
}
