package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryIntSearchTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает список
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        if (count < 1) {
            throw new IllegalArgumentException("Count have to be greater then 0");
        }

        List<Integer> entrySet = entrySet();
        entrySet.sort(Comparator.comparingInt(Integer::intValue).reversed());

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < entrySet.size() && result.size() < count; i++) {
            if (entrySet.get(i) <= upperBound) {
                result.add(entrySet.get(i));
            }
        }

        return result;
    }

    public List<Integer> entrySet() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();

            if (list.contains(current.value)) {
                continue;
            }
            if (current.right != null) {
                if (!list.contains(current.right.value)) {
                    stack.push(current);
                    stack.push(current.right);
                    continue;
                }
                list.add(current.value);
            }

            if (current.left != null) {
                if (!list.contains(current.left.value)) {
                    stack.push(current);
                    stack.push(current.left);
                    continue;
                }
                list.add(current.value);
            }

            if (current.left == null && current.right == null) {
                list.add(current.value);
            }
        }

        return list;
    }
}