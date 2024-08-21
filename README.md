# ProjetoSeleniumSeuBarriga
### Projeto de Sistema de Automação Web do Sistema Seu Barriga com Selenium WebDriver.
#### Descrição:
O exemplo simula a automação de funcionalidades como: 
- **Login** (Cadastro de Novo Usuário e Login no sistema);
- **Contas** (Adicionar nova Conta e Listar todas as contas adicionadas no sistema);
- **Movimentação** (Criar novas movimentações de um usuário do sistema);
- **Resumo Mensal** (Buscar/Pesquisar em um período mensal um Resumo Mensal da(s) Movimentação(ões) realizadas no sistema).
Para cada uma destas funcionalidades descritas acima possuem seus Cenários de Testes cada um com todos os seus respectivos Casos de Testes sejam eles ligados a um fluxo de sucesso, a um fluxo alternativo ou a um fluxo de exceção. Ao todo foram escritos 47 Casos de Testes ligados a um desses Cénarios de Testes: **Login**, **Contas**, **Movimentação**, **Resumo Mensal**.     

#### Padrão de Projeto *Designer Pattern*:
Neste projeto foram utilizados pelo menos 4 Padrões de Projeto *Designer Pattern* que são elencados abaixo:
- **Singleton**;
- **Factory**;
- **Page Objects**;
- **DSL**.

##### Nota: *Os Padrões de Projeto - Designer Pattern permitem uma melhor organização do projeto separando cada elemento, componente entre outros artefatos do projeto em camadas cada uma separada da outra, porém comunicando-se entre elas. Além desta organização do projeto outros pontos a serem destacados é o reúso de código, separação de responsabilidades e a fácil manutenção do código do projeto.* 

#### Organização do Projeto de Automação do Sistema Seu Barriga com Selenium WebDriver:
O exemplo que simula a automação do Sistema Seu Barriga com Selenium WebDriver está disposto/organizado da seguinte maneira:

- **src/main**
- - **Java**
- - - **core**
- - - - **assistant**
- - - - **base**
- - - - **drivefactory**
- - - - **dsl**
- - - - - **dslbase**
- - - - - **dslcadastrologin**
- - - - - **dslconta**
- - - - - **dsllogin**
- - - - - **dslmovimentacao**
- - - - - **dslresumomensal**
- - - - **properties**
- - - **objeto**
- - - - **baselogin**
- - - - **cadastrologin**
- - - - **conta**
- - - - **login**
- - - - **movimentacao**
- - - - **resumomensal**
- - - **pageobjects**
- - - - **cadastrologin**
- - - - **conta**
- - - - **login**
- - - - **movimentacao**
- - - - **resumomensal**
- - - **suitetests**
- - - **tests**
- - - - **cadastrologin**
- - - - **conta**
- - - - **login**
- - - - **movimentacao**
- - - - **resumomensal**
- - **Resources**
- - - **drivers**
- - - - **chromedriver**
- - - - **edgedriver**
- - - - **geckodriver**
- - - - **operadriver**
- - - **screenshot**
- - - - **TestCadastroLogin**
- - - - **TestConta**
- - - - **TestLogin**
- - - - **TestMovimentacao**
- - - - **TestResumoMensal**

#### Observações:
*Arquivos chamados ProjetoSeleniumSeuBarriga.iml e pom.xml são arquivos de configuração do projeto bem como a pasta target/classes com seus arquivos.*<br>
*Para cada uma das funcionalidades descritas acima que possuem seus Cenários de Testes cada um com todos os seus respectivos Casos de Testes são criadas pastas com o nome de cada Cenário de Testes e dentro de cada uma das pastas estão localizadas cada um dos **screenshot** de cada Caso de Teste.*<br>
*Todos os 4 principais drivers para executar o projeto estão dentro da pasta **drivers**; estes por sua vez estão dentro da pasta chamada **Resources**.*<br>
*Ao todo são criadas 5 pastas de Cenários de Testes que contém **screenshot** de cada Caso de Teste. As pastas com arquivos de **screenshot** bem como as pastas para cada um dos drivers estão dentro da pasta chamada **Resources**.*
