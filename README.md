# FilmLibrary
É uma api onde Voce poderá gerenciar os filmes que já assistiu e os que quer assistir futuramente

* o projeto vai consumir uma api de filme

* ser possivel o filme na conta do usuario e ele vai marcar como assistido ou pendente e dar um comentario se quiser e clicar na estrelinhas pra avaliar o filme as outras informações do filme já serão puxadas da api que iremos consumir

* se ele clicar no maximo de estrela esse filme vai ficar listado nos favoritos dele

* se ele excluir um filme o filme continua em todos porem n estara mais vinculado com a conta dele e se quiser d volta vai ter que add dnv

* os filmes q ele ainda não adicionou em sua conta são os filmes da api externa e os filmes recomendados são os filmes com melhor avaliação geral da api externa!



## Endpoints

- Filmes
    - [Listar Todos](#listar-todos)
    - [Detalhar](#detalhar-filme)
    - [Cadastrar](#cadastrar-filme)
    - [Apagar](#apagar-filme)
    - [Editar](#editar-filme)

- Movimentações 

---
### Listar Todos

`GET` / filmes

Retorna um array com todas os filmes

**Exemplo de Resposta**

```js
[
    {
    "id": 1,
    "nome": "À Procura da Felicidade",
    "descricao":"Um pai solteiro determinado não mede esforços na luta para construir uma vida melhor para sua família",
    "foto": "src/assent/Fotofilme/aProcuraDaFelicidade.jpg",
    "genero":"Drama",
    "ano":2006,
    "duracao":"1h57min",
    "elenco":"Will Smith, Jaden Smith, Thandiwe Newton",
    "nota":5,
    }
]
```
**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso

--- 

### Detalhar Filme

`GET` /filme/{id}  para pegar um filme especifico

Retornar os dados do filme com o `id` informado.

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "À Procura da Felicidade",
    "descricao":"Um pai solteiro determinado não mede esforços na luta para construir uma vida melhor para sua família",
    "foto": "src/assent/Fotofilme/aProcuraDaFelicidade.jpg",
    "genero":"Drama",
    "ano":2006,
    "duracao":"1h57min",
    "elenco":"Will Smith, Jaden Smith, Thandiwe Newton",
    "nota":5
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|404| Id do filme não encontrado 

--- 

### Cadastrar Filme

`POST` /filme

Insere um novo filme.


**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|o nome do filme
|descricao|string|✅|a descrição do filme
|foto|string|✅|a foto da capa do filme
|genero|string|✅|os generos do filme
|duracao|string|✅|as horas e minutos de duração do filme
|elenco|string|✅|apenas os atores principais
|nota|string|✅|nota geral que o filme tem de avaliação


```js
{
    "nome": "À Procura da Felicidade",
    "descricao":"Um pai solteiro determinado não mede esforços na luta para construir uma vida melhor para sua família",
    "foto": "src/assent/Fotofilme/aProcuraDaFelicidade.jpg",
    "genero":"Drama",
    "ano":2006,
    "duracao":"1h57min",
    "elenco":"Will Smith, Jaden Smith, Thandiwe Newton",
    "nota":5
}
```

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "À Procura da Felicidade",
    "descricao":"Um pai solteiro determinado não mede esforços na luta para construir uma vida melhor para sua família",
    "foto": "src/assent/Fotofilme/aProcuraDaFelicidade.jpg",
    "genero":"Drama",
    "ano":2006,
    "duracao":"1h57min",
    "elenco":"Will Smith, Jaden Smith, Thandiwe Newton",
    "nota":5
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|400| Erro de validação - verifique o corpo da requisição

---

### Apagar Filme

`DELETE` /filme/{id}  para apagar um filme caso não queira ter ele na sua lista 

Apaga o filme com o `id` informado.

**Códigos de Status**

| código | descrição|
|--------|----------|
|204|Filme apagada com sucesso
|404| Id do filme não encontrado 

--- 


### Editar Filme

`PUT` /filme

Atualizar os dados das informações do `id` do filme informado.

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|o nome do filme
|descricao|string|✅|a descrição do filme
|foto|string|✅|a foto da capa do filme
|genero|string|✅|os generos do filme
|duracao|string|✅|as horas e minutos de duração do filme
|elenco|string|✅|apenas os atores principais
|nota|string|✅|nota geral que o filme tem de avaliação


```js
{
    "nome": "À Procura da Felicidade",
    "descricao":"Um pai solteiro determinado não mede esforços na luta para construir uma vida melhor para sua família",
    "foto": "src/assent/Fotofilme/aProcuraDaFelicidade.jpg",
    "genero":"Drama",
    "ano":2006,
    "duracao":"1h57min",
    "elenco":"Will Smith, Jaden Smith, Thandiwe Newton",
    "nota":5
}
```

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "À Procura da Felicidade",
    "descricao":"Um pai solteiro determinado não mede esforços na luta para construir uma vida melhor para sua família",
    "foto": "src/assent/Fotofilme/aProcuraDaFelicidade.jpg",
    "genero":"Drama",
    "ano":2006,
    "duracao":"1h57min",
    "elenco":"Will Smith, Jaden Smith, Thandiwe Newton",
    "nota":5
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|filme atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id da categoria não encontrado

---
