import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class HashMapTest {
    /*
        Тест кейс сделан для проверки работоспособности методов put и get класса HashMap
        Тестирование put get используя key - Integer,  data - String
        Ключи взяты как минмиальное, максимальное значение int и 0
        Тестирование на ввод и вывод слова на русском, на английском
        Проверка пустой строки и строки с максимальным количеством символов
        Проверка строки совпадающей с ключом
        Проверка строки с числами и знаками
        Првоерка. можно ли получить значение по ключу при заполненном HashMap
    */
    @ParameterizedTest
    @MethodSource("getKey")
    public void PutGetTest(int ints){
        HashMap<Integer, String> object = new HashMap<>();

        object.put(ints, "Тест");
        assertThat(object.get(ints)).isEqualTo("Тест");

        object.put(ints, "Test");
        assertThat(object.get(ints)).isEqualTo("Test");

        object.put(ints, "");
        assertThat(object.get(ints)).isEqualTo("");

        object.put(ints, String.valueOf(ints));
        assertThat(object.get(ints)).isEqualTo(String.valueOf(ints));

        object.put(ints, "123..е");
        assertThat(object.get(ints)).isEqualTo("123..е");

        //создаём максимальную по длинне строку
        char[] array = new char[2^31 - 1];
        Arrays.fill(array, 'a');
        String string = new String(array);
        object.put(ints, string);
        assertThat(object.get(ints)).isEqualTo(string);

        //HashMap с промежуточными числами
        int number = (int)(Math.random()*10);
        for(int i=number-10;i<number;i++){
            object.put(i, "linesUpTo");
        }
        object.put(number, "Test");
        for(int i=number+1;i<(int)(Math.random()*10);i++){
            object.put(i, "linesAfter");
        }
        assertThat(object.get(number)).isEqualTo("Test");
    }

    /*
        Тест кейс сделан для проверки работоспособности методов put и get класса HashMap с различными типами данных
        Для проверки в HashMap вводятся в виде ключа и значения различные типы данных
    */
    @ParameterizedTest
    @MethodSource("getObject")
    public void PutGetObjectTest(Object obj) {
        HashMap<Object, Object> object = new HashMap<>();

        object.put(obj, obj);
        assertThat(object.get(obj)).isEqualTo(obj);
    }

    /*
        Тест кейс сделан для проверки замены значения при использовании одного и того же ключа
        Вводятся 2 строки с одним и тем же ключом, но с разными значениями
        проверяется какое значение выдаётся по заданному ключу и сколько записей находится в HashMap

        Проверяем, стирается ли старое значение при одном и тоже ключе, если HashMap заполнен данными
    */
    @ParameterizedTest
    @MethodSource("getKey")
    public void ReplacingAValueTest(int ints){
        HashMap<Object, Object> object = new HashMap<>();

        object.put(ints, "String 1");
        object.put(ints, "String 2");
        assertThat(object.get(ints)).isEqualTo("String 2");
        assertThat(object.size()).isEqualTo(1);

        //с заполненным HashMap
        int number = 1+(int)(Math.random()*10);
        for(int i=1;i<number;i++){
            object.put(i, "linesUpTo");
        }

        object.put(number, "String 3");
        int max_number=object.size() + (int)(Math.random()*10);
        for(int i=object.size();i<max_number;i++){
            object.put(i, "linesAfter");
        }

        object.put(number, "String 4");
        assertThat(object.get(number)).isEqualTo("String 4");
        assertThat(object.size()).isEqualTo(max_number);
    }

    /*
        Тест кейс сделан для проверки работоспособности метода clear класса HashMap
        Проверяем как ведёт себя метод при очистке пустого хеша
        Проверяем как метод очищает хеш заполненный различными типами данных
        Проверяем как ведёт себя метод, если хэш заполнен большим количеством данных
    */
    @ParameterizedTest
    @MethodSource("getObject")
    public void ClearTest(Object obj){
        HashMap<Object, Object> object = new HashMap<>();
        //Очистка, пустого HashMap
        object.clear();
        assertThat(object.size()).isEqualTo(0);
        //очистка разных типов данных
        object.put(obj, obj);
        object.clear();
        assertThat(object.size()).isEqualTo(0);
        //очистка большого количества данных в HashMap
        for(int i=0;i<(2^31-1);i++){
            object.put(i, i);
        }
        object.clear();
        assertThat(object.size()).isEqualTo(0);
    }
    /*
        Тест кейс был сделан для проверки может ли null быть в качестве ключа
        Для этого в хеш помещён объект с ключом null и проверяется можно ли вернуть значение по этому ключу
    */
    @Test
    public void NullTest(){
        HashMap<Object, Object> object = new HashMap<>();
        object.put(null, "Test");
        assertThat(object.get(null)).isEqualTo("Test");
    }

    //список тестируемых объектов
    public static List<Object> getObject(){
        List<Object> array = new ArrayList<>();
        array.add("Тест");
        array.add("Test");
        array.add("");
        array.add("123..е");
        array.add(0);
        array.add(Integer.MIN_VALUE);
        array.add(Integer.MAX_VALUE);
        array.add(Float.MAX_VALUE);
        array.add(Float.MIN_VALUE);
        array.add(Long.MIN_VALUE);
        array.add(Long.MAX_VALUE);
        array.add(Float.MAX_VALUE);
        array.add(Float.MIN_VALUE);
        array.add(Byte.MAX_VALUE);
        array.add(Byte.MIN_VALUE);
        array.add(Short.MAX_VALUE);
        array.add(Short.MIN_VALUE);
        array.add(12.2f);
        array.add(3.14159);
        array.add(true);
        array.add(false);
        return array;
    }

    //списко тестируемых ключей
    public static List<Integer> getKey(){
        List<Integer> array = new ArrayList<>();
        array.add(Integer.MAX_VALUE);
        array.add(Integer.MIN_VALUE);
        array.add(0);
        return array;
    }

}
