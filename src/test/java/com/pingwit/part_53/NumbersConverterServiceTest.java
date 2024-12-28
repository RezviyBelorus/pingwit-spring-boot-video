package com.pingwit.part_53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersConverterServiceTest {

    private final NumbersConverterService subject = new NumbersConverterService();

    @Test
    void valueOf_ValidPositiveNumber() {
        //given
        String input = "123";
        Integer expected = 123;

        //when
        Integer actual = subject.valueOf(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void valueOf_ValidNegativeNumber() {
        //given
        String input = "-123";
        Integer expected = -123;

        //when
        Integer actual = subject.valueOf(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void valueOf_InvalidNumberWithLetter() {
        //given
        String input = "-12aa3";

        //when
        Integer actual = subject.valueOf(input);

        //then
        assertNull(actual);
    }

    @Test
    void valueOf_EmptyString() {
        //given
        String input = "";

        //when
        Integer actual = subject.valueOf(input);

        //then
        assertNull(actual);
    }

    @Test
    void valueOf_WhitespaceString() {
        //given
        String input = "     ";

        //when
        Integer actual = subject.valueOf(input);

        //then
        assertNull(actual);
    }
}