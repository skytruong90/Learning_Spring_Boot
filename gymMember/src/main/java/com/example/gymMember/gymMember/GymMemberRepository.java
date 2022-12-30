package com.example.gymMember.gymMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//_____Repository is the naming convention for anything that acts as your database

@Repository
//extending to the JpaRepository gives us access to methods such as .finAll, .delete, etc.
public interface GymMemberRepository
        extends JpaRepository<GymMember, Long> {
    @Query("Select s From GymMember s Where s.email = ?1")
    Optional<GymMember> findGymMemberByEmail(String Email);
}
