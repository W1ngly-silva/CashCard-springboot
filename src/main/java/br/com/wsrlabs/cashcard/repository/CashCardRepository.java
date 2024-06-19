/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.wsrlabs.cashcard.repository;

import br.com.wsrlabs.cashcard.CashCard;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author wingl
 */
public interface CashCardRepository extends CrudRepository<CashCard, Long>{
    
}
