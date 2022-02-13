import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class HasMapTest {
    /*
    1) Проверяем метод put и get в HashMap
    Добавление инт ключа и объкта
    (Надо, чтобы доавлялся любой объект и возвращался) - > String, int , double ,
    collection, ArrayList,
    Дать в HashMap одно и тоже значение, что для ключа, то и для объекта
    Проверить вводятся ли все значения int от минимального до максимального в роли ключа

    2)Создание HashMap(? , ? ) с различными запрашиваемыми типами данных

    3)Добавить несколько Объектов с одинаковым ключам, объект с таким же ключам перезаписывается
    Это надо проверить при всех возможных наборах ключей (int_min < x < int_max)

    4)Метод clear удаляет всё содержимое контейнера
    Удалить всё содержимое ничего не записав туда и проверить как отработало
    Записать все возможные int ключи - т е максимально заплнить его и выполнить команду удаления

    5)Проверить принимается ли в роле ключа -> null
    */

    @Test
    public void SimpleTest(){
        HashMap<Integer, Object> object = new HashMap<>();
        object.put(12, "Привет");
        assertThat(object.get(12)).isEqualTo("Привет");
    }
}
