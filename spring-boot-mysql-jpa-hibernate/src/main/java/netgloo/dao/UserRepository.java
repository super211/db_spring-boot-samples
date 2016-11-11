package netgloo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	//public List<User> selectById(long ID);
	
	@Query("select u from User u")
	List<User> getList();
	//User findByName(@Param("name") String name);
}
