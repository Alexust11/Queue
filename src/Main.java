import java.awt.*;
import java.util.*;
import java.util.List;

//Подходя к кассе супермаркета, мы выбираем очередь, в которой меньше всего людей. Когда становится слишком много людей,
// один из сотрудников вызывает Галю, открывающую дополнительную кассу.
//        Напишите программу, в которой имитируется данное поведение.
//        Создайте 2 очереди (Queue<String>) с максимальной размерностью 5.
//        Заполните обе очереди случайным количеством элементов (от 0 до 5 — для каждой очереди свой случайный элемент).
//        В качестве значения используйте имя человека в этой очереди (можно использовать любую строку/строки).
//        Напишите новый метод, принимающий строку (имя человека), который добавляет человека в очередь,
//        где меньше всего людей. Если обе очереди заполнены, выведите в консоль просьбу позвать Галю.
//
//





public class Main {

    private static final List<String> NAMES =List.of("Вася","Петя","Нина","Галя","Коля","Карина",
            "Оля", "Игорь", "Лена","Иван", "Петр","Федр");
    private static Random random = new Random();
    private static Queue<String> queue3 = new ArrayDeque<>();
    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();


        queueForming(queue1);
        queueForming(queue2);
        System.out.println("Первая очередь-{ "+queue1+" }");
        System.out.println("Вторая очередь-{ "+queue2+" }");
        queueAddMen("Зина",queue1,queue2);

    }

    private static void queueForming(Queue queue) {
        int size=random.nextInt(6);// формирует случаный размер очереди в пределах 6
        System.out.println(size);
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                queue.offer(NAMES.get(random.nextInt(NAMES.size())));// добовляет в конец очереди случаное имя из списка NAMES

            }
        }
    }

    private static void queueAddMen(String name, Queue queue1, Queue queue2) {
        if (queue1.size() < queue2.size()&&queue1.size()<6) {
            queue1.offer(name);
            System.out.println( name+ " добавлена в первую очередь");
            System.out.println(queue1);
        }
        if (queue2.size() < queue1.size()&&queue2.size()<6) {
            queue1.offer(name);
            System.out.println( name+ " добавлена во вторую очередь");
            System.out.println(queue2);
        }
        if (queue1.size() > 5 && queue2.size() > 5) {
            System.out.println("Позовите Галю!!! Делаем третью очередь");
            queue3.offer(name);
            System.out.println("Третья очередь "+queue3);
        }


    }
    }




