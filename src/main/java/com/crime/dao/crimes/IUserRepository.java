package com.crime.dao.crimes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crime.entity.crimes.StationUser;

@Repository
public interface IUserRepository extends JpaRepository<StationUser, Long> {

	Optional<StationUser> findByUserNameAndPassword(String userName, String password);

	Optional<StationUser> findByUserName(String username);

	Optional<StationUser> findByBadgeId(String badgeId);

}
