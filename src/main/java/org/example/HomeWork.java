package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Требуется реализовать интерфейс TicketManager в соответствии с JavaDoc описанием.
     * Реализации очередей из стандартной библиотеки не используем.
     */
    public TicketManager managerFabric() {
        return new TicketManagerImpl();
    }


    /**
     * Задача со звездочкой (опционально)
     * <br/>
     * На вход строки:
     *  номер_впереди : номер_сзади
     * Если впереди или сзади никого нет - то 0, для первого и последнего в очереди.
     * На выход нужно восстановить порядок номеров в очереди.
     *
     * В тестах генератор тестовых данных (очереди и пары).
     * @see <a href="https://codeforces.com/problemset/problem/490/B?locale=ru">https://codeforces.com/problemset/problem/490/B?locale=ru</a>
     */
    public List<Integer> check(List<String> records){
//        LinkedList<Integer> queue = new LinkedList<>();
//        for (String record : records) {
//            String[] parts = record.split(":");
//            int front = Integer.parseInt(parts[0]);
//            int back = Integer.parseInt(parts[1]);
//            if (!queue.isEmpty() && queue.getFirst() == front) {
//                queue.removeFirst();
//            } else {
//                queue.addFirst(front);
//            }
//            if (!queue.isEmpty() && queue.getLast() == back) {
//                queue.removeLast();
//            } else {
//                queue.addLast(back);
//            }
//        }
//        return queue.stream().mapToInt(Integer::intValue).boxed().collect(Collectors.toList());
        return null;
    }

}
