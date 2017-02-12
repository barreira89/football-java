package repository;

import java.util.List;

import model.PicksDTO;

public interface PicksRepositoryCustom {
	
	List<PicksDTO> findPicksByUsernameWithGameDetails(String username);

}
