CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    users_id INT,
    rooms_id INT,
    dataReserve DATE NOT NULL,
    timeStart TIME NOT NULL,
    timeEnd TIME NOT NULL,
    status VARCHAR(50),
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (rooms_id) REFERENCES rooms(id)
);