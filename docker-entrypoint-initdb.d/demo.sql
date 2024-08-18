-- Adminer 4.8.1 MySQL 8.0.32 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `caches`;
CREATE TABLE `caches` (
  `id` bigint NOT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `caches` (`id`, `content`) VALUES
(0,	'demo-content');

DROP TABLE IF EXISTS `certificates`;
CREATE TABLE `certificates` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `code` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `certificates` (`id`, `user_id`, `code`) VALUES
(1,	0,	'vault:v1:HK9pD7Vq7ysydMcgAbJM3xNGkERPVBBCRrRhtiwdaIivh/zNOQ==');

DROP TABLE IF EXISTS `locations`;
CREATE TABLE `locations` (
  `id` bigint NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `longitude` decimal(17,14) DEFAULT NULL,
  `latitude` decimal(17,14) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `locations` (`id`, `name`, `longitude`, `latitude`) VALUES
(0,	'shanghai',	121.51977539062500,	31.04822792454978),
(1,	'hangzhou',	120.91683347717286,	29.66550424246299),
(2,	'nanjing',	120.91683347717286,	29.69413920369897);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint NOT NULL,
  `status` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `orders` (`id`, `status`, `user_id`) VALUES
(0,	1,	0);

DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `count` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `points` (`id`, `user_id`, `count`) VALUES
(0,	0,	1);

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` bigint NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `dirty` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products` (`id`, `name`, `status`, `dirty`) VALUES
(0,	'battery',	0,	1);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `gender` int DEFAULT NULL,
  `name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` (`id`, `gender`, `name`) VALUES
(0,	1,	'tom');

-- 2024-08-18 12:45:23
