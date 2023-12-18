package linkedlist;

interface LinkedListInterface<T> {

    //добавляет в конец списка элемент
    void add(T data);

    //возвращает длину списка
    int size();

    //возвращает элемент лежащий на индексе, если длина списка меньше индекса то выкидывает ошибку IndexOutOfBoundsException
    T get(int index);

    //удаляет элемент лежащий на индексе, если длина списка меньше индекса то выкидывает ошибку IndexOutOfBoundsException
    void remove(int index);

    //добавляет элемент лежащий на индексе, если длина списка меньше индекса то выкидывает ошибку IndexOutOfBoundsException
    void add(int index, T data);
}
