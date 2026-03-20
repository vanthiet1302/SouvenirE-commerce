-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: SouvenirDB
-- ------------------------------------------------------
-- Server version	8.0.45

DROP TABLE IF EXISTS `auth_providers`;
CREATE TABLE `auth_providers` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `provider_name` varchar(50) NOT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `provider_name` (`provider_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `name` varchar(255) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE `role_permissions` (
                                    `role_id` int NOT NULL,
                                    `permission_id` int NOT NULL,
                                    `assigned_by` varchar(64) NOT NULL,
                                    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    PRIMARY KEY (`role_id`,`permission_id`),
                                    KEY `role_permissions_fk_permission` (`permission_id`),
                                    CONSTRAINT `role_permissions_fk_permission` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
                                    CONSTRAINT `role_permissions_fk_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `role_permissions` WRITE;

DROP TABLE IF EXISTS `role_users`;
CREATE TABLE `role_users` (
                              `user_id` char(36) NOT NULL,
                              `role_id` int NOT NULL,
                              `is_primary` tinyint(1) NOT NULL DEFAULT '1',
                              `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              `expired_at` datetime DEFAULT NULL,
                              PRIMARY KEY (`user_id`,`role_id`),
                              KEY `role_users_fk_role` (`role_id`),
                              CONSTRAINT `role_users_fk_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
                              CONSTRAINT `role_users_fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user_authentications`;
CREATE TABLE `user_authentications` (
                                        `user_id` varchar(50) NOT NULL,
                                        `provider_id` int NOT NULL,
                                        `identifier` varchar(255) NOT NULL,
                                        `credential_hash` varchar(255) DEFAULT NULL,
                                        `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`user_id`,`provider_id`),
                                        KEY `provider_id` (`provider_id`),
                                        CONSTRAINT `user_authentications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
                                        CONSTRAINT `user_authentications_ibfk_2` FOREIGN KEY (`provider_id`) REFERENCES `auth_providers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `id` char(36) NOT NULL,
                         `username` varchar(50) NOT NULL,
                         `last_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `first_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `email` varchar(50) NOT NULL,
                         `date_of_birth` date NOT NULL,
                         `avatar_url` varchar(255) DEFAULT NULL,
                         `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `gender` enum('MALE','FEMALE','OTHER') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
