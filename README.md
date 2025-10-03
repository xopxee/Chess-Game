# ♟️ Chess Game in Java

Este é um projeto de um jogo de xadrez clássico desenvolvido em Java. O objetivo é criar um motor de xadrez funcional com todas as regras padrão, operando inicialmente via console e, futuramente, com uma interface gráfica.

> **Atenção:** Este projeto está atualmente em fase de desenvolvimento. As funcionalidades principais estão sendo construídas e a versão atual ainda não representa o jogo completo.

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

O projeto encontra-se em construção. A estrutura base do tabuleiro e o movimento das peças foram implementados, mas as regras complexas e condições de vitória ainda não foram finalizadas.

## ✨ Funcionalidades Atuais

  * **Estrutura de Tabuleiro:** Representação completa de um tabuleiro de xadrez 8x8.
  * **Design Orientado a Objetos:** Cada peça (Peão, Torre, Cavalo, Bispo, Rainha, Rei) é modelada como uma classe distinta, herdando de uma classe base `Peca`, o que promove a reutilização e manutenção do código.
  * **Movimentação Básica:** Implementação da lógica de movimento e captura para todas as peças, de acordo com suas regras fundamentais.
  * **Interface de Console:** Exibição do estado atual do tabuleiro no terminal para visualização do jogo.

## 🗺️ Roadmap e Próximos Passos

A lista abaixo detalha as funcionalidades críticas que estão planejadas para as próximas versões.

  - [ ] **Lógica de Jogo Avançada:** Implementar as condições de xeque-mate e empate (stalemate).
  - [ ] **Regras de Xeque:** Programar as restrições de movimento para peças que estão "cravadas" (pinned), ou seja, que não podem se mover pois deixariam o seu rei em xeque.
  - [ ] **Movimentos Especiais:** Adicionar a lógica para o movimento especial de Roque (castling).
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
├── LICENSE
├── Prototipo Xadrez.iml
└── README.md
```

## 📄 Licença

Este projeto está licenciado sob a [Licença MIT](https://en.wikipedia.org/wiki/MIT_License). Veja o arquivo para mais detalhes.

-----
