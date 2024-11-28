package com.aston.hw1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Ручная реализация ArrayList. <p>
 * Начальный размер - {@value #INITIAL_CAPACITY}
 */
public class MyArrayList<T> {
    private static final int INITIAL_CAPACITY = 15; // Изначальный размер
    private T[] elements; // Массив для хранения элементов
    private int size; // Текущий размер списка

    /**
     * Конструктор, создающий пустой список с начальным размером массива {@value #INITIAL_CAPACITY}.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент, который нужно добавить.
     * @throws ClassCastException Если элемент не соответствует типу T.
     */
    public void add(T element) {
        checkType(element);
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Вставляет элемент по указанному индексу в список.
     *
     * @param index Индекс, по которому будет вставлен элемент.
     * @param element Элемент, который нужно вставить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимых значений.
     * @throws ClassCastException Если элемент не соответствует типу T.
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        checkType(element);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента, который нужно получить.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимых значений.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        return elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу из списка.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимых значений.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Очищает весь список, удаляя все элементы.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Сортирует элементы списка в порядке возрастания.
     * Элементы должны реализовывать интерфейс Comparable.
     */
    public void sort() {
        Arrays.sort(elements, 0, size);
    }

    /**
     * Заменяет элемент по указанному индексу новым значением.
     *
     * @param index Индекс элемента, который нужно заменить.
     * @param element Новое значение элемента.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимых значений.
     * @throws ClassCastException Если элемент не соответствует типу T.
     */
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        checkType(element);
        elements[index] = element;
    }

    /**
     * Возвращает текущее количество элементов в списке.
     *
     * @return Текущий размер списка.
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true если список пустой, иначе false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Увеличивает емкость массива при необходимости для добавления новых элементов.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    /**
     * Проверяет соответствие типа элемента типу T.
     *
     * @param element Элемент для проверки.
     * @throws ClassCastException Если элемент не соответствует типу T.
     */
    private void checkType(T element) {
        if (element != null && !(elements.getClass().getComponentType().isAssignableFrom(element.getClass()))) {
            throw new ClassCastException("Неверный тип элемента: " + element.getClass().getName());
        }
    }
    /**
     * Сортирует элементы списка с использованием алгоритма быстрой сортировки.
     *
     * @param comparator Компаратор для определения порядка сортировки.
     */
    public void quickSort(Comparator<? super T> comparator) {
        QuickSort.sort(elements, 0, size - 1, comparator);
    }

    /**
     * Сортирует элементы списка с использованием алгоритма быстрой сортировки по естественному порядку.
     */
    public void quickSort() {
        QuickSort.sort(elements, 0, size - 1, null);
    }
}
