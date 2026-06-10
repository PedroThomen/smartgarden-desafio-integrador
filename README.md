# SmartGarden

Sistema inteligente de monitoramento e controle de irrigação desenvolvido para o Desafio Integrador do 6º período de Engenharia de Software.

## Objetivo

O objetivo do projeto é permitir o monitoramento da umidade do solo e o controle remoto da irrigação por meio de um aplicativo mobile integrado a uma API REST e a um dispositivo IoT ESP32.

## Tecnologias Utilizadas

- Flutter
- Dart
- Spring Boot
- Java 21
- MySQL
- ESP32
- HTTP REST
- Git/GitHub

## Estrutura do Sistema

O sistema é dividido em três partes principais:

- Aplicativo Flutter: responsável pela interface mobile.
- API Spring Boot: responsável pelas regras de negócio e comunicação com o banco.
- ESP32: responsável pela comunicação IoT e envio de dados para a API.

## Funcionalidades

- Cadastro de usuários
- Login de usuários
- Dashboard com leitura de umidade
- Controle remoto da irrigação
- Registro de leituras
- Registro de acionamentos
- Relatórios com média, máxima, mínima e quantidade de irrigações

## Banco de Dados

O banco utilizado é o MySQL.

Tabelas principais:

- usuarios
- leituras
- irrigacoes

## Como executar a API

1. Abrir o XAMPP.
2. Iniciar o MySQL.
3. Criar o banco:

## Integração IoT

O ESP32 realiza comunicação HTTP com a API Spring Boot, enviando leituras de umidade e recebendo comandos relacionados ao sistema de irrigação.


```sql
CREATE DATABASE smartgarden;

