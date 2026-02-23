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
    public void getKittensCallsFelineMethodOnce() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самка", mockFeline);

        assertEquals(5, lion.getKittens());
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    public void getFoodReturnsFoodFromPredator() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы"));

        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы"), food);
        verify(mockFeline).eatMeat();
    }
}