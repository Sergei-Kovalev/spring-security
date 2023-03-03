UPDATE users SET enabled = false WHERE username = 'sergey';


UPDATE users SET password = '{bcrypt}$2a$10$06pDs/biGwgyazwjZ1SCq.W6fhzEuKyqLUqLZxtpafTw9siFlNiEK' WHERE username = 'sergey';
UPDATE users SET password = '{bcrypt}$2a$10$qBc9IB.3qkMDgnCdCeYmJOaiyjj245k7J4a4pYaT5I6lw8Soi9zju' WHERE username = 'elena';
UPDATE users SET password = '{bcrypt}$2a$10$24ggG3UpygVnG5.0QcGk6e6Bdp6H5.KSbEQEnK6lCnzbIaqk6gV9K' WHERE username = 'ivan';

ALTER TABLE users ALTER COLUMN password TYPE VARCHAR(100);