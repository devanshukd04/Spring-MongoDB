package com.example.Spring.MongoDB.controller;

import com.example.Spring.MongoDB.models.VoterCard;
import com.example.Spring.MongoDB.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voter")
public class Controller {

    @Autowired
    private VoterRepository voterRepository;

    @GetMapping("/")
    public ResponseEntity<?> getVoter(){
        return ResponseEntity.ok(this.voterRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> addVoter(@RequestBody VoterCard voter){
        VoterCard votersave=this.voterRepository.save(voter);
        return ResponseEntity.ok(votersave);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteVoter(@PathVariable("id") int id){
        try{
            this.voterRepository.deleteById(id);
            return ResponseEntity.ok("Deleted Data with id "+id);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateVoter(@PathVariable("id") int id,@RequestBody VoterCard voter){
        try{
            VoterCard old=(VoterCard) this.voterRepository.findFirstById(id);
            old=voter;
            VoterCard update=this.voterRepository.save(old);
            return ResponseEntity.ok(update);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
