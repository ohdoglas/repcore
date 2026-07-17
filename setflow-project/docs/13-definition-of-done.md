# 13 — Definition of Done

## 1. DoD de história/entrega

Uma entrega está concluída somente quando todos os itens aplicáveis forem verdadeiros.

### Escopo

- [ ] Objetivo principal atingido.
- [ ] Todos os critérios de aceite verificados.
- [ ] Nenhum item fora de escopo implementado silenciosamente.
- [ ] Divergências documentadas e aprovadas.

### Código

- [ ] Código compila.
- [ ] Arquitetura e ADRs respeitados.
- [ ] Nomes seguem o domínio.
- [ ] Não há duplicação relevante introduzida.
- [ ] Não há TODO impeditivo.
- [ ] Erros são tratados de forma acionável.
- [ ] Não há logs sensíveis em release.

### Dados

- [ ] Persistência mantém integridade.
- [ ] Mudança de schema possui migração.
- [ ] Migração possui teste.
- [ ] Snapshots históricos foram preservados.
- [ ] Operações críticas são transacionais.
- [ ] Backup foi atualizado quando necessário.

### UI/UX

- [ ] Estados loading, conteúdo, vazio e erro foram considerados.
- [ ] Fluxo repetitivo não exige digitação desnecessária.
- [ ] Ação principal é acessível.
- [ ] Componentes possuem semântica.
- [ ] Escala de fonte não quebra fluxo crítico.
- [ ] Preview ou documentação visual foi adicionada quando útil.

### Testes

- [ ] Testes obrigatórios implementados.
- [ ] Testes existentes continuam verdes.
- [ ] Build debug executado.
- [ ] Validação manual descrita foi realizada quando aplicável.
- [ ] Resultado de cada comando aparece no relatório.

### Documentação

- [ ] Documentos afetados foram atualizados.
- [ ] Nova decisão arquitetural possui ADR.
- [ ] Entrega e backlog foram atualizados.
- [ ] Relatório do Executor foi entregue no formato exigido.

## 2. DoD de feature

Além da DoD de entrega:

- [ ] Fluxo completo pode ser executado por UI.
- [ ] Dados permanecem após reabrir app.
- [ ] Erros de entrada e persistência foram testados.
- [ ] Integração com features adjacentes foi validada.
- [ ] Não existem telas permanentemente alimentadas por mocks.

## 3. DoD de sprint

- [ ] Todas as entregas aceitas pelo Orquestrador.
- [ ] Suíte completa da sprint verde.
- [ ] Backlog e dependências atualizados.
- [ ] Débitos técnicos explícitos, com prioridade.
- [ ] Build instalável gerado.
- [ ] Smoke test executado em emulador ou aparelho.

## 4. DoD do MVP

- [ ] Plano inicial importado corretamente.
- [ ] Usuário inicia e recupera sessão.
- [ ] Séries comuns, aquecimento e unilateral funcionam.
- [ ] Supersérie controla rodadas e descanso.
- [ ] Técnicas e alertas funcionam.
- [ ] Cronômetro persiste e recalcula.
- [ ] Histórico e último desempenho funcionam.
- [ ] Progressão é sinalizada sem alterar carga automaticamente.
- [ ] Backup restaura uma base equivalente.
- [ ] CSV é exportado.
- [ ] Release assinada instalada no aparelho principal.
- [ ] Sessão real concluída sem bloco de notas.
- [ ] Nenhum defeito conhecido de perda de dados permanece aberto.

## 5. Não é Done quando

- “Funciona na minha máquina” sem build/teste.
- A tela funciona, mas os dados somem ao reabrir.
- O teste foi desativado.
- Foi usado banco destrutivo para evitar migração.
- A regra do plano foi simplificada sem documentação.
- O relatório omite limitações.
- A feature depende de clique impossível com TalkBack ou fonte aumentada.
- O código inclui funcionalidade futura parcialmente conectada.
