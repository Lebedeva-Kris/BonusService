package ru.netology.bonus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @ParameterizedTest(name = "[{index}] {3}")
    @CsvSource(
            value = {
                    "'registered user, under limit', 100060, 30, true",
                    "'registered user, over limit', 100000060, 500, true",
                    "'unregistered user, under limit', 100060, 10, false",
                    "'unregistered user, over limit', 100000060, 500, false",
                    "'registered user, under limit', 500000, 150, true",
                    "'registered user, over limit', 300000000, 500, true",
                    "'unregistered user, under limit', 500000, 50, false",
                    "'unregistered user, over limit', 500000000, 500, false"
            }
    )
    void shouldCalculate(String test, long amount, long expected, boolean registered) {
        BonusService service = new BonusService();

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}