/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wsrlabs.cashcard.controllers;

import br.com.wsrlabs.cashcard.CashCard;
import br.com.wsrlabs.cashcard.repository.CashCardRepository;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author wingly
 */
@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    
    private final CashCardRepository cashCardRepository;
    
    private CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }
    
    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        
        if (cashCardOptional.isPresent()) {  
            return ResponseEntity.ok(cashCardOptional.get());
        } else{
            return ResponseEntity.notFound().build();
        }

    }
}
