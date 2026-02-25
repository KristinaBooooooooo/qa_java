package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatTest {

    @Test
    public void getSoundReturnsMeow() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsValueFromFelineEatMeat() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(feline);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void getFoodCallsFelineEatMeatMethod() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(feline);
        cat.getFood();

        verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void getFoodPropagatesExceptionFromPredator() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenThrow(new Exception("ошибка еды"));

        Cat cat = new Cat(feline);

        cat.getFood();
    }
}