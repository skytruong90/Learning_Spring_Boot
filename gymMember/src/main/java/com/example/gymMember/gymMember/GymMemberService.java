package com.example.gymMember.gymMember;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Component is used to tell gymMemberController that gymMember Service is a bean
//@Service is functionally the same as @Component, but it is more specific fro readability sake
public class GymMemberService {

    private final GymMemberRepository gymMemberRepository;

    @Autowired
    public GymMemberService(GymMemberRepository gymMemberRepository) {
        this.gymMemberRepository = gymMemberRepository;
    }

    public List<GymMember> getGymMember(){
        return gymMemberRepository.findAll();
    }

    public void addNewGymMember( GymMember gymMember) {
        Optional<GymMember> gymMemberByEmail = gymMemberRepository
                .findGymMemberByEmail(gymMember.getEmail());
        if(gymMemberByEmail.isPresent()){
            throw new IllegalStateException("email taken, MY GUY");
        }
        gymMemberRepository.save(gymMember);
        System.out.println(gymMember);
    }

    public void deleteGymMember(Long gymMemberId) {
        boolean exists = gymMemberRepository.existsById(gymMemberId);
        if(!exists){
            throw new IllegalStateException("Gym Member with ID" + gymMemberId+ " does not exist, MY GUY");
        }
        gymMemberRepository.deleteById(gymMemberId);
    }

    @Transactional
    public void updateGymMember(Long gymMemberId, String name, String email, Double weight) {
        GymMember gymMember = gymMemberRepository.findById(gymMemberId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with Id" + gymMemberId + "does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(gymMember.getName(), name)) {
            gymMember.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(gymMember.getEmail(), email)) {
            Optional<GymMember> gymMemberOptional = gymMemberRepository
                    .findGymMemberByEmail(email);
            if (gymMemberOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            gymMember.setName(email);
        }

        if (weight != null &&
                weight > 0 &&
                !Objects.equals(gymMember.getWeight(), weight)) {
            gymMember.setWeight(weight);
        }
    }
}
