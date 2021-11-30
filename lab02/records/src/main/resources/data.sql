insert into record (id, station_id, description, created_at)
values (1, 1, 'Good weather', now()),
       (2, 1, 'Bad weather', now()),
       (3, 2, 'Bad weather', now()),
       (4, 3, 'Bad weather', now()),
       (5, 3, 'Normal weather', now());

insert into additional_info (id, record_id, airflow, humidity, temperature)
values (1, 1, 'Mild, South', 53.2, 21.3),
       (2, 2, 'Strong, South-East', 45.1, 24.2),
       (3, 3, 'Strong, South-West', 72.7, 26.2),
       (4, 4, 'Super Strong, North', 48.8, 23.7),
       (5, 5, 'Mild, West', 62.2, 21.5);