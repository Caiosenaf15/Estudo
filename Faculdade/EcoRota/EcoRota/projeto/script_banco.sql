-- Script para criar/atualizar o banco de dados EcoRota

CREATE DATABASE IF NOT EXISTS ecorota;
USE ecorota;

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha_hash VARCHAR(255) NOT NULL,
    cor_fundo VARCHAR(7) DEFAULT '#f5fff9',
    cor_fonte VARCHAR(7) DEFAULT '#333333'
);

INSERT IGNORE INTO usuario (usuario, senha_hash, cor_fundo, cor_fonte) 
VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '#e8f5e8', '#2c5e2c');

CREATE TABLE IF NOT EXISTS motorista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS trajeto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    origem VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    distancia DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS viagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    motorista_id INT NOT NULL,
    trajeto_id INT NOT NULL,
    data_viagem DATE NOT NULL,
    FOREIGN KEY (motorista_id) REFERENCES motorista(id),
    FOREIGN KEY (trajeto_id) REFERENCES trajeto(id)
); 