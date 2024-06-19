/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wsrlabs.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;


/**
 *
 * @author wingly
 */

@JsonTest
public class CashCardJsonTest {
    
    @Autowired
    private JacksonTester<CashCard> json;
    
    @Test
    void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);
        
        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
                
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
        
    }
    
    /**
     * @throws IOException
     */
    @Test
    void cashCardDeserializationTest() throws IOException {
        String expected = """
                          {
                            "id":99,
                            "amount":123.45
                          }
                          """;
        assertThat(json.parse(expected)).isEqualTo(new CashCard(99L, 123.45));
        
        assertThat(json.parseObject(expected).id()).isEqualTo(99);
        
        assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    }
    
}
