package com.example.apiathlete.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {

    @Test
    public void testState(){
        //fixture
        String nameState = "Paraíba";
        String uf = "PB";
        //Created object
        State state = new State();
        state.setStateName(nameState);
        state.setUf(uf);
        // Asserts
        assertEquals(state.getStateName(), "Paraíba");
        assertEquals(state.getUf(), "PB");
    }
}
