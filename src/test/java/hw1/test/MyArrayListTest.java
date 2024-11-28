package hw1.test;
import com.aston.hw1.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayListTest {
    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1); // Удаляем элемент 2

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.size()); // Размер должен быть 2
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testQuickSortNaturalOrder() {
        list.add(3);
        list.add(1);
        list.add(2);

        list.quickSort();

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testQuickSortWithComparator() {
        list.add(3);
        list.add(1);
        list.add(2);

        // Сортировка по убыванию
        Comparator<Integer> descendingComparator = (a, b) -> b.compareTo(a);

        list.quickSort(descendingComparator);

        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    void testAddAtIndex() {
        list.add(1);
        list.add(3);

        // Вставляем 2 по индексу 1
        list.add(1, 2);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testSet() {
        list.add(1);

        // Заменяем 1 на 2
        list.set(0, 2);

        assertEquals(2, list.get(0));
    }

    @Test
    void testAddManyElements() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.size());
    }
}
