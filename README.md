# ProjetoUol
# 1. Introdução
O "AppAlbumFotos" é um aplicativo Android desenvolvido para proporcionar aos usuários uma experiência de visualização de álbuns de fotos, detalhes do usuário e listagem de usuários. Este documento oferece uma visão geral das principais características, estrutura do projeto, componentes e instruções para execução.

# 2. Visão Geral
# 2.1 Objetivo do Projeto
O principal objetivo do projeto é criar uma aplicação Android que interage com a API jsonplaceholder.typicode.com para obter dados de usuários, detalhes do usuário, álbuns e fotos. A aplicação utiliza a arquitetura MVC (Model-View-Controller) para garantir uma estrutura organizada e modular.

# 2.2 Funcionalidades Principais
- Listagem de Usuários
- Detalhes do Usuário
- Listagem de Álbuns
- Visualização de Fotos em Álbuns
  
# 2.3 Tecnologias Utilizadas
- Linguagem: Kotlin
- Bibliotecas: Retrofit, Picasso
- Arquitetura: MVC (Model-View-Controller)
- Layout: XML para definição das telas
  
# 3. Estrutura do Projeto
# 3.1 Pacotes
model: Contém as classes de modelo (User, Album, Photo).
network: Contém a interface do Retrofit para chamadas à API (UserApiService).
controller: Classes controladoras para lógica de negócios (UserController, AlbumController).
adapters: Adaptares para RecyclerView (UserAdapter, AlbumAdapter, PhotoAdapter).
view: Atividades do Android e interfaces (UserActivity, UserView).

# 3.2 Dependências
- Retrofit: 2.9.0
- Picasso: 2.71828
  
# 4. Configuração do Projeto
# 4.1 Ambiente de Desenvolvimento
Certifique-se de ter o ambiente de desenvolvimento Android configurado corretamente com o Android Studio e Kotlin.

# 4.2 Dependências e Configurações
As dependências do projeto estão especificadas no arquivo build.gradle e incluem Retrofit e Picasso. Certifique-se de sincronizar o projeto após qualquer alteração nesse arquivo.

# 5. Instruções de Execução
Certifique-se de ter configurado corretamente o ambiente de desenvolvimento Android. Após isso, basta executar o aplicativo em um emulador ou dispositivo físico.

