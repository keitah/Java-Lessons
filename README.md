# Java-Lessons   <br />
<h1>V1.2.0</h1>  <br />
<h3>Что было обновлено:</h3>   <br />
* Полностью переделан функционал "search", теперь он ищет не по firstName, а по id записи   <br />
* Удалена функция name, её заменили firstName, lastName, middleName   <br />
* Добавлен функционал ввода dateOfBirth как при добавлении записи, так и при обновлении данных   <br />
* Исправление минорных багов, варнингов, недочётов, грамматических оборотов и косметических несоответствий   <br />
Скрипт на Java, который выполняет базовые функции Controller-Person, а именно: add, update, list, delete, search или exit  <br />
1) Распределить код из Main по трём пакетам:  <br />
* controller - отображение и работа с вводом,  <br />
* service - логика приложения, по созданию, обновлению и удалению,  <br />
* storage - хранилище  <br />
2) Добавить в Person поле Id, которое будет отвечать за порядковый номер записи. Этот номер присваивается при записи в хранилище. Должен начинаться от 0. <br /> 
3) Все переменные в исполняемых классах должны быть инкапсулированы.  <br />
4) Доступ из контроллера в сервис, должен осуществляться через интерфейс  <br />
5) Должны осуществляться функции: add, update, list, delete, search и exit  <br />
6) Функция search осуществляет поиск по внутреннему "id"   <br />
<h1>V1.1.0</h1>  <br />
<h3>Что было обновлено:</h3>   <br />
<h4>Важная правка - отдельный файл Main.java, исполняющий функции "монитора" из controller.java</h4>  <br />
Скрипт на Java, который выполняет базовые функции Controller-Person, а именно: add, update, list, delete, search или exit  <br />
1) Распределить код из Main по трём пакетам:  <br />
* controller - отображение и работа с вводом,  <br />
* service - логика приложения, по созданию, обновлению и удалению,  <br />
* storage - хранилище  <br />
2) Добавить в Person поле Id, которое будет отвечать за порядковый номер записи. Этот номер присваивается при записи в хранилище. Должен начинаться от 0. <br /> 
3) Все переменные в исполняемых классах должны быть инкапсулированы.  <br />
4) Доступ из контроллера в сервис, должен осуществляться через интерфейс  <br />
5) Должны осуществляться функции: add, update, list, delete, search и exit  <br />
<h1>V1.0.0</h1>  <br />
Скрипт на Java, который выполняет базовые функции Controller-Person, а именно: add, update, list, delete или exit <br /> 
Задачи эксперимента:  <br />
1) Распределить код из Main по трём пакетам:  <br />
* controller - отображение и работа с вводом,  <br />
* service - логика приложения, по созданию, обновлению и удалению,  <br />
* storage - хранилище  <br />
2) Добавить в Person поле Id, которое будет отвечать за порядковый номер записи. Этот номер присваивается при записи в хранилище. Должен начинаться от 0.  <br />
3) Все переменные в исполняемых классах должны быть инкапсулированы.  <br />
4) Доступ из контроллера в сервис, должен осуществляться через интерфейс  <br />
