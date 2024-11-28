package com.aston.hw1;

import java.util.Comparator;

/**
 * Класс QuickSort реализует алгоритм быстрой сортировки.
 */
public class QuickSort {

    /**
     * Сортирует массив с использованием алгоритма быстрой сортировки.
     *
     * @param elements Массив элементов для сортировки.
     * @param low Начальный индекс диапазона.
     * @param high Конечный индекс диапазона.
     * @param comparator Компаратор для определения порядка сортировки. Может быть null.
     */
    public static <T> void sort(T[] elements, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(elements, low, high, comparator);
            sort(elements, low, pivotIndex - 1, comparator);
            sort(elements, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Разделяет массив на две части для быстрой сортировки.
     *
     * @param elements Массив элементов для сортировки.
     * @param low Начальный индекс диапазона.
     * @param high Конечный индекс диапазона.
     * @param comparator Компаратор для определения порядка сортировки. Может быть null.
     * @return Индекс опорного элемента после разделения.
     */
    private static <T> int partition(T[] elements, int low, int high, Comparator<? super T> comparator) {
        T pivot = elements[high]; // Опорный элемент
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(elements[j], pivot, comparator) <= 0) {
                i++;
                swap(elements, i, j);
            }
        }
        swap(elements, i + 1, high); // Помещаем опорный элемент на правильную позицию
        return i + 1;
    }

    /**
     * Сравнивает два элемента с учетом компаратора или естественного порядка.
     *
     * @param a Первый элемент.
     * @param b Второй элемент.
     * @param comparator Компаратор для определения порядка сортировки. Может быть null.
     * @return Результат сравнения: отрицательное значение если a < b,
     *         ноль если a == b и положительное значение если a > b.
     */
    private static <T> int compare(T a, T b, Comparator<? super T> comparator) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else if (a instanceof Comparable) {
            return ((Comparable<T>) a).compareTo(b);
        } else {
            throw new ClassCastException("Элементы не могут быть сравнены.");
        }
    }

    /**
     * Меняет местами два элемента в массиве.
     *
     * @param elements Массив элементов для сортировки.
     * @param i Индекс первого элемента.
     * @param j Индекс второго элемента.
     */
    private static <T> void swap(T[] elements, int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
