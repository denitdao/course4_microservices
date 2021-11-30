# Микросервисы 3
## Работа с системами отправки сообщений - RabbitMQ

Предметную область взять из задания по XML.
Веб-приложение разбить на 2 части:
- первая принимает запрос от клиента, валидирует и отправляет через систему обмена сообщения второй части;
- вторая часть — забирает сообщение из очереди и сохраняет в БД.
  Система управления очередями, например RabbitMQ.

Работа с RabbitMQ https://www.youtube.com/watch?v=YrZhKepoY0Q&ab_channel=BorisBochkarev%7CBeTry

### Tutorials
Установка:
https://www.rabbitmq.com/install-windows.html

Добавление UI
https://www.rabbitmq.com/management.html

Пример работы со Spring:
https://spring.io/guides/gs/messaging-rabbitmq/

Видео по SpringBoot:
https://www.youtube.com/watch?v=uRXRIDy-6UU
 
