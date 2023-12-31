package queue;

public interface QueueInterface<T> {

    //функция проверяет пуста ли очередь
    boolean isEmpty();

    //функция проверяет полна ли очередь
    boolean isFull();

    //возвращает длину очереди
    int size();

    //кладет значение в очередь
    void enqueue(T item);

    //возвращает первый элемент очереди и убирает его из очереди
    //(так же если очередь пустой, то нужно опрокинуть ошибку)
    T dequeue();

    //возвращает первый элемент очереди
    T peek();

    //еще метод toString
}
