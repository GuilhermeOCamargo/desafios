# Telegram Bot - Reddit

### Passos para a resolução do desafio

##### Parte 1
<p>Para resolver o desafio o primeiro passo foi pesquisar sobre o funcionamento do Jsoup para iniciar a criação do crawler.
Após entender o funcionamento da biblioteca, iniciei o processo de desenvolvimento da parte de conexão e busca dos dados 
na página web do Reddit.
</p>
<p>O passo seguinte foi entender a estrutura das tags html da página para que fosse possível criar a lógica de busca das 
threads. Após compreender o padrão da lista de threads, foi possível criar os métodos que são responsáveis por extrair as
informações do html da página e convertê-los na entidade de domínio para que fosse possível filtrar as informações de 
acordo com os parametros necessários.</p>
<p>Após ter as informações em mãos, foi possível criar a lógica que possibilita receber uma lista de subreddits para 
buscar a efetuar a aplicação dos filtros e retornar ao usuário.</p>
<p>Depois de criado toda a parte de busca e filtro das threads, criei a lógica responsável por ler um arquivo csv com a 
lista de subreddits e buscar as informações para o usuário. O ultimo passo da primeira parte do desafio foi criar as 
validações e tratamento de exceções de todo o processo de leitura do arquivo, busca e filtro das threads.</p>

##### Parte 2
<p>A segunda parte do desafio começou com um estudo da biblioteca de criação de bot do telegram. Após compreender o 
funcionamento, iniciei o processo de criação de bot com o <strong>Bot Father</strong> do Telegram, gerando um token de
acesso e um nome de usuário.</p>
<p>Após a criação do bot pelo Bot Father, iniciei o processo de desenvolvimento da lógica que recebe as mensagens e 
retorna ao usuário uma nova mensagem. Ao fazer a integração do recebimento da mensagem com o retorno da pesquisa no Reddit
foi possível perceber que a mensagem de retorno para o usuário possui uma limitação de tamanho, logo, foi necessário 
enviar a resposta ao usuário em várias mensagens, cada qual com uma thread encontrada durante a pesquisa.</p>
<p>Ao finalizar o desenvolvimento da aplicação, iniciei o processo de tratativa de exceções e mensagens amigáveis para 
o usuário. Percebi também que era possível aplicar o padrão de projeto <strong>Strategy</strong> para validar a mensagem
e direcioná-la para a classe que deve tratá-la</p>
<p>Após finalizar os testes, criei uma imagem no docker para executar a aplicação de maneira mais fácil e padronizada.</p>

#### Execução da aplicação

<p>A aplicação está pronta para rodar em um container no docker. Para executá-la, primeiro será necessário [criar um novo
bot no Bot Father do Telegram](https://core.telegram.org/bots) para gerar um token e um nome de usuário. Após criado, siga 
as instruções abaixo:</p>

- Abra o terminal e navegue até a pasta do projeto
- Execute o comando `docker build -t reddit-telegram-bot .` para criar a imagem do docker
- No arquivo env.list atribua o token gerado pelo Bot Father a variável de ambiente <strong>TELEGRAM_REDDIT_BOT</strong>
e o nome de usuário a variável <strong>TELEGRAM_REDDIT_USERNAME</strong>.
- Execute o comando `docker run -d --env-file env.list --name reddit-telegram-bot reddit-telegram-bot`

<p>Após executar esses passos, um container será iniciado com a aplicação sendo executada. Abra o Telegram no bot criado 
e execute o comando <code>/start</code> e a seguinte mensagem irá aparecer: <strong>Ola humano! :)</strong></p>
<p>Digite o comando <code>/NadaPraFazer</code> seguido de um ou mais subreddits separados por ; para que o bot retone as
principais threads com pelo menos 5000 pontos das categorias solicitadas. Exemplo: <code>/NadaPraFazer cats;worldnews</code></p>