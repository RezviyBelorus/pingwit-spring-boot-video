package com.pingwit.part_53;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonesBookWarehouseTest {

    private final PhonesBookWarehouse subject = new PhonesBookWarehouse();

    @BeforeEach
    private void setUp() {
        subject.newContact("Egorka", 666);
        subject.newContact("Olga", 777);
    }

    @Test
    void newContact() {
        //given
        //when
        //then
        assertEquals(666, subject.getPhone("Egorka"));
        assertEquals(777, subject.getPhone("Olga"));
    }

    @Test
    void removeContact() {
        //given
        //when
        Integer actual = subject.removeContact("Egorka");
        //then
        assertEquals(666, actual);
    }

    @Test
    void getPhone() {
        //given
        //when
        Integer actual = subject.getPhone("Egorka");
        //then
        assertEquals(666, actual);
    }

    @Test
    void getTotalContacts() {
        //given
        //when
        Integer actual = subject.getTotalContacts();
        //then
        assertEquals(2, actual);
    }

}