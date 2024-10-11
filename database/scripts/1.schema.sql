CREATE TABLE `role` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `account` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
);

CREATE TABLE `role_account` (
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id` int NOT NULL,
  `account_id` int NOT NULL,
  PRIMARY KEY (`role_id`, `account_id`)
);

CREATE UNIQUE INDEX `title` ON `role` (`title`);

CREATE UNIQUE INDEX `username` ON `account` (`username`);

ALTER TABLE `role_account` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE;

ALTER TABLE `role_account` ADD FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE;
