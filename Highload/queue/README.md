# Домашнее задание №3

## Условие
Необходимо спроектировать систему, которая будет поддерживать систему авторизации и регистрации пользователей.

Для этого необходимо проработать систему отправки сообщений клиенту в нескольких очередях:
1. Очередь, которая будет отправлять сообщения пользователю с информацией о регистрации в системе. Вместо пароля пользователю необходимо указать почту, после которой ему на почту должно прийти письмо с токеном для установления пароля
2. После этого пользователь проходит по ссылке, заполняет свой пароль и регистрируется в системе
3. Важно поддержать инвалидацию токенов: если письмо не было зарегистрировано в течение X минут (в реальной жизни - двое суток), то токен становится нерабочим. В таком случае необходимо пользователю возвращать страницу: “токен невалидный”, просьба построить запрос

## Запуск
### При помощи скрипта
Выполнить команду
```
./start.sh
```
### В ручную
В первую очередь нужно запустить очередь
```
docker run -dit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management 
```
Далее необходимо собрать проект
```
mvn install
```
Запуск проекта осуществляется при помощи команды
```
java -jar target/queue-0.0.1-SNAPSHOT.jar
```
