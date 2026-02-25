package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyReturnsCorrectFamily() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParamReturnsOne() {
        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParamReturnsFive() {
        Feline feline = new Feline();

        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void getKittensWithParamReturnsZero() {
        Feline feline = new Feline();

        assertEquals(0, feline.getKittens(0));
    }

    @Test
    public void getFoodReturnsHerbivoreFood() throws Exception {
        Feline feline = new Feline();

        assertEquals(
                List.of("Трава", "Различные растения"),
                feline.getFood("Травоядное")
        );
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionForUnknownAnimalKind() throws Exception {
        Feline feline = new Feline();

        feline.getFood("Неизвестный вид");
    }
}
