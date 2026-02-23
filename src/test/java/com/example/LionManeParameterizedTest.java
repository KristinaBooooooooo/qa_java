package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionManeParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionManeParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0} → грива: {1}")
    public static Collection<Object[]> data() {
        return List.of(
                new Object[] {"Самец", true},
                new Object[] {"Самка", false}
        );
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        Feline mockFeline = mock(Feline.class);

        Lion lion = new Lion(sex, mockFeline);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}