insert into bus(bus_number, bus_name, facilities) values
    ('Na 7 Kha 6778', 'SiddhaBaba Rocket', 'Free Wi-Fi, Personal power outlets, Reclining leather seats, Extra legroom, Overhead storage, On-board restroom, and Eco-friendly'),
    ('Ba 7 Kha 2978', 'Bouddhanath Yatayat', 'Free Wi-Fi, Personal power outlets, Reclining leather seats, Extra legroom, Overhead storage, On-board restroom, and Eco-friendly'),
    ('Ga 4 Kha 5023', 'Gandaki Express', 'Free Wi-Fi, Personal power outlets, Reclining leather seats, Extra legroom, Overhead storage, On-board restroom, and Eco-friendly'),
    ('Lu 4 Kha 2978', 'Lumbini Rocket A/C', 'Free Wi-Fi, Personal power outlets, Reclining leather seats, Extra legroom, Overhead storage, On-board restroom, and Eco-friendly'),
    ('Ba 2 Kha 6778', 'Vikings Express', 'Free Wi-Fi, Personal power outlets, Reclining leather seats, Extra legroom, Overhead storage, On-board restroom, and Eco-friendly');

insert into ticket(fare_per_seat, total_seats, available_seats, source, destination, bus_id)
    (select 1600 as fare_per_seat, 29 as total_seats, 29 as available_seats, 'Syangja' as source, 'Dang' as destination, bus_id from bus where bus_number = 'Na 7 Kha 6778');
insert into ticket(fare_per_seat, total_seats, available_seats, source, destination, bus_id)
    (select 1500 as fare_per_seat, 24 as total_seats, 23 as available_seats, 'Dharan' as source, 'Kathmandu' as destination, bus_id from bus where bus_number = 'Ba 7 Kha 2978');
insert into ticket(fare_per_seat, total_seats, available_seats, source, destination, bus_id)
    (select 2000 as fare_per_seat, 29 as total_seats, 24 as available_seats, 'Pokhara' as source, 'Butwal' as destination, bus_id from bus where bus_number = 'Ga 4 Kha 5023');
insert into ticket(fare_per_seat, total_seats, available_seats, source, destination, bus_id)
    (select 2000 as fare_per_seat, 24 as total_seats, 24 as available_seats, 'Butwal' as source, 'Kathmandu' as destination, bus_id from bus where bus_number = 'Lu 4 Kha 2978');
insert into ticket(fare_per_seat, total_seats, available_seats, source, destination, bus_id)
    (select 1300 as fare_per_seat, 26 as total_seats, 26 as available_seats, 'Pokhara' as source, 'Kathmandu' as destination, bus_id from bus where bus_number = 'Ba 2 Kha 6778');

insert into user(username, email, password, first_name, last_name, active) values ('admin', 'admin@test.com', '{bcrypt}$2a$10$HxqBhsGL2ti29ZLy6CGn/e.D5uTM9D7JejBylV7kDyYe1H9b.GLKG', 'Admin', 'Admin', true);

insert into role(role) values ('USER'), ('ADMIN');

insert into user_role (user_id, role_id)
    (select u.user_id, r.role_id from user u, role r where u.username = 'admin' and r.role = 'ADMIN');
