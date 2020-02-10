# Formatação de textos

### Passos para a resolução do desafio
<p>Para resolver o desafio, o primeiro passo foi criar um método para receber o texto e criar lógica para limitar a 
quantidade de caracteres por linha. Após limitar a quantidade de caracteres, criei a lógica que trata os cenários em que
a ultima palavra da linha foi cortada ao meio. Depois de concluir as validações da limitação de caracteres, fiz um
mapeamento dos passos necessários para deixar o texto justificado:</p>

- Verificar a quantidade atual de caracteres da linha
- Calcular a quantidade de espaços necessários para preencher a linha até o limite de caracteres
- Verificar a quantidade de espaços que existem na linha
- Calcular a quantidade de espaços que serão adicionados entre cada palavra
- Preencher a linha com a quantidade de espaços calculados

<p>Após aplicar todos os passos da linha acima, criei as validações necessárias para que não ocorra o lançamento indevido
de exceções durante a execução da aplicação.</p>
<p>O último passo foi adaptar o a entrada dos parametros para a execução da aplicação.</p>

#### Execução da aplicação
<p>Após clonar o projeto, siga os passos abaixo:</p>

- Navegue até {PastaDoProjeto}/strings/JavaTemplate e execute o comando <strong>mvn clean install</strong>.
- Após finalizar o processo de compilação, será criada a pasta <strong>/target</strong> que terá os jars da aplicação.
- Navegue até a pasta, abra o terminal e execute o comando java -jar IdWallFormatter-jar-with-dependencies.jar.
