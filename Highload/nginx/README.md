# Домашнее задание №1

## API Java Spring APP

1) `http://localhost:port/api/date` - Возвращает JSON-файл с 10 000 одинаковыми записями `{ "year", "month", "day" }` - текущая дата запроса 

2) `http://localhost:port/api/person?name=<имя>` - Возвращает JSON-файл с 10 000 одинаковыми записями `{ "name" }`, где имя "name" получено из POST-параметра формы запроса

## Конфигурация nginx для кэширования и балансировки

Необходимо создать папку `/var/cache/nginx`, также нужно выполнить команду `nginx -c nginx.conf`

```
events {}

http {
    proxy_cache_path /var/cache/nginx keys_zone=cache:10m inactive=60m;

    upstream backend {
        server localhost:8888;
        server localhost:8889;
        server localhost:8890;
    }

    server {
        listen 8000;

        location /api {
            proxy_pass http://backend/api;
            proxy_cache cache;
            proxy_cache_valid any 10m;
            add_header X-Proxy-Cache $upstream_cache_status;

        }
    }
}

```

В папке `nginx` есть скрипт и jar файлы для запуска трех экземпляров REST API сервиса. Убедитесь, что порты `8888`, `8889` и `8890` не заняты, а также стоит `java11`.

## Измерения при помощи apache-utils2

1) `ab -c 250 -n 10000 http://localhost:8888/api/date`

```
Concurrency Level:      250
Time taken for tests:   32.791 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      3201300000 bytes
HTML transferred:       3200010000 bytes
Requests per second:    304.96 [#/sec] (mean)
Time per request:       819.777 [ms] (mean)
Time per request:       3.279 [ms] (mean, across all concurrent requests)
Transfer rate:          95339.01 [Kbytes/sec] received
```

2) `ab -c 250 -n 10000 http://localhost:8888/api/person?name=Aleksey`

```
Concurrency Level:      250
Time taken for tests:   10.446 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      1901300000 bytes
HTML transferred:       1900010000 bytes
Requests per second:    957.27 [#/sec] (mean)
Time per request:       261.159 [ms] (mean)
Time per request:       1.045 [ms] (mean, across all concurrent requests)
Transfer rate:          177740.16 [Kbytes/sec] received
```

### Протестируем через nginx
1) `ab -c 250 -n 10000 http://localhost:8000/api/date`

```
Concurrency Level:      250
Time taken for tests:   2.028 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      3201810004 bytes
HTML transferred:       3200010000 bytes
Requests per second:    4930.29 [#/sec] (mean)
Time per request:       50.707 [ms] (mean)
Time per request:       0.203 [ms] (mean, across all concurrent requests)
Transfer rate:          1541585.77 [Kbytes/sec] received
```

2) `ab -c 250 -n 10000 http://localhost:8000/api/person?name=Aleksey`

```
Concurrency Level:      250
Time taken for tests:   1.508 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      1901810001 bytes
HTML transferred:       1900010000 bytes
Requests per second:    6629.60 [#/sec] (mean)
Time per request:       37.710 [ms] (mean)
Time per request:       0.151 [ms] (mean, across all concurrent requests)
Transfer rate:          1231273.09 [Kbytes/sec] received
```

## Итог
  Действительно при подключении балансировщика нагрузки и кэширования удалось ускорить работу сервиса в несколько раз. Также появилось отказоусточивость, ведь если отвалится какой-то из сервисов, все равно конечная точка будет выдавать результаты наших запросов.
