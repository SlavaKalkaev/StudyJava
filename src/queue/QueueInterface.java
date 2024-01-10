package queue;

public interface QueueInterface<T> {

    //функция проверяет пуста ли очередь
    boolean isEmpty();

    //функция проверяет полна ли очередь
    boolean isFull();

    //возвращает длину очереди
    int size();

    //кладет значение в очередь
    int enqueue(int item);

    //возвращает первый элемент очереди и убирает его из очереди
    //(так же если очередь пустой, то нужно опрокинуть ошибку)
    Integer dequeue();

    //возвращает первый элемент очереди
    Integer peek();

    //еще метод toString
}
