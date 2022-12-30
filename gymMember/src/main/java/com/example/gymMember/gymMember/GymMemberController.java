package com.example.gymMember.gymMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gymMember")

public class GymMemberController {

    private final GymMemberService gymMemberService;
    @Autowired
    //Autowired is saying that the variable student service in the class will be used into this constructor
    public GymMemberController(GymMemberService gymMemberService) {
        this.gymMemberService = gymMemberService;
    }

    @GetMapping()
    public List<GymMember> getGymMember(){
        return gymMemberService.getGymMember();
    }
    @PostMapping
    public void registerGymMember(@RequestBody GymMember gymMember){
        gymMemberService.addNewGymMember(gymMember);
    }
    @DeleteMapping(path = "{gymMemberID}")
    public void deleteGymMember(@PathVariable("gymMemberID") Long gymMemberId){
        gymMemberService.deleteGymMember(gymMemberId);
    }
    @PutMapping(path = "{gymMemberID}")
    public void updateGymMember(
            @PathVariable("gymMemberID") Long gymMemberId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Double weight){
        gymMemberService.updateGymMember(gymMemberId, name, email, weight);
    }
}
