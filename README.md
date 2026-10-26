# Spotify: tocar música pelo terminal

Programa de console em **Java** que usa a **API Web do Spotify** para mostrar o nome do usuário logado e **iniciar a reprodução de uma faixa** no dispositivo Spotify dele.

## Para que serve

É um estudo de integração com a API do Spotify: autenticação por *access token*, leitura do perfil do usuário e controle de reprodução (play) a partir do código.

## Como funciona

1. O programa pede o **token de acesso** (OAuth) do Spotify.
2. Cria o cliente da API com esse token.
3. Consulta o perfil do usuário e imprime o **nome de exibição**.
4. Pede a faixa a tocar e envia o comando de *play* para o Spotify.

### O que você precisa ter

- Um **access token** válido do Spotify, gerado com a permissão (*scope*) `user-modify-playback-state`. Veja [como obter](https://developer.spotify.com/documentation/web-api/concepts/access-token).
- Uma conta **Spotify Premium** e um **dispositivo ativo**: o aplicativo do Spotify aberto no celular ou no computador. A API de controle de reprodução exige isso.
- A faixa deve ser informada como **URI do Spotify**, no formato `spotify:track:<id>`.

> O token expira depois de cerca de uma hora. Nunca coloque seu token no código nem o publique no GitHub: o programa o recebe pelo teclado justamente por isso.

## Tecnologias

- Java 21 e Maven
- [spotify-web-api-java](https://github.com/spotify-web-api-java/spotify-web-api-java) 9.4.0
- slf4j-simple (logs)

## Estrutura

```
src/main/java/net/bifewagyu/
├── Main.java                  # lê o token e a música e chama a classe abaixo
└── config/SpotifyToken.java   # configura a API, busca o perfil e envia o play
```

## Como executar

Pré-requisitos: **JDK 21** e **Maven**.

```bash
git clone https://github.com/guilherf/SpotifyTocarToken.git
cd SpotifyTocarToken
mvn compile exec:java -Dexec.mainClass=net.bifewagyu.Main
```

## Autor

Guilherme Ferreira — [@guilherf](https://github.com/guilherf)
