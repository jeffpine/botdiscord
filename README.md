# 🎲 Bot de Rolagem de Dados D&D — Java + JDA

Este é um bot de Discord escrito em **Java 17** utilizando a **JDA (Java Discord API)**. Ele implementa **Slash Commands** para rolagens de dados no estilo Dungeons & Dragons, incluindo suporte a vantagem e desvantagem.

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA)
- SLF4J para logging
- Discord Slash Commands

---

## 🚀 Funcionalidades

- `/roll d20` → Rola um dado de 20 lados
- `/roll 2d6+3` → Rola dois dados de 6 lados e soma +3
- `/roll d20 adv` → Rolagem com vantagem
- `/roll d20 dis` → Rolagem com desvantagem
- `/ajuda` → Mostra os comandos disponíveis

---

## 🧩 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repo.git
cd nome-do-repo
```

### 2. Configure o `pom.xml` (se estiver usando Maven)

Certifique-se de incluir:

```xml
<dependency>
  <groupId>net.dv8tion</groupId>
  <artifactId>JDA</artifactId>
  <version>5.0.0-beta.21</version>
</dependency>

<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-simple</artifactId>
  <version>2.0.17</version>
  <scope>test</scope>
</dependency>
```

### 3. Configure seu token

No arquivo `BotMain.java`, substitua:

```java
JDABuilder.createDefault("SEU_TOKEN_AQUI")
```

Por:

```java
JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"))
```

Ou mantenha fixo durante o desenvolvimento (não recomendado em produção).

---

## 🧪 Executando o Bot

```bash
mvn clean install
java -jar target/seu-bot.jar
```

---

## 🧠 Exemplo de Uso

```bash
/roll d20          → 🎲 Resultado de d20: 13
/roll 2d6+1        → 🎲 Resultado de 2d6+1: 10
/roll d20 adv      → 🎲 Vantagem: 12 vs 18 → 18
/roll d20 dis      → 🎲 Desvantagem: 7 vs 14 → 7
```

---

## 🔐 Permissões Recomendadas

Ao adicionar o bot ao seu servidor, use um link com:

```
https://discord.com/oauth2/authorize?client_id=SEU_CLIENT_ID&scope=bot%20applications.commands&permissions=274877990912
```

Permissões necessárias:
- `View Channels`
- `Send Messages`
- `Use Slash Commands`
- `Read Message History`

---

## 📚 Contribuindo

Sinta-se à vontade para abrir issues, enviar PRs ou sugerir melhorias como:
- Integração com personagens salvos
- Iniciativas em grupo
- Rolações com proficiência e atributos

---

## 🧙 Autor

Desenvolvido por **Jeff Pinheiro**  
🔗 [LinkedIn](https://www.linkedin.com/in/eijeffpinheiro/)  
🎯 Discord Bot feito com amor por DMs de D&D

---

## 🪄 Licença

Este projeto está sob a licença MIT.
