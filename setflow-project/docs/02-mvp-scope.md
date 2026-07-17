# 02 — Escopo do MVP

## 1. Objetivo da versão

Entregar uma versão pessoal utilizável na academia que substitua o bloco de notas para musculação e controle o descanso das séries.

## 2. Escopo obrigatório

### Fundação

- Projeto Android nativo em Kotlin.
- Jetpack Compose e Material 3.
- Navegação de atividade única.
- Room para dados estruturados.
- DataStore para preferências.
- Injeção de dependência.
- Tema escuro e claro, com escuro como preferência inicial sugerida.

### Carga inicial

- Programa de duas semanas.
- Cinco treinos por semana.
- Exercícios, faixas de repetições e descanso do plano atual.
- Superséries dos treinos de braços.
- Técnicas opcionais indicadas.
- Notas de aquecimento e foco.
- Reimportação do seed apenas por ação explícita.

### Catálogo e modelos

- CRUD lógico de exercícios: criar, editar e arquivar.
- CRUD lógico de modelos de treino.
- Blocos normais e superséries.
- Reordenação de blocos e exercícios.
- Faixa de séries, repetições e descanso.
- Marcação unilateral.

### Treino ativo

- Iniciar a partir de modelo, último treino ou treino livre.
- Uma sessão ativa por vez.
- Registro de aquecimento e séries efetivas.
- Carga, repetições, RIR, técnica e observação.
- Copiar série anterior.
- Preencher a partir do último histórico.
- Adicionar, substituir, pular e reordenar exercício na sessão.
- Recuperar sessão ativa.
- Finalizar ou cancelar.

### Descanso

- Início automático configurável.
- Duração contextual por exercício ou bloco.
- Ajuste ±15 segundos.
- Pausar, retomar, reiniciar e encerrar.
- Som e vibração em primeiro plano.
- Persistência do deadline.
- Sem permissão de alarme exato.

### Histórico e progressão

- Lista de sessões.
- Detalhe por sessão.
- Histórico por exercício.
- Último desempenho durante o treino.
- Volume efetivo.
- Sinalização de candidato a progressão dupla.
- Edição de sessão histórica com confirmação.

### Dados

- Backup JSON versionado.
- Restauração JSON validada.
- Exportação CSV.
- Redefinição de dados com confirmação reforçada.

## 3. Escopo condicional

Pode entrar no MVP somente se não atrasar os itens obrigatórios:

- Manter tela ligada durante sessão.
- Atalho “repetir último treino”.
- Indicador simples de recorde pessoal.
- Filtro rápido por grupo muscular.
- Etiquetas de dor, execução parcial e equipamento indisponível.

## 4. Fora do MVP

- Login, perfil remoto e múltiplos usuários.
- Backend, API e sincronização.
- Rede social, ranking, feed e compartilhamento.
- IA geradora de treino ou dieta.
- Prescrição automática de carga.
- Banco nutricional, código de barras e refeições completas.
- Cardio estruturado.
- Health Connect e smartwatch.
- Fotos de progresso e medidas corporais.
- Assinatura, anúncios e pagamentos.
- iOS, web e desktop.
- Notificações com exigência de alarme exato.
- Gráficos avançados e dashboards extensos.
- Traduções além de `pt-BR`.

## 5. Limites de implementação

- Não criar multi-module antes de necessidade comprovada e ADR.
- Não introduzir backend “para preparar o futuro”.
- Não usar dados mockados permanentes depois que o repositório Room estiver disponível.
- Não codificar exercícios diretamente em Composables.
- Não misturar entidades Room com modelos de UI sem justificativa.
- Não adicionar biblioteca para funcionalidade coberta adequadamente pelo SDK ou Jetpack já adotado.
- Não permitir exclusão física de registros históricos pela UI do MVP.

## 6. Cortes verticais de entrega

### MVP-0 — Base executável

Projeto abre, navega e possui arquitetura, DI, banco e preferências.

### MVP-1 — Plano navegável

Seed importado; usuário consulta semanas, treinos e exercícios.

### MVP-2 — Registro real

Usuário inicia treino e registra séries com persistência.

### MVP-3 — Condução

Cronômetro, supersérie, técnicas e recuperação de sessão funcionam.

### MVP-4 — Aprendizado

Histórico, volume, último desempenho e progressão são apresentados.

### MVP-5 — Segurança

Backup, restauração, CSV, testes e release pessoal.

## 7. Critério de congelamento do MVP

Após o início de `MVP-2`, qualquer nova funcionalidade deve:

1. corrigir perda de dados;
2. corrigir bloqueio do fluxo principal;
3. ser necessária para representar o plano atual; ou
4. substituir uma solução claramente inviável.

Caso contrário, deve ir para pós-MVP.

## 8. Saída esperada

- APK release assinada para uso pessoal.
- Repositório compilável.
- Seed versionado.
- Migrações testadas.
- Documentação atualizada.
- Backup de teste restaurado com sucesso.
