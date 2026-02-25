package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        Feline mockFeline = mock(Feline.class);

        new Lion("Неизвестно", mockFeline);
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", mockFeline);

        assertEquals(3, lion.getKittens());
    }

    @Test
    public void getKittensCallsFelineGetKittensMethod() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самка", mockFeline);
        lion.getKittens();

        verify(mockFeline).getKittens();
    }

    @Test
    public void getFoodReturnsValueFromFelineEatMeat() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", mockFeline);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getFoodCallsFelineEatMeatMethod() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", mockFeline);
        lion.getFood();

        verify(mockFeline).eatMeat();
    }
}