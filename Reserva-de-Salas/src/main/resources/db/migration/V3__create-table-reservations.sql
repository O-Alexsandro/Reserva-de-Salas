CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    users_id INT,
    rooms_id INT,
    data_reserve DATE NOT NULL,
    time_start TIME NOT NULL,
    time_end TIME NOT NULL,
    status VARCHAR(50),
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (rooms_id) REFERENCES rooms(id)
);