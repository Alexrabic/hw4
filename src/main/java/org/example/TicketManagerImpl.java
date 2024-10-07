package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketManagerImpl implements TicketManager {

    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public void add(Ticket ticket) {
        if (ticket == null) {
            throw new NullPointerException("Нельзя передавать null");
        }
        tickets.add(ticket);
        Collections.sort(tickets);
    }

    @Override
    public Ticket next() {
        return tickets.isEmpty() ? null : tickets.remove(0);
    }
}
