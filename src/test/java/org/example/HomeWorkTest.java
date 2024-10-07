package org.example;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    void managerFabric() {
        var manager = homeWork.managerFabric();
        var now = OffsetDateTime.now();
        var ticket1 = new Ticket(Ticket.PENSION, now);
        var ticket2 = new Ticket(Ticket.OTHER, now.plusMinutes(1));
        var ticket3 = new Ticket(Ticket.OTHER, now.plusMinutes(2));
        var ticket4 = new Ticket(Ticket.PENSION, now.plusMinutes(3));
        var ticket5 = new Ticket(Ticket.OTHER, now.plusMinutes(4));
        var ticket6 = new Ticket(Ticket.PENSION, now.plusMinutes(5));

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        assertEquals(ticket1, manager.next());
        assertEquals(ticket4, manager.next());
        assertEquals(ticket6, manager.next());
        assertEquals(ticket2, manager.next());
        assertEquals(ticket3, manager.next());
        assertEquals(ticket5, manager.next());
        assertThrows(NullPointerException.class, () -> manager.add(null));
    }

    @Test
    void check() {
        List<Integer> expectedQueue = generateQueue(1, 4);
        List<String> pairs = generatePairs(expectedQueue);
        assertEquals(expectedQueue, homeWork.check(pairs));
    }

    private List<String> generatePairs(List<Integer> expectedQueue) {
        List<String> pairs = new ArrayList<>();
        Function<Integer, Integer> map = (x) -> (x < 0 || x >= expectedQueue.size()) ? 0 : expectedQueue.get(x);

        for (int i = 0;
             i < expectedQueue.size(); i++) {
            pairs.add(String.format("%d:%d", map.apply(i - 1), map.apply(i + 1)));
        }
        Collections.shuffle(pairs);
        return pairs;
    }

    private List<Integer> generateQueue(int seed, int length) {
        return new Random(seed)
                .ints(1, length * 100)
                .limit(length)
                .boxed()
                .collect(Collectors.toList());
    }


}