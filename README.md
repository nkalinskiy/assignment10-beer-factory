# Disclaimer
В домашках больше нельзя использовать мутабельные переменые, `throw`, касты или проверки на типы с помощью методов из Java вроде `asInstanceOf` и тд. Если не знаете, как вам проверить на типы, чем заменить `throw` или другое функционал из Java, то внимательно посмотрите прошлые лекции, там есть вся информация о данных практиках в Scala.

В домашних заданиях вы можете менять сигнатуры методов/интерфейс, если на написано обратного. Если в задании нужно реализовать определенную функцию, которая уже объявлена за вас, в таких случаях ее сигнатуру менять нельзя.

# Фабрики газированных напитков
В этом задании вам нужно реализовать домен производства различных газированных напитков:
* Sparkling Water Саяны (Франция)
* Квас "Лягаевский"
* Калинские компоты
* Напитки для детей "РосТишкин" (Россия)


Ваша задача написать алгоритм, который принимает на вход список заказов для каждого напитка. Заказ состоит из:
* Кол-ва напитков
* Максимальное время для выполнения заказа - опционально. Если не указано, то пытаемся произвести нужное кол-во напитков.

Если достигнут лимит по времени производства напитка на одной из фабрик, то произвести отмену выполнения всех заказов на всех фабриках.
Заказы можно захардкодить при запуске программы, ничего не нужно считывать из консоли.

Программа должна уметь запускать указанные фабрики в параллель. Производство напитка на каждой фабрике происходит последовательно, т.е. следующий напиток произведется только после успешного производства предыдущего. Для каждой фабрики есть конфиг:
* Название
* Кол-во ошибок производства напитков до остановки из-за халатности сотрудников
* Время на производство одного напитка в миллисекундах
* Вероятность халатности работников фабрики
* Вероятность выхода оборудования из строя
* Время починки оборудования в миллисекундах

Если оборудование вышло из строя, то производство полностью останавливается до его починки. 
Если достигнут лимит кол-ва ошибок халатности сотрудников, то все заказы на всех фабриках отменяются, и программа завершается.
 
Также, в программе есть интерфейс агрегатора результатов производства напитков. Он принимает в себя ADT результата производства каждого напитка на каждой фабрике. Подробности его реализации не важны для этого задания, поэтому просто используйте предоставленную реализацию. 

Вам необходимо написать тесты, которые бы показали все описанные выше сценарии. Проверки тестов можно основывать на получении результатов из агрегатора или вызове отдельных функций.

Референсы:
* https://typelevel.org/cats-effect/docs/concepts
* https://typelevel.org/cats-effect/api/3.x/cats/effect/IO.html
