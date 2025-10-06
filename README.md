# ♟️ Jogo de Xadrez em Java

-----

### [🇬🇧/🇺🇸 English Version](https://github.com/xopxee/Chess-Game/blob/main/README_en.md)

-----

Este é um projeto de um jogo de xadrez clássico desenvolvido em Java. O objetivo é criar um motor de xadrez funcional com todas as regras padrão, operando inicialmente via console e, futuramente, com uma interface gráfica.

> **Atenção:** Este projeto está atualmente em fase de desenvolvimento. Algumas funcionalidades estão sendo construídas e a versão atual ainda não representa o jogo completo.

-----

## 📜 Sumário

* Status do Projeto
* Funcionalidades Atuais
* Roadmap e Próximos Passos
* Tecnologias Utilizadas
* Como Executar o Projeto
* Estrutura do Projeto
* Licença

-----

## 🚧 Status do Projeto

O projeto encontra-se em fase final de desenvolvimento. Está operando completamente no terminal, e apenas falta a implementação da interface gráfica para que ele esteja completo.

## ✨ Funcionalidades Atuais

* **Estrutura de Tabuleiro:** Representação completa de um tabuleiro de xadrez 8x8.
* **Design Orientado a Objetos:** Cada peça (Peão, Torre, Cavalo, Bispo, Rainha, Rei) é modelada como uma classe distinta, herdando de uma classe base `Peca`, o que promove a reutilização e manutenção do código.
* **Movimentação Completa:** Lógica de movimento e captura para todas as peças, de acordo com suas regras fundamentais.
* **Regras Complexas:** O jogo conta com regras avançadas como en passant, roque, xeque, peças cravadas.
* **Condições de Vitória ou Empate:** Xeque-Mate, Empate por afogamento, Derrota por desistência.
* **Interface de Console:** Exibição do estado atual do tabuleiro no terminal para visualização do jogo.

## 🗺️ Roadmap e Próximos Passos

A lista abaixo detalha as funcionalidades críticas que estão planejadas para as próximas versões.

- [ ] **Interface Gráfica (GUI):** Desenvolver uma interface de usuário visualmente interativa utilizando a biblioteca JavaFX para substituir a atual visualização em console.

## 🛠️ Tecnologias Utilizadas

Linguagem: Java

Plataforma: JDK (Java Development Kit) 11 ou superior

Framework de UI (Planejado): JavaFX

## 🚀 Como Executar o Projeto

Para compilar e executar este projeto localmente, siga os passos abaixo.

### Pré-requisitos

Antes de começar, certifique-se de que você tem o **Java Development Kit (JDK)** (versão 11 ou mais recente) instalado em sua máquina.

### Passos para Execução

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/xopxee/Chess-Game.git
    ```

2.  **Navegue até o diretório do projeto:**

    ```bash
    cd Chess-Game
    ```

3.  **Compile os arquivos `.java` a partir da raiz do projeto:**
    O comando abaixo compilará todas as classes necessárias, respeitando a estrutura de pacotes.

    ```bash
    javac src/**/*.java
    ```

4.  **Execute a aplicação:**
    Após a compilação bem-sucedida, execute a classe principal para iniciar o jogo no console.

    ```bash
    java src/Main
    ```

## 📂 Estrutura do Projeto

O código-fonte está organizado de forma a separar as responsabilidades, facilitando o entendimento e a manutenção.

```
Chess-Game/
├── .idea/
├── src/
│   ├── Tabuleiro/
│   │   ├── Casa.java
│   │   └── Tabuleiro.java
│   ├── pecas/
│   │   ├── Bispo.java
│   │   ├── Cavalo.java
│   │   ├── Peao.java
│   │   ├── Peca.java
│   │   ├── Rainha.java
│   │   ├── Rei.java
│   │   └── Torre.java
│   └── Main.java
├── .gitignore
├── ChessGame.iml
├── LICENSE
├── README.md
└── README_en.md
```

###[📂Diagrama UML](https://lucid.app/lucidchart/95e617d8-9ed0-4962-9897-b22b88b38569/edit?beaconFlowId=1853CEFB36C7CF9A&invitationId=inv_1e47aab7-1f42-41f4-a381-2b2e6b5ff430&page=HWEp-vi-RSFO#)

## 📄 Licença

Este projeto está licenciado sob a [Licença MIT](https://en.wikipedia.org/wiki/MIT_License). Veja o arquivo para mais detalhes.

-----
